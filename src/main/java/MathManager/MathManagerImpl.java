package MathManager;

import java.util.*;

import ReversePolishNotation.Procesar;
import ReversePolishNotation.ReversePolishNotation;

public class MathManagerImpl implements MathManager {

    Queue<Operacion> listaOperacionesMatematicas = new LinkedList<Operacion>();

    List<Instituto> listaInstitutos = new ArrayList<Instituto>();
    HashMap<String,Alumno> mapaAlumnos = new HashMap<String, Alumno>();

    private int iniciadorTest=0;
    private int iniciadorRest =0;
    public int getIniciadorRest (){
        return this.iniciadorRest;
    }
    public void modIniciadorRest (){
        this.iniciadorRest=1;
    }
    public void modIniciadorTest (){
        this.iniciadorTest=1;
    }
    public int getIniciadorTest(){
        return this.iniciadorTest;
    }

    public void crearInstitutosYAlumnos(){
        Instituto instituto1 = new Instituto("Maristes");
        Instituto instituto2 = new Instituto("Drassanes");
        listaInstitutos.add(instituto1);
        listaInstitutos.add(instituto2);
        Alumno a1 = new Alumno("David","Maristes");
        Alumno a2 = new Alumno("Ruben","Maristes");
        Alumno a3 = new Alumno("David2","Drassanes");
        Alumno a4 = new Alumno("David3","Drassanes");
        Alumno a5 = new Alumno("David4","Drassanes");
        mapaAlumnos.put("David",a1);
        mapaAlumnos.put("Ruben",a2);
        mapaAlumnos.put("David2",a3);
        mapaAlumnos.put("David3",a4);
        mapaAlumnos.put("David4",a5);
        instituto1.introAlumno(a1);
        instituto1.introAlumno(a2);
        instituto2.introAlumno(a3);
        instituto2.introAlumno(a4);
        instituto2.introAlumno(a5);

    }
    public void addInstituto(Instituto insti){
        listaInstitutos.add(insti);
    }
    public void addAlumno(Alumno alum){
        String nombre = alum.getNombre();
        mapaAlumnos.put(nombre,alum);
    }


    public Instituto consultarInstituto(String nombreInsti){
        for(Instituto insti: listaInstitutos){
            if (insti.getNombreInstituto().equals(nombreInsti)) {
                return insti;
            }
        }
        return null;
    }
    public Alumno consultarAlumno (String alumno){
        Alumno al = this.mapaAlumnos.get(alumno);
        return al;
    }
    public Alumno consultarAlumno(Alumno alumno){
        String nombre = alumno.getNombre();
        String nombreInstituto = alumno.getInstituto();
        Instituto instituto = consultarInstituto(nombreInstituto);
        if (instituto==null){
            return null;
        }else{
            ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(instituto.consultarAlumnos());
            for(Alumno alum: listaAlumnos){
                if (alum.getNombre().equals(nombre)) {
                    return alumno;
                }
            }
        }
        return null;
    }

    public boolean realizarOperacion (Operacion operacion){
        Alumno alumno = operacion.getAlumno();
        alumno = consultarAlumno(alumno);
        //boolean resp = true;
        if(alumno==null){
            return false;
        } else{
            alumno.addlistaOperaciones(operacion);
            listaOperacionesMatematicas.add(operacion);
            return true;
        }

    }
    public Integer procesarOperacion() {
        Operacion operacion = listaOperacionesMatematicas.poll();
        ReversePolishNotation rpm = new Procesar();
        int res = rpm.procesarOp(operacion);

        return res;
    }

    public List<Instituto> listadoInstitutos (){
        for (Instituto instituto: listaInstitutos){
            instituto.NumOperacionesTotal();
        }
        List<Instituto> listaOrdenadaDesce = new ArrayList(listaInstitutos);
        Collections.sort(listaOrdenadaDesce, Comparator.comparing(Instituto::getNumOperacionesTotales));
        Collections.reverse(listaOrdenadaDesce);
        return listaOrdenadaDesce;
    }
    public List<Operacion> operacionesInstituto(String nombreInstituto){
        Instituto instituto = consultarInstituto(nombreInstituto);
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(instituto.consultarAlumnos());
        ArrayList<Operacion> operacionesMatematicas = new ArrayList<Operacion>();

        for(Alumno alumno: listaAlumnos){
            ArrayList<Operacion> operacionesMatematicasIndividuales = new ArrayList<Operacion>(alumno.consultaOperaciones());
            for(Operacion opera: operacionesMatematicasIndividuales){
                operacionesMatematicas.add(opera);
            }
        }
        return operacionesMatematicas;
    }
    public List<Operacion> operacionesAlumno (Alumno alumno){
        alumno= consultarAlumno(alumno);
        if (alumno==null){
            return null;
        } else{
            return alumno.consultaOperaciones();
        }
    }

}
