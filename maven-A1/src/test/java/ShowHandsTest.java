import static org.junit.Assert.*;

import org.junit.Test;

public class ShowHandsTest {
	App test = new App();
	@Test
	public void test() {
		test.input("SQ S10 SJ SK SA D3 C3 S3 S4 C4");
		assertEquals(Winner.AIP,test.compareResult(2,1));

	}

}
