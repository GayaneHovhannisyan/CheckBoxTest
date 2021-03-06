package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MyWebDriver {
    private static WebDriver driver;

    private  static void setUpDriver(){
    System.setProperty("webdriver.chrome.driver","src/main/drivers/chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--headless");
    driver = new ChromeDriver(options);
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
    public static WebDriver getDriver() {
        if (driver == null) {
            setUpDriver();
        }
        return driver;
    }

}

