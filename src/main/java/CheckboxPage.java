
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class CheckboxPage {
    private final WebDriverWait webDriverWait;
    final int TIMEOUT = 10;

    public CheckboxPage(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(5));
        webDriver.get("http://the-internet.herokuapp.com/checkboxes");
        webDriver.manage().window().maximize();
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkboxInput;


    public void checkingCheckboxClick() {
        checkboxInput.click();
        if (checkboxInput.isSelected())
            System.out.println(("checkbox нажат"));
        else {
            System.out.println(("checkbox не нажат"));
        }
    }

}
