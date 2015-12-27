package ua.in.iwanoff.lesson210;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by oleg on 12/27/15.
 */
public class LaunchIfAnnotated {

    public static void invkeFromClass(String className) {
        System.out.println("----------- class " + className + " -----------");
        try {
            Class<?> cls = Class.forName(className);
            Method[] methods = cls.getMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(ToInvoke.class) &&
                        m.getAnnotation(ToInvoke.class).run()) {
                    m.invoke(cls.newInstance());
                }
            }
        } catch(ClassNotFoundException | SecurityException |
                InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException exc) {
            exc.printStackTrace();
        }
    }
}
