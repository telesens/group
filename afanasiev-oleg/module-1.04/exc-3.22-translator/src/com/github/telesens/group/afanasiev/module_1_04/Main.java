package com.github.telesens.group.afanasiev.module_1_04; /**
 * Created by oleg on 11/18/15.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input java code: ");
        String code = scanner.nextLine();

        System.out.println("Your code: " + code);
        checkCode(code);
        System.out.println("Changed code: " + javaToPascalTranslate(code));
    }

    private static String javaToPascalTranslate(String strJava) {
        String strPascal;
        strPascal = strJava.replaceAll("\\{", " begin ");
        strPascal = strPascal.replaceAll("\\}", " end ");

        return strPascal;
    }

    private static boolean checkCode(String str) {
        int nBraces = 0;

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '{')
                nBraces++;

            if (str.charAt(i) == '}')
                nBraces--;

            if (nBraces < 0) {
                System.out.printf("Error format near at %d posistion", i + 1);
                return false;
            }
        } // for

        if (nBraces > 0) {
            System.out.println("Error format. All the braces must be closed.");
            return false;
        }

        return true;
    }
}
