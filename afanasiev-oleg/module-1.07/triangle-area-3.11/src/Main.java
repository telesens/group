import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;

/**
 * Created by oleg on 11/20/15.
 */
class CompareByArea implements Comparator<Triangle> {
    @Override
    public int compare(Triangle t1, Triangle t2) {
        return Double.compare(t1.area(), t2.area());
    }
}

public class Main {
    private static Triangle[] triangles;
    private static final int N = 10;

    public static void main(String[] args) {
        initTriangles();
        sortTriangles1();

        System.out.println(Arrays.toString(triangles));
    }

    private static void sortTriangles1() {
        Arrays.sort(triangles, new CompareByArea());
    }

    private static void sortTriangles2() {
        Arrays.sort(triangles, new Comparator<Triangle>() {
            @Override
            public int compare(Triangle t1, Triangle t2) {
                return Double.compare(t1.area(), t2.area());
            }
        });
    }

    private static void sortTriangles3() {
        Arrays.sort(triangles, (t1, t2) -> Double.compare(t1.area(), t2.area()));
    }

    private static void initTriangles() {
        double a, b, c;

        triangles = new Triangle[N];
        for (int i = 0; i < N; i++) {
            a = i + 2;
            b = i + 3;
            c = i + 4;

            try {
                triangles[N - i - 1] = new Triangle(a, b, c);
            } catch(Triangle.InitTriangleError er) {
                er.printError();
            }
        } // for
    }


}
