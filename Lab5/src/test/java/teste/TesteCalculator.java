package teste;

import lucrareLab.Calculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteCalculator {
    @Test
    public void test1_suma() {
        Calculator c=new Calculator(4,5);
        assertEquals(9, c.suma());
    }
    @Test
   public void test2_suma() {
        Calculator c=new Calculator(2,2);
        assertTrue(c.suma()==4);
    }
    @Test
    public void test3_suma() {
        Calculator c=new Calculator(3,7);
        assertFalse(c.suma()!=10);
    }
}
