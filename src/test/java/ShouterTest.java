import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import src.main.java.Shouter;

public class ShouterTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void testShoutSuccess() {
		Shouter shouter = new Shouter();
		shouter.shout("hello");
		assertEquals("HELLO", outContent.toString().trim());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShoutFailed() {
		Shouter shouter = new Shouter();
		shouter.shout(null);
	}

	
	@Test
	public void testIntentionalFailure() {
		boolean shouldFail = false; 
		if (shouldFail) {
			fail("This test is intentionally failed to test CI/CD build failure");
		}
	}



}
