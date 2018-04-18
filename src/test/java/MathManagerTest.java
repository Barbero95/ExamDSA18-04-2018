import java.*;
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
    public void operacionesAlumnoTest(){
        OperacionMatematica op1 = null;
        OperacionMatematica op2 = null;
        this.david.addlistaOperaciones(op1);
        this.david.addlistaOperaciones(op2);
        List<OperacionMatematica> operacionesMatematicas = new ArrayList<OperacionMatematica>(this.david.consultaOperaciones());
        List<OperacionMatematica> operacionesMatematicasPrueba = this.math.operacionesAlumno(this.david);
        assertEquals(operacionesMatematicas.size(), operacionesMatematicasPrueba.size());
        assertEquals(operacionesMatematicas.get(0), operacionesMatematicasPrueba.get(0));

    }
    public void operacionesInstitutoTest(){
        OperacionMatematica op1 = null;
        OperacionMatematica op2 = null;
        this.ruben.addlistaOperaciones(op1);
        this.ruben.addlistaOperaciones(op2);

        List<OperacionMatematica> operacionesMatematicas = new ArrayList<OperacionMatematica>(this.ruben.consultaOperaciones());

        this.math.realizarOperacion(op1,ruben);
        this.math.realizarOperacion(op2,ruben);
        this.math.procesarOperacion();
        this.math.procesarOperacion();
        List<OperacionMatematica> operacionesMatematicasPrueba = this.math.operacionesInstituto(this.maristes.getNombreInstituto());

        assertEquals(operacionesMatematicas.size(), operacionesMatematicasPrueba.size());
        assertEquals(operacionesMatematicas.get(0), operacionesMatematicasPrueba.get(0));
    }
    public void realizarTest(){
        OperacionMatematica op1 = null;
        this.david.addlistaOperaciones(op1);
        boolean resp = this.math.realizarOperacion(op1,this.david);
        assertEquals(true, resp);
    }
    public void procesarTest(){
        int x = this.math.procesarOperacion();
        assertEquals(0, x);
    }

}
