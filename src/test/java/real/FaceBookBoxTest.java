package real;

import base.BaseTest;
import base.Helper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FaceBookPage;

public class FaceBookBoxTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUpFaceBookPage() {
        final String url = "https://www.facebook.com/";
        getDriver().get(url);
    }
@Test
    public void fillFaceBookBoxes(){
        final String email="gayaneog13@mail.ru";
        final String passWord ="Enayag#";
    FaceBookPage faceBookPage= PageFactory.initElements(getDriver(),FaceBookPage.class);
    faceBookPage.setEmail(email);
    faceBookPage.setPassWord(passWord);
    faceBookPage.setSubmit();

}



}
