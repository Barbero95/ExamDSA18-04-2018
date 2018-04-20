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
        Operacion op1 = null;
        Operacion op2 = null;
        this.david.addlistaOperaciones(op1);
        this.david.addlistaOperaciones(op2);
        List<Operacion> operacionesMatematicas = new ArrayList<Operacion>(this.david.consultaOperaciones());
        Alumno alumno = this.math.consultarAlumno("David");
        List<Operacion> operacionesMatematicasPrueba = this.math.operacionesAlumno(alumno);
        assertEquals(operacionesMatematicas.size(), operacionesMatematicasPrueba.size());
        assertEquals(operacionesMatematicas.get(0), operacionesMatematicasPrueba.get(0));

    }
    @Test
    public void operacionesInstitutoTest(){
        Expressio op1 = null;
        Expressio op2 = null;
        /*
        op1.addOperacio(new VersionAnterior.Expresio(5));
        op1.addOperacio(new VersionAnterior.Expresio(1));
        op1.addOperacio(new VersionAnterior.Expresio("+"));
        this.ruben.addlistaOperaciones(op1);
        op2.addOperacio(new VersionAnterior.Expresio(5));
        op2.addOperacio(new VersionAnterior.Expresio(1));
        op2.addOperacio(new VersionAnterior.Expresio("-"));
        this.ruben.addlistaOperaciones(op2);
        */
        //List<VersionAnterior.OperacionMatematica> operacionesPrueba = new ArrayList<VersionAnterior.OperacionMatematica>();
        //operacionesPrueba.add(op1);
        //operacionesPrueba.add(op2);
        List<Operacion> operacionesMatematicas = new ArrayList<Operacion>(this.ruben.consultaOperaciones());

        //this.math.realizarOperacion(op1);
        //this.math.realizarOperacion(op2);
        // this.math.procesarOperacion();
        //this.math.procesarOperacion();
        List<Operacion> operacionesMatematicasPrueba = this.math.operacionesInstituto(this.maristes.getNombreInstituto());

        assertEquals(operacionesMatematicas.size(), operacionesMatematicasPrueba.size());
        assertEquals(operacionesMatematicas.get(0), operacionesMatematicasPrueba.get(0));
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


        /*
        //alumno no existe
        VersionAnterior.OperacionMatematica op2=null;
        op2.addOperacio(new VersionAnterior.Expresio(5));
        MathManager.MathManager.Alumno alumnoNoExistente = null;
        alumnoNoExistente.setNombre("xxxx");
        op1.setAlumno(alumnoNoExistente);
        boolean resp2 = this.math.realizarOperacion(op1);
        assertEquals(false, resp2);
        */
    }
    @Test
    public void procesarTest(){
        Alumno alumno = this.math.consultarAlumno("David");
        this.math.realizarOperacion(new Operacion());
        int x = this.math.procesarOperacion();
        assertEquals(0, x);
    }

}
