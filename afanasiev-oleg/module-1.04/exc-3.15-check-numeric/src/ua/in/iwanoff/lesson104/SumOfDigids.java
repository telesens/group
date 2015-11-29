package ua.in.iwanoff.lesson104;

/**
 * Created by oleg on 11/29/15.
 */
public class SumOfDigids {

    public static void main(String[] args) {
        String n = args[0];
        int sum = 0;
        for (int i = 0; i < n.length(); i++) {
            if (charIsNumeric(n.charAt(i)))
                sum += Integer.parseInt(n.charAt(i) + "");
        }
        System.out.println(sum);
    }

    private static boolean charIsNumeric(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
