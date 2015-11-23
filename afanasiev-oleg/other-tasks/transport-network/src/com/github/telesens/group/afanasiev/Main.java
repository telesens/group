package com.github.telesens.group.afanasiev;

import java.util.Collection;

/**
 * Created by oleg on 11/20/15.
 */
public class Main {
    private static TransportNetwork<TrainStation> trainNetwork;

    public static void main(String[] args) {
        trainNetwork = new TransportNetwork<>("Железнодорожная транспортная сеть");

        initArcs();

        System.out.println("Train network" + trainNetwork);
        printAllArcs();
        printAllStations();
        testNearestStations();
        printOrderedStations();
        printFastestArc();
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

            // The next statement will get exception
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

        Collection<Arc<TrainStation>> arcs = trainNetwork.getAllArcs();
        for (Arc<TrainStation> arc : arcs)
            System.out.println(arc);
    }

    private static void printAllStations() {
        System.out.println("\n---------------Full list of the station-----------------");

        Collection<TrainStation> stations = trainNetwork.getAllNodes();
        for (TrainStation station : stations) {
            System.out.println(station);
        }
    }

    private static void testNearestStations() {
        Collection<TrainStation> nearestStations = trainNetwork.getNearestNodes(new TrainStation("Лозовая"));

        System.out.println("\n-------------------All the nearest stations------------------");
        for (TrainStation station : nearestStations) {
            System.out.println(station);
        }
    }

    private static void printOrderedStations() {
        Collection<TrainStation> orderedStations = trainNetwork.getOrderedNodes();

        System.out.println("\n-------------------The stations ordered by count of the relations stations------------------");
        for (TrainStation station : orderedStations)
            System.out.println(station);
    }

    private static void printFastestArc() {
        System.out.println("\n-------------------The fastest arc------------------");
        System.out.println(trainNetwork.getFastestArc());
    }
}
