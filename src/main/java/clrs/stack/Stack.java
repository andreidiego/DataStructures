package clrs.stack;

public interface Stack<T> {

	public boolean isEmpty();

	public void push(T item);

	public T pop();

	public int size();

	public int capacity();

	public boolean isFull();

	public boolean contains(T item);

}
