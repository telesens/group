package ua.in.iwanoff.lesson210;

/**
 * Created by oleg on 12/27/15.
 */
public class ATest {
    public void aFirst() {
        System.out.println("aFirst launched");
    }

    @ToInvoke (run = true)
    public void aSecond() {
        System.out.println("aSecond launched");
    }

    @ToInvoke (run = false)
    public void aThird() {
        System.out.println("aThird launched");
    }

}
