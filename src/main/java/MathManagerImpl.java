

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
    public boolean realizarOperacion (OperacionMatematica ope, Alumno alumno){
        List<Expresio> listaexpre= new LinkedList<Expresio>(ope.listaExpresionesDeUnaOperacion());
        int contador =0;
        List<Expresio> listaExpreACalcular = new LinkedList<Expresio>();
        for(Expresio expre: listaexpre){
            //aqui mirem si es un int o una operacio
            //si es igual a un int
            if (expre.equals(1)) {
                listaExpreACalcular.add(expre);
            }
            //aqui mirem si es un simbol aleshores
            else if(expre.equals(1)){
                //aqui al veure que no es un numero agafariem de la listaExpreACalcular els dos valors anteriors i calculariem.
                //modificariem la llista amb el nom valor calcular i continuariem
            }
            //no es ni un numero ni un simbol
            else{
                return false;
            }
            contador++;
            return true;
        }
        return false;

    }
    public Integer procesarOperacion(){
        Expresio expre = null;
        int resultado =0;
        OperacionMatematica op = null;
        op = listaOperacionesMatematicas.poll();

        return resultado;
        /*
        Pedido p = null;
        p = listaPedidosTotal.poll();

        if (p==null) return p;

        Usuario u = p.getUsuario();
        List<LineaDePedido> lp = p.getProductos();
        int num = 0;
        Producto producto;

        for (LineaDePedido linea: lp) {
            num = linea.getNum();
            producto = linea.getProducto();

            producto.incrementar(num);
            logger.log(Level.SEVERE, "value =" + producto.getNumeroVentas());
        }
        u.addPedido(p);

        return p;
        */
    }
    public Alumno consultarAlumno (String nombre){
        Alumno alumno = this.mapaAlumnos.get(nombre);
        return alumno;
    }
    public List<Instituto> listadoInstitutos (){
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
