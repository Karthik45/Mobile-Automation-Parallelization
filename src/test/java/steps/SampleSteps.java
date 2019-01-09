package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.SamplePage;

import static utils.OperationTypes.*;
import static utils.Operations.*;

public class SampleSteps extends BaseSteps {

    private SamplePage samplePage = new SamplePage(driver);

    @Given("^launch the application$")
    public void launchTheApplication() {
        samplePage.checkAppGotLaunched();
    }

    @And("^user perform (.*) operation for ([^\\\"]*) and ([^\\\"]*)$")
    public void userPerformAdditionOperationForNumAndNum(String operation, double num1, double num2) throws Exception {
        switch (operation.toUpperCase()) {
            case ADDITION:
                samplePage.performOperation(num1, num2, ADD);
                break;
            case SUBTRACTION:
                samplePage.performOperation(num1, num2, MINUS);
                break;
            case MULTIPLICATION:
                samplePage.performOperation(num1, num2, MULTIPLY);
                break;
            case DIVISION:
                samplePage.performOperation(num1, num2, DIVIDE);
                break;
            default:
                throw new Exception("Invalid Operation");
        }
    }

    @And("^user check result is ([^\\\"]*)$")
    public void userCheckResultIsRes(double res) {
        samplePage.checkResult(res);
    }
}
