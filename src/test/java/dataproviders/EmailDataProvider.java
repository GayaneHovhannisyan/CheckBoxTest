package dataproviders;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class EmailDataProvider {
 @DataProvider(name = "invalidEmail")
    public static Object[][] invalidEmailData(){

     return new Object[][]{
             {"asd@qwe"},
             {"@qles.com"},
             {"@."},
             {"@gmail.com"},
     };
 }
}
