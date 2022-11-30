
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class TheInternetPage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    final int TIMEOUT = 10;

    public TheInternetPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkboxInput;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLogin;

    @FindBy(xpath = "//img[@alt='User Avatar']")
    public WebElement userAvatar;

    @FindBy(css = "#content > div > div:nth-child(3) > div > h5")
    public WebElement textUnderUserAvatar;

    @FindBy(css = "#content > div > a:nth-child(8)")
    public WebElement elementRenderedAfterTheFact;

    @FindBy(xpath = "//button")
    public WebElement buttonStart;

    @FindBy(xpath = "//*[@id='finish']/h4")
    public WebElement textAfterLoader;

    @FindBy(css = "#target")
    public WebElement target;

    @FindBy(xpath = "//*[@id='result']")
    public WebElement result;

    @FindBy(css = "#content > div > button")
    public WebElement buttonAddElement;

    public void checkingCheckboxClick() {
        checkboxInput.click();
        if (checkboxInput.isSelected())
            System.out.println(("checkbox нажат"));
        else {
            System.out.println(("checkbox не нажат"));
        }
    }

    public void authentication(String username, String password, String message) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        buttonLogin.click();
        webDriverWait.withMessage(message);
        System.out.println(message);
    }

    public void hoverToUser() {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(userAvatar).perform();
        if (textUnderUserAvatar.isDisplayed()) {
            System.out.println("Текст отображается");
        } else {
            System.out.println("Текст не отображается");
        }
    }

    public void dynamicallyLoadedPageElement() {
        elementRenderedAfterTheFact.click();
        buttonStart.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(textAfterLoader));
        assert textAfterLoader.getText().equals("Hello World!");
    }

    public void keyPresses(String command) {
        target.sendKeys(command);
        webDriverWait.until(ExpectedConditions.visibilityOf(result));
        String resultText = result.getText();
        System.out.println(resultText);
        assert resultText.equals("You entered: " + StringUtils.right(command, 1).toUpperCase());
    }

    public void addAndRemoveElement() {
        int addElem;
        for (addElem = 0; addElem < 3; addElem++) {
            buttonAddElement.click();
        }
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[@id='elements']/button"), addElem));
    }
}
