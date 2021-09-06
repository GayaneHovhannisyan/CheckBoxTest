package real;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;

import java.util.List;

import static org.testng.Assert.*;

public class CheckBoxTest extends BaseTest {
    private CheckBoxesPage checkBoxesPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        final String url = "https://demoqa.com/checkbox";
        getDriver().get(url);
        checkBoxesPage = PageFactory.initElements(getDriver(), CheckBoxesPage.class);
    }

    @Test
    public void allSubsectionsAreExpanded() {
        assertTrue(checkBoxesPage.areAllCollapsed());
        checkBoxesPage.expandAll();
        assertTrue(checkBoxesPage.areAllExpanded());
        checkBoxesPage.iconHome();
        assertTrue(checkBoxesPage.areAllChecked());
        checkBoxesPage.CheckOrHalfCheck();
        assertTrue(checkBoxesPage.isHomeHalfCheck());
        checkBoxesPage.collapseAll();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }

}
