import static org.junit.Assert.*;

import org.junit.Test;

public class FlushTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Hands.FLUSH,test.getHands());
	}

}
