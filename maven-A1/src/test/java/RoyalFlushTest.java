import static org.junit.Assert.*;

import org.junit.Test;

public class RoyalFlushTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.RoyalFlush,test.getHands());
	}

}
