import static org.junit.Assert.*;

import org.junit.Test;

public class rankTest {
	App test = new App();
	@Test
	public void test() {
		
		assertEquals(Winner.AIP,test.compareResult(2,1));

	}

}
