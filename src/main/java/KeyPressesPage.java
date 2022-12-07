
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KeyPressesPage {
    final int TIMEOUT = 10;
    private WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    String text;
    public KeyPressesPage(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(5));
        webDriver.get("https://the-internet.herokuapp.com/key_presses");
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id='target']")
    public WebElement target;

    @FindBy(xpath = "//*[@id='result']")
    public WebElement result;

    public void enterKeysCommand(Keys key) {
        target.sendKeys(key);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        assert !result.isDisplayed();

    }
    public void enterCommand(Keys key) {
        target.sendKeys(key);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        assert result.isDisplayed();
        System.out.println("You entered: TAB");
    }
    public void keyPresses(String command) {
        target.sendKeys(command);
        webDriverWait.until(ExpectedConditions.visibilityOf(result));
        String resultText = result.getText();
        System.out.println(resultText);
        assert resultText.equals("You entered: " + StringUtils.right(command, 1).toUpperCase());
    }
}
