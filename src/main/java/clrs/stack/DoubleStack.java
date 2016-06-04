package clrs.stack;

public interface DoubleStack<T> {

	boolean isRightStackEmpty();

	boolean isLeftStackEmpty();

	void pushRight(T item);

	void pushLeft(T item);

	int rightStackSize();

	int leftStackSize();

	T popRight();

	T popLeft();

}
