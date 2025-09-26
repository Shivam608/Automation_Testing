package Components;

import org.openqa.selenium.By;

public interface XpathStore {

    By forgotPassword_rsa_Login = By.xpath("//div[contains(@class, 'forgot')]/a[contains(text(), 'Forgot')]");

    static By placeHolder(String placeHolder) {
        return By.xpath("//input[contains(@placeholder,'" + placeHolder + "')]");
    }

    static By SelectCheckBoxLocator(String text) {
        return By.xpath("//span/input[@type='checkbox'][../label[contains(text(),'" + text + "')]]");
    }

    By resetButton_rsa_Login = By.xpath("//div[contains(@class,'forgot')][.//@class='reset-pwd-btn']/button[contains(text(),'Reset')]");
    By goToLoginButton_rsa_Login = By.xpath("//div[contains(@class,'forgot')][.//@class='reset-pwd-btn']/button[contains(text(),'Login')]");

    By staticDropDown = By.xpath("//select[contains(@id, 'DropDownListCurrency')]");
    By dynamicDropDown = By.xpath("//legend[.//b[text()='Country']]//following-sibling::input[@id='autosuggest']");
    By autoSuggestDropDownlist = By.xpath("//ul[contains(@class,'ui-widget-content')][.//li[@role='presentation']]/li/a");

    static By SelectCheckBoxDropdown(String text) {
        return By.xpath("//div[@id='discount-checkbox']//following::input[@type='checkbox'][.//following-sibling::label[contains(text(), '" + text + "')]]");
    }
}
