package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.WebUniPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebUniStepdefinitions {
WebUniPage webUniPage= new WebUniPage();
String ilkSayfaWHD;

    // login portal'a kadar asagi indigimizde click problem oldugundan
    // contact us butonuna kadar asagi indik
    @Then("Login Portal a  kadar asagi iner")
    public void login_portal_a_kadar_asagi_iner() {
        ilkSayfaWHD=Driver.getDriver().getWindowHandle();
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",webUniPage.contakUsButonu);
        ReusableMethods.bekle(3);


    }
    @Then("Login Portal a tiklar")
    public void login_portal_a_tiklar() {
        webUniPage.loginPortalButonu.click();

    }
    @Then("Diger window'a gecer")
    public void diger_window_a_gecer() {
        ReusableMethods.switchToWindow("WebDriver | Login Portal");
        System.out.println(Driver.getDriver().getTitle());


    }
    @Then("username ve  password kutularina faker ile deger yazdirir")
    public void username_ve_password_kutularina_faker_ile_deger_yazdirir() {
     Faker faker= new Faker();
     webUniPage.usernameKutusu.sendKeys(faker.name().username());
     webUniPage.passwordKutusu.sendKeys(faker.internet().password());

    }
    @Then("webUni login butonuna basar")
    public void web_uni_login_butonuna_basar() {
     webUniPage.loginButton.click();
    }
    @Then("Popup'ta cikan yazinin validation failed oldugunu test eder")
    public void popup_ta_cikan_yazinin_validation_failed_oldugunu_test_eder() {
        ReusableMethods.bekle(2);
        String expectedAlertYazisi="validation failed";
        String actualAlertYazisi=Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

    }
    @Then("Ok diyerek Popup'i kapatir")
    public void ok_diyerek_popup_i_kapatir() {
        Driver.getDriver().switchTo().alert().accept();

    }
    @When("Ilk sayfaya geri doner")
    public void ılk_sayfaya_geri_doner() {
        ReusableMethods.bekle(4);
        Driver.getDriver().switchTo().window(ilkSayfaWHD);


    }
    @Then("Ilk sayfaya donuldugunu test eder")
    public void ılk_sayfaya_donuldugunu_test_eder() {
        String expectedIlkSayfaUrl="http://webdriveruniversity.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedIlkSayfaUrl,actualUrl);

    }
    @Then("sayfalari kapatir")
    public void sayfalari_kapatir() {
        Driver.quitDriver();


    }


}
