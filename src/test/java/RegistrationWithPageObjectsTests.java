import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TableOfDataPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TableOfDataPage tableOfDataPage = new TableOfDataPage();


    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Novikov")
                .setEmail("ivan.example@gmail.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubject("Maths")
                .setHobbies("Sports")
                .setPicture("imageForTest.jpg")
                .setAddress("Some address, 12345")
                .setStateAndCity("Rajasthan", "Jaiselmer")
                .submitPracticeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable("Student Name", "Ivan Novikov");
        tableOfDataPage.checkDataTable("Student Email", "ivan.example@gmail.com");
        tableOfDataPage.checkDataTable("Gender", "Other");
        tableOfDataPage.checkDataTable("Mobile", "1234567890");
        tableOfDataPage.checkDataTable("Date of Birth", "30 July,2008");
        tableOfDataPage.checkDataTable("Subjects", "Maths");
        tableOfDataPage.checkDataTable("Hobbies", "Sports");
        tableOfDataPage.checkDataTable("Picture", "imageForTest.jpg");
        tableOfDataPage.checkDataTable("Address", "Some address, 12345");
        tableOfDataPage.checkDataTable("State and City", "Rajasthan Jaiselmer");
    }

    @Test
    void negativeEmailTest() {
        registrationPage.openPage()
                .setFirstName(" ")
                .setLastName(" ")
                .setEmail("email")
                .setGender("Female")
                .setUserNumber("1234567890")
                .setDateOfBirth("12","July", "2023")
                .setSubject("Maths")
                .setPicture("imageForTest.jpg")
                .setStateAndCity("Rajasthan", "Jaiselmer")
                .setHobbies("Sports")
                .submitPracticeForm();

        registrationPage.checkUnsuccessPageWithTable();
    }

    @Test
    void minDataTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Novikov")
                .setGender("Male")
                .setEmail("ivan.example@gmail.com")
                .setUserNumber("8999999999")
                .submitPracticeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable("Student Name","Ivan Novikov");
        tableOfDataPage.checkDataTable("Student Email","ivan.example@gmail.com");
        tableOfDataPage.checkDataTable("Gender","Male");
        tableOfDataPage.checkDataTable("Mobile","8999999999");

    }
}