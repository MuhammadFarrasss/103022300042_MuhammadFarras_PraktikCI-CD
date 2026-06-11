import static org.junit.Assert.assertEquals;
import org.junit.Test;

import src.main.java.Counter;

public class CounterTest {

	@Test
	public void testResetSuccess() {
		Counter testCounter = new Counter();
		
		for(int i = 0; i < 10; i++) {
			testCounter.increment();
		}
		
		testCounter.reset();
		
		assertEquals(0, testCounter.getCount());
	}

	@Test
	public void testIncrementSuccess() {
		Counter testCounter = new Counter();
		
		for(int i = 1; i < 10; i++) {
			testCounter.increment();
			assertEquals(i, testCounter.getCount());
		}
	}

	@Test
	public void testDecrementSuccess() {
		Counter testCounter = new Counter();
		
		for(int i = 1; i < 10; i++) {
			testCounter.decrement();
			assertEquals(i * -1, testCounter.getCount());
		}
	}

	
	@Test
	public void testCounterIntentionalFailure() {
		boolean shouldFail = false; 
		if (shouldFail) {
			Counter testCounter = new Counter();
			assertEquals(99, testCounter.getCount());
		}
	}

}
