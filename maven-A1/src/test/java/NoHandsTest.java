import static org.junit.Assert.*;

import org.junit.Test;

public class NoHandsTest {

	@Test
	public void test() {
		App test = new App();
		test.input("SQ C10 H9 D1 DK");
		assertEquals(Hands.NONE,test.getHands());
	}

}
