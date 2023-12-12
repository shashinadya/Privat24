package tests.telecominucations.positive;

import org.junit.jupiter.api.Test;
import tests.base.BaseTest;
import static constants.Constant.TimeoutVariables.Urls.MOBILE_PAYMENT_URL;
import pages.telecomunications.MobilePhoneReplenishmentPage;

public class MobilePhoneReplenishmentPositiveTest extends BaseTest {
    //Узнать почему нельзя вызвать метод selectCardFromWallet без создания объекта, в видео с курса можно
    private MobilePhoneReplenishmentPage mobilePhoneReplenishmentPage = new MobilePhoneReplenishmentPage(driver);
    @Test
    public void checkIsRedirectToAuth(){
        basePage.goToUrl(MOBILE_PAYMENT_URL);
        mobilePhoneReplenishmentPage.selectCardFromWallet();
        basePage.isAuthWidgetPresent();
    }
}
