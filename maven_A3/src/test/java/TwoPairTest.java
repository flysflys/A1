import static org.junit.Assert.*;

import org.junit.Test;

public class TwoPairTest {

	@Test
	public void test() {
		App test = new App();
		test.input("SQ CQ HK DJ DK");
		assertEquals(Hands.TP,test.getHands());
	}
	@Test
	public void test2() {
		App test = new App();
		test.input("SQ CA HK DQ DK");
		assertEquals(Hands.TP,test.getHands());
	}

}
