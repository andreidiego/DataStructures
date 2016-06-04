package clrs.queue;

public interface Queue<T> {

	int size();

	int capacity();

	void enqueue(T item);

	boolean contains(T item);

	T deque();

	boolean isEmpty();

	boolean isFull();

}
