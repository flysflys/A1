import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void test() {
		App test = new App();
		test.input("SQ C10 H9 D1 DQ");
		assertEquals(Hands.PAIR,test.getHands());
	}

}
