import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy1Test {

	@Test
	public void test() {
		App test = new App();
		Hands oldHands=test.getHands();
		test.exchange();
		assertEquals(oldHands,test.getHands());
	}

}
