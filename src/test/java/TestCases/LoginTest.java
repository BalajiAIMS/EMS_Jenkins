package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.BaseClass;
import POM.LoginPage;
public class LoginTest extends BaseClass {

    LoginPage login;

    @BeforeClass
    public void setup() {
        // Launch the application
        driver.get(prop.getProperty("url"));
    }

    @BeforeMethod
    public void initPageObjects() {
        login = new LoginPage(driver);  // Page object init before each test
    }

    @Test
    public void loginTest() {
        login.userLogin(prop.getProperty("email"), prop.getProperty("password"));
        // Add assertion if needed, e.g.:
        //Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }
}

