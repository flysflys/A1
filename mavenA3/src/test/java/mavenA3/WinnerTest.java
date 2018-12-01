package mavenA3;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        	driver.findElement(By.id("numOfAI")).sendKeys("3");
        	Thread.sleep(1000);
        	driver.findElement(By.id("startButt")).click();
        	Thread.sleep(1000);
        }
        catch(Exception e)
        {
        	
        }
		String tempStr=driver.findElement(By.id("numP")).getText();
		String temp=tempStr.charAt(tempStr.length()-1)+"";
		tempStr=driver.findElement(By.id("numAI")).getText();
		String temp2=tempStr.charAt(tempStr.length()-1)+"";
		//System.out.println("#="+temp);
		assertEquals("Player1",temp2);
		driver.close();
	}

}
