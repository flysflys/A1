import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy9Test {

	@Test
	public void test() {
		App test = new App();
		test.input("S5 D7 D2 S4 H4 D10 C10 S10");
		test.exchange();
		assertEquals(Hands.FH,test.getHands());
	}

}
