package com.github.telesens.group.afanasiev.queue;

import java.util.NoSuchElementException;


/**
 * Created by oleg on 12/3/15.
 */
public class Main {
    private static ArrayQueue<Integer> intQueue;
    private static ArrayQueue<String> personQueue;

    public static void main(String[] args) {
        System.out.println("******************Test queue*****************");
        intQueue = new ArrayQueue<>();
        personQueue = new ArrayQueue<>(5);

        testIntegerQueue();
        testStringQueue();
    }

    private static void testIntegerQueue() {
        int size = 15;

        for (int i = 1; i <= size; i++) {
            intQueue.offer(i);
        }

        System.out.println("----------------Fill intQueue by calling offer [1..15]-------------------------");

        print(intQueue);

        System.out.println("----------------Clear intQueue-------------------------");

        intQueue.clear();
        print(intQueue);

        System.out.println("----------------Test overflow [21..35]-------------------------");

        for (int i = 1; i <= size + 5; i++) {
            intQueue.offer(20 + i);
        }

        print(intQueue);

        System.out.println("----------------Test overflow with exception [101..115]-------------------------");

        intQueue.clear();

        try {
            for (int i = 1; i <= size + 5; i++) {
                intQueue.add(100 + i);
            }
        } catch(IllegalStateException exc) {
            System.out.println("I caught exception.");
        }

        print(intQueue);

        System.out.println("----------------Test peek-------------------------");

        System.out.printf("peek: %d %n", intQueue.peek());

        System.out.println("clear");
        intQueue.clear();

        System.out.printf("Try peek again: %d %n%n", intQueue.peek());

        for (int i = 1; i <= size + 5; i++) {
            intQueue.offer(i);
        }

        System.out.println("----------------Test poll-------------------------");

        System.out.printf("Current: %s %n", intQueue);
        System.out.printf("poll: %d %n", intQueue.poll());
        System.out.printf("After polling: %s %n", intQueue);

        System.out.println("clear");
        intQueue.clear();

        System.out.printf("Try poll again: %d %n%n", intQueue.poll());

        for (int i = 1; i <= size + 5; i++) {
            intQueue.offer(i);
        }

        System.out.println("----------------Test remove-------------------------");

        System.out.printf("Current: %s %n", intQueue);
        System.out.printf("remove: %d %n", intQueue.remove());
        System.out.printf("After removing: %s %n", intQueue);

        System.out.println("clear");
        intQueue.clear();

        try {
            System.out.printf("Try remove again: %d %n%n", intQueue.remove());
        } catch(NoSuchElementException exc) {
            System.out.println("I caught exception!");
        }

    }

    private static void testStringQueue() {
        int size = 5;

        Students  group = new Students(size);
        System.out.println("\n------------------Test string queue----------------------");

        System.out.printf("Empty queue: %s %n", group);
        group.add("Andry");
        group.add("Oleg");
        group.add("Mi56kle"); // incorrect name
        group.add("Sergey");
        group.add("Katya");

        System.out.printf("Queue after fulling: %s %n", group);
        System.out.println("Queue is full");
    }

    private static void print(ArrayQueue queue) {
        System.out.printf("queue.toString(): %n%s %n%n", queue);
        System.out.printf("queue.testShow(): %n%s, %n%n", queue.testShow());
    }
}
