package com.github.telesens.group.afanasiev.queue;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by oleg on 12/3/15.
 */
public class TestArrayQueue {
    private ArrayQueue<String> strQueue;
    private ArrayQueue<Integer> intQueue;
    private final int  sMax = 5;

    @Before
    public  void setup() {
        strQueue = new ArrayQueue<>(sMax);
        intQueue = new ArrayQueue<>();
    }

    @Test(expected=NullPointerException.class)
    public void testStringQueueOfferNull() {
        for (int i = 0; i <= 10; i++    )
            strQueue.offer(null);
    }

    @Test(expected = IllegalStateException.class)
    public void testStringQueueAddException() {
        for (int i = 0; i <= sMax * 2; i++) {
            strQueue.add("test");
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testStringQueueRemove () {
        for (int i = 0; i <= sMax * 2; i++)
            strQueue.remove();
    }

    @Test
    public void testStringQueueOfferPoll() {
        strQueue.clear();
        assertEquals(0, strQueue.size());

        assertTrue(strQueue.offer("Oleg"));
        assertEquals(1, strQueue.size());
        assertEquals("Oleg", strQueue.peek());

        assertTrue(strQueue.offer("Andry"));
        assertEquals(2, strQueue.size());
        assertEquals("Oleg", strQueue.peek());

        assertTrue(strQueue.offer("Viktor"));
        assertEquals(3, strQueue.size());
        assertEquals("Oleg", strQueue.peek());

        assertTrue(strQueue.offer("Vlad"));
        assertEquals(4, strQueue.size());
        assertEquals("Oleg", strQueue.peek());

        assertTrue(strQueue.offer("Kate"));
        assertEquals(5, strQueue.size());
        assertEquals("Oleg", strQueue.peek());

        for (int i = 1; i <= 10; i++) {
            assertFalse(strQueue.offer("Helen"));
            assertEquals(sMax, strQueue.size());
        }

        strQueue.clear();
        Random random = new Random();
        int size = 0;

        for (int i = 1; i <= 100000000; i++) {
            if (random.nextBoolean()) {
                if (size == sMax)
                    assertFalse(strQueue.offer("test"));
                else
                    assertTrue(strQueue.offer("test"));

                size = Math.min(sMax, size + 1);
                assertEquals(size, strQueue.size());
            }
            else {
                if (size == 0)
                    assertEquals(null, strQueue.poll());
                else {
                    assertEquals("test", strQueue.peek());
                    assertEquals("test", strQueue.poll());
                }

                size = Math.max(0, size - 1);
                assertEquals(size, strQueue.size());
            }
        }

        strQueue.clear();
        assertEquals(0, strQueue.size());
    }

    @Test
    public void testIterator() {
        strQueue.clear();
        for (Integer i = 1; i <= sMax; i++)
            strQueue.add(i.toString());

        Integer i = 1;
        Iterator iterator = strQueue.iterator();
        while(iterator.hasNext()) {
            assertEquals(i.toString(), iterator.next());
            i++;
        }
    }
}
