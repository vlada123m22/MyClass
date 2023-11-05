package lab3.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import lab3.interfaces.Stack;

public class ArrayStack<E> implements Stack<E> {
    private ArrayList<E> stackList = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    @Override
    public int size() {
        return stackList.size();
    }

    @Override
    public void push(E item) {
        stackList.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.remove(stackList.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.get(stackList.size() - 1);
    }
}

