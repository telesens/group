/**
 * Created by oleg on 11/20/15.
 */
public class Triangle {

    public class InitTriangleError extends Exception {
        private double a, b, c;

        public InitTriangleError(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public void printError() {
            System.out.println("The length of each side must be less then sum of the lengths of the another sides");
            System.out.printf("(a = %f, b = %f, c = %f)%n", a, b, c);
            System.exit(1);
        }
    }
    private double a, b, c;

    public Triangle(double a, double b, double c) throws InitTriangleError{
        if (!check(a, b, c))
            throw new InitTriangleError(a, b, c);

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        double m1, m2, m3, m4, S;

        m1 = a + b + c;
        m2 = b + c - a;
        m3 = a + c - b;
        m4 = a + b - c;
        S = 1.0/4*Math.sqrt(m1 * m2 * m3 * m4);

        return S;
    }

    public void print() {
        System.out.printf("(a = %f, b = %f, c = %f, S = %f) %n", a, b, c, area());
    }

    @Override
    public String toString() {
        String str = "(a = " + a + ", b = " + b + ", c = " + c + ", S =" + area() + ")\n";
        return str;
    }

    private boolean check(double a, double b, double c)  {
        if (a > b + c || b > a + c || c > a + b)
            return false;
        else
            return true;
    }
}
