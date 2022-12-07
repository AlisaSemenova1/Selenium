
import org.jetbrains.annotations.TestOnly;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AppTests {
    @Before
    public void pageOpen() {
        webDriver = new ChromeDriver();
    }

    WebDriver webDriver;

    @Test
    public void checkingCheckboxClick() {
        CheckboxPage checkboxPage;
        checkboxPage = new CheckboxPage(webDriver);
        checkboxPage.checkingCheckboxClick();
    }

    @Test
    public void formAuthentication() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        FormAuthenticationPage formAuthenticationPage;
        formAuthenticationPage = new FormAuthenticationPage(webDriver);
        formAuthenticationPage.authentication(username, password, "You logged into a secure area!");
        System.out.println("Вы вошли.");
    }

    @Test
    public void incorrectFormAuthentication() {
        String incorrectUsername = "marysmith";
        String incorrectPassword = "NotSecretPassword!";
        FormAuthenticationPage formAuthenticationPage;
        formAuthenticationPage = new FormAuthenticationPage(webDriver);
        formAuthenticationPage.authentication(incorrectUsername, incorrectPassword, "Your username is invalid!");
        System.out.println("Неверный логин/пароль.");
    }

    @Test
    public void hoverToUser() {
        HoverPage hoverPage;
        hoverPage = new HoverPage(webDriver);
        hoverPage.hoverToUser();
    }

    @Test
    public void dynamicallyLoadedPageElement() {
        DynamicallyLoadedPage dynamicallyLoadedPage;
        dynamicallyLoadedPage = new DynamicallyLoadedPage(webDriver);
        dynamicallyLoadedPage.dynamicallyLoadedPageElement();
    }

    @Test
    public void keyPresses() {
        Keys keys = Keys.ENTER;
        KeyPressesPage keyPressesPage;
        keyPressesPage = new KeyPressesPage(webDriver);
        webDriver.get("https://the-internet.herokuapp.com/key_presses");
        keyPressesPage.enterKeysCommand(keys);
    }

    @Test
    public void keyPressesTab() {
        Keys keys = Keys.TAB;
        KeyPressesPage keyPressesPage;
        keyPressesPage = new KeyPressesPage(webDriver);
        webDriver.get("https://the-internet.herokuapp.com/key_presses");
        keyPressesPage.enterCommand(keys);
    }
    @Test
    public void keyPressesWord() {
        String command = "enter";
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/key_presses");
        KeyPressesPage keyPressesPage;
        keyPressesPage = new KeyPressesPage(webDriver);
        keyPressesPage.keyPresses(command);
    }


    @Test
    public void addAndRemoveElement() {
        AddAndRemoveElement addAndRemoveElement;
        addAndRemoveElement = new AddAndRemoveElement(webDriver);
        addAndRemoveElement.addAndRemoveElement(3);
    }
    @After
    public void pageClose() {
            webDriver.quit();
    }
}
