import static org.junit.Assert.*;

import org.junit.Test;

public class FullHouseTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.FH,test.getHands());
	}

}
