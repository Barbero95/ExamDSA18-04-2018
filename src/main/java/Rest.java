import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Path("/json")
public class Rest {


        protected MathManager math;

        public Rest() {
            this.math = Singleton.getInstance().getImpl();
            int x = this.math.getIniciadorRest();
            if (x==0) {
                this.math.crearInstitutosYAlumnos();
                OperacionMatematica op = null;

                Instituto instituto = this.math.consultarInstituto("Maristes");
                Alumno alumno = this.math.consultarAlumnoString("David");
                List<Alumno> listaAlum = new ArrayList<Alumno>(instituto.consultarAlumnos());
                Alumno a1 = listaAlum.get(1);
                Queue<Expresio> operacioCua = new LinkedList<Expresio>();
                operacioCua.add(new Expresio(1));
                operacioCua.add(new Expresio(3));
                operacioCua.add(new Expresio("+"));
                op.setOperacioCua(operacioCua);
                        this.math.realizarOperacion(op);
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
            boolean col  = this.math.realizarOperacion(op);
            if (col){
                return Response.status(201).entity("ope realizada").build();
            }
            else{
                return Response.status(409).entity("Error al realizar").build();
            }

        }


}
