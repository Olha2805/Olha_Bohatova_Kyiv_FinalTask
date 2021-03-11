package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;

public class DefinitionSteps {
    @After
    public void tearDown(){driver.close();}

    @And("User sees heart icon")
    public void userSeesHeartIcon(){

    }

    @And("User checks field visibility")
    public void userChecksFieldVisibility(){

    }

    @And

}
