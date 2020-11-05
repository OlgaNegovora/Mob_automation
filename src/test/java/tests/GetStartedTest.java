package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase
{
    @Test
    public void testPassThroughWelcome()
    {
        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMW() )) {
            return;
        }
        WelcomePageObject WelcomePage=new WelcomePageObject(driver);
        WelcomePage.waitForLearnMoreLink();
        System.out.println("shag1") ;
        WelcomePage.clickNextButton();
        System.out.println("shag2") ;
        WelcomePage.waitForNewWayToExploreText();
        System.out.println("shag3") ;
        WelcomePage.clickNextButton();
        System.out.println("shag4") ;
        WelcomePage.waitForAddOrEditPreferredLandText();
        WelcomePage.clickNextButton();
        WelcomePage.waitForLearnMoreAboutDataCollectedText();
        WelcomePage.clickGetStartedButton();
    }
}
