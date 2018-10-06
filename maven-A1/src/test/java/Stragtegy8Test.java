import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy8Test {

	@Test
	public void test() {
		App test = new App();
		test.input("HK S3 HQ DJ DK D9 C10 ");
		test.exchange();
		assertEquals(Hands.STRAIGHT,test.getHands());
	}
	@Test
	public void test2() {
		App test = new App();
		test.input("HK S4 HQ DJ D3 D9 C10 ");
		test.exchange();
		assertEquals(Hands.STRAIGHT,test.getHands());
	}

}
