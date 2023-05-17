package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class AccountsOverviewPage {
    WebDriver driver;
    double sum;
    @FindBy(css = "td.ng-binding")
    List<WebElement> balance;

    @FindBy(xpath = "//b[@class='ng-binding']") WebElement total;
    @FindBy(linkText = "Transfer Funds") WebElement next_link;
    public AccountsOverviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public double sum_up(){
        for(int i =0; i < balance.size(); i+=2 ){
            WebElement acc_balance = balance.get(i);
            String balance_value_text = acc_balance.getText().replaceAll("[^\\d.]+", "");
            double balance_value_digit = Double.parseDouble(balance_value_text);
            sum += balance_value_digit ;
        }
        System.out.println("Sum of Available amount is " + sum );
        return sum;
    }
    public void compare(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", total);
        String total_value_text = total.getText().replaceAll("[^\\d.]+", "");
        double total_value_digit = Double.parseDouble(total_value_text);
        if(sum==total_value_digit){
            System.out.println("Sum is equal to total");
        }
        else {
            System.out.println("Sum is NOT equal to total");
        }
    }
    public TransferFundsPage navigate_next_page(){
        next_link.click();
        return new TransferFundsPage(driver)
    }
}
