import static org.junit.Assert.*;

import org.junit.Test;

public class FOAKTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.FOAK,test.getHands());
	}

}
