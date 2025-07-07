package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPages registrationPages = new RegistrationPages();
    TestData data = new TestData();

    @Test
    void successfulRegistrationWithFakerTest() {
        registrationPages.openPage();
        registrationPages
                .openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setPhone(data.phone)
                .setBirthDate(data.year, data.month, data.day)
                .setSubjects(data.subject)
                .setHobbies(data.hobby)
                .uploadPicture("picture.jpg")
                .setAddress(data.address)
                .selectState(data.state)
                .selectCity(data.city)
                .submit();

        registrationPages
                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phone)
                .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", data.address)
                .checkResult("State and City", data.state + " " + data.city);
    }
}
