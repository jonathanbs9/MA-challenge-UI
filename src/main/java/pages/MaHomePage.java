package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MaHomePage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//div[@id='desktopMenu']//li[@id='menu-item-30907']")
    WebElement segurosPersonalesMenu;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[1]/header[1]/div[1]/nav[2]/div[2]/ul[1]/div[3]/li[1]/ul[1]/li[2]")
    WebElement autoDropDown;


    public MaHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSegurosPersonalesMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='desktopMenu']//li[@id='menu-item-30907']")));
        segurosPersonalesMenu.click();
    }

    public void clickAutoDropDown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/nav[2]/div[2]/ul[1]/div[3]/li[1]/ul[1]/li[2]")));
        autoDropDown.click();
    }
}
