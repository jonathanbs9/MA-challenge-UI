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

public class MaCotizarAutoCostosPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id='brand']")
    WebElement marcaText;

    @FindBy(how = How.XPATH, using = "//*[@id='model']")
    WebElement modeloText;

    @FindBy(how = How.XPATH, using = "//*[@id='year']")
    WebElement anioText;

    @FindBy(how = How.XPATH, using = "//button[@id='wc-button']")
    WebElement chatOnlineButton;

    @FindBy(how = How.XPATH, using = "//*[@id='step3Label']")
    WebElement costosBreadcumb;

    public MaCotizarAutoCostosPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String obtenerMarca(){
        return marcaText.getText();
    }

    public String obtenerModelo(){
        return modeloText.getText();
    }

    public String obtenerAnio(){
        return anioText.getText();
    }

    public Boolean chatOnlinePresente() {
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[4]/iframe")));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='wc-button']")));
        Boolean isChatPresente =  driver.findElement(By.xpath("//button[@id='wc-button']")).isDisplayed();

        driver.switchTo().defaultContent();
        return isChatPresente;
    }

    public Boolean isCostosActivo(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='step3Label']")));
        return costosBreadcumb.getAttribute("class").contains("active");
    }
    

}
