package mavenA3;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OneAITest {

	static WebDriver driver;
	//static IndexPage indexPage=new IndexPage();
	App test=new App();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\michael\\eclipse-workspace\\geckodriver.exe");
		driver = new FirefoxDriver();
        driver.get("http://localhost:8080/A3/Firstpage.html");
        driver.manage().window().maximize();
        
        
	}
	private void player3Game()
	{
		driver.findElement(By.id("numOfPlayers")).clear();
    	driver.findElement(By.id("numOfAI")).clear();
		driver.findElement(By.id("numOfPlayers")).sendKeys("3");
    	driver.findElement(By.id("numOfAI")).sendKeys("1");
    	try
        {	Thread.sleep(1000);}
    	catch(Exception e)
        {
        }
    	driver.findElement(By.id("startButt")).click();

	}
	
	@Test
	public void HumanWins1AI() {
		try
        {
			driver.navigate().back();
			driver.navigate().back();
        	Thread.sleep(500);
        	player3Game();
        	
        	/*driver.findElement(By.id("p2card2")).click();
    		driver.findElement(By.id("p2card3")).click();
    		driver.findElement(By.id("p2card4")).click();
    		driver.findElement(By.id("p3card1")).click();
    		driver.findElement(By.id("p3card5")).click();*/

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(3000);

        }
        catch(Exception e)
        {
        	
        }
		

		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("1",temp2);		
	}
	@Test
	public void AIWins1AI() {
		try
        {
			driver.navigate().back();
			driver.navigate().back();
        	Thread.sleep(500);
        	player3Game();
        	

    		driver.findElement(By.id("p1card5")).click();
    		
    		driver.findElement(By.id("p2card1")).click();
    		driver.findElement(By.id("p2card3")).click();
    		
    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(3000);

        }
        catch(Exception e)
        {
        	
        }
		

		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("3",temp2);
		
		
	}
	@Test
	public void humanWins2AI() {
		try
        {
			driver.navigate().back();
			driver.navigate().back();
        	Thread.sleep(500);
        	driver.findElement(By.id("numOfPlayers")).clear();
        	driver.findElement(By.id("numOfAI")).clear();
    		driver.findElement(By.id("numOfPlayers")).sendKeys("3");
        	driver.findElement(By.id("numOfAI")).sendKeys("2");
        	try
            {	Thread.sleep(1000);}
        	catch(Exception e)
            {
            }
        	driver.findElement(By.id("startButt")).click();
        	

    		

    		
    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(3000);

        }
        catch(Exception e)
        {
        	
        }
		

		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("1",temp2);
		
		
	}
	@Test
	public void AIWins2AI() {
		try
        {
			driver.navigate().back();
			driver.navigate().back();
        	Thread.sleep(500);
        	driver.findElement(By.id("numOfPlayers")).clear();
        	driver.findElement(By.id("numOfAI")).clear();
    		driver.findElement(By.id("numOfPlayers")).sendKeys("3");
        	driver.findElement(By.id("numOfAI")).sendKeys("2");
        	try
            {	Thread.sleep(1000);}
        	catch(Exception e)
            {
            }
        	driver.findElement(By.id("startButt")).click();
        	
        	driver.findElement(By.id("p1card5")).click();
    		

    		
    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(3000);

        }
        catch(Exception e)
        {
        	
        }
		

		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("2",temp2);
		
		
	}
	@Test
	public void AIWins3AI() {
		try
        {
			driver.navigate().back();
			driver.navigate().back();
        	Thread.sleep(500);
        	driver.findElement(By.id("numOfPlayers")).clear();
        	driver.findElement(By.id("numOfAI")).clear();
    		driver.findElement(By.id("numOfPlayers")).sendKeys("3");
        	driver.findElement(By.id("numOfAI")).sendKeys("3");
        	try
            {	Thread.sleep(1000);}
        	catch(Exception e)
            {
            }
        	driver.findElement(By.id("startButt")).click();
        	
        	
    		

    		
    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(3000);

        }
        catch(Exception e)
        {
        	
        }
		

		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("1",temp2);
		
		
	}
}
