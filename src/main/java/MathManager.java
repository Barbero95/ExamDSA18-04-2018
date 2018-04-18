import java.util.AbstractList;
import java.util.List;

public interface MathManager {
    boolean realizarOperacion (OperacionMatematica ope, Alumno alumno);
    List<Instituto> listadoInstitutos ();
    Integer procesarOperacion();
    List<OperacionMatematica> operacionesInstituto(String nombreInstituto);
    List<OperacionMatematica> operacionesAlumno (Alumno alumno);


    void addInstituto(Instituto insti);
    void addAlumno(Alumno alum);
    Instituto consultarInstituto(String nombreInsti);
    void crearInstitutosYAlumnos();
    Alumno consultarAlumnoString (String alumno);
    void modIniciadorTest1 ();
    void modIniciadorTest2 ();
    void modIniciadorRest ();
    int getIniciadorRest ();
    int getIniciadorTest1 ();
    int getIniciadorTest2 ();

}
