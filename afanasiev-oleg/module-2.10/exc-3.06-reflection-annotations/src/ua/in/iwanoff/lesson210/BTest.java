package ua.in.iwanoff.lesson210;

/**
 * Created by oleg on 12/27/15.
 */
public class BTest {

    @ToInvoke (run = false)
    public void bFirst() {
        System.out.println("bFirst launched");
    }

    public void bSecond() {
        System.out.println("bSecond launched");
    }

    @ToInvoke (run = true)
    public void bThird() {
        System.out.println("bThird launched");
    }
}
