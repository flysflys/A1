import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy7Test {

	@Test
	public void test() {
		App test = new App();

		test.exchange();
		assertEquals(Hands.FLUSH,test.getHands());
	}

}
