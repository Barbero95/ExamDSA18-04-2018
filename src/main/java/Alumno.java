import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String instituto;
    private int numOperaciones = 0;
    private int numOperacionesFinal = 0;
    private List<OperacionMatematica> operacionesMatematicas = new ArrayList<OperacionMatematica>();



    public Alumno(){

    }
    public Alumno(String nombre, String instituto){
        this.nombre=nombre;
        this.instituto=instituto;

    }
    public void addlistaOperaciones (OperacionMatematica operacion){
        this.operacionesMatematicas.add(operacion);
        this.numOperaciones++;
    }
    //otra forma de ver el numero de operaciones
    public void numOperaciones (){
        int x = operacionesMatematicas.size();
        this.numOperacionesFinal += x;
    }
    public List<OperacionMatematica> consultaOperaciones(){
        return this.operacionesMatematicas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
    public int getNumOperaciones() {
        return numOperaciones;
    }

    public void setNumOperaciones(int numOperaciones) {
        this.numOperaciones = numOperaciones;
    }

    public int getNumOperacionesFinal() {
        return numOperacionesFinal;
    }

    public void setNumOperacionesFinal(int numOperacionesFinal) {
        this.numOperacionesFinal = numOperacionesFinal;
    }
}
