import com.github.telesens.group.afanasiev.module_2_04.BitsCollector;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

import static junit.framework.Assert.*;

/**
 * Created by oleg on 12/15/15.
 */
public class BitsCollectorTest {
    BitsCollector bitsCollector;

    @Before
    public void init() {
    }

    @Test
    public void globalTest() {
        testToArrayBytes(10_000_000);
        testToArrayBytes(10_000_003);
    }

    @Test
    public void testAddBit() {
        bitsCollector = new BitsCollector();

        bitsCollector.pushBit(0);
        bitsCollector.pushBit(1);
        assertEquals(2, bitsCollector.size());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(1, bitsCollector.size());
        assertEquals(1, bitsCollector.pollBit());

        assertEquals(0, bitsCollector.size());

        final int N = 10_000_000;

        for (int i = 1; i <= N; i++) {
            if ((i % 5) == 0)
                bitsCollector.pushBit(1);
            else
                bitsCollector.pushBit(0);

            assertEquals(i, bitsCollector.size());
        }

        assertEquals(N, bitsCollector.size());

        for (int i = 1; i <= N; i++) {
            if ((i % 5) == 0)
                assertEquals(1, bitsCollector.pollBit());
            else
                assertEquals(0, bitsCollector.pollBit());

            assertEquals(N - i, bitsCollector.size());
        }

        assertEquals(0, bitsCollector.size());
    }

    @Test
    public void removeLastBit() {
        bitsCollector = new BitsCollector();
        final int N = 85;

        for (int i = 1; i <= N; i++)
            if (i <= N / 2)
                bitsCollector.pushBit(1);
            else
                bitsCollector.pushBit(0);

        bitsCollector.pushBit(1);
        bitsCollector.pushBit(1);
        bitsCollector.pushBit(0);
        assertEquals(N + 3, bitsCollector.size());

        bitsCollector.removeLastBit();
        bitsCollector.removeLastBit();
        bitsCollector.removeLastBit();
        assertEquals(N, bitsCollector.size());

        for (int i = 1; i <= N; i++) {
            if (i <= N/2)
                assertEquals(1, bitsCollector.pollBit());
            else
                assertEquals(0, bitsCollector.pollBit());

            assertEquals(N-i, bitsCollector.size());
        }
    }

    @Test
    public void testIterator() {
        final int N = 10_000_000;
        BitsCollector bitsCollector = new BitsCollector();

        for (int i = 1; i <= N; i++)
            if (i % 5 == 0)
                bitsCollector.pushBit(1);
            else
                bitsCollector.pushBit(0);

        assertEquals(N, bitsCollector.size());
        Iterator<Integer> iterator = bitsCollector.iterator();
        int i = 1;
        while (iterator.hasNext()) {
            if (i % 5 == 0)
                assertEquals(1, (int)iterator.next());
            else
                assertEquals(0, (int)iterator.next());
            i++;
        }
        assertEquals(N, bitsCollector.size());
    }

    public void testToArrayBytes(int n) {

        BitsCollector bitsCollector = new BitsCollector();

        for (int i = 1; i <= n; i++)
            if (i % 3 == 0)
                bitsCollector.pushBit(1);
            else
                bitsCollector.pushBit(0);

        assertEquals(n, bitsCollector.size());
        Byte[] arr = bitsCollector.toArrayBytes();

        int cursor = 0;
        int nextBit;
        for (int i = 1; i <= n; i++) {
            nextBit = (arr[cursor] >> ((i - 1) % 8)) & 1;
            if (i % 3 == 0)
                assertEquals(nextBit, 1);
            else
                assertEquals(nextBit, 0);

            if (i % 8 == 0)
                cursor++;
        }
    }

    @Test
    public void testClone() {
        final int N = 100;
        BitsCollector bitsCollector = new BitsCollector();
        for (int i = 1; i <= N; i++)
            if (i % 7 == 0)
                bitsCollector.pushBit(0);
            else
                bitsCollector.pushBit(1);

        assertEquals(N, bitsCollector.size());
        BitsCollector cloned = bitsCollector.clone();
        assertEquals(N, cloned.size());

        for (int i = 1; i <= N; i++)
            if (i % 7 == 0)
                assertEquals(0, cloned.pollBit());
            else
                assertEquals(1, cloned.pollBit());
    }

    @Test
    public void testPushBitsFromBC() {
        final int N1 = 303;
        final int N2 = 5042;


        BitsCollector bitsCollector = new BitsCollector();
        BitsCollector bitsCollectorAdded = new BitsCollector();

        for (int i = 1; i <= N1; i++)
            if (i % 4 == 0)
                bitsCollector.pushBit(1);
            else
                bitsCollector.pushBit(0);

        for (int i = 1; i <= N2; i++)
            if (i % 3 == 0)
                bitsCollectorAdded.pushBit(0);
            else
                bitsCollectorAdded.pushBit(1);

        assertEquals(N1, bitsCollector.size());
        assertEquals(N2, bitsCollectorAdded.size());

        bitsCollector.pushBitsFrom(bitsCollectorAdded);

        assertEquals(N1 + N2, bitsCollector.size());
        assertEquals(N2, bitsCollectorAdded.size());

        for (int i = 1; i <= N1; i++)
            if (i % 4 == 0)
                assertEquals(1, bitsCollector.pollBit());
            else
                assertEquals(0, bitsCollector.pollBit());

        for (int i = 1; i <= N2; i++)
            if (i % 3 == 0) {
                assertEquals(0, bitsCollector.pollBit());
                assertEquals(0, bitsCollectorAdded.pollBit());
            } else {
                assertEquals(1, bitsCollector.pollBit());
                assertEquals(1, bitsCollectorAdded.pollBit());
            }
    }

    @Test
    public void testPushBitsFromArr() {
        final int N = 3;
        byte[] arrTest = new byte[N];
        Random random = new Random();
        //int startCursor = random.nextInt(N/2 - 5);
        int startCursor = 0;
        int nBits = 17;//startCursor * 8  + 5;

        for (int i = 0; i < N; i++) {
            arrTest[i] = (byte)(5 + i); // (byte)random.nextInt();
        }

        BitsCollector bitsCollector = new BitsCollector();
        bitsCollector.pushBitsFrom(arrTest, startCursor, nBits);

        assertEquals(nBits, bitsCollector.size());
        assertEquals(1, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(1, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());

        assertEquals(0, bitsCollector.pollBit());
        assertEquals(1, bitsCollector.pollBit());
        assertEquals(1, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());
        assertEquals(0, bitsCollector.pollBit());

        assertEquals(1, bitsCollector.pollBit());
    }
}
