package dummy;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;

import static org.testng.Assert.*;

public class CheckBoxTest extends BaseTest {
    CheckBoxesPage checkBoxesPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String url = "https://demoqa.com/checkbox";
        getDriver().get(url);
        checkBoxesPage = PageFactory.initElements(getDriver(), CheckBoxesPage.class);
    }

    @Test
    public void checkBoxesTest() {
       checkBoxesPage.getCloseChevrones().get(0).click();

       checkBoxesPage.getCloseChevrones().get(0).click();
    }

}
