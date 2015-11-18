/**
 * Created by oleg on 11/18/15.
 */
public class Main {
    public static void main(String[] args) {

        System.out.print("Enter the number: ");
        byte n = Byte.parseByte(System.console().readLine());

        System.out.printf("n = %d%n", n);
        System.out.printf("binary reverse = ");

        for (int i = 0; i < 8; i++) {
            System.out.print((byte)(1 & (n >> i)));
        }
        System.out.println();
    }
}
