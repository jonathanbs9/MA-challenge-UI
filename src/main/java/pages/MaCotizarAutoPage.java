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

public class MaCotizarAutoPage {
    private WebDriver driver;

    public MaCotizarAutoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//select[@id='selectMarcas']")
    WebElement marcaSelect;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'PEUGEOT')]")
    WebElement peugeoutOption;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'FERRARI')]")
    WebElement ferrariOption;

    @FindBy(how = How.XPATH, using = "//select[@id='selectAnio']")
    WebElement anioSelect;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'2022')]")
    WebElement option2022;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'2010')]")
    WebElement option2010;

    @FindBy(how = How.XPATH, using = "//select[@id='selectModelos']")
    WebElement modeloSelect;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'206')]")
    WebElement doscientosSeisOption;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'488 SPYDER')]")
    WebElement spyder488Option;

    @FindBy(how = How.XPATH, using = "//select[@id='selectVersion']")
    WebElement versionSelect;

    @FindBy(how = How.XPATH, using = "//option[@value='320565']")
    WebElement cincoPtasGenerationOption;

    @FindBy(how = How.XPATH, using = "//option[@value='510038']")
    WebElement spyderVersionOption;

    @FindBy(how = How.XPATH, using = "//select[@id='selectProvincias']")
    WebElement provinciaSelect;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'BUENOS AIRES')]")
    WebElement buenosAiresOption;

    @FindBy(how = How.XPATH, using = "//select[@id='selectCiudad']")
    WebElement localidadSelect;

    @FindBy(how = How.XPATH, using = "//option[contains(text(),'MAR DEL PLATA')]")
    WebElement marDelPlataOption;

    @FindBy(how = How.XPATH, using = "//button[@id='cotizador-next1']")
    WebElement siguienteBoton;


    @FindBy(how = How.XPATH, using = "//*[@id='cotizar-error']")
    WebElement cotizarMensaje;

    public void clickMarcaSelectAndClickPeugeoutOption() {
        marcaSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'PEUGEOT')]")));
        peugeoutOption.click();
    }

    public void clickMarcaSelectAndClickFerrariOption() {
        marcaSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'FERRARI')]")));
        ferrariOption.click();
    }

    public void clickAnioSelectAndClick2010Option() {
        anioSelect.click();
        option2010.click();
    }

    public void clickAnioSelectAndClick2022Option() {
        anioSelect.click();
        option2022.click();
    }

    public void clickModeloSelectAndClick206() {
        modeloSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'206')]")));
        doscientosSeisOption.click();
    }

    public void clickModelosSelectAndClickSpyder488Option() {
        modeloSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'488 SPYDER')]")));
        spyder488Option.click();
    }

    public void clickVersionSelectAndClick5PtasGenerationOption() {
        versionSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='320565']")));
        cincoPtasGenerationOption.click();
    }

    public void clickVersionSelectAndSpyder488Option() {
        versionSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='510038']")));
        spyderVersionOption.click();
    }

    public void clickProvinciaSelectAndClickBuenosAiresOption() {
        provinciaSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'BUENOS AIRES')]")));
        buenosAiresOption.click();
    }

    public void clickLocalidadSelectAndClickMarDelPlataOption() {
        localidadSelect.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'MAR DEL PLATA')]")));
        marDelPlataOption.click();
    }

    public void clickSiguiente() {
        siguienteBoton.click();
    }

    public String obtenerMensajeCotizador() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cotizar-error']")));
        return cotizarMensaje.getText();
    }
}
