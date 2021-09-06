package real;

import base.BaseTest;
import base.Helper;
import dataproviders.EmailDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.ElementsTextBox;
import pages.ImdbTop;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import static org.testng.Assert.*;

public class ElementTextBox extends BaseTest {
    public static final Logger log = Logger.getLogger(String.valueOf(ElementsTextBox.class));
    private Helper helper;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        helper = new Helper();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        final String url = "https://demoqa.com/text-box";
        getDriver().get(url);
    }


    @Test
    public void fillTestBoxes() {
        final String fullName = "Sos Sargsyan";
        final String email = "sos@gmail.com";
        final String currentAddress = "Republic square 1";
        final String permanentAddress = "Lori" + UUID.randomUUID().toString();
        ElementsTextBox elementsTextBox = PageFactory.initElements(getDriver(), ElementsTextBox.class);

        elementsTextBox
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress);


        Helper helper = new Helper();
        final String path = "C:\\Users\\HP\\Desktop\\FileScreen\\";
        String fileName = "Element.jpg";
        helper.screenShot(getDriver(), path + fileName);

        elementsTextBox.submit();
        //-------------
        elementsTextBox.scrollToOutput();
        assertEquals(fullName, elementsTextBox.getFullName());
        assertEquals(email, elementsTextBox.getEmail());
//        assertEquals(currentAddress, elementsTextBox.getCurrentAddress());
//        assertEquals(permanentAddress, elementsTextBox.getPermanentAddress());
    }

    @Test(testName = "check invalid email", dataProvider = "invalidEmail", dataProviderClass = EmailDataProvider.class)
    public void checkEmailValidation(String invalidEmail) {
        final ElementsTextBox elementsTextBox = PageFactory.initElements(getDriver(), ElementsTextBox.class);
        elementsTextBox.setEmail(invalidEmail);
        elementsTextBox.submit();
    //    assertTrue(elementsTextBox.isEmailErrorDisplayed());
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }

}
