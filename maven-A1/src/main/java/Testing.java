import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testing {
	public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\michael\\eclipse-workspace\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
    }
}
