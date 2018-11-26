import static org.junit.Assert.*;

import org.junit.Test;

public class CompareTest2 {
	App test = new App();
	@Test
	public void test() {
		
		test.readFile();
		test.newGame();
		test.exchange();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test1 done-----------");
	}
	
	@Test
	public void test2() {
		
		test.readFile();
		test.newGame();
		test.newGame();
		test.exchange();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test2 done-----------");
	}
	
	@Test
	public void test3() {
		
		test.readFile();
		test.newGame();
		test.newGame();
		test.newGame();
		test.exchange();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test3 done-----------");
	}
	
	@Test
	public void test4() {
		
		test.readFile();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.exchange();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test4 done-----------");
	}
	@Test
	public void test5() {
		
		test.readFile();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.exchange();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test5 done-----------");
	}

}
