package pages.components;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationCheckResultWindow {

    public void checkResult(String key, String value) {
        $(".modal-content").shouldBe(visible);
        $(".table-responsive").shouldHave(text(key), text(value));
    }

    public void checkResultNegative() {
        $(".modal-content").shouldNotBe(visible);
    }
}
