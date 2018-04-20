package MathManager;

import java.util.List;

public interface MathManager {
    //boolean realizarOperacion (VersionAnterior.OperacionMatematica ope, MathManager.MathManager.Alumno alumno);
    boolean realizarOperacion (Operacion ope);
    List<Instituto> listadoInstitutos ();
    Integer procesarOperacion();
    List<Operacion> operacionesInstituto(String nombreInstituto);
    List<Operacion> operacionesAlumno (Alumno alumno);


    void addInstituto(Instituto insti);
    void addAlumno(Alumno alum);
    Instituto consultarInstituto(String nombreInsti);
    void crearInstitutosYAlumnos();
    Alumno consultarAlumno (String alumno);
    void modIniciadorTest1 ();
    void modIniciadorTest2 ();
    void modIniciadorRest ();
    int getIniciadorRest ();
    int getIniciadorTest1 ();
    int getIniciadorTest2 ();

}
