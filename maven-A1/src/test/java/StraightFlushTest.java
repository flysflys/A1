import static org.junit.Assert.*;

import org.junit.Test;

public class StraightFlushTest {

	@Test
	public void test() {
		App test = new App();
		test.input("C8 C7 C5 C6 C4");
		assertEquals(Hands.SF,test.getHands());
	}

}
