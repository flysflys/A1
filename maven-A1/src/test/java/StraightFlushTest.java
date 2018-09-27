import static org.junit.Assert.*;

import org.junit.Test;

public class StraightFlushTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.SF,test.getHands());
	}

}
