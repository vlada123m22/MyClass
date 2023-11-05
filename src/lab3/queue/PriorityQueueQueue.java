package lab3.queue;

import lab3.interfaces.Queue;

import java.util.PriorityQueue;

 public class PriorityQueueQueue<E> implements Queue<E> {
    private PriorityQueue<E> priorityQueue;

    public PriorityQueueQueue() {
        priorityQueue = new PriorityQueue<>();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    public int size() {
        return priorityQueue.size();
    }

    public void enqueue(E item) {
        priorityQueue.add(item);
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return priorityQueue.poll();
    }

    public E peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return priorityQueue.peek();
    }
}
