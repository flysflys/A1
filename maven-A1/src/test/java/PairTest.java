import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.PAIR,test.getHands());
	}

}
