package pl.sda.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondSeleniumTest {
    // TypOgolny nazwa-zmiennej = new TypSzczegolny()
    WebDriver browser = new ChromeDriver ();    // wyciągnięte do góry jako zmienna zadana dla całej klasy

    @BeforeClass                                // opisujemy co przed całym zestawem testów ma zrobić klasa
    public static void setup() {                // @BeforeClass wymusza "static"
        System.setProperty ("webdriver.chrome.driver", "C:/bin/chromedriver.exe");
    }

    @Before                                     // wykona się przed każdym testem
    public void beforeEveryTest(){
        browser = new ChromeDriver ();          // żeby przed każdym testem mieć czysty obiekt ChromeDriver, który nie pamięta tego co zrobił poprzedni test
        browser.get ("http://google.com/");     // wywołanie strony startowej za każdym testem
    }

    @Test
    public void talkToBrowser() {               // pierwszy test po prostu otwiera i zamyka strone
        System.out.println (browser.getCurrentUrl ());
        System.out.println (browser.getTitle ());
    }

    @Test
    public void navigate() {                    // drugi test do navigacji między stronami
        browser.navigate ().to ("http://frisco.com/");
        browser.navigate ().refresh ();
        browser.navigate ().back ();
        browser.navigate ().forward ();
    }

    @After                                      // wykona się przed po testem
    public void afterEachTest(){
        browser.quit ();                        // całkowicie zakończy komunikację z webdriverem - zamknie wszystko
    }

}