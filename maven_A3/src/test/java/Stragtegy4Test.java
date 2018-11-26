import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy4Test {

	@Test
	public void test() {
		App test = new App();
		test.input("H7 D7 S2 C6 S7 D6");
		test.exchange();
		assertEquals(Hands.FH,test.getHands());
		
	}
	@Test
	public void test2() {
		App test = new App();
		test.input("H7 D7 S1 C6 S6 D6");
		test.exchange();
		assertEquals(Hands.FH,test.getHands());
	}

}
