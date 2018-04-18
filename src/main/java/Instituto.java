import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Instituto {
    private String nombreInstituto;
    private ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    private int numOperacionesTotales=0;



    public Instituto() {
    }
    public Instituto(String insti){
        this.nombreInstituto = insti;
    }
    public void introAlumno (Alumno alumno){
        this.listaAlumnos.add(alumno);
    }

    public List<Alumno> consultarAlumnos(){
        return this.listaAlumnos;
    }
    public void NumOperacionesTotal (){
        for (Alumno alum: listaAlumnos){
            int x = alum.getNumOperaciones();
            this.numOperacionesTotales = this.numOperacionesTotales + x;
        }
    }
    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }
    public int getNumOperacionesTotales() {
        return numOperacionesTotales;
    }

    public void setNumOperacionesTotales(int numOperacionesTotales) {
        this.numOperacionesTotales = numOperacionesTotales;
    }
}
