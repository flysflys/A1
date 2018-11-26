import static org.junit.Assert.*;

import org.junit.Test;

public class CompareTest {
	App test = new App();
	
	@Test
	public void test1() {
		test.readFile();
		test.newGame();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test1 done-----------");
	}

	@Test
	public void test2() {
		test.readFile();
		test.newGame();
		test.newGame();
		assertEquals(Winner.OPPONENT,test.winner());
		System.out.println("--------test2 done-----------");
	}
	
	@Test
	public void test3() {
		test.readFile();
		test.newGame();
		test.newGame();
		test.newGame();
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
		assertEquals(Winner.OPPONENT,test.winner());
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
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test5 done-----------");
	}
	
	@Test
	public void test6() {
		test.readFile();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		assertEquals(Winner.OPPONENT,test.winner());
		System.out.println("--------test6 done-----------");
	}
	
	@Test
	public void test7() {
		test.readFile();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test7 done-----------");
	}
	
	@Test
	public void test8() {
		test.readFile();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		assertEquals(Winner.OPPONENT,test.winner());
		System.out.println("--------test8 done-----------");
	}
	
	@Test
	public void test9() {
		test.readFile();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		test.newGame();
		assertEquals(Winner.AIP,test.winner());
		System.out.println("--------test9 done-----------");
	}
}
