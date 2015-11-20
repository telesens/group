/**
 * Created by oleg on 11/20/15.
 */
// enum только для удобства тестирования
//enum NameOfStations{
//    KHARKOV,
//    LUBOTIN,
//    NOVOSOLOVKA,
//    MERCHIK,
//    KRASNOGRAD,
//    LOZOVAYA;
//}

public class Main {
    //private static TrainStation[] stations;
    private static TransportNetwork<TrainStation> trainNetwork;

    public static void main(String[] args) {
        trainNetwork = new TransportNetwork<>("Железнодорожная транспортная сеть");

        initStations();
        initArcs();

        System.out.println("Train network" + trainNetwork);
        printAllArcs();
        printAllStations();
        testNearestStations();
        printOrderedStations();
        printFastestArc();
    }
    private static void initStations() {
//        stations = new TrainStation[NameOfStations.values().length];
//
//        stations[NameOfStations.KHARKOV.ordinal()] = new TrainStation("Харьков");
//        stations[NameOfStations.LUBOTIN.ordinal()] = new TrainStation("Люботин");
//        stations[NameOfStations.NOVOSOLOVKA.ordinal()] = new TrainStation("Новоселовка");
//        stations[NameOfStations.MERCHIK.ordinal()] = new TrainStation("Мерчик");
//        stations[NameOfStations.KRASNOGRAD.ordinal()] = new TrainStation("Красноград");
//        stations[NameOfStations.LOZOVAYA.ordinal()] = new TrainStation("Лозовая");
    }

    private static void initArcs() {
        try {
            trainNetwork.addArc(
                    new Arc<>(
                            new TrainStation("Харьков"),
                            new TrainStation("Новоселовка"),
                            2, 5)
            );

            trainNetwork.addArc(
                    new Arc<>(
                            new TrainStation("Новоселовка"),
                            new TrainStation("Люботин"),
                            22, 35)
            );

            trainNetwork.addArc(
                    new Arc<>(
                            new TrainStation("Новоселовка"),
                            new TrainStation("Мерчик"),
                            23, 30)
            );

            trainNetwork.addArc(
                    new Arc<>(
                            new TrainStation("Люботин"),
                            new TrainStation("Мерчик"),
                            18, 35)
            );

            trainNetwork.addArc(
                    new Arc<>(
                            new TrainStation("Мерчик"),
                            new TrainStation("Красноград"),
                            76, 120)
            );

            trainNetwork.addArc(
                    new Arc<>(
                            new TrainStation("Мерчик"),
                            new TrainStation("Лозовая"),
                            123, 120)
            );

            // in the next statement will get exception
            trainNetwork.addArc(
                    new Arc<>(
                            new TrainStation("Мерчик"),
                            new TrainStation("Мерчик"),
                            123, 120)
            );
        } catch(Arc.ErrorNodesInit err) {
            err.printError();
        }
    }

    private static void printAllArcs() {
        System.out.println("\n--------------All arcs---------------");

        Object[] arcs = trainNetwork.getAllArcs();
        for (Object arc : arcs)
            System.out.println(arc);
    }

    private static void printAllStations() {
        System.out.println("\n---------------Full list of the station-----------------");

        Object[] stations = trainNetwork.getAllNodes();
        for (Object station : stations)
            System.out.println(station);
    }

    private static void testNearestStations() {
        Object[] nearestStations = trainNetwork.getNearestNodes(new TrainStation("Лозовая"));

        System.out.println("\n-------------------All the nearest stations------------------");
        for (Object station : nearestStations) {
            System.out.println(station);
        }
    }

    private static void printOrderedStations() {
        Object[] orderedStations = trainNetwork.getOrderedNodes();

        System.out.println("\n-------------------The stations ordered by count of the relations stations------------------");
        for (Object station : orderedStations)
            System.out.println(station);
    }

    private static void printFastestArc() {
        System.out.println("\n-------------------The fastest arc------------------");
        System.out.println(trainNetwork.getFastestArc());
    }
}
