package co.com.sofka.stepdefinition.loginMyinfo;

import co.com.sofka.model.LoginMyInfoModel.LoginMyInfoModel;
import co.com.sofka.page.myinfo.MyInfoPage;
import co.com.sofka.stepdefinition.restassured.regresin.login.loginStepDefinition;
import co.com.sofka.stepdefinition.setup.webui.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.Response;

public class LoginPanelCucumberStepDefinition extends WebUI {

    private LoginMyInfoModel loginMyInfoModel;
    private MyInfoPage loginPanel;
    private static final String ASSERTION_MESSAGE = "El usuario ingresó exitosamente al menú Welcome";
    private static final Logger LOGGER = Logger.getLogger(loginStepDefinition.class);
    private Response response;
    private RequestSpecification request;


    @Given("el empleado se encuentra en la pagina login de la plataforma")
    public void elEmpleadoSeEncuentraEnLaPaginaLoginDeLaPlataforma() {
        try {
            generalSetUp();
            loginMyInfoModel = new LoginMyInfoModel();
            loginMyInfoModel.setUserName("Admin");
            loginMyInfoModel.setPassword("admin123");
        } catch (Exception e){
            quitDriver();
        }
    }

    @When("el empleado ingrese con el usuario y la contraseña valida")
    public void elEmpleadoIngreseConElUsuarioYLaContrasenaValida() {
        try {
            loginPanel = new MyInfoPage(driver, loginMyInfoModel);
            loginPanel.fillLoginForm();
        }catch (Exception e){
            quitDriver();
        }
    }

    @Then("el sistema deberá mostrar un mensaje de Welcome con el nombre del usuario")
    public void elSistemaDeberaMostrarUnMensajeDeWelcomeConElNombreDelUsuario() {
        try {
            Assertions.assertTrue(loginPanel.loginSucessful(),ASSERTION_MESSAGE);
        }catch (Exception e){
            quitDriver();
        }
        finally {
            quitDriver();
        }
    }
}

