import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy2Test {

	@Test
	public void test() {
		App test = new App();
		test.input("H1 S7 HQ HJ HK H10");
		test.exchange();
		assertEquals(Hands.RF,test.getHands());
		
	}

}
