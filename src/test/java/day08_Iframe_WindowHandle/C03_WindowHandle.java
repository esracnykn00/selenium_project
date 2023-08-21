package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle extends TestBase {

    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindow = driver.getWindowHandle(); //driver hangi sayfadaysa o sayfaya gidip windowhandle yapip
                                                         // hazirda bekletmem gerekiyor.

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW); //driver'a yeni bir pencereye gecis yap dedim
        driver.get("https://www.youtube.com");
        String youtubeWindow = driver.getWindowHandle();

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedInWindow = driver.getWindowHandle(); //en son gittgim llinkedin sayfasini kapatti
                                                          //cunku testBase de drive.close() yazmistim

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindow);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindow);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedInWindow);
    }

    @Test
    public void windowHandle2() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproWindow = driver.getWindowHandle(); //driver hangi sayfadaysa o sayfaya gidip windowhandle yapip
        // hazirda bekletmem gerekiyor.

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education", driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB); //driver'a yeni bir pencereye gecis yap dedim
        driver.get("https://www.youtube.com");
        String youtubeWindow = driver.getWindowHandle();

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedInWindow = driver.getWindowHandle(); //en son gittgim llinkedin sayfasini kapatti
                                                         // cunku testBase de drive.close() yazmistim
        bekle(2);

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproWindow);
        bekle(2);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindow);
        bekle(2);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedInWindow);
        bekle(2);

    }

    @Test
    public void windowHandle3() {

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        //Başlığın "TechPro Education" olduğunu doğrulayın
        Assert.assertEquals("TechPro Education",driver.getTitle());

        //Window 2'de (yeni bir sekmede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com");

        //Window 3'te (yeni bir sekmede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        bekle(2);
        List<String> pencerelerListesi = new ArrayList<>(driver.getWindowHandles());
        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(pencerelerListesi.get(0));
        bekle(2);
        //youtube sayfasına geçiniz:
        driver.switchTo().window(pencerelerListesi.get(1));
        bekle(2);
        driver.switchTo().window(pencerelerListesi.get(2));
        bekle(2);

    }
}
