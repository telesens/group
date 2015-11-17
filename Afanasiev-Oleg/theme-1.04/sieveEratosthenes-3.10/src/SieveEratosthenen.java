/**
 * Created by oleg on 11/14/15.
 */
public class SieveEratosthenen
{
    private final int N;
    private int[] arr;

    public SieveEratosthenen(int n) {
        N = n;
        initArray();
        solve();
    }

    public void print() {
        final int maxCol = 30;

        for (int i = 0, col = 1; i < N; i++, col++) {
            System.out.printf("%4d ", arr[i]);

            if (col == maxCol) {
                System.out.println();
                col = 0;
            }
        }
    }

    public void printOnlyPrime() {
        final int maxCol = 30;

        for (int i = 0, col = 0; i < N; i++) {
            if (arr[i] > 0) {
                col++;
                System.out.printf("%4d ", arr[i]);

                if (col == maxCol) {
                    col = 0;
                    System.out.println();
                }
            }
        }
    }

    private void initArray() {
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
    }

    private void solve() {
        for (int i = 1; i < N; i++) {
            iter(i);
        }
    }

    private void iter(int i) {
        if (arr[i] < 0)
            return;

        int step = arr[i];

        for (int j = i + step; j < N; j+= step) {
            if (arr[j] > 0)
                arr[j] = - arr[j];
        }
    }
}
