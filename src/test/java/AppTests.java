
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;


public class AppTests {
    WebDriver webDriver;
    TheInternetPage theInternetPage;

    @Test
    public void checkingCheckboxClick() {
        webDriver = new ChromeDriver();
        webDriver.get("http://the-internet.herokuapp.com/checkboxes");
        theInternetPage = new TheInternetPage(webDriver);
        theInternetPage.checkingCheckboxClick();
    }

    @Test
    public void formAuthentication() {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";
        webDriver = new ChromeDriver();
        webDriver.get("http://the-internet.herokuapp.com/login");
        theInternetPage = new TheInternetPage(webDriver);
        theInternetPage.authentication(username, password, "You logged into a secure area!");
        System.out.println("Вы вошли.");
    }

    @Test
    public void incorrectFormAuthentication() {
        String incorrectUsername = "marysmith";
        String incorrectPassword = "NotSecretPassword!";
        webDriver = new ChromeDriver();
        webDriver.get("http://the-internet.herokuapp.com/login");
        theInternetPage = new TheInternetPage(webDriver);
        theInternetPage.authentication(incorrectUsername, incorrectPassword, "Your username is invalid!");
        System.out.println("Неверный логин/пароль.");
    }

    @Test
    public void hoverToUser() {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/hovers");
        theInternetPage = new TheInternetPage(webDriver);
        theInternetPage.hoverToUser();
    }

    @Test
    public void dynamicallyLoadedPageElement() {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/dynamic_loading");
        theInternetPage = new TheInternetPage(webDriver);
        theInternetPage.dynamicallyLoadedPageElement();
    }

    @Test
    public void keyPresses() {
        String command = "enter";
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/key_presses");
        theInternetPage = new TheInternetPage(webDriver);
        theInternetPage.keyPresses(command);
    }

    @Test
    public void addAndRemoveElement() {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        theInternetPage = new TheInternetPage(webDriver);
        theInternetPage.addAndRemoveElement();
    }

    @After
    public void pageClose() {
        if (webDriver != null)
            webDriver.close();
    }
}