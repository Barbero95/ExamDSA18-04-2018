import java.util.LinkedList;
import java.util.List;

public class OperacionMatematica {
    private Alumno alumno;

    private List<Expresio> operacion = new LinkedList<Expresio>();

    public OperacionMatematica() {
    }
    public void addOperacio (Expresio expre){
        this.operacion.add(expre);
    }
    public List<Expresio> listaExpresionesDeUnaOperacion (){
        return this.operacion;
    }
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
