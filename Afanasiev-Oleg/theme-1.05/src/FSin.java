import com.sun.corba.se.spi.orbutil.fsm.FSM;

/**
 * Created by oleg on 11/16/15.
 */
public class FSin extends AbstractFunc{
    public FSin() {

    }

    public double f(double x) {
        return Math.sin(x);
    }
}
