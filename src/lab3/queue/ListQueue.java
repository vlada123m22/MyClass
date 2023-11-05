package lab3.queue;

import lab3.interfaces.Queue;

import java.util.LinkedList;

public class ListQueue<E> implements Queue<E> {
    private LinkedList<E> list;

    public ListQueue() {
        list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void enqueue(E item) {
        list.addLast(item);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return list.removeFirst();
    }

    public E peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return list.getFirst();
    }
}

