package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class BillPayPage {
    WebDriver driver;
    @FindBy(name = "payee.name") WebElement name_fld;
    @FindBy(name = "payee.address.street") WebElement add_fld;
    @FindBy(name = "payee.address.city") WebElement city_fld;
    @FindBy(name = "payee.address.state") WebElement st_fld;
    @FindBy(name = "payee.address.zipCode") WebElement zip_fld;
    @FindBy(name = "payee.phoneNumber") WebElement phone_fld;
    @FindBy(name = "payee.accountNumber") WebElement acc_fld;
    @FindBy(name = "verifyAccount") WebElement v_acc_fld;
    @FindBy(name = "amount") WebElement amount_fld;
    @FindBy(name = "fromAccountId") WebElement from_acc_fld;
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[1]/form/table/tbody/tr[14]/td[2]/input") WebElement btn;
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div[2]/h1") WebElement message;
    @FindBy(linkText = "Accounts Overview") WebElement acc_over;
    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a") WebElement acc;
    public BillPayPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void bill_pay(String one, String two, String three, String four, String five,
                         String six, String seven, String eight, String nine, String ten){
        name_fld.sendKeys(one);
        add_fld.sendKeys(two);
        city_fld.sendKeys(three);
        st_fld.sendKeys(four);
        zip_fld.sendKeys(five);
        phone_fld.sendKeys(six);
        acc_fld.sendKeys(seven);
        v_acc_fld.sendKeys(eight);
        amount_fld.sendKeys(nine);
        from_acc_fld.sendKeys(ten);
        btn.click();

    }
    public String get_message(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return message.getText();
    }
    public void next_page(){
        acc_over.click();
        acc.click();
    }
}
