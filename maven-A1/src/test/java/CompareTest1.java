import static org.junit.Assert.*;

import org.junit.Test;

public class CompareTest1 {
	App test = new App();
	@Test
	public void test() {
		test.readFile();
		test.newGame();
		test.exchange();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test1 done-----------");
	}

}
