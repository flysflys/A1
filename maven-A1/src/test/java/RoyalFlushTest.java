import static org.junit.Assert.*;

import org.junit.Test;

public class RoyalFlushTest {

	@Test
	public void test() {
		App test = new App();
		test.input("S1 S10 SQ SJ SK");
		assertEquals(Hands.RF,test.getHands());
	}

}
