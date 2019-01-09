package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.Operations;

public class SamplePage extends BasePage {

    @FindBy(id = "inputFieldLeft")
    private WebElement leftField;

    @FindBy(id = "inputFieldRight")
    private WebElement rightField;

    @FindBy(id = "additionButton")
    private WebElement additionBtn;

    @FindBy(id = "subtractButton")
    private WebElement subtractionBtn;

    @FindBy(id = "multiplicationButton")
    private WebElement multiplyBtn;

    @FindBy(id = "divisionButton")
    private WebElement divisionBtn;

    @FindBy(id = "resultTextView")
    private WebElement result;

    public SamplePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkAppGotLaunched() {
        Assert.assertTrue(leftField.isDisplayed(), "App is not launched.");
    }

    public void performOperation(double num1, double num2, Operations operation) {
        sendKeys(leftField, String.valueOf(num1));
        sendKeys(rightField, String.valueOf(num2));
        switch (operation) {
            case ADD:
                tapOnButton(additionBtn);
                break;
            case MINUS:
                tapOnButton(subtractionBtn);
                break;
            case MULTIPLY:
                tapOnButton(multiplyBtn);
                break;
            case DIVIDE:
                tapOnButton(divisionBtn);
                break;
        }
    }

    public void checkResult(double res) {
        String rslt = getText(result).split("=")[1];
        Assert.assertEquals(Double.valueOf(rslt), res, "Result is wrong");
    }
}