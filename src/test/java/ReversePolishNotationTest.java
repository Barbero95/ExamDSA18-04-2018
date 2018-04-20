
import MathManager.*;
import ReversePolishNotation.*;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class ReversePolishNotationTest {
    ReversePolishNotation polish = null;
    Operacion operacion = null;
    Queue<Expressio> operacioCua = null;
    @Before
    public void setUp() {
        this.polish = Singleton2.getInstance().getImpl();
        int x = this.polish.getIniciadorTest2();
        if (x==0) {
            operacioCua = new LinkedList<Expressio>();
            operacioCua.add(new Numero(5));
            operacioCua.add(new Numero(1));
            operacioCua.add(new Numero(2));
            operacioCua.add(new Simbolo("+"));
            operacioCua.add(new Numero(4));
            operacioCua.add(new Simbolo("*"));
            operacioCua.add(new Simbolo("+"));
            operacioCua.add(new Numero(3));
            operacioCua.add(new Simbolo("-"));
            this.polish.modIniciadorTest2();
        }
    }
    @After
    public void tearDown() {
        //this.p.clear();
    }
    @Test
    public void procesarTest(){
        Operacion op1;
        Alumno alumno = null;
        op1 = new Operacion(operacioCua,alumno);
        int x = this.polish.procesarOp(op1);
        assertEquals(14, x);
    }

}
