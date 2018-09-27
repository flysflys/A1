import static org.junit.Assert.*;

import org.junit.Test;

public class TOAKTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.TOAK,test.getHands());
	}

}
