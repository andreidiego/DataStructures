package clrs.stack;


public class ArrayStack<T> implements Stack<T> {

	private int top;
	private T[] array;

	public ArrayStack() {
		this(10);
	}

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		array = (T[]) new Object[capacity];
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public void push(T item) {
		
		if(top >= capacity()) {
			throw new ArrayIndexOutOfBoundsException("You are trying to add more items than the stack capacity.");
		}
		
		array[top++] = item;
	}

	@Override
	public T pop() {
		
		if(isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("You are trying to pop items from an empty stack.");
		}
		
		return array[--top];
	}

	@Override
	public int size() {
		return top;
	}

	@Override
	public int capacity() {
		return array.length;
	}

	@Override
	public boolean isFull() {
		return size() == capacity();
	}

	@Override
	public boolean contains(T item) {
		
		for(int i = 0; i < top; i++) {
			
			if(array[i].equals(item))
				return true;
		}
		
		return false;
	}
}
