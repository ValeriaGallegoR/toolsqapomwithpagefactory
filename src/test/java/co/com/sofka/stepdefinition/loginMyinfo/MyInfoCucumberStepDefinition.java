package co.com.sofka.stepdefinition.loginMyinfo;

import co.com.sofka.model.LoginMyInfoModel.LoginMyInfoModel;
import co.com.sofka.page.myinfo.MyInfoPage;
import co.com.sofka.stepdefinition.setup.webui.WebUI;
import co.com.sofka.util.Gender;
import co.com.sofka.util.MaritalStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class MyInfoCucumberStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(MyInfoCucumberStepDefinition.class);
    private LoginMyInfoModel LoginMyInfoModel;
    private MyInfoPage myInfoPage;
    private static final String ASSERTION_MESSAGE = "Marco Luis Zapata";

    @Given("el empleado se encuentra en la sesion personal details de la plataforma")
    public void elEmpleadoSeEncuentraEnLaSesionPersonalDetailsDeLaPlataforma() {
        try {
            generalSetUpMyInfo();
            LoginMyInfoModel = new LoginMyInfoModel();
            LoginMyInfoModel.setUserName("Admin");
            LoginMyInfoModel.setPassword("admin123");
            myInfoPage = new MyInfoPage(driver, LoginMyInfoModel);
            myInfoPage.fillLoginForm();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado llene los campos requeridos y presione el boton save")
    public void elEmpleadoLleneLosCamposRequeridosYPresioneElBotonSave() {
        try {
            LoginMyInfoModel dataform = dataConfiguration();
            myInfoPage.fillMyInfo(dataform);
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema guardara los cambios realizados")
    public void elSistemaGuardaraLosCambiosRealizados() {
        try {
            Assertions.assertEquals(myInfoPage.expected(1),ASSERTION_MESSAGE);
        }catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
        finally {
            quitDriver();
        }
    }

    //Funciones comunes:
    private LoginMyInfoModel dataConfiguration() {
        LoginMyInfoModel = new LoginMyInfoModel();
        LoginMyInfoModel.setFirstName("Marco");
        LoginMyInfoModel.setMiddleName("Luis");
        LoginMyInfoModel.setLastName("Zapata");
        LoginMyInfoModel.setOtherid("1234");
        LoginMyInfoModel.setLicenseNumber("00672781");
        LoginMyInfoModel.setSsNumber("12");
        LoginMyInfoModel.setSiNumber("13");
        LoginMyInfoModel.setGender(Gender.FEMALE);
        LoginMyInfoModel.setMaritialStatus(MaritalStatus.SINGLE);
        LoginMyInfoModel.setDay("21");
        LoginMyInfoModel.setYear("2021");
        LoginMyInfoModel.setMonth("Diciembre");
        LoginMyInfoModel.setNickName("marc");
        LoginMyInfoModel.setMilitaryService("remiso");

        return LoginMyInfoModel;
    }
}
