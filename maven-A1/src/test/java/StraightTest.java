import static org.junit.Assert.*;

import org.junit.Test;

public class StraightTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.STRAIGHT,test.getHands());
	}

}
