package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "username") WebElement usr_fld;
    @FindBy(name = "password") WebElement passwd_fld;
    @FindBy(css = "input[type='submit'].button[value='Log In']") WebElement login_btn;
    @FindBy(xpath = "//a[@class='ng-binding']") WebElement acc_id;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fill_usr(String usr){
        usr_fld.sendKeys(usr);
    }
    public void fill_passwd(String passwd){
        passwd_fld.sendKeys(passwd);
    }
    public void login(){
        login_btn.click();
    }
    public String get_id(){
        return acc_id.getText();
    }

}
