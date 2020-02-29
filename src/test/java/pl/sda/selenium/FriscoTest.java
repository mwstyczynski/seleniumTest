package pl.sda.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FriscoTest {
    @Test
    public void firstClick(){
        System.setProperty ("webdriver.chrome.driver", "C:/bin/chromedriver.exe");

        WebDriver browser = new ChromeDriver ();
        browser.get("https://www.frisco.pl/stn,promocje");

        // dodajemy czekanie na zaladowanie się calej strony
        //browser.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);

        // dodajemy lepsze czekanie na zaladowanie się calej strony
        WebDriverWait wait = new WebDriverWait (browser,20);
        WebElement foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".ribbon-message button")));
        foundElement.click ();          // turn off unnecessary element

        // turn off unnecessary ribbons and messages
        // browser.findElement (By.cssSelector (".ribbon-message button")).click ();

        // dodajemy element do koszyka z wyszukanych wszystkich cart-button_add
        browser.findElements (By.cssSelector (".cart-button_add"));
        List<WebElement> addToCart = browser.findElements (By.cssSelector (".cart-button_add"));
        addToCart.get (1).click ();                 // metoda get dla 2giego przycisku znalezionego na stronie

    }
}