/**
 * Created by oleg on 11/16/15.
 */
public class Main {
    public static void main(String[] args) {
        Complex z1 = new Complex(2, 4);
        Complex z2 = new Complex(5, 7);
        double c = 5;

        System.out.println("z1 = " + z1);
        System.out.println("z2 = " + z2);
        System.out.println("Re(z1) = " + z1.re());
        System.out.println("Im(z1) = " + z1.im());
        System.out.println("z1 + z2 = " + z1.plus(z2));
        System.out.println("z1 - z2 = " + z1.minus(z2));
        System.out.println("z1 * z2 = " + z1.mult(z2));
        System.out.printf("z1 * %.2f = %s \n", c, z1.mult(c));
        System.out.println("z1 / z2 = " + z1.div(z2));
        System.out.println("1 / z1 = " + z1.reciprical());
        System.out.println("(z1 / z2) * z2 = " + z1.div(z2).mult(z2));
    }
}
