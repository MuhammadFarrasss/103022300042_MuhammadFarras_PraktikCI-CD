import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

	// Success test (Happy Path)
	@Test
	public void testShoutSuccess() {
		Shouter shouter = new Shouter();
		shouter.shout("hello");
		assertEquals("HELLO", outContent.toString().trim());
	}

	// Failed test (Unhappy Path / Exception Test)
	@Test(expected = IllegalArgumentException.class)
	public void testShoutFailed() {
		Shouter shouter = new Shouter();
		shouter.shout(null);
	}

	// Test that intentionally fails (to test CI/CD failure behavior)
	// You can change 'shouldFail' to true to see the CI/CD pipeline fail
	@Test
	public void testIntentionalFailure() {
		boolean shouldFail = false; // Set to true to test failing build in CI/CD
		if (shouldFail) {
			fail("This test is intentionally failed to test CI/CD build failure");
		}
	}

}
