package lab3.queue;

import lab3.interfaces.Queue;

import java.util.ArrayDeque;

public class ArrayQueue<E> implements Queue<E> {
    private ArrayDeque<E> deque;

    public ArrayQueue() {
        deque = new ArrayDeque<>();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    public void enqueue(E item) {
        deque.addLast(item);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return deque.removeFirst();
    }

    public E peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return deque.getFirst();
    }
}
