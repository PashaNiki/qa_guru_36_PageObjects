package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationCheckResultWindow {

    public void checkResult(String key, String value) {
        $(".modal-content").$(byText(key))
                .parent().shouldHave(text(value));
    }

    public void checkResultNegative() {
        $(".modal-content").shouldNotBe(visible);
    }
}