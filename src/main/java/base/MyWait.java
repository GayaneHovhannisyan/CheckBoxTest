package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWait {
    private WebDriverWait wait;

    public WebDriverWait getWait(WebDriver driver) {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10, 1000);
        }
        return wait;
    }

    public WebElement waitForElement(WebDriver driver, WebElement element) {
        getWait(driver).withMessage("can't find " + element)
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
