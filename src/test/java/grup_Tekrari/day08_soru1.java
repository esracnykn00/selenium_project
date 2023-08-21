package grup_Tekrari;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class day08_soru1 extends TestBase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully kismini mauel test ettik
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. Verify 'New User Signup!' is visible
        driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed();
        //6. Enter name and email address
        // 7. Click 'Signup' button
        WebElement buton= driver.findElement(By.xpath("//*[@type='text']"));
        buton.sendKeys("Esra", Keys.TAB,"hz3zfx@ezztt.com",Keys.TAB,Keys.ENTER);
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed();
        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement bilgiler = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        bilgiler.click();
        bilgiler.sendKeys(Keys.TAB,Keys.TAB,"1234",Keys.TAB,"27",Keys.TAB,"June",Keys.TAB,"2020");
        bekle(2);
        //10. Select checkbox 'Sign up for our newsletter!'
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@name='newsletter']"));
        checkBox1.click();
       // if (!checkBox1.isSelected()){
         //   checkBox1.click();
        //}
        //11. Select checkbox 'Receive special offers from our partners!'
        bekle(2);
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        checkBox2.click();
       // if (!checkBox2.isSelected()){
       //     checkBox2.click();
       // }
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        bekle(2);
        WebElement bilgiler2 = driver.findElement(By.xpath("//*[@id='first_name']"));

        bilgiler2.sendKeys("esra",Keys.TAB,"canayakin",Keys.TAB,"techpro",Keys.TAB,"istanbul",Keys.TAB);













    }
}
