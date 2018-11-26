import static org.junit.Assert.*;

import org.junit.Test;

public class FlushTest {

	@Test
	public void test() {
		App test = new App();
		test.input("S8 S3 SQ SK S4");
		assertEquals(Hands.FLUSH,test.getHands());
	}

}
