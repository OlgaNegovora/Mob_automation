package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{
    private static final String
    LOGIN_BUTTON="xpath://body/div//a[text()='Log in']",
            // //body/div//a[text()='Log in']",
    LOGIN_INPUT="css:input[name='wpName']",
    PASSWORD_INPUT="css:input[name='wpPassword']",
    SUBMIT_BUTTON="css:button#wpLoginAttempt";

    public AuthorizationPageObject (RemoteWebDriver driver){
        super(driver);
    }
    public void clickAuthButton() throws InterruptedException {
        //System.out.println(LOGIN_BUTTON);
        Thread.sleep(2000);
        /*if (Platform.getInstance().isMW()){
            this.tryClickElementWithFewAttempts(
                    LOGIN_BUTTON,
                   "Cannot find button Log in",
                    5) ;
        }else {
            //{*/
            this.waitForElementPresent(LOGIN_BUTTON,"Cannot find auth button",5);
            // }
            //System.out.println(LOGIN_BUTTON);
        Thread.sleep(2000);
            this.waitForElementAndClick(LOGIN_BUTTON, "Cannot find and click auth button", 5);
       // }
    }

    public void enterLoginData(String login, String password) throws InterruptedException {
        Thread.sleep(2000);
        this.waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find and put a login to the login input",10 );
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password,"Cannot find and put a password to the password input",10 );
    }

    public void submitForm(){
        this.waitForElementAndClick(SUBMIT_BUTTON, "Cannot find and click submit auth button",5 );
    }
}
