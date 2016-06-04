package clrs.queue;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DoubleStackQueueTest extends QueueTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		queue = new DoubleStackQueue<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Override
	@Test
	public void whenAQueueIsCreatedItIsEmptyAndItsSizeIs0() {
		super.whenAQueueIsCreatedItIsEmptyAndItsSizeIs0();
	}

	@Override
	@Test
	public void creatingAQueueShouldConfigureItsCapacityToTheValueInformedByTheUser() {
		Queue<Integer> queue = new DoubleStackQueue<>(150);
		assertThat(queue.capacity(), is(150));
	}

	@Override
	@Test
	public void whenNoCapacityIsInformedCreatingAQueueShouldConfigureItsCapacityToTheDefaultValueWhichIs10() {
		super.whenNoCapacityIsInformedCreatingAQueueShouldConfigureItsCapacityToTheDefaultValueWhichIs10();
	}

	@Override
	@Test
	public void reportsQueueIsEmptyWhenNoElementsAreFound() {
		super.reportsQueueIsEmptyWhenNoElementsAreFound();
	}

	@Override
	@Test
	public void reportsQueueIsNotEmptyWhenElementsAreFound() {
		super.reportsQueueIsNotEmptyWhenElementsAreFound();
	}

	@Override
	@Test
	public void afterEnqueueTheQueueMustContainTheNewElement() {
		super.afterEnqueueTheQueueMustContainTheNewElement();
	}

	@Override
	@Test
	public void ifAnElementWasNotEnqueuedTheQueueMustNotContainIt() {
		super.ifAnElementWasNotEnqueuedTheQueueMustNotContainIt();
	}

	@Override
	@Test
	public void enqueueShouldAlterTheSizeOfTheQueue() {
		super.enqueueShouldAlterTheSizeOfTheQueue();
	}

	@Override
	@Test
	public void enqueueShouldThrowAnExceptionIfTheQueueIsAlreadyFull() {
		super.enqueueShouldThrowAnExceptionIfTheQueueIsAlreadyFull();
	}

	@Override
	@Test
	public void dequeueShouldRemoveTheFirstElementFromTheQueue() {
		super.dequeueShouldRemoveTheFirstElementFromTheQueue();
	}

	@Override
	@Test
	public void dequeueShouldReturnTheElementRemoved() {
		super.dequeueShouldReturnTheElementRemoved();
	}

	@Override
	@Test
	public void dequeueShouldAlterTheSizeOfTheQueue() {
		super.dequeueShouldAlterTheSizeOfTheQueue();
	}

	@Override
	@Test
	public void dequeueShouldThrowAnExceptionIfTheQueueIsEmpty() {
		super.dequeueShouldThrowAnExceptionIfTheQueueIsEmpty();
	}

	@Override
	@Test
	public void isQueueReutilizable() {
		super.isQueueReutilizable();
	}

	@Override
	@Test
	public void queueShouldReportItIsFullWhenItReachesItsCapacity() {
		super.queueShouldReportItIsFullWhenItReachesItsCapacity();
	}

	@Override
	@Test
	public void queueShouldNotReportItIsFullWhenItHasFreeCapacity() {
		super.queueShouldNotReportItIsFullWhenItHasFreeCapacity();
	}

}