package clrs.queue;

import java.util.NoSuchElementException;

import clrs.stack.ArrayStack;
import clrs.stack.Stack;

public class DoubleStackQueue<T> implements Queue<T> {
	private Stack<T> enqueueStack;
	private Stack<T> dequeueStack;

	public DoubleStackQueue() {
		this(10);
	}

	public DoubleStackQueue(int capacity) {
		enqueueStack = new ArrayStack<>(capacity);
		dequeueStack = new ArrayStack<>(capacity);
	}

	@Override
	public int size() {
		return enqueueStack.size() + dequeueStack.size();
	}

	@Override
	public int capacity() {
		return enqueueStack.capacity();
	}

	@Override
	public void enqueue(T item) {

		if (isFull())
			throw new ArrayIndexOutOfBoundsException(
					"This Queue is already full. To be able to insert new elements, some existing elements must be removed first.");

		enqueueStack.push(item);
	}

	@Override
	public boolean contains(T item) {
		return enqueueStack.contains(item) || dequeueStack.contains(item);
	}

	@Override
	public T deque() {
		T itemToBeReturned;

		if (dequeueStack.isEmpty()) {

			if (enqueueStack.isEmpty())
				throw new NoSuchElementException("This Queue is empty.");

			int enqueueStackSize = enqueueStack.size();

			for (int i = 0; i < enqueueStackSize - 1; i++) {
				dequeueStack.push(enqueueStack.pop());
			}

			itemToBeReturned = enqueueStack.pop();

		} else {
			itemToBeReturned = dequeueStack.pop();
		}

		return itemToBeReturned;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean isFull() {
		return enqueueStack.size() + dequeueStack.size() == capacity();
	}

}
