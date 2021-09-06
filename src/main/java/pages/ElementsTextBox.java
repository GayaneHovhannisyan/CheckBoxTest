package pages;

import base.Helper;
import base.MyWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsTextBox {
    @FindBy(css = "[id='userName']")
    private WebElement fullName;
    @FindBy(css = "[id='userEmail']")
    private WebElement email;
    @FindBy(css = "[id='currentAddress']")
    private WebElement currentAddress;
    @FindBy(css = "[id='permanentAddress']")
    private WebElement permanentAddress;
    @FindBy(css = "[id='submit']")
    private WebElement submit;

    //-------------------------------------------
    @FindBy(css = "[id='output']")
    private WebElement output;
    @FindBy(css = "[id='name']")
    private WebElement nameOutput;
    @FindBy(css = "[id='email']")
    private WebElement emailOutput;
    @FindBy(css = "[id='currentAddress']")
    private WebElement currentAddressOutput;
    @FindBy(css = "[id='permanentAddress']")
    private WebElement permanentAddressOutput;
    //    ---------------------------------------
    @FindBy(css ="[id='suggestion-search']")
    private WebElement searchImdb;
    private final Helper helper=new Helper();


    public ElementsTextBox setSearchImdb(String searchImdbText) {

        searchImdb.click();
        searchImdb.sendKeys(searchImdbText);
        return this;
    }


//    private void scrollIntoView(WebElement element) {
//        ((JavascriptExecutor) MyWebDriver.getDriver())
//                .executeScript("arguments[0].scrollIntoView(true)", element);
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public ElementsTextBox setFullName(String fullNameText) {
        helper.scrollIntoView(fullName);
        fullName.click();
        fullName.sendKeys(fullNameText);
        return this;
    }

    public ElementsTextBox setEmail(String emailText) {
        helper.scrollIntoView(email);
        email.click();
        email.sendKeys(emailText);
        return this;
    }

    public ElementsTextBox setCurrentAddress(String currentAddressText) {
        helper.scrollIntoView(currentAddress);
        currentAddress.click();
        currentAddress.sendKeys(currentAddressText);
        return this;
    }

    public ElementsTextBox setPermanentAddress(String permanentAddressText) {
        helper.scrollIntoView(permanentAddress);
        permanentAddress.click();
        permanentAddress.sendKeys(permanentAddressText);
        return this;
    }

    public void submit() {
        helper.scrollIntoView(submit);
        submit.click();
    }

    public String getInputFieldPlaceHolder(WebElement inputElement) {
        helper.scrollIntoView(inputElement);
        return inputElement.getAttribute("placeholder");
    }

    public boolean isEmailErrorDisplayed() {
        helper.scrollIntoView(email);
        return email.getAttribute("class").contains("field-error");
    }

    public void scrollToOutput() {
        helper.scrollIntoView(output);
    }

    public String getFullName() {
        return nameOutput.getText().split(":")[1];
    }

    public String getEmail() {
        return emailOutput.getText().split(":")[1];
    }

    public String getCurrentAddress() {
        return currentAddressOutput.getText().split(":")[1];
    }

    public String getPermanentAddress() {
        return permanentAddressOutput.getText().split(":")[1];
    }
}
