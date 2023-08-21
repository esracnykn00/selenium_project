package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Alert extends TestBase {

     /*
        Eğer bir sayfadaki butona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan uyarı penceresine sağ klik
    yapamıyorsak (incele/inspect) bu tür uyarı pencerelerine js Alert denir. Bu uyarı penceresini handle edemediğimiz
    için driver'i bu pencereye geçiş yaptırmamız gerekir. Bunun içinde switchTo() methodu kullanılır.
    driver.swichTo().alert() methoduyla alert'e geçiş yaparız. Ve alert onaylamak için accept(), iptal etmek için
    dismiss(), alert üzerindeki yazıyı almak için getText() ve alertteki mesaj kutusuna bir text göndermek için
    sendKeys() methodunu kullanırız.
     */

    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        Bir metod olusturun: acceptAlert
        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
        Bir metod olusturun: dismissAlert
        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        "successfuly" icermedigini test edin.
        Bir metod olusturun: sendKeysAlert
        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının  "You successfully clicked an alert" oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();//-->1. buttona click yaptık
        bekle(2);
        driver.switchTo().//-->Geçiş methodu
                alert().//-->Alerte driver'i geçirdik
                accept();//-->Alert'ü onayladık
        String actualResultMessage = driver.findElement(By.xpath("(//p)[2]")).getText();
        String expectedResultMessage = "You successfully clicked an alert";
        Assert.assertEquals(expectedResultMessage,actualResultMessage);

    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // 2. butona tıklayın, uyarıdaki(alert) Cancel butonuna tıklayın ve result mesajının
        // "successfuly" icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();//-->2. buttona click yaptık
        bekle(2);
        driver.switchTo().alert().
                dismiss();//-->Cancel
        bekle(2);
        String ResultMessage = driver.findElement(By.xpath("(//p)[2]")).getText();
        String unexpectedMessage = "successfuly";
        Assert.assertFalse(ResultMessage.contains(unexpectedMessage));

    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("(//button)[3]")).click();//-->3. buttona click yaptık
        bekle(2);
        driver.switchTo().alert().sendKeys("esra");
        bekle(2);
        driver.switchTo().alert().accept();
        String resultMessage = driver.findElement(By.xpath("(//p)[2]")).getText();//-->You entered: esra
        String expectedMessage = "esra";
        Assert.assertTrue(resultMessage.contains("esra"));

    }

}
