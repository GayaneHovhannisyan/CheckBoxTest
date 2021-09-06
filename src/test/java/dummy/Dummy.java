package dummy;

import base.BaseTest;
import dataproviders.IndexDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Dummy extends BaseTest {
//    @AfterMethod
//    public void a(){
//        System.out.println("After------Method ");
//    }
//    @AfterTest
//    public void d(){
//        System.out.println("After------Test");
//    }
//    @BeforeMethod
//    public void m() {
//        System.out.println("Before-------->Method");
//    }
//
//    @BeforeClass
//    public void c() {
//        System.out.println("Before---------->Class");
//    }
//
//    @BeforeSuite
//    public void s() {
//        System.out.println("_Before------>Suit");
//    }
//
//    @BeforeTest
//    public void b() {
//        System.out.println("Before--------->Test");
//    }

//    @Test(testName = "Test 1",
//            dataProvider = "indexes",
//            dataProviderClass = IndexDataProvider.class)
//    public void dummy(int i) {
//        System.out.println("Test " + i);
//    }

    private boolean check = true;
@Test (priority=10)
    public void dummy1(){
    System.out.println("priority 10");
    check=!check;
    if(check){
        System.out.println("Error");
        throw new AssertionError();
    }
}
    @Test ()
    public void dummy2(){
        System.out.println("priority 0");
    }
    @Test (priority=7,enabled = false)
    public void dummy3(){
        System.out.println("priority 7");
    }
    @Test (priority=-8,enabled = false)
    public void dummy4(){
        System.out.println("priority -8");
    }
    @Test (priority=9)
    public void dummy5(){
        System.out.println("priority 9");
    }
    @Test (priority=3)
    public void dummy6(){
        System.out.println("priority 3");
    }
}
