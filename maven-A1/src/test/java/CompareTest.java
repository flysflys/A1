import static org.junit.Assert.*;

import org.junit.Test;

public class CompareTest {

	@Test
	public void test() {
		App test = new App();
		assertEquals(Winner.AIP,test.winner());
	}

}
