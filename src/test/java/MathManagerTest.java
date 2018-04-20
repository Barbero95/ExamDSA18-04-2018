import java.*;

import javassist.expr.Expr;
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
        int x = this.math.getIniciadorTest2();
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

            this.math.modIniciadorTest2();
        }
    }
    @After
    public void tearDown() {
        //this.p.clear();
    }
    @Test
    public void listarinstitutosTest() {
        List<Instituto> listaInstitutos = new ArrayList<Instituto>();
        listaInstitutos.add(maristes);
        listaInstitutos.add(drasanes);
        Collections.sort(listaInstitutos, Comparator.comparing(Instituto::getNumOperacionesTotales));
        Collections.reverse(listaInstitutos);
        List<Instituto> listaInstitutosPrueba = new ArrayList<Instituto>(this.math.listadoInstitutos());
        assertEquals(listaInstitutos.size(), listaInstitutosPrueba.size());
        assertEquals(listaInstitutos.get(0), listaInstitutosPrueba.get(0));

    }
    @Test
    public void operacionesAlumnoTest(){
        OperacionMatematica op1 = null;
        OperacionMatematica op2 = null;
        this.david.addlistaOperaciones(op1);
        this.david.addlistaOperaciones(op2);
        List<OperacionMatematica> operacionesMatematicas = new ArrayList<OperacionMatematica>(this.david.consultaOperaciones());
        Alumno alumno = this.math.consultarAlumnoString("David");
        List<OperacionMatematica> operacionesMatematicasPrueba = this.math.operacionesAlumno(alumno);
        assertEquals(operacionesMatematicas.size(), operacionesMatematicasPrueba.size());
        assertEquals(operacionesMatematicas.get(0), operacionesMatematicasPrueba.get(0));

    }
    @Test
    public void operacionesInstitutoTest(){
        OperacionMatematica op1 = null;
        OperacionMatematica op2 = null;
        /*
        op1.addOperacio(new Expresio(5));
        op1.addOperacio(new Expresio(1));
        op1.addOperacio(new Expresio("+"));
        this.ruben.addlistaOperaciones(op1);
        op2.addOperacio(new Expresio(5));
        op2.addOperacio(new Expresio(1));
        op2.addOperacio(new Expresio("-"));
        this.ruben.addlistaOperaciones(op2);
        */
        //List<OperacionMatematica> operacionesPrueba = new ArrayList<OperacionMatematica>();
        //operacionesPrueba.add(op1);
        //operacionesPrueba.add(op2);
        List<OperacionMatematica> operacionesMatematicas = new ArrayList<OperacionMatematica>(this.ruben.consultaOperaciones());

        //this.math.realizarOperacion(op1);
        //this.math.realizarOperacion(op2);
        // this.math.procesarOperacion();
        //this.math.procesarOperacion();
        List<OperacionMatematica> operacionesMatematicasPrueba = this.math.operacionesInstituto(this.maristes.getNombreInstituto());

        assertEquals(operacionesMatematicas.size(), operacionesMatematicasPrueba.size());
        assertEquals(operacionesMatematicas.get(0), operacionesMatematicasPrueba.get(0));
    }
    @Test
    public void realizarPeticionDeOperacionTest(){
        OperacionMatematica op1=null;
        /*
        op1.addOperacio(new Expresio(5));
        op1.addOperacio(new Expresio(1));
        op1.addOperacio(new Expresio(2));
        op1.addOperacio(new Expresio("+"));
        op1.addOperacio(new Expresio(4));
        op1.addOperacio(new Expresio("*"));
        op1.addOperacio(new Expresio("+"));
        op1.addOperacio(new Expresio(3));
        op1.addOperacio(new Expresio("-"));
        op1.setAlumno(this.david);
        */
        Queue<Expresio> operacioCua = new LinkedList<Expresio>();
        operacioCua.add(new Expresio(5));
        operacioCua.add(new Expresio(1));
        operacioCua.add(new Expresio("+"));
        op1.setOperacioCua(operacioCua);
        //Alumno a = this.math.consultarAlumnoString("David");
        //op1.setAlumno(a);
        boolean resp = this.math.realizarOperacion(op1);
        assertEquals(true, resp);



        /*
        //alumno no existe
        OperacionMatematica op2=null;
        op2.addOperacio(new Expresio(5));
        Alumno alumnoNoExistente = null;
        alumnoNoExistente.setNombre("xxxx");
        op1.setAlumno(alumnoNoExistente);
        boolean resp2 = this.math.realizarOperacion(op1);
        assertEquals(false, resp2);
        */
    }
    @Test
    public void procesarTest(){
        Alumno alumno = this.math.consultarAlumnoString("David");
        this.math.realizarOperacion(new OperacionMatematica());
        int x = this.math.procesarOperacion();
        assertEquals(0, x);
    }

}
