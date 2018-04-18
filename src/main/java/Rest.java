import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Path("/json")
public class Rest {


        protected MathManager math;

        public Rest() {
            this.math = Singleton.getInstance().getImpl();
            int x = this.math.getIniciadorRest();
            if (x==0) {
                this.math.crearInstitutosYAlumnos();
                OperacionMatematica op = null;
                Expresio expresio1 = new Expresio(1);
                Expresio expresio2 = new Expresio("+");
                Expresio expresio3 = new Expresio(3);

                Instituto instituto = this.math.consultarInstituto("Maristes");
                List<Alumno> listaAlum = new ArrayList<Alumno>(instituto.consultarAlumnos());
                Alumno a1 = listaAlum.get(1);
                op.addOperacio(expresio1);
                op.addOperacio(expresio2);
                op.addOperacio(expresio3);
                        this.math.realizarOperacion(op,a1);
                        this.math.modIniciadorRest();
            }

        }
        //listado institutos
        @GET
        @Path("/listarInstitutos")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Instituto> getListaInsti() {
            return this.math.listadoInstitutos();
        }

        //lista las operaciones alumno
        @GET
        @Path("/listarOpeAlumn/{nom}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<OperacionMatematica> getListaOpeAlumno(@PathParam("nom") String nom) {
            Alumno a = this.math.consultarAlumnoString(nom);
            List<OperacionMatematica> listar = new LinkedList<OperacionMatematica>(this.math.operacionesAlumno(a));
            return listar;
        }

        //lista las operaciones instituto
        @GET
        @Path("/listarOpeinstituto/{nom}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<OperacionMatematica> getListaOpeInstituto(@PathParam("nom") String nom) {
            List<OperacionMatematica> listar = new LinkedList<OperacionMatematica>(this.math.operacionesInstituto(nom));
            return listar;
        }

        //Procesar
        @GET
        @Path("/procesarOperacion")
        @Produces(MediaType.APPLICATION_JSON)
        public Integer  getProcesar() {
            return this.math.procesarOperacion();
        }


        //realizar operacion
        @POST
        @Path("/realizarOperacion/{user}")
        @Consumes(MediaType.APPLICATION_JSON)
        public Response compra (@PathParam("user") String user, OperacionMatematica op) {
            Alumno a = this.math.consultarAlumnoString(user);
            boolean col  = this.math.realizarOperacion(op,a);
            if (col){
                return Response.status(201).entity("ope realizada").build();
            }
            else{
                return Response.status(409).entity("Error al realizar").build();
            }

        }


}
