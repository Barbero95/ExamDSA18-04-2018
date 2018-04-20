

import java.util.*;
import java.util.logging.Level;

public class MathManagerImpl implements MathManager,ReversePolishNotation {

    Queue<OperacionMatematica> listaOperacionesMatematicas = new LinkedList<OperacionMatematica>();

    List<Instituto> listaInstitutos = new ArrayList<Instituto>();
    HashMap<String,Alumno> mapaAlumnos = new HashMap<String,Alumno>();

    private int iniciadorTest1=0;
    private int iniciadorTest2=0;
    private int iniciadorRest =0;
    public int getIniciadorRest (){
        return this.iniciadorRest;
    }
    public void modIniciadorRest (){
        this.iniciadorRest=1;
    }
    public void modIniciadorTest1 (){
        this.iniciadorTest1=1;
    }
    public int getIniciadorTest1(){
        return this.iniciadorTest1;
    }
    public void modIniciadorTest2 (){
        this.iniciadorTest2=1;
    }
    public int getIniciadorTest2(){
        return this.iniciadorTest2;
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
    public Alumno consultarAlumnoString (String alumno){
        Alumno al = this.mapaAlumnos.get(alumno);
        return al;
    }
    public boolean consultarAlumno(Alumno alumno){
        String nombre = alumno.getNombre();
        String nombreInstituto = alumno.getInstituto();
        Instituto instituto = consultarInstituto(nombreInstituto);
        if (instituto==null){
            return false;
        }else{
            ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(instituto.consultarAlumnos());
            for(Alumno alum: listaAlumnos){
                if (alum.getNombre().equals(nombre)) {
                    return true;
                }
            }
        }
        return false;
    }
    //public boolean realizarOperacion (OperacionMatematica ope, Alumno alumno){
    public boolean realizarOperacion (OperacionMatematica operacion){

        Alumno alumno = operacion.getAlumno();
        boolean resp = consultarAlumno(alumno);
        //boolean resp = true;
        if(resp){
            alumno.addlistaOperaciones(operacion);
            listaOperacionesMatematicas.add(operacion);
            return true;
        } else{
            return false;
        }

    }
    public Integer procesarOperacion(){
        OperacionMatematica operacion = listaOperacionesMatematicas.poll();
        //Stack<Expresio> listaExpresiones;
        //listaExpresiones = operacion.listaExpresionesConPila();
        //Expresio result;
        Queue<Expresio> listaDeExpresiones = new LinkedList<Expresio>(operacion.getOperacioCua());
        //Stack<Expresio> pilaExpresiones = new Stack<Expresio>();

        //int res = ReversePolishNotation.process(operacion);
        ///




        Stack<Integer> pilaExpresiones = new Stack<Integer>();
        for(Expresio expre: listaDeExpresiones){
            //result=null;
            if (expre.verQueEs()) {
                //si entra es que no es una operacion y en teoria es un int
                pilaExpresiones.push(expre.getNumero());
            }
            else{
                if (expre.equals("+")){
                    int x1 = pilaExpresiones.pop();
                    int x2 = pilaExpresiones.pop();
                    int operacio = (x2+x1);
                    pilaExpresiones.push(operacio);
                    /*
                    Expresio expre1 = pilaExpresiones.pop();
                    Expresio expre2 = pilaExpresiones.pop();
                    int x1 = expre1.getNumero();
                    int x2 = expre2.getNumero();
                    int operacio = (x2 + x1);
                    result.setNumero(operacio);
                    pilaExpresiones.push(result);
                    */
                }if(expre.equals("-")) {
                    int x1 = pilaExpresiones.pop();
                    int x2 = pilaExpresiones.pop();
                    int operacio = (x2-x1);
                    pilaExpresiones.push(operacio);
                    /*
                    Expresio expre1 = pilaExpresiones.pop();
                    Expresio expre2 = pilaExpresiones.pop();
                    int x1 = expre1.getNumero();
                    int x2 = expre2.getNumero();
                    int operacio = (x2 - x1);
                    result.setNumero(operacio);
                    pilaExpresiones.push(result);
                    */
                }if(expre.equals("*")) {
                    int x1 = pilaExpresiones.pop();
                    int x2 = pilaExpresiones.pop();
                    int operacio = (x2*x1);
                    pilaExpresiones.push(operacio);
                    /*
                    Expresio expre1 = pilaExpresiones.pop();
                    Expresio expre2 = pilaExpresiones.pop();
                    int x1 = expre1.getNumero();
                    int x2 = expre2.getNumero();
                    int operacio = (x2 * x1);
                    result.setNumero(operacio);
                    pilaExpresiones.push(result);
                    */
                }if(expre.equals("/")) {
                    int x1 = pilaExpresiones.pop();
                    int x2 = pilaExpresiones.pop();
                    int operacio = (x2/x1);
                    pilaExpresiones.push(operacio);
                    /*
                    Expresio expre1 = pilaExpresiones.pop();
                    Expresio expre2 = pilaExpresiones.pop();
                    int x1 = expre1.getNumero();
                    int x2 = expre2.getNumero();
                    int operacio = (x2 / x1);
                    result.setNumero(operacio);
                    pilaExpresiones.push(result);
                    */
                } else{
                    return null;
                }
            }
        }
        //result = pilaExpresiones.pop();
        //operacion.setResultado();
        //return result.getNumero();
        return pilaExpresiones.pop();
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
    public List<OperacionMatematica> operacionesInstituto(String nombreInstituto){
        Instituto instituto = consultarInstituto(nombreInstituto);
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>(instituto.consultarAlumnos());
        ArrayList<OperacionMatematica> operacionesMatematicas = new ArrayList<OperacionMatematica>();

        for(Alumno alumno: listaAlumnos){
            ArrayList<OperacionMatematica> operacionesMatematicasIndividuales = new ArrayList<OperacionMatematica>(alumno.consultaOperaciones());
            for(OperacionMatematica opera: operacionesMatematicasIndividuales){
                operacionesMatematicas.add(opera);
            }
        }
        return operacionesMatematicas;
    }
    public List<OperacionMatematica> operacionesAlumno (Alumno alumno){
        boolean resp = false;
        resp = consultarAlumno(alumno);
        if (resp){
            return alumno.consultaOperaciones();
        } else{
          return null;
        }
    }

}
