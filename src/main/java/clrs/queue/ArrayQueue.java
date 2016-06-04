package clrs.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

	private int head;
	private int tail;
	private T[] array;
	private int size;

	public ArrayQueue() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		array = (T[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int capacity() {
		return array.length;
	}

	@Override
	public void enqueue(T item) {

		if (size() == capacity())
			throw new ArrayIndexOutOfBoundsException(
					"This Queue is already full. To be able to insert new elements, some existing elements must be removed first.");

		array[tail++] = item;
		size++;

		// Flawed after queue is completely filled and completely empty by the
		// first time
		if (tail == capacity())
			tail = 0;
	}

	@Override
	public boolean contains(T item) {

		int i = head;

		while (i != tail) {

			if (array[i].equals(item))
				return true;

			if (++i == array.length)
				i = 0;

		}

		return false;
	}

	@Override
	public T deque() {

		if (isEmpty())
			throw new NoSuchElementException("This Queue is empty.");

		T itemToRemove = array[head];

		if (++head == capacity())
			head = 0;

		size--;

		return itemToRemove;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean isFull() {
		return size() == capacity();
	}

}
