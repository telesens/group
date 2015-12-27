/*
    Реализовать предыдущее задание с вводом с клавиатуры значения аргумента и
    использованием средств динамической компиляции кода.
    Добавить возможность вызова математических функций Java.
 */
package com.telesens.afanasiev;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by oleg on 12/27/15.
 */
public class Main {
    private static final String sourceFile = "out/production/exc-3.04-reflection-dynamic-compile/com/telesens/afanasiev/MathExp.java";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the math expression f(x) (example '3 + cos(x)') # ");
        String expr = scanner.nextLine();
        getSource(expr);

        try {
            if (compile()) {
                System.out.print("Input x: ");
                double x = scanner.nextDouble();
                Class<?> cls = Class.forName("com.telesens.afanasiev.MathExp");
                Method m = cls.getMethod("func", double.class);
                System.out.printf("%s = %s %n", expr, m.invoke(null, new Object[]{x}));
            }
        } catch(ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException exc) {
            exc.printStackTrace();
        }
    }

    private static void getSource(String expression) {
        try (PrintWriter out = new PrintWriter(sourceFile)) {
            out.println("package com.telesens.afanasiev;");
            out.println("import static java.lang.Math.*;");
            out.println("public class MathExp {");
            out.println("   public static double func(double x) {");
            out.println("       return " + expression + ";");
            out.println("   }");
            out.println("}");
        } catch(IOException exc) {
            exc.printStackTrace();
        }
    }

    private static boolean compile() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        return compiler.run(System.in, System.out, System.err, sourceFile) == 0;
    }
}
