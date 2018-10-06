import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy6Test {

	@Test
	public void test() {
		App test = new App();
		test.input("D7 C3 H5 C6 D1 D4");
		test.exchange();
		assertEquals(Hands.STRAIGHT,test.getHands());
	}
	@Test
	public void test2() {
		App test = new App();
		test.input("HK SJ HQ S10 DK D9");
		test.exchange();
		assertEquals(Hands.STRAIGHT,test.getHands());
	}

}
