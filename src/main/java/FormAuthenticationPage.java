import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class FormAuthenticationPage {
    private WebDriverWait webDriverWait;
    WebDriver webDriver;
    final int TIMEOUT = 10;

    public FormAuthenticationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("http://the-internet.herokuapp.com/login");
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;


    public void authentication(String username, String password, String message) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        buttonLogin.click();
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(5));
        webDriverWait.withMessage(message);
        System.out.println(message);
    }
}

