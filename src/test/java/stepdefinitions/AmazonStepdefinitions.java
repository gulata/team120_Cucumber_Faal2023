package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class AmazonStepdefinitions {
    AmazonPage amazonPage = new AmazonPage();
    Select select;
    List<WebElement> opsiyonElementList;
    String ikinciUrunIsim;
    String ikinciUrunFiyat;

    @Given("kullanici amazonUrl anasayfaya gider")
    public void kullanici_amazon_url_anasayfaya_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }

    @Given("arama kutusuna Nutella yazip aratir")

    public void arama_kutusuna_nutella_yazip_aratir() {

        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }

    @Then("arama sonuclarinin Nutella icerdigini test eder")
    public void arama_sonuclarinin_nutella_icerdigini_test_eder() {
        String expectedIcerik = "Nutella";
        String actualAramaSonucu = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualAramaSonucu.contains(expectedIcerik));

    }

    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();

    }

    @Given("arama kutusuna Java yazip aratir")
    public void arama_kutusuna_java_yazip_aratir() {
        amazonPage.aramaKutusu.sendKeys("Java" + Keys.ENTER);
    }

    @Then("arama sonuclarinin Java icerdigini test eder")
    public void arama_sonuclarinin_java_icerdigini_test_eder() {
        String expectedIcerik = "Java";
        String actualAramaSonucu = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualAramaSonucu.contains(expectedIcerik));

    }

    @Then("{int} saniye bekler")
    public void saniye_bekler(Integer saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullanici_anasayfaya_gider(String istenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(istenenUrl));

    }

    @Then("arama kutusuna {string} yazip aratir")
    public void arama_kutusuna_yazip_aratir(String arananUrun) {
        amazonPage.aramaKutusu.sendKeys(arananUrun + Keys.ENTER);

    }

    @Then("arama sonuclarinin {string} icerdigini test eder")
    public void arama_sonuclarinin_icerdigini_test_eder(String arananUrun) {
        // Write code here that turns the phrase above into concrete actions
        String actualSonucYaziElementi = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYaziElementi.contains(arananUrun));

    }

    @Then("ilk urunu tiklar")
    public void ilk_urunu_tiklar() {
        amazonPage.ilkUrunElementi.click();
    }

    @Then("urun isminin {string} icerdigini test eder")
    public void urun_isminin_icerdigini_test_eder(String arananUrun) {
        String actualIlkUrunIsmi = amazonPage.ilkUrunIsimElementi.getText();
        Assert.assertTrue(actualIlkUrunIsmi.contains(arananUrun));

    }

    @Then("Arama kutusunun solundaki dropdown menuye handle edin")
    public void arama_kutusunun_solundaki_dropdown_menuye_handle_edin() {
        select = new Select(amazonPage.getDropDownElement);


    }

    @Then("dropdown menudeki opsiyonlari liste olarak yazdirii")
    public void dropdown_menudeki_opsiyonlari_liste_olarak_yazdirii() {

        opsiyonElementList = select.getOptions();
        List<String> opsiyonlarListesi = ReusableMethods.stringListeCevir(opsiyonElementList);
        System.out.println(opsiyonlarListesi);


    }

    @Then("dropdown menude {int} eleman oldugunu test  edin")
    public void dropdown_menude_eleman_oldugunu_test_edin(Integer expectedOptiOnSayisi) {

        Integer actualOptionSayisi = opsiyonElementList.size();
        Assert.assertEquals(expectedOptiOnSayisi, actualOptionSayisi);


    }

    @When("dropdown menuden elektronik bolumu secer")
    public void dropdown_menuden_elektronik_bolumu_secer() {
        select.selectByVisibleText("Electronics");

    }

    @When("bulunan sonuc sayisini yazdirir")
    public void bulunan_sonuc_sayisini_yazdirir() {
        System.out.println(amazonPage.sonucYaziElementi.getText());

    }

    @Then("ikinci urune tiklar")
    public void ikinci_urune_tiklar() {
        amazonPage.ikinciElement.click();


    }
    @Then("urunun title'ni ve fiyatini variable'a assing edip urunu sepete ekleyelim")
    public void urunun_title_ni_ve_fiyatini_variable_a_assing_edip_urunu_sepete_ekleyelim () {
ikinciUrunIsim= amazonPage.ikinciUrunIsimElementi.getText();
ikinciUrunFiyat=amazonPage.ikinciUrunFiyatElementi.getText();
amazonPage.addToCardButonu.click();

    }
}
