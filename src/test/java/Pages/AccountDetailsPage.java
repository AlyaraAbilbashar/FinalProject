package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountDetailsPage {
    WebDriver driver;
    @FindBy(id = "transactionTable") WebElement table;

    public AccountDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void list_table(){
        List<WebElement> rows =  table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                String cellText = column.getText();
                System.out.print(cellText + "\t");
            }
            System.out.println();
        }
    }
}
