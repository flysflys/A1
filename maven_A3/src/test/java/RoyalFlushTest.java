import static org.junit.Assert.*;

import org.junit.Test;

public class RoyalFlushTest {

	@Test
	public void test() {
		App test = new App();
		test.input("SA S10 SQ SJ SK");
		assertEquals(Hands.RF,test.getHands());
	}
	@Test
	public void test2() {
		App test = new App();
		test.input("S10 SJ SQ SA SK");
		assertEquals(Hands.RF,test.getHands());
	}

}
