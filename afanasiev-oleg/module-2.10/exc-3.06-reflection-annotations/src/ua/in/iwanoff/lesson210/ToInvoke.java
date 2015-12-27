package ua.in.iwanoff.lesson210;

import java.lang.annotation.*;

/**
 * Created by oleg on 12/27/15.
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ToInvoke {
    boolean run();
}
