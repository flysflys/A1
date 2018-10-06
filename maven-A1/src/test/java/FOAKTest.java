import static org.junit.Assert.*;

import org.junit.Test;

public class FOAKTest {

	@Test
	public void test() {
		App test = new App();
		test.input("DJ D8 CJ HJ SJ ");
		assertEquals(Hands.FOAK,test.getHands());
	}

}
