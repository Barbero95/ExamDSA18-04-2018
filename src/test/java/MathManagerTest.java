import MathManager.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class MathManagerTest {
    MathManager math = null;
    Instituto maristes = null;
    Instituto drasanes = null;
    Alumno david =null;
    Alumno ruben =null;
    Alumno jorge = null;
    @Before
    public void setUp() {
        this.math = Singleton.getInstance().getImpl();
        int x = this.math.getIniciadorTest();
        if (x==0) {
            this.maristes = new Instituto("Maristes");
            this.drasanes = new Instituto("Drasanes");
            this.david = new Alumno("David", this.maristes.getNombreInstituto());
            this.ruben = new Alumno("Ruben", this.maristes.getNombreInstituto());
            this.jorge = new Alumno("Jorge", this.drasanes.getNombreInstituto());


            this.maristes.introAlumno(david);
            this.maristes.introAlumno(ruben);
            this.drasanes.introAlumno(jorge);
            this.math.addInstituto(maristes);
            this.math.addInstituto(drasanes);
            this.math.addAlumno(this.david);
            this.math.addAlumno(this.ruben);
            this.math.addAlumno(this.jorge);

            this.math.modIniciadorTest();
        }
    }
    @After
    public void tearDown() {
        //this.p.clear();
    }
    @Test
    public void listarinstitutosTest() {
        //creo una lista ordenana ya con el resultado que me deberia dar
        List<Instituto> listaInstitutos = new ArrayList<Instituto>();
        Instituto insti1 = this.math.consultarInstituto("Maristes");
        Instituto insti2 = this.math.consultarInstituto("Drasanes");
        listaInstitutos.add(insti1);
        listaInstitutos.add(insti2);

        Operacion op1;
        Operacion op2;
        Queue<Expressio> operacioCua = new LinkedList<Expressio>();
        operacioCua.add(new Numero(5));
        operacioCua.add(new Numero(1));
        operacioCua.add(new Simbolo("+"));
        Alumno n1 = this.math.consultarAlumno("David");
        op1 = new Operacion(operacioCua,n1);
        op2 = new Operacion(operacioCua,n1);

        Operacion op3;
        Alumno n2 = this.math.consultarAlumno("Jorge");
        op3 = new Operacion(operacioCua,n2);

        this.math.realizarOperacion(op1);
        this.math.realizarOperacion(op2);
        this.math.realizarOperacion(op3);
        this.math.procesarOperacion();
        this.math.procesarOperacion();
        this.math.procesarOperacion();

        List<Instituto> listaInstitutosPrueba = new ArrayList<Instituto>(this.math.listadoInstitutos());
        assertEquals(listaInstitutos.size(), listaInstitutosPrueba.size());
        assertEquals(listaInstitutos.get(0), listaInstitutosPrueba.get(0));

    }
    @Test
    public void operacionesAlumnoTest(){
        Operacion op1;
        Operacion op2;
        Queue<Expressio> operacioCua = new LinkedList<Expressio>();
        operacioCua.add(new Numero(5));
        operacioCua.add(new Numero(1));
        operacioCua.add(new Simbolo("+"));
        Alumno n1 = this.math.consultarAlumno("David");
        op1 = new Operacion(operacioCua,n1);
        op2 = new Operacion(operacioCua,n1);

        this.math.realizarOperacion(op1);
        this.math.realizarOperacion(op2);
        this.math.procesarOperacion();
        this.math.procesarOperacion();

        List<Operacion> operacionesMatematicasPrueba = this.math.operacionesAlumno(n1);
        assertEquals(2, operacionesMatematicasPrueba.size());

    }
    @Test
    public void operacionesInstitutoTest(){
        Operacion op1;
        Operacion op2;
        Operacion op3;
        Queue<Expressio> operacioCua = new LinkedList<Expressio>();
        operacioCua.add(new Numero(5));
        operacioCua.add(new Numero(1));
        operacioCua.add(new Simbolo("+"));

        Alumno n1 = this.math.consultarAlumno("David");
        op1 = new Operacion(operacioCua,n1);
        Alumno n2 = this.math.consultarAlumno("Ruben");
        op2 = new Operacion(operacioCua,n2);
        Alumno n3 = this.math.consultarAlumno("Jorge");
        op3 = new Operacion(operacioCua,n3);

        this.math.realizarOperacion(op1);
        this.math.realizarOperacion(op2);
        this.math.realizarOperacion(op3);
        this.math.procesarOperacion();
        this.math.procesarOperacion();
        this.math.procesarOperacion();


        List<Operacion> operacionesMatematicas = new ArrayList<Operacion>(this.ruben.consultaOperaciones());

        List<Operacion> operacionesMatematicasPrueba1 = this.math.operacionesInstituto(this.maristes.getNombreInstituto());
        List<Operacion> operacionesMatematicasPrueba2 = this.math.operacionesInstituto(this.drasanes.getNombreInstituto());

        assertEquals(2, operacionesMatematicasPrueba1.size());
        assertEquals(1, operacionesMatematicasPrueba2.size());
    }
    @Test
    public void realizarPeticionDeOperacionTest(){
        Operacion op1;
        Queue<Expressio> operacioCua = new LinkedList<Expressio>();
        operacioCua.add(new Numero(5));
        operacioCua.add(new Numero(1));
        operacioCua.add(new Simbolo("+"));

        Alumno a = this.math.consultarAlumno("David");
        op1 = new Operacion(operacioCua,a);
        boolean resp = this.math.realizarOperacion(op1);
        assertEquals(true, resp);



        //alumno no existe
        Operacion op2=null;
        Queue<Expressio> operacioCua2 = new LinkedList<Expressio>();
        operacioCua2.add(new Numero(5));
        operacioCua2.add(new Numero(1));
        operacioCua2.add(new Simbolo("+"));
        Alumno alumnoNoExistente = new Alumno("Pitufo","Maristes");
        op2 = new Operacion(operacioCua2,alumnoNoExistente);
        boolean resp2 = this.math.realizarOperacion(op2);
        assertEquals(false, resp2);

    }
    @Test
    public void procesarTest(){
        Operacion op1;
        Queue<Expressio> operacioCua = new LinkedList<Expressio>();
        operacioCua.add(new Numero(5));
        operacioCua.add(new Numero(1));
        operacioCua.add(new Simbolo("+"));
        operacioCua.add(new Numero(5));
        operacioCua.add(new Simbolo("-"));

        Alumno alumno = this.math.consultarAlumno("David");
        op1 = new Operacion(operacioCua,alumno);
        boolean resp = this.math.realizarOperacion(op1);
        int x = this.math.procesarOperacion();
        assertEquals(1, x);
    }

}
