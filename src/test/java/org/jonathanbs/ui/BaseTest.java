package org.jonathanbs.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {
    public static WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void SetUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        logger = Logger.getLogger("BaseTest");

        logger.info("Inicializando driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mercantilandina.com.ar/");
    }

    @AfterClass
    public void TearDown(){

        logger.info("Cerrando driver");
        driver.close();
        driver.quit();
    }

    public void createWait(int segundos){
        Logger logger = Logger.getLogger("BaseTest");
        logger.info("Espera de: "+segundos+" segundos");
        driver.manage().timeouts().implicitlyWait(segundos,TimeUnit.SECONDS) ;
    }
}
