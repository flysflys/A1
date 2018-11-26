import static org.junit.Assert.*;

import org.junit.Test;

public class FullHouseTest {

	@Test
	public void test() {
		App test = new App();
		test.input("D10 C10 H1 S1 H10");
		assertEquals(Hands.FH,test.getHands());
	}
	
	@Test
	public void test2() {
		App test = new App();
		test.input("D1 C10 H1 S10 H10");
		assertEquals(Hands.FH,test.getHands());
	}

}
