/**
 * Created by oleg on 11/20/15.
 */
public class TrainStation {
    private String name;

    public TrainStation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String str = "Station name: " + name;

        return str;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof TrainStation))
            return false;

        return this.name.equals(((TrainStation) other).name);
    }
}
