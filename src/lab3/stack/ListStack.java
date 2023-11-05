package lab3.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

import java.util.Queue;;
import lab3.interfaces.Stack;

public class ListStack<E> implements Stack<E>{
    private LinkedList<E> deque = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public void push(E item) {
        deque.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return deque.removeLast();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return deque.getLast();
    }
    public E getFirst(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return deque.getFirst();
    }
}
