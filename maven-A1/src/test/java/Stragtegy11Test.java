import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy11Test {

	@Test
	public void test() {
		App test = new App();
		test.input("S7 C7 H7 H8 D9 D7");
		test.exchange();
		assertEquals(Hands.FOAK,test.getHands());
	}

}
