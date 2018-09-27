import static org.junit.Assert.*;

import org.junit.Test;

public class NoHandsTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.NONE,test.getHands());
	}

}
