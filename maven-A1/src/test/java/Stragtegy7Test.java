import static org.junit.Assert.*;

import org.junit.Test;

public class Stragtegy7Test {

	@Test
	public void test() {
		App test = new App();
		test.input("S2 C3 DJ D6 D9 D10 D4 ");
		test.exchange();
		assertEquals(Hands.FLUSH,test.getHands());
	}
	@Test
	public void test2() {
		App test = new App();
		test.input("S2 S3 DJ D6 D9 D10 D4 ");
		test.exchange();
		assertEquals(Hands.FLUSH,test.getHands());
	}

}
