import java.util.Collection;

/**
 * Created by oleg on 11/20/15.
 */
enum NameOfStations{
    KHARKOV,
    LUBOTIN,
    NOVOSOLOVKA,
    MERCHIK,
    KRASNOGRAD,
    LOZOVAYA;
}

public class Main {
    private static TrainStation[] stations;
    private static TransportNetwork<TrainStation> trainNetwork;

    public static void main(String[] args) {
        trainNetwork = new TransportNetwork<>("Железнодорожная транспортная сеть");

        initStations();
        initSections();

        System.out.println("Train network" + trainNetwork);
        printAllSections();
        printAllNodes();
        testNearestNodes();
    }
    private static void initStations() {
        stations = new TrainStation[NameOfStations.values().length];

        stations[NameOfStations.KHARKOV.ordinal()] = new TrainStation("Харьков");
        stations[NameOfStations.LUBOTIN.ordinal()] = new TrainStation("Люботин");
        stations[NameOfStations.NOVOSOLOVKA.ordinal()] = new TrainStation("Новоселовка");
        stations[NameOfStations.MERCHIK.ordinal()] = new TrainStation("Мерчик");
        stations[NameOfStations.KRASNOGRAD.ordinal()] = new TrainStation("Красноград");
        stations[NameOfStations.LOZOVAYA.ordinal()] = new TrainStation("Лозовая");
    }

    private static void initSections() {
        try {
            trainNetwork.addSection(
                    new Section(
                            stations[NameOfStations.KHARKOV.ordinal()],
                            stations[NameOfStations.NOVOSOLOVKA.ordinal()],
                            2, 5)
            );

            trainNetwork.addSection(
                    new Section(
                            stations[NameOfStations.NOVOSOLOVKA.ordinal()],
                            stations[NameOfStations.LUBOTIN.ordinal()],
                            22, 35)
            );

            trainNetwork.addSection(
                    new Section(
                            stations[NameOfStations.NOVOSOLOVKA.ordinal()],
                            stations[NameOfStations.MERCHIK.ordinal()],
                            23, 30)
            );

            trainNetwork.addSection(
                    new Section(
                            stations[NameOfStations.LUBOTIN.ordinal()],
                            stations[NameOfStations.MERCHIK.ordinal()],
                            18, 35)
            );

            trainNetwork.addSection(
                    new Section(
                            stations[NameOfStations.MERCHIK.ordinal()],
                            stations[NameOfStations.KRASNOGRAD.ordinal()],
                            76, 120)
            );

            trainNetwork.addSection(
                    new Section(
                            stations[NameOfStations.MERCHIK.ordinal()],
                            stations[NameOfStations.LOZOVAYA.ordinal()],
                            123, 120)
            );

            trainNetwork.addSection(
                    new Section(
                            stations[NameOfStations.MERCHIK.ordinal()],
                            stations[NameOfStations.MERCHIK.ordinal()],
                            123, 120)
            );
        } catch(Section.ErrorNodesInit err) {
            err.printError();
        }
    }

    private static void printAllSections() {
        System.out.println("All sections: ");

        Object[] sections = trainNetwork.getAllSections();
        for (Object section : sections)
            System.out.println(section);
    }

    private static void printAllNodes() {
        System.out.println("All nodes: ");

        Object[] stations = trainNetwork.getAllNodes();
        for (Object station : stations)
            System.out.println(station);
    }

    private static void testNearestNodes() {
        Object[] nearestStations = trainNetwork.getNearestNodes(stations[NameOfStations.LUBOTIN.ordinal()]);

        System.out.println("Nearest stations: ");
        for (Object station : nearestStations) {
            System.out.println(station);
        }
    }
}
