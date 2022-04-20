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

public class MaCotizarAutoDatosPage {
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='nombre']")
    WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//input[@id='mail']")
    WebElement emailInput;

    @FindBy(how = How.XPATH, using = "//input[@id='tel-area']")
    WebElement phoneAreaInput;

    @FindBy(how = How.XPATH, using = "//input[@id='tel']")
    WebElement phoneInput;

    @FindBy(how = How.XPATH, using = "//body[1]/div[1]/div[1]/div[1]/div[1]/section[1]/main[1]/article[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/form[1]/div[2]/fieldset[1]/div[1]/div[1]")
    WebElement captcha;

    @FindBy(how = How.XPATH, using = "//button[@id='cotizador-next2']")
    WebElement siguienteBoton;


    public MaCotizarAutoDatosPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ingresarNombre(String name){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nombre']")));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void ingresarEmail(String email){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mail']")));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void ingresarAreaYTelefono(String area, String telefono){
        phoneAreaInput.clear();
        phoneAreaInput.sendKeys(area);

        phoneInput.clear();
        phoneInput.sendKeys(telefono);
    }

    public void clickearCaptcha(){
        captcha.click();
    }

    public void clickearSiguiente(){
        siguienteBoton.click();
    }

}
