/**
 * Created by oleg on 11/16/15.
 */
public class Main {
    public static void main(String[] args) {
        FSquare fSquare = new FSquare();
        FSin fSin = new FSin();
        System.out.println("min of x^2 on [5, 10] = " + fSquare.min(5, 10));
        System.out.println("min of sin on [-PI/2, PI/2] = " + fSin.min(-Math.PI /2, Math.PI /2 ));
    }
}
