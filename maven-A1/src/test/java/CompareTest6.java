import static org.junit.Assert.*;

import org.junit.Test;

public class CompareTest6 {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Winner.OPPONENT,test.winner());
	}

}
