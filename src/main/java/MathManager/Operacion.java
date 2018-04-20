package MathManager;

import java.util.LinkedList;
import java.util.Queue;

public class Operacion {

    private Alumno alumno;
    private int resultado=0;
    private Queue<Expressio> llistaExpressions = null;

    public Operacion() {
    }

    public Operacion(Queue<Expressio> llistaExpressions, Alumno alumno) {
        this.llistaExpressions = new LinkedList<Expressio>(llistaExpressions);
        this.alumno=alumno;
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

    public Queue<Expressio> getLlistaExpressions() {
        return llistaExpressions;
    }

    public void setLlistaExpressions(Queue<Expressio> llistaExpressions) {
        this.llistaExpressions = llistaExpressions;
    }
}
