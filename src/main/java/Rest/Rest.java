package Rest;

//import MathManager.MathManager;
//import MathManager.Singleton;
//import MathManager.Numero;
//import MathManager.Simbolo;
import MathManager.*;
import ReversePolishNotation.ReversePolishNotation;

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
                Operacion op = null;
                Instituto instituto = this.math.consultarInstituto("Maristes");
                Alumno alumno = this.math.consultarAlumno("David");
                List<Alumno> listaAlum = new ArrayList<Alumno>(instituto.consultarAlumnos());
                Alumno a1 = listaAlum.get(1);
                Queue<Expressio> operacioCua = new LinkedList<Expressio>();
                operacioCua.add(new Numero(1));
                operacioCua.add(new Numero(3));
                operacioCua.add(new Simbolo("+"));
                op.setLlistaExpressions(operacioCua);
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
        public List<Operacion> getListaOpeAlumno(@PathParam("nom") String nom) {
            Alumno a = this.math.consultarAlumno(nom);
            List<Operacion> listar = new LinkedList<Operacion>(this.math.operacionesAlumno(a));
            return listar;
        }

        //lista las operaciones instituto
        @GET
        @Path("/listarOpeinstituto/{nom}")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Operacion> getListaOpeInstituto(@PathParam("nom") String nom) {
            List<Operacion> listar = new LinkedList<Operacion>(this.math.operacionesInstituto(nom));
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
        public Response compra (@PathParam("user") String user, Operacion op) {
            Alumno a = this.math.consultarAlumno(user);
            boolean col  = this.math.realizarOperacion(op);
            if (col){
                return Response.status(201).entity("ope realizada").build();
            }
            else{
                return Response.status(409).entity("Error al realizar").build();
            }

        }


}
