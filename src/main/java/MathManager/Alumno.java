package MathManager;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String instituto;
    private int numOperaciones = 0;
    private List<Operacion> operacionesMatematicas = new ArrayList<Operacion>();



    public Alumno(){

    }
    public Alumno(String nombre, String instituto){
        this.nombre=nombre;
        this.instituto=instituto;

    }
    public void addlistaOperaciones (Operacion operacion){
        this.operacionesMatematicas.add(operacion);
        this.numOperaciones++;
    }

    public List<Operacion> consultaOperaciones(){
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
}
