package pages;

import base.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FaceBookPage {
    @FindBy(css ="[id='email']")
    WebElement email;
    @FindBy(css="[id='pass']")
    WebElement password;
    @FindBy(css="[type='submit']")
    WebElement submit;
    Helper helper=new Helper();

public FaceBookPage setEmail(String emailText){
    helper.scrollIntoView(email);
    email.click();
    email.sendKeys(emailText);
    return  this;
}
public FaceBookPage setPassWord(String passWordText){
    helper.scrollIntoView(password);
    password.click();
    password.sendKeys(passWordText);
    return this;
}
public void setSubmit(){
    helper.scrollIntoView(submit);
    submit.click();
}

}
