import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class OperacionMatematica {
    private Alumno alumno;
    private int resultado;


    private Stack<Expresio> operaciones = new Stack<Expresio>();
    private Queue<Expresio> operacioCua = new LinkedList<Expresio>();

    public OperacionMatematica() {
    }

    public Stack<Expresio> listaExpresionesConPila (){
        return this.operaciones;
    }
    public void addPilaOperacion (Expresio exp){
        this.operaciones.push(exp);
    }

    public Queue<Expresio> getOperacioCua() {
        return operacioCua;
    }

    public void setOperacioCua(Queue<Expresio> operacioCua) {
        this.operacioCua = operacioCua;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

}
