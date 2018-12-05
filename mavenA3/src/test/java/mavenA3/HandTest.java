package mavenA3;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.junit.BeforeClass;
import org.junit.Test;

public class HandTest {

	static WebDriver driver;
	
	App test=new App();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\michael\\eclipse-workspace\\geckodriver.exe");
		driver = new FirefoxDriver();
        driver.get("http://localhost:8080/A3/Firstpage.html");
        driver.manage().window().maximize();
        try
        {
        	Thread.sleep(500);
        	driver.findElement(By.id("numOfPlayers")).sendKeys("3");
        	driver.findElement(By.id("numOfAI")).sendKeys("0");
        	Thread.sleep(1000);
        	driver.findElement(By.id("startButt")).click();
        	Thread.sleep(1000);
        }
        catch(Exception e)
        {
        	
        }
        
	}

	@Test
	public void handTesting() {
		
		String tempStr=driver.findElement(By.id("p1Hand")).getText();
		String [] temp=tempStr.split("\\s+");
		//System.out.println("#="+temp);
		assertEquals("RF",temp[temp.length-1]);
		
		tempStr=driver.findElement(By.id("p2Hand")).getText();
		temp=tempStr.split("\\s+");

		assertEquals("SF",temp[temp.length-1]);
		
		tempStr=driver.findElement(By.id("p3Hand")).getText();
		temp=tempStr.split("\\s+");

		assertEquals("SF",temp[temp.length-1]);
		
	}

	

}
