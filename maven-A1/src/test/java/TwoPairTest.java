import static org.junit.Assert.*;

import org.junit.Test;

public class TwoPairTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.TP,test.getHands());
	}

}
