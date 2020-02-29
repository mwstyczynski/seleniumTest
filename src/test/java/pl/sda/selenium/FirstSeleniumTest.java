package pl.sda.selenium;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    @BeforeClass        // opisujemy co przed całym zestawem testów ma zrobić klasa
    public static void setup() {
        System.setProperty ("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
    }

    @Test
    public void talkToBrowser() {           // pierwszy test po prostu otwiera i zamyka strone
        WebDriver browser = new ChromeDriver ();    // TypOgólny nazwazmiennej = new TypSzczególny();
        browser.get ("http://google.com/");
        System.out.println (browser.getCurrentUrl ());
        System.out.println (browser.getTitle ());
        browser.quit ();    // całkowicie zakończy komunikację z webdriverem - zamknie wszystko
    }

}