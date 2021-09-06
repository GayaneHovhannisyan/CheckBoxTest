package base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import javax.naming.directory.NoSuchAttributeException;
import java.time.Duration;
import java.util.UUID;

public abstract class BaseTest {
//    private static WebDriver driver;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return MyWebDriver.getDriver();
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), 10, 1000);
        }
        return wait;
    }

    public WebElement waitForElement(WebElement element) {
        return getWait().withMessage("Element can not be located " + element)
                .until(ExpectedConditions.visibilityOf(element));
    }

    //   public boolean waitForInputValueToBe(WebElement element,String text){
//       return getWait().withMessage("No").until(ExpectedConditions.or(ExpectedConditions.attributeToBe(element,"value","xx")));
//   }
//    private FluentWait<WebDriver> getFluentWait(WebDriver webDriver) {
//
//        return new FluentWait<>(getDriver());
//    }
//
//    public void fluentWait(By element) {
//        wait.withMessage("error message").withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class)
//                .until(ExpectedConditions.invisibilityOfElementLocated(element));
//    }
//
//    public void waitForAttribute(By element) {
//        getFluentWait(getDriver()).withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchAttributeException.class)
//                .until(ExpectedConditions.attributeToBe(element, "hidden", "true"));
//    }
    @AfterMethod(alwaysRun = true)
    public void methodTearDown(ITestResult result){
     if(ITestResult.FAILURE==result.getStatus() ) {
         Helper helper =new Helper();
         String filePhat="C:\\Users\\HP\\Desktop\\FileScreen\\";
         String fileName = UUID.randomUUID()+".png";
         helper.screenShot(getDriver(),filePhat+fileName);
     }



    }
//@BeforeTest(alwaysRun = true)
//    public void beforeTest(){
//    System.out.println("before Test");
//}
//@BeforeClass(alwaysRun = true)
//        public void beforeClass(){
//        System.out.println("Before Class");
//    }
}


