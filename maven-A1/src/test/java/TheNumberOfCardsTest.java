import static org.junit.Assert.*;

import org.junit.Test;

public class TheNumberOfCardsTest {
	App test = new App();
	@Test
	public void theNumberOfCardsTestforAIP() {
		
		assertEquals(5,test.getAIPCards().length);
	}
	public void theNumberOfCardsTestforOP() {

		assertEquals(5,test.getOpCards().length)
	}

}
