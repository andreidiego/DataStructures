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

import clrs.stack.ArrayStack;
import clrs.stack.Stack;

public class ArrayStackTest {

	Stack<Integer> stack;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		stack = new ArrayStack<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenAStackIsCreatedItIsEmptyAndItsSizeIs0() {
		assertTrue(stack.isEmpty());
		assertThat(stack.size(), is(0));
	}

	@Test
	public void whenNoCapacityIsInformedInStackCreationItShouldBeSetToItsDefaultWhichIs10() {
		assertThat(stack.capacity(), is(10));
	}
	
	@Test
	public void whenCapacityIsInformedInStackCreationItShouldBeSetToTheValueInformed() {
		stack = new ArrayStack<>(150);
		assertThat(stack.capacity(), is(150));
	}
	
	@Test
	public void reportsStackIsEmptyWhenNoElementsAreFound() {
		assertTrue(stack.isEmpty());
	}

	@Test
	public void reportsStackIsNotEmptyWhenElementsAreFound() {
		stack.push(1);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void elementsAreCorrectlyPushedAndPopped() {

		for(int i = 0; i < stack.capacity(); i++) {
			stack.push(i);
			assertThat(stack.size(), is(i + 1));
		}
		
		for(int i = stack.capacity() - 1; i >= 0; i--) {
			assertThat(stack.pop(), is(i));
			assertThat(stack.size(), is(i));
		}
		
		assertTrue(stack.isEmpty());
	}

	@Test
	public void afterPushingAnElementTheStackShouldContainThatElement() {
		stack.push(1);
		assertTrue(stack.contains(1));
	}
	
	@Test
	public void ifAnElementWasNotPushedStackDoesNotContainIt() {
		assertFalse(stack.contains(1));
	}
	
	@Test
	public void reportsStackIsFullWhenCapacityReached() {
		
		for(int i = 0; i < stack.capacity(); i++) {
			stack.push(i);
		}
		
		assertTrue(stack.isFull());
	}
	
	@Test
	public void reportsStackIsNotFullCapacityNotReached() {
		
		for(int i = 0; i < stack.capacity() - 1; i++) {
			stack.push(i);
			assertFalse(stack.isFull());
		}
		
	}

	
	@Test
	public void pushShouldThrowAnExceptionIfTheStackIsAlreadyFull() {
		
		for(int i = 0; i < stack.capacity(); i++) {
			stack.push(i);
		}

		try {
			stack.push(10);

			fail("Trying to add more items than the stack capacity should throw an ArrayIndexOutOfBoundsException.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(
					e.getMessage(),
					is("You are trying to add more items than the stack capacity."));
			assertThat(stack.size(), is(10));
		}
	}

	@Test
	public void reportsFailureWhenPoppingFromAnEmptyStack() {

		try {
			stack.pop();

			fail("Trying to pop items from an empty stack should throw an ArrayIndexOutOfBoundsException.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(e.getMessage(),
					is("You are trying to pop items from an empty stack."));
		}
	}

}