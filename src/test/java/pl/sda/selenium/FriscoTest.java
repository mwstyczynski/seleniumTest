package pl.sda.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FriscoTest {
    @Test
    public void firstClick(){
        System.setProperty ("webdriver.chrome.driver", "C:/bin/chromedriver.exe");

        WebDriver browser = new ChromeDriver ();
        browser.get("https://www.frisco.pl/stn,promocje");

                    // dodajemy czekanie na zaladowanie się calej strony
                    // browser.manage ().timeouts ().implicitlyWait (5, TimeUnit.SECONDS);

                    // dodajemy lepsze czekanie na zaladowanie się calej strony
                    // WebDriverWait wait = new WebDriverWait (browser,20);

        // ten fragment odnosi się do pokazanego w notatkach nowego popupu (krzyzyk ma klase .close jako css selector)
        // dodajemy jeszcze lepsze czekanie dające możliwości konfiguracji elementów
        // Typy generyczne Java (bardzo zaawansowana wiedza programistyczna, ale można doczytać)
        FluentWait<WebDriver> wait = new FluentWait<> (browser);
        // czekamy az pojawi się element który chcemy wylaczyc przed samym testem i klikamy na niego (robimy element i ponizej klikamy)
        Duration duration = Duration.ofSeconds(5);
        wait.pollingEvery (duration);
        // WebElement popup = w ten sposób przypisujemy WebElement do zmiennej "popup"
        WebElement popup = wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".close")));
        popup.click ();
        // czekamy aż element zostanie zamknięty
        wait.until (ExpectedConditions.not (ExpectedConditions.presenceOfAllElementsLocatedBy (By.cssSelector (".fixed-popup"))));

        // wyłaczamy ribbon o klasie css selektora .ribbon-message button (to na dole)
        WebElement foundElement = wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".ribbon-message button")));
        foundElement.click ();          // turn off unnecessary element

        // dodajemy wyjątek jeśli by się okazało, ze tego popupa nie bedzie np za tydzień


        // drukowanie do konsoli informacji o cookiesach
        for(Cookie cookie: browser.manage ().getCookies ()){
            System.out.println (cookie.getValue());
        }

        // turn off unnecessary ribbons and messages
        // browser.findElement (By.cssSelector (".ribbon-message button")).click ();

        // dodajemy element do koszyka z wyszukanych wszystkich cart-button_add
        browser.findElements (By.cssSelector (".cart-button_add"));
        List<WebElement> addToCart = browser.findElements (By.cssSelector (".cart-button_add"));
        addToCart.get (1).click ();                 // metoda get dla 2giego przycisku znalezionego na stronie

    }
}