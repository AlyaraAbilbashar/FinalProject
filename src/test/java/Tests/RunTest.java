package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class RunTest {
    WebDriver driver;
    String acc_id;
    TransferFundsPage transferFundsPage;

    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test(priority = 0)
    public void login_test(){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fill_usr("Alyara");
        loginPage.fill_passwd("123");
        loginPage.login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        acc_id = loginPage.get_id();
    }
    @Test(priority = 1)
    public void account_overview(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AccountsOverviewPage acc_page = new AccountsOverviewPage(driver);
        acc_page.sum_up();
        acc_page.compare();
        TransferFundsPage transferFundsPage = acc_page.navigate_next_page();
    }
    @Test(priority = 2)
    public void transfer_funds(){
        TransferFundsPage transferFundsPage = new TransferFundsPage(driver);
        transferFundsPage.transaction();
        transferFundsPage.next_page();
    }
    @DataProvider(name = "payee")
    public Object[][] provideInfo(){
        return new Object[][]{
                {"Alyara", "kaskelen", "kaskelen", "kaskelen", "123", "123","1","1","50",acc_id}
        };
    }
    @Test(dataProvider = "payee", priority = 3)
    public void bill_pay(String one, String two, String three, String four, String five,
                         String six, String seven, String eight, String nine, String ten){
        BillPayPage billPayPage = new BillPayPage(driver);
        billPayPage.bill_pay(one, two, three, four, five, six, seven, eight, nine, ten);
        //Assert.assertEquals(billPayPage.get_message(), "See Account Activity for more details.");
        billPayPage.next_page();
    }
    @Test(priority = 4)
    public void details_info(){
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
        accountDetailsPage.list_table();
    }

}
