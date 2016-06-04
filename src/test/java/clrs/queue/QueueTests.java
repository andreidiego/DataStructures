package clrs.queue;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

public abstract class QueueTests {
	Queue<Integer> queue;

	public void whenAQueueIsCreatedItIsEmptyAndItsSizeIs0() {
		assertTrue(queue.isEmpty());
		assertThat(queue.size(), is(0));
	}

	public abstract void creatingAQueueShouldConfigureItsCapacityToTheValueInformedByTheUser();

	public void whenNoCapacityIsInformedCreatingAQueueShouldConfigureItsCapacityToTheDefaultValueWhichIs10() {
		assertThat(queue.capacity(), is(10));
	}

	public void reportsQueueIsEmptyWhenNoElementsAreFound() {
		assertTrue(queue.isEmpty());
	}
	
	public void reportsQueueIsNotEmptyWhenElementsAreFound() {
		queue.enqueue(1);
		assertFalse(queue.isEmpty());
	}
	
	public void afterEnqueueTheQueueMustContainTheNewElement() {
		queue.enqueue(1);
		assertTrue(queue.contains(1));
	}

	public void ifAnElementWasNotEnqueuedTheQueueMustNotContainIt() {
		assertFalse(queue.contains(1));
	}

	public void enqueueShouldAlterTheSizeOfTheQueue() {
		queue.enqueue(1);
		assertThat(queue.size(), is(1));
	}

	public void enqueueShouldThrowAnExceptionIfTheQueueIsAlreadyFull() {

		for (int i = 0; i < queue.capacity(); i++) {
			queue.enqueue(i);
		}

		try {
			queue.enqueue(10);

			fail("Trying to add more items than the queue's capacity should throw and Exception.");

		} catch (Exception e) {
			assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
			assertThat(e.getMessage(), is(
					"This Queue is already full. To be able to insert new elements, some existing elements must be removed first."));

			assertThat(queue.size(), is(10));
			assertFalse(queue.contains(10));
		}

	}

	public void dequeueShouldRemoveTheFirstElementFromTheQueue() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		queue.deque();
		assertFalse(queue.contains(1));

		queue.deque();
		assertFalse(queue.contains(2));
		assertTrue(queue.contains(3));
	}

	public void dequeueShouldReturnTheElementRemoved() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		assertThat(queue.deque(), is(1));
	}

	public void dequeueShouldAlterTheSizeOfTheQueue() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		assertThat(queue.size(), is(3));

		queue.deque();

		assertThat(queue.size(), is(2));
	}

	public void dequeueShouldThrowAnExceptionIfTheQueueIsEmpty() {

		try {
			queue.deque();

			fail("Trying to deque from an empty Queue shoudl throw an Exception.");

		} catch (Exception e) {
			assertThat(e, instanceOf(NoSuchElementException.class));
			assertThat(e.getMessage(), is("This Queue is empty."));
			assertThat(queue.size(), is(0));
		}
	}

	public void isQueueReutilizable() {

		// Enqueue until the Queue's capacity
		for (int i = 0; i < queue.capacity(); i++) {
			queue.enqueue(i);
		}

		assertThat(queue.size(), is(10));

		// Dequeue until size = 0
		for (int i = 0; i < queue.capacity(); i++) {
			queue.deque();
		}

		assertThat(queue.size(), is(0));

		// Repeat the steps above one more time

		// Enqueue until the Queue's capacity
		for (int i = 0; i < queue.capacity(); i++) {
			queue.enqueue(i);
		}

		assertThat(queue.size(), is(10));

		// Dequeue until size = 0
		for (int i = 0; i < queue.capacity(); i++) {
			queue.deque();
		}

		assertThat(queue.size(), is(0));
	}

	public void queueShouldReportItIsFullWhenItReachesItsCapacity() {

		// Enqueue until the Queue's capacity
		for (int i = 0; i < queue.capacity(); i++) {
			queue.enqueue(i);
		}

		assertTrue(queue.isFull());
	}

	public void queueShouldNotReportItIsFullWhenItHasFreeCapacity() {

		// Enqueue until the Queue's capacity
		for (int i = 0; i < queue.capacity() - 1; i++) {
			queue.enqueue(i);
			assertFalse(queue.isFull());
		}

	}

}