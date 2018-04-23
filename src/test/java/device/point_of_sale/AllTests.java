package device.point_of_sale;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AppTest.class, TestBarCodeType.class, TestDevice.class, TestProductsDatabase.class, TestReceipt.class })
public class AllTests {

}
