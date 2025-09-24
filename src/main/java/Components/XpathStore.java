package Components;

import org.openqa.selenium.By;

public interface XpathStore {

    By forgotPassword_rsa_Login = By.xpath("//div[contains(@class, 'forgot')]/a[contains(text(), 'Forgot')]");

    static By placeHolder(String placeHolder) {
        return By.xpath("//input[@type='text'][contains(@placeholder,'" + placeHolder + "')]");
    }

    By resetButton_rsa_Login = By.xpath("//div[contains(@class,'forgot')][.//@class='reset-pwd-btn']/button[contains(text(),'Reset')]");
    By goToLoginButton_rsa_Login = By.xpath("//div[contains(@class,'forgot')][.//@class='reset-pwd-btn']/button[contains(text(),'Login')]");
}
