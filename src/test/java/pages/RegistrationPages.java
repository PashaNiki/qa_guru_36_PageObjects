package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationCheckResultWindow;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPages {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitTab = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationCheckResultWindow checkResultWindow = new RegistrationCheckResultWindow();

    public RegistrationPages openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPages setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPages setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPages setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPages setGender(String gender) {
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPages setPhone(String value) {
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPages setBirthDate(String year, String month, String day) {
        calendarInput.click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public RegistrationPages setSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject).pressEnter();
        }
        return this;
    }

    public RegistrationPages setHobbies(String hobby) {
        hobbiesInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPages uploadPicture(String filename) {
        pictureInput.uploadFromClasspath(filename);
        return this;
    }

    public RegistrationPages setAddress(String value) {
        addressInput.setValue(value);
        return this;
    }

    public RegistrationPages selectState(String state) {
        stateInput.scrollIntoView(true).click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPages selectCity(String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPages submit() {
        submitTab.pressEnter();
        return this;
    }

    public RegistrationPages checkResult(String key, String value) {
        checkResultWindow.checkResult(key, value);
        return this;
    }

    public RegistrationPages checkModalNotVisible() {
        checkResultWindow.checkResultNegative();
        return this;
    }
}
