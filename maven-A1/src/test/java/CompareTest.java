import static org.junit.Assert.*;

import org.junit.Test;

public class CompareTest {

	@Test
	public void test() {
		App test = new App();
		test.readFile();
		test.newGame();
		assertEquals(Winner.AIP,test.winner());
	}

}
