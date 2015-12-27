import com.telesens.afanasiev.module_1_04.Fibonacci;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import static org.junit.Assert.*;

/**
 * Created by oleg on 12/27/15.
 */
public class TestFibonacci  {
    private Fibonacci fibonacci;
    private long[] fRes;

    @Before
    public void init() {
        fibonacci = new Fibonacci();
        fRes = new long[fibonacci.getMAX()+1];

        fRes[0] = 0;
        fRes[1] = 1;
        for (int i = 2; i <= fibonacci.getMAX(); i++)
                fRes[i] += fRes[i-1] + fRes[i-2];
    }

    @Test
    public void testFibonacciF() {
        int i = 1000000;
        Random random = new Random();
        int n;

        while (i-- > 0) {
            n = random.nextInt(fibonacci.getMAX());
            assertEquals(fRes[n], fibonacci.f(n));
        }
    }
}
