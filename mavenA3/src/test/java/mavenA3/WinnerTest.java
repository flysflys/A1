package mavenA3;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WinnerTest {

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
    	driver.findElement(By.id("numOfAI")).sendKeys("0");
    	try
        {	Thread.sleep(1000);}
    	catch(Exception e)
        {
        }
    	driver.findElement(By.id("startButt")).click();

	}
	@Test
	public void RFWins() {
		try
        {
			driver.navigate().back();
			driver.navigate().back();
        	Thread.sleep(500);
        	player3Game();
        	//Thread.sleep(3000);

        	/*WebDriverWait wait = new WebDriverWait(driver, 10);
        	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("p2card2")));*/

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
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("1",temp2);
		
		//driver.close();
	}
	@Test
	public void SFWins() {
		try
        {
			
			driver.navigate().back();
			driver.navigate().back();
			player3Game();
        	driver.findElement(By.id("p1card5")).click();
    		

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(3000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("3",temp2);
		
	}
	@Test
	public void FOAKWins() {
		try
        {
			Thread.sleep(3000);
			driver.navigate().back();
			driver.navigate().back();
			player3Game();
			driver.findElement(By.id("p1card1")).click();
			driver.findElement(By.id("p1card2")).click();
			driver.findElement(By.id("p1card3")).click();
			driver.findElement(By.id("p1card4")).click();
			
			driver.findElement(By.id("p2card1")).click();
			driver.findElement(By.id("p2card3")).click();
			
			driver.findElement(By.id("p3card1")).click();
			driver.findElement(By.id("p3card5")).click();
    		

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(1000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("1",temp2);
		
	}
	@Test
	public void FHWins() {
		try
        {
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			player3Game();
			driver.findElement(By.id("p1card5")).click();
			
			
			driver.findElement(By.id("p2card1")).click();
			driver.findElement(By.id("p2card2")).click();
			driver.findElement(By.id("p2card4")).click();
			
			driver.findElement(By.id("p3card1")).click();
			driver.findElement(By.id("p3card2")).click();
			driver.findElement(By.id("p3card3")).click();
    		

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(1000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("3",temp2);
		
	}
	
	@Test
	public void TOAKWins() {
		try
        {
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			player3Game();

			driver.findElement(By.id("p1card5")).click();
			
			driver.findElement(By.id("p2card1")).click();
			driver.findElement(By.id("p2card2")).click();
			driver.findElement(By.id("p2card4")).click();
			driver.findElement(By.id("p2card5")).click();

			driver.findElement(By.id("p3card1")).click();
			driver.findElement(By.id("p3card2")).click();
			driver.findElement(By.id("p3card3")).click();
			driver.findElement(By.id("p3card4")).click();
    		

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(1000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("3",temp2);
		
	}
	
	@Test
	public void STRAIGHTWins() {
		try
        {
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			player3Game();
			
			driver.findElement(By.id("p1card1")).click();


			driver.findElement(By.id("p2card1")).click();
			driver.findElement(By.id("p2card3")).click();
			
			driver.findElement(By.id("p3card1")).click();
			driver.findElement(By.id("p3card5")).click();
			
    		

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(1000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("1",temp2);
		
	}
	@Test
	public void FLUSHWins() {
		try
        {
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			player3Game();
			
			driver.findElement(By.id("p1card5")).click();



			driver.findElement(By.id("p2card5")).click();
			
			
			driver.findElement(By.id("p3card5")).click();
			
    		

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(1000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("3",temp2);
		
	}
	@Test
	public void TPWins() {
		try
        {
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			player3Game();
			
			driver.findElement(By.id("p1card5")).click();


			driver.findElement(By.id("p2card1")).click();
			driver.findElement(By.id("p2card2")).click();
			driver.findElement(By.id("p2card3")).click();
			driver.findElement(By.id("p2card4")).click();
			
			driver.findElement(By.id("p3card1")).click();
			driver.findElement(By.id("p3card2")).click();
			driver.findElement(By.id("p3card3")).click();
			driver.findElement(By.id("p3card5")).click();
			
    		

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(1000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("3",temp2);
		
	}
	@Test
	public void PairWins() {
		try
        {
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();
			player3Game();
			
			driver.findElement(By.id("p1card5")).click();


			driver.findElement(By.id("p2card1")).click();
			driver.findElement(By.id("p2card2")).click();
			driver.findElement(By.id("p2card3")).click();
			driver.findElement(By.id("p2card4")).click();
			driver.findElement(By.id("p2card5")).click();
			
			driver.findElement(By.id("p3card1")).click();
			driver.findElement(By.id("p3card2")).click();
			driver.findElement(By.id("p3card3")).click();
			driver.findElement(By.id("p3card4")).click();
			driver.findElement(By.id("p3card5")).click();
			
    		

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(1000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("3",temp2);
		
	}

}
