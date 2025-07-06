package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPages;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPages registrationPages = new RegistrationPages();

    @Test
    void successfulRegistrationTest() {
        registrationPages.openPage()
                .setFirstName("Oleg")
                .setLastName("Shirobokov")
                .setEmail("shirobokov@mail.ru")
                .setGender("Male")
                .setPhone("89635411862")
                .setBirthDate("2000", "July", "15")
                .setSubjects("Computer Science", "Arts", "Chemistry", "Social Studies")
                .setHobbies("Sports")
                .uploadPicture("picture.jpg")
                .setAddress("KMarks.Street")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit()
                .checkResult("Student Name", "Oleg Shirobokov")
                .checkResult("Student Email", "shirobokov@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "89635411862")
                .checkResult("Date of Birth", "15 July,2000")
                .checkResult("Subjects", "Computer Science, Arts, Chemistry, Social Studies")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", "KMarks.Street")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void successfulMinFormTest() {
        registrationPages.openPage()
                .setFirstName("Oleg")
                .setLastName("Shirobokov")
                .setEmail("shirobokov@mail.ru")
                .setGender("Male")
                .submit()
                .checkResult("Student Name", "Oleg Shirobokov")
                .checkResult("Student Email", "shirobokov@mail.ru")
                .checkResult("Gender", "Male");
    }

    @Test
    void negativeFormTest() {
        registrationPages.openPage()
                .setFirstName("Oleg")
                .setLastName("Shirobokov")
                .setEmail("")
                .submit()
                .checkModalNotVisible();
    }
}
