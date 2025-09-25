package Components;

import org.openqa.selenium.By;

public interface XpathStore {

    By forgotPassword_rsa_Login = By.xpath("//div[contains(@class, 'forgot')]/a[contains(text(), 'Forgot')]");

    static By placeHolder(String placeHolder) {
        return By.xpath("//input[contains(@placeholder,'" + placeHolder + "')]");
    }

    static By SelectCheckBox(String text) {
        return By.xpath("//span/input[@type='checkbox'][../label[contains(text(),'" + text + "')]]");
    }

    By resetButton_rsa_Login = By.xpath("//div[contains(@class,'forgot')][.//@class='reset-pwd-btn']/button[contains(text(),'Reset')]");
    By goToLoginButton_rsa_Login = By.xpath("//div[contains(@class,'forgot')][.//@class='reset-pwd-btn']/button[contains(text(),'Login')]");
}
