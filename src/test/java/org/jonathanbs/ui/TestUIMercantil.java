package org.jonathanbs.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.logging.Logger;


public class TestUIMercantil extends BaseTest {
    private static String COTIZAR_MENSAJE = "Excede Suma asegurada permitida para suscripcion directa.";

    @Test
    public void TestCase001CotizarPeugeot206() throws InterruptedException {
        MaHomePage homepage = new MaHomePage(driver);
        logger.info("Home Page");
        createWait(2);
        homepage.clickSegurosPersonalesMenu();
        homepage.clickAutoDropDown();

        logger.info("Auto page");
        MaAutoPage autoPage = new MaAutoPage(driver);
        autoPage.clickCotizarAuto();

        logger.info("Ingresando datos auto");
        MaCotizarAutoPage cotizarAutoPage = new MaCotizarAutoPage(driver);
        cotizarAutoPage.clickMarcaSelectAndClickPeugeoutOption();
        cotizarAutoPage.clickAnioSelectAndClick2010Option();
        cotizarAutoPage.clickModeloSelectAndClick206();
        cotizarAutoPage.clickVersionSelectAndClick5PtasGenerationOption();
        cotizarAutoPage.clickProvinciaSelectAndClickBuenosAiresOption();
        cotizarAutoPage.clickLocalidadSelectAndClickMarDelPlataOption();

        cotizarAutoPage.clickSiguiente();

        logger.info("Ingresando datos personales");
        MaCotizarAutoDatosPage autoDatosPage = new MaCotizarAutoDatosPage(driver);
        autoDatosPage.ingresarNombre("Juan Carlos Tesla");
        autoDatosPage.ingresarEmail("test.automation@gmail.com");
        autoDatosPage.ingresarAreaYTelefono("223", "44445555");
        logger.info("Clickeando captcha");
        autoDatosPage.clickearCaptcha();

        Thread.sleep(4000);
        autoDatosPage.clickearSiguiente();

        logger.info("Costos Page");
        MaCotizarAutoCostosPage autoCostosPage = new MaCotizarAutoCostosPage(driver);

        /** Validar pantalla Costos **/
        logger.info("Validando Asserts");
        createWait(5);
        Assert.assertTrue(autoCostosPage.isCostosActivo());

        /** Validar datos **/
        Assert.assertEquals(autoCostosPage.obtenerMarca(), "PEUGEOT");
        Assert.assertEquals(autoCostosPage.obtenerModelo(), "206");
        Assert.assertEquals(autoCostosPage.obtenerAnio(), "2010");

        /** Validar chat **/
        Assert.assertTrue(autoCostosPage.chatOnlinePresente());
        logger.info("Fin Test");
    }

    @Test
    public void TestCase002CotizarFerrari(){
        logger.info("Home Page");
        MaHomePage homepage = new MaHomePage(driver);
        homepage.clickSegurosPersonalesMenu();
        homepage.clickAutoDropDown();

        logger.info("Autos Page");
        MaAutoPage autoPage = new MaAutoPage(driver);
        autoPage.clickCotizarAuto();

        logger.info("Ingresando datos auto");
        MaCotizarAutoPage cotizarAutoPage = new MaCotizarAutoPage(driver);
        cotizarAutoPage.clickMarcaSelectAndClickFerrariOption();
        cotizarAutoPage.clickAnioSelectAndClick2022Option();
        cotizarAutoPage.clickModelosSelectAndClickSpyder488Option();
        cotizarAutoPage.clickVersionSelectAndSpyder488Option();
        cotizarAutoPage.clickProvinciaSelectAndClickBuenosAiresOption();
        cotizarAutoPage.clickLocalidadSelectAndClickMarDelPlataOption();

        cotizarAutoPage.clickSiguiente();

        /** Validar mensaje de Cotizador **/
        logger.info("Validando asserts");
        Assert.assertEquals(cotizarAutoPage.obtenerMensajeCotizador(), COTIZAR_MENSAJE);
        logger.info("Fin Test");
    }
}
