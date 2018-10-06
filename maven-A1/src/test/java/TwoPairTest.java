import static org.junit.Assert.*;

import org.junit.Test;

public class TwoPairTest {

	@Test
	public void test() {
		App test = new App();
		test.input("SQ CQ HK DJ DK");
		assertEquals(Hands.TP,test.getHands());
	}

}
