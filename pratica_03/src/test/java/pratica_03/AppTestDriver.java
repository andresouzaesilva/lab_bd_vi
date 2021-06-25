package pratica_03;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AppTestDriver {
	
	@ParameterizedTest
	@CsvSource(value = {"50:50:75", "25:15:28.75", "10:3:10.3","256:11:284.16","100:0:100", "1225:33:1629.25", "550:25:55025"}, delimiter=':')
    public void testParticao1(float numero1, float numero2, float resultado) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");    
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/pratica_03/porcentagem");
        Thread.sleep(1000);
        WebElement numero1Input = driver.findElement(By.name("numero1"));
        numero1Input.sendKeys(String.valueOf(numero1));
        WebElement numero2Input = driver.findElement(By.name("numero2"));
        numero2Input.sendKeys(String.valueOf(numero2));
        Thread.sleep(1000);
        WebElement bt = driver.findElement(By.id("enviar")); 
        bt.click();
        Thread.sleep(1000);
        Float resultWebDrive = Float.parseFloat(driver.findElement(By.id("result")).getText());
        assertTrue(resultWebDrive.equals(resultado));
		driver.close();
        driver.quit();
    }
	

}
