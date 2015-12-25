package com.github.telesens.group.afanasiev.queue;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * Created by oleg on 12/3/15.
 */
public class ArrayQueue<E> extends AbstractQueue<E>{
    class ArrayIterator implements Iterator<E> {

        private int cursor = head;
        private int fence = tail;

        @Override
        public boolean hasNext() {
            return cursor > -1 && cursor <= fence;
        }

        @Override
        public E next() {
            return (E)arr[cursor++ % arr.length];
        }
    }

    private final int N;
    private Object[] arr;
    private int head;
    private int tail;

    public ArrayQueue() {
        this.N = 15;
        init();
    }

    public ArrayQueue(int n) {
        this.N = n;
        init();
    }

    /**
     * Inserts the specified element at the front of this queue.
     *
     * @param e the element to add
     * @return {@code true}
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();

        if (tail - head + 1 > arr.length - 1)
            return false;

        if (tail == -1)
            head++;

        arr[++tail % arr.length] = e;

        correctCursor();

        return true;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {

        if (size() == 0) {
            return null;
        }

        E e = (E)arr[head++ % arr.length];

        return e;
    }

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    @Override
    public int size() {
        if (head == -1 || tail == -1)
            return 0;

        return tail - head + 1;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    /**
     * Retrieves, but does not remove, the head of the queue represented by
     * this queue, or returns {@code null} if this deque is empty.
     *
     * @return the head of the queue represented by this queue, or
     *         {@code null} if this queue is empty
     */
    @Override
    public E peek() {
        if (size() == 0)
            return null;

        return (E)arr[head % arr.length];
    }

    public String testShow() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if (!first)
                sb.append(", ");
            else
                first = false;

            sb.append(arr[i]);
        }
        sb.append("]\n");
        sb.append(String.format("head = %d, tail = %d, size = %d", head, tail, size()));
        return sb.toString();
    }

    private void init() {
        arr = new Object[N];
        head = -1;
        tail = -1;
    }

    private void correctCursor() {
        if (tail >= arr.length && head >= arr.length) {
            tail -= arr.length;
            head -= arr.length;
        }
    }
}
