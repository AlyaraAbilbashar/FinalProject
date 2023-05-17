package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class TransferFundsPage {
    WebDriver driver;
    @FindBy(id = "amount") WebElement amount_fld;
    @FindBy(id = "fromAccountId") WebElement from_acc_dd;
    @FindBy(id = "toAccountId") WebElement to_acc_dd;
    @FindBy(css = "input[type='submit'][value='Transfer']") WebElement transfer_btn;
    @FindBy(xpath = "//p[contains(text(), 'See Account Activity for more details.')]") WebElement message;
    @FindBy(linkText = "Bill Pay") WebElement link_np;

    public TransferFundsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void transaction(){
        Random random = new Random();
        int min = 1;
        int max = 100;
        int random_amount = random.nextInt(max-min+1) + min;
        amount_fld.sendKeys(String.valueOf(random_amount));
        driver.navigate().refresh();
        amount_fld.sendKeys(String.valueOf(random_amount));
        from_acc_dd.sendKeys("16563");
        to_acc_dd.sendKeys("17007");
        transfer_btn.click();

    }
    public void next_page(){
        link_np.click();
    }
}
