package dataproviders;

import base.Helper;
import org.testng.annotations.DataProvider;

public class IndexDataProvider {
    @DataProvider(name="indexes")
    public static Object[][] indexProvider(){
        Helper helper=new Helper();

        return helper.index(5);

    }
}
