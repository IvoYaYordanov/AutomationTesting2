package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "UserName")
    public WebElement textUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement textPassword;

    @FindBy(how = How.NAME, using = "Login")
    public WebElement buttonLogin;

    public void Login(String userName, String password){
        textUserName.sendKeys(userName);
        textPassword.sendKeys(password);

    }
    public void ClickLogin(){
        buttonLogin.submit();
    }

}
