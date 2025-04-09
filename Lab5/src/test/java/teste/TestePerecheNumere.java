package teste;

import lucrareLab.PerecheNumere;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestePerecheNumere {
    @Test
    public void tes1_suma()
    {
        PerecheNumere p=new PerecheNumere(20,80);
        assertFalse(p.suntCuAcelasiSumaCifre());
    }

    @Test
    public void tes2_suma()
    {
        PerecheNumere p=new PerecheNumere(5,8);
        assertTrue(p.suntNrConsecutiveInFib());
    }

    @Test
    public void tes3_suma()
    {
        PerecheNumere p=new PerecheNumere(10,10);
        assertTrue(p.suntCuNrCifrePare());
    }

}
