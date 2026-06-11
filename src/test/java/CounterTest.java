import static org.junit.Assert.*;
import src.main.java.Counter;
import org.junit.Test;

public class CounterTest {

	// Success Test - Reset Counter
	@Test
	public void testResetSuccess() {
		Counter testCounter = new Counter();
		
		for(int i = 0; i < 10; i++) {
			testCounter.increment();
		}
		
		testCounter.reset();
		
		assertEquals(0, testCounter.getCount());
	}

	// Success Test - Increment Counter
	@Test
	public void testIncrementSuccess() {
		Counter testCounter = new Counter();
		
		for(int i = 1; i < 10; i++) {
			testCounter.increment();
			assertEquals(i, testCounter.getCount());
		}
	}

	// Success Test - Decrement Counter
	@Test
	public void testDecrementSuccess() {
		Counter testCounter = new Counter();
		
		for(int i = 1; i < 10; i++) {
			testCounter.decrement();
			assertEquals(i * -1, testCounter.getCount());
		}
	}

	// Test that intentionally fails (to test CI/CD failure behavior)
	// You can change 'shouldFail' to true to see the CI/CD pipeline fail
	@Test
	public void testCounterIntentionalFailure() {
		boolean shouldFail = false; // Set to true to test failing build in CI/CD
		if (shouldFail) {
			// This assertion will fail because count should be 0, not 99
			Counter testCounter = new Counter();
			assertEquals(99, testCounter.getCount());
		}
	}

}
