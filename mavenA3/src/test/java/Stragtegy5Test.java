import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy5Test {

	@Test
	public void test() {
		App test = new App();
		test.input("H7 D7 HA H6 H2 H9");
		test.exchange();
		assertEquals(Hands.FLUSH,test.getHands());
	}

}
