import static org.junit.Assert.*;

import org.junit.Test;

public class TOAKTest {

	@Test
	public void test() {
		App test = new App();
		test.input("SQ CQ C5 H2 HQ");
		assertEquals(Hands.TOAK,test.getHands());
	}

}
