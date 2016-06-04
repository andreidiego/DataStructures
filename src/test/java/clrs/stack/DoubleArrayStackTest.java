package clrs.stack;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clrs.stack.DoubleArrayStack;
import clrs.stack.DoubleStack;

public class DoubleArrayStackTest {

	DoubleStack<Integer> doubleStack;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		doubleStack = new DoubleArrayStack<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void reportsRightStackEmptyWhenNoItemsFound() {
		assertTrue(doubleStack.isRightStackEmpty());
	}

	@Test
	public void reportsLeftStackEmptyWhenNoItemsFound() {
		assertTrue(doubleStack.isLeftStackEmpty());
	}

	@Test
	public void reportsRightStackNotEmptyWhenItemsFound() {
		doubleStack.pushRight(10);
		assertFalse(doubleStack.isRightStackEmpty());
	}

	@Test
	public void reportsLeftStackNotEmptyWhenItemsFound() {
		doubleStack.pushLeft(10);
		assertFalse(doubleStack.isLeftStackEmpty());
	}

	@Test
	public void itemsAreCorrectlyPushedAndPoppedFromRightStack() {

		// Pushing
		doubleStack.pushRight(1);
		assertThat(doubleStack.rightStackSize(), is(1));

		doubleStack.pushRight(2);
		assertThat(doubleStack.rightStackSize(), is(2));

		doubleStack.pushRight(3);
		assertThat(doubleStack.rightStackSize(), is(3));

		doubleStack.pushRight(4);
		assertThat(doubleStack.rightStackSize(), is(4));

		doubleStack.pushRight(5);
		assertThat(doubleStack.rightStackSize(), is(5));

		doubleStack.pushRight(6);
		assertThat(doubleStack.rightStackSize(), is(6));

		doubleStack.pushRight(7);
		assertThat(doubleStack.rightStackSize(), is(7));

		doubleStack.pushRight(8);
		assertThat(doubleStack.rightStackSize(), is(8));

		doubleStack.pushRight(9);
		assertThat(doubleStack.rightStackSize(), is(9));

		// Popping
		assertThat(doubleStack.popRight(), is(9));
		assertThat(doubleStack.rightStackSize(), is(8));

		assertThat(doubleStack.popRight(), is(8));
		assertThat(doubleStack.rightStackSize(), is(7));

		assertThat(doubleStack.popRight(), is(7));
		assertThat(doubleStack.rightStackSize(), is(6));

		assertThat(doubleStack.popRight(), is(6));
		assertThat(doubleStack.rightStackSize(), is(5));

		assertThat(doubleStack.popRight(), is(5));
		assertThat(doubleStack.rightStackSize(), is(4));

		assertThat(doubleStack.popRight(), is(4));
		assertThat(doubleStack.rightStackSize(), is(3));

		assertThat(doubleStack.popRight(), is(3));
		assertThat(doubleStack.rightStackSize(), is(2));

		assertThat(doubleStack.popRight(), is(2));
		assertThat(doubleStack.rightStackSize(), is(1));

		assertThat(doubleStack.popRight(), is(1));
		assertThat(doubleStack.rightStackSize(), is(0));
	}

	@Test
	public void itemsAreCorrectlyPushedAndPoppedFromLeftStack() {

		// Pushing
		doubleStack.pushLeft(1);
		assertThat(doubleStack.leftStackSize(), is(1));

		doubleStack.pushLeft(2);
		assertThat(doubleStack.leftStackSize(), is(2));

		doubleStack.pushLeft(3);
		assertThat(doubleStack.leftStackSize(), is(3));

		doubleStack.pushLeft(4);
		assertThat(doubleStack.leftStackSize(), is(4));

		doubleStack.pushLeft(5);
		assertThat(doubleStack.leftStackSize(), is(5));

		doubleStack.pushLeft(6);
		assertThat(doubleStack.leftStackSize(), is(6));

		doubleStack.pushLeft(7);
		assertThat(doubleStack.leftStackSize(), is(7));

		doubleStack.pushLeft(8);
		assertThat(doubleStack.leftStackSize(), is(8));

		doubleStack.pushLeft(9);
		assertThat(doubleStack.leftStackSize(), is(9));

		// Popping
		assertThat(doubleStack.popLeft(), is(9));
		assertThat(doubleStack.leftStackSize(), is(8));

		assertThat(doubleStack.popLeft(), is(8));
		assertThat(doubleStack.leftStackSize(), is(7));

		assertThat(doubleStack.popLeft(), is(7));
		assertThat(doubleStack.leftStackSize(), is(6));

		assertThat(doubleStack.popLeft(), is(6));
		assertThat(doubleStack.leftStackSize(), is(5));

		assertThat(doubleStack.popLeft(), is(5));
		assertThat(doubleStack.leftStackSize(), is(4));

		assertThat(doubleStack.popLeft(), is(4));
		assertThat(doubleStack.leftStackSize(), is(3));

		assertThat(doubleStack.popLeft(), is(3));
		assertThat(doubleStack.leftStackSize(), is(2));

		assertThat(doubleStack.popLeft(), is(2));
		assertThat(doubleStack.leftStackSize(), is(1));

		assertThat(doubleStack.popLeft(), is(1));
		assertThat(doubleStack.leftStackSize(), is(0));
	}

