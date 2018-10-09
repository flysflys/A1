import static org.junit.Assert.*;

import org.junit.Test;

public class SuitTest {
	App test = new App();
	@Test
	public void test() {
		
		assertEquals(Winner.AIP,test.compareResult(14,1));

	}

}
