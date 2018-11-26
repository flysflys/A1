import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy3Test {

	@Test
	public void test() {
		App test = new App();
		test.input("H10 C7 HQ HJ H9 H8");
		test.exchange();
		assertEquals(Hands.SF,test.getHands());
	}

}