	@Test
	public void reportsRightStackIsFullWhenPushingBeyondTotalCapacity() {

		doubleStack.pushRight(1);
		doubleStack.pushRight(2);
		doubleStack.pushRight(3);
		doubleStack.pushRight(4);
		doubleStack.pushRight(5);
		doubleStack.pushRight(6);
		doubleStack.pushRight(7);
		doubleStack.pushRight(8);
		doubleStack.pushRight(9);
		doubleStack.pushRight(10);

		try {
			doubleStack.pushRight(11);

			fail("Trying to push items to a full stack should throw an ArrayIndexOutOfBoundsException.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(
					e.getMessage(),
					is("You are trying to push elements to a full stack. You probably need a bigger stack."));
			assertThat(doubleStack.rightStackSize(), is(10));
		}

	}

	@Test
	public void reportsLeftStackIsFullWhenPushingBeyondTotalCapacity() {

		doubleStack.pushLeft(1);
		doubleStack.pushLeft(2);
		doubleStack.pushLeft(3);
		doubleStack.pushLeft(4);
		doubleStack.pushLeft(5);
		doubleStack.pushLeft(6);
		doubleStack.pushLeft(7);
		doubleStack.pushLeft(8);
		doubleStack.pushLeft(9);
		doubleStack.pushLeft(10);

		try {
			doubleStack.pushLeft(11);

			fail("Trying to push items to a full stack should throw an ArrayIndexOutOfBoundsException.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(
					e.getMessage(),
					is("You are trying to push elements to a full stack. You probably need a bigger stack."));
			assertThat(doubleStack.leftStackSize(), is(10));
		}

	}

	@Test
	public void reportsRightStackIsFullWhenPushingToAPositionAlreadyFilledByLeftStack() {

		doubleStack.pushLeft(10);
		doubleStack.pushLeft(9);
		doubleStack.pushLeft(8);
		doubleStack.pushLeft(7);
		doubleStack.pushLeft(6);
		
		doubleStack.pushRight(1);
		doubleStack.pushRight(2);
		doubleStack.pushRight(3);
		doubleStack.pushRight(4);
		doubleStack.pushRight(5);

		try {
			doubleStack.pushRight(6);

			fail("Trying to push items to a full stack should throw an ArrayIndexOutOfBoundsException.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(
					e.getMessage(),
					is("You are trying to push elements to a full stack. You probably need a bigger stack."));
			assertThat(doubleStack.rightStackSize(), is(5));
		}

	}
	
	@Test
	public void reportsLeftStackIsFullWhenPushingToAPositionAlreadyFilledByRightStack() {

		doubleStack.pushRight(1);
		doubleStack.pushRight(2);
		doubleStack.pushRight(3);
		doubleStack.pushRight(4);
		doubleStack.pushRight(5);

		doubleStack.pushLeft(10);
		doubleStack.pushLeft(9);
		doubleStack.pushLeft(8);
		doubleStack.pushLeft(7);
		doubleStack.pushLeft(6);
		
		try {
			doubleStack.pushLeft(5);

			fail("Trying to push items to a full stack should throw an ArrayIndexOutOfBoundsException.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(
					e.getMessage(),
					is("You are trying to push elements to a full stack. You probably need a bigger stack."));
			assertThat(doubleStack.rightStackSize(), is(5));
		}

	}
	
	@Test
	public void reportsFailureWhenPoppingFromAnEmptyStack() {

		try {
			doubleStack.popRight();

			fail("Trying to pop items from an empty stack should throw an ArrayIndexOutOfBoundsException.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(e.getMessage(),
					is("You are trying to pop items from an empty stack."));
			assertThat(doubleStack.rightStackSize(), is(0));
		}

		try {
			doubleStack.popLeft();

			fail("Trying to pop items from an empty stack should throw an ArrayIndexOutOfBoundsException.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(e.getMessage(),
					is("You are trying to pop items from an empty stack."));
			assertThat(doubleStack.rightStackSize(), is(0));
		}
	}

}