import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy10Test {

	@Test
	public void test() {
		App test = new App();
		test.input("C3 S9 D7 DQ HJ C10 S9 CK");
		test.exchange();
		assertEquals(Hands.STRAIGHT,test.getHands());
	}

}
