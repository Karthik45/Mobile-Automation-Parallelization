package steps;

import cucumber.api.java.en.Given;

public class IOSSampleSteps extends BaseSteps {

    @Given("^user launch the application$")
    public void userLaunchTheApplication() {
        System.out.println("Its working");
    }
}
