package steps;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;
import transformation.EmailTransform;
import transformation.SalaryCountTransformer;

import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("I navigate to the login page");
        base.driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    //    @And("^I enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
//    public void iEnterTheUsernameAsAndPasswordAs(String username, String password){
//        System.out.println("Username is " + username + "  and password is " + password);
//    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() {

       Assert.assertEquals( base.driver.findElement(By.id("Initial")).isDisplayed(), true,"Its not displayed");
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        LoginPage page = new LoginPage(base.driver);
        page.ClickLogin();
    }

    @And("^I enter the following for Login$")
    public void iEneterTheFollowingForLogin(DataTable table) {

        // Create an ArrayList
        List<User> users =
        // Store all the users in the ArrayList
        users = table.asList(User.class);

        LoginPage page = new LoginPage(base.driver);

        for (User user : users ) {

            page.Login(user.username, user.password);
        }
    }

    @And("^I enter ([^\\\"]*) and ([^\\\"]*)$")
    public void iEnterUsernameAndPassword(String username, String password){
        System.out.println("The username is " + username);
        System.out.println("The password is " + password);
        System.out.println();
    }

    @And("^I enter the users email address as Email:([^\\\"]*)$")
    public void iEneterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email){
        System.out.println("The email address is " + email);
    }

    @And("^I verify the count of salary for (\\d+)$")
    public void iVerifyTheCountOfSalaryFor(@Transform(SalaryCountTransformer.class) int salary ){

        System.out.println("My salary is " + salary);
    }

    static class User {
        private String username;
        private String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUserName() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

}
