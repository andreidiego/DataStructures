package clrs.stack;

public class DoubleArrayStack<T> implements DoubleStack<T> {

	private int rightTop;
	private T[] array;
	private int leftTop;

	@SuppressWarnings("unchecked")
	public DoubleArrayStack() {
		array = (T[]) new Object[10];
		leftTop = array.length - 1;
	}

	@Override
	public boolean isRightStackEmpty() {
		return rightTop == 0;
	}

	@Override
	public boolean isLeftStackEmpty() {
		return leftTop == array.length - 1;

	}

	@Override
	public void pushRight(T item) {

		if (thereIsRoomInRight()) {
			array[rightTop++] = item;

		} else {
			throw new ArrayIndexOutOfBoundsException(
					"You are trying to push elements to a full stack. You probably need a bigger stack.");
		}

	}

	@Override
	public void pushLeft(T item) {

		if (thereIsRoomInLeft()) {
			array[leftTop--] = item;

		} else {
			throw new ArrayIndexOutOfBoundsException(
					"You are trying to push elements to a full stack. You probably need a bigger stack.");
		}

	}

	private boolean thereIsRoomInRight() {
		return rightTop < array.length && rightTop <= leftTop;
	}

	private boolean thereIsRoomInLeft() {
		return leftTop >= 0 && leftTop >= rightTop;
	}

	@Override
	public int rightStackSize() {
		return rightTop;
	}

	@Override
	public int leftStackSize() {
		return array.length - 1 - leftTop;
	}

	@Override
	public T popRight() {

		if (isRightStackEmpty()) {
			throw new ArrayIndexOutOfBoundsException(
					"You are trying to pop items from an empty stack.");
		}

		return array[--rightTop];
	}

	@Override
	public T popLeft() {

		if (isLeftStackEmpty()) {
			throw new ArrayIndexOutOfBoundsException(
					"You are trying to pop items from an empty stack.");
		}

		return array[++leftTop];
	}

}
