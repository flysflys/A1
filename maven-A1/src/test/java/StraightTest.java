import static org.junit.Assert.*;

import org.junit.Test;

public class StraightTest {

	@Test
	public void test() {
		App test = new App();
		test.input("SQ C10 H9 DJ DK");
		assertEquals(Hands.STRAIGHT,test.getHands());
	}

}
