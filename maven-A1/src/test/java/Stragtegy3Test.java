import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy3Test {

	@Test
	public void test() {
		App test = new App();

		test.exchange();
		assertEquals(Hands.SF,test.getHands());
	}

}
