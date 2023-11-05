package lab3.interfaces;

public interface Stack<E> {
    boolean isEmpty();
    int size();
    void push(E item);
    E pop();
    E peek();
}
