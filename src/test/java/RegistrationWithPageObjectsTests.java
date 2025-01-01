import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TableOfDataPage;
import utils.TestData;


public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TableOfDataPage tableOfDataPage = new TableOfDataPage();
    TestData testData = new TestData();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.mobileNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .setPicture(testData.picture)
                .setAddress(testData.address)
                .setStateAndCity(testData.state, testData.city)
                .submitPracticeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable("Student Name", testData.firstName + " " + testData.lastName);
        tableOfDataPage.checkDataTable("Student Email", testData.email);
        tableOfDataPage.checkDataTable("Gender", testData.gender);
        tableOfDataPage.checkDataTable("Mobile", testData.mobileNumber);
        tableOfDataPage.checkDataTable("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth);
        tableOfDataPage.checkDataTable("Subjects", testData.subject);
        tableOfDataPage.checkDataTable("Hobbies", testData.hobbies);
        tableOfDataPage.checkDataTable("Picture", testData.picture);
        tableOfDataPage.checkDataTable("Address", testData.address);
        tableOfDataPage.checkDataTable("State and City", testData.state + " " + testData.city);
    }

    @Test
    void negativeEmailTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.mobileNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setPicture(testData.picture)
                .setStateAndCity(testData.state, testData.city)
                .setHobbies(testData.hobbies)
                .submitPracticeForm();

        registrationPage.checkUnsuccessPageWithTable();
    }

    @Test
    void minDataTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setEmail(testData.email)
                .setUserNumber(testData.mobileNumber)
                .submitPracticeForm();

        tableOfDataPage.checkSuccessPageWithTable();
        tableOfDataPage.checkDataTable("Student Name", testData.firstName + " " + testData.lastName);
        tableOfDataPage.checkDataTable("Student Email", testData.email);
        tableOfDataPage.checkDataTable("Gender",testData.gender);
        tableOfDataPage.checkDataTable("Mobile", testData.mobileNumber);

    }
}