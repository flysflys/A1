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

	@Test
	public void WinnerTesting() {
		try
        {
        	Thread.sleep(500);
        	driver.findElement(By.id("numOfPlayers")).sendKeys("3");
        	driver.findElement(By.id("numOfAI")).sendKeys("0");
 
        	Thread.sleep(1000);
        	driver.findElement(By.id("startButt")).click();
        	//Thread.sleep(3000);

        	/*WebDriverWait wait = new WebDriverWait(driver, 10);
        	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("p2card2")));*/
        	Thread.sleep(1500);
        	driver.findElement(By.id("p2card2")).click();
    		driver.findElement(By.id("p2card3")).click();
    		driver.findElement(By.id("p2card4")).click();
    		driver.findElement(By.id("p3card1")).click();
    		driver.findElement(By.id("p3card5")).click();

    		Thread.sleep(2000);
    		driver.findElement(By.id("butt")).click();
    		Thread.sleep(2000);

        }
        catch(Exception e)
        {
        	
        }
		
		//System.out.println("#="+temp);
		String temp=driver.findElement(By.id("Winner")).getText();
		String temp2=temp.charAt(temp.length()-1)+"";
		assertEquals("2",temp2);
		driver.close();
	}

}
