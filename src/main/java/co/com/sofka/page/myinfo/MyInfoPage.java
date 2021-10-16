package co.com.sofka.page.myinfo;

import co.com.sofka.model.LoginMyInfoModel.LoginMyInfoModel;
import co.com.sofka.page.common.BaseSikulix;
import co.com.sofka.page.common.CommonActionsOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class MyInfoPage extends CommonActionsOnPages {

    private static final Logger LOGGER = Logger.getLogger(MyInfoPage.class);
    private LoginMyInfoModel loginMyInfoModel;
    private BaseSikulix baseSikulix;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //For input test cases login
    @FindBy(id = "txtUsername")
    @CacheLookup
    private WebElement userName;

    @FindBy(id = "txtPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement loginSubmit;

    //For input test myInfo
    @FindBy(id = "personal_txtEmpFirstName")
    @CacheLookup
    private WebElement firstname;

    @FindBy(id = "personal_txtEmpMiddleName")
    @CacheLookup
    private WebElement middleName;

    @FindBy(xpath = "//*[@id=\"personal_txtEmpLastName\"]")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "personal_txtOtherID")
    @CacheLookup
    private  WebElement otherid;

    @FindBy(id = "personal_txtLicenNo")
    @CacheLookup
    private  WebElement licenseNumber;

    @FindBy(id = "personal_txtLicExpDate")
    @CacheLookup
    private  WebElement dateOfLicenseInput;

    @FindBy(xpath = "//*[@id=\"personal_optGender_1\"]")
    @CacheLookup
    private WebElement genderMale;

    @FindBy(xpath = "//*[@id=\"personal_optGender_2\"]")
    @CacheLookup
    private WebElement genderFemale;

    @FindBy(id = "personal_DOB")
    @CacheLookup
    private  WebElement dateOfBirthInput;

    @FindBy(id = "personal_txtNICNo")
    @CacheLookup
    private  WebElement ssNumber;

    @FindBy(id = "personal_txtSINNo")
    @CacheLookup
    private  WebElement siNumber;

    @FindBy(xpath = "//*[@id=\"personal_cmbMarital\"]/option[3]")
    @CacheLookup
    private WebElement maritalMarried;

    @FindBy(xpath = "//*[@id=\"personal_cmbMarital\"]/option[2]")
    @CacheLookup
    private WebElement maritalSingle;

    @FindBy(xpath = "//*[@id=\"personal_cmbMarital\"]/option[4]")
    @CacheLookup
    private WebElement maritalOther;

    @FindBy(id = "personal_txtEmpNickName")
    @CacheLookup
    private WebElement nickName;

    @FindBy(id = "personal_txtMilitarySer")
    @CacheLookup
    private WebElement militaryService;

    @FindBy(id = "personal_chkSmokeFlag")
    @CacheLookup
    private WebElement smokerButton;

    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    @CacheLookup
    private WebElement editButton;

    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    @CacheLookup
    private WebElement saveButton;

    @FindBy(id = "menu_pim_viewMyDetails")
    @CacheLookup
    private WebElement myinfoButton;

    @FindBy(css = "ui-datepicker-month")
    @CacheLookup
    private WebElement monthButton;

    @FindBy(id = "empPic")
    @CacheLookup
    private WebElement imageEmp;

    @FindBy(xpath = "//*[@id=\"frmPhoto\"]/fieldset/ol/li")
    @CacheLookup
    private WebElement selectImage;

    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    @CacheLookup
    private WebElement saveImageChange;

    @FindBy(id = "personal_cmbNation")
    @CacheLookup
    private WebElement nationalityButton;


    //For Assertions test case.
    @FindBy(id = "welcome")
    @CacheLookup
    private WebElement assertionwelcome;

    @FindBy(id = "//*[@id=\"profile-pic\"]/h1")
    @CacheLookup
    private WebElement assertname;

    //Sikulix elements.
    private static final String ATTACHMENT_FILE_PATCH = USER_DIR.value() + "\\src\\test\\resources\\images\\practiceform\\imagen.jpg";
    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page\\practiceform\\";
    private static final String SELECT_OPEN_PATCH = PAGE_BASE_PATCH + "openWindows.PNG";
    private static final String FILE_NAME_TEXT_BOX_PATCH = PAGE_BASE_PATCH + "fileNameWindows.PNG";


    public MyInfoPage(WebDriver driver, LoginMyInfoModel loginMyInfoModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.loginMyInfoModel = loginMyInfoModel;
    }
    public boolean loginSucessful(){ return isDisplayed(assertionwelcome);
    }

    public MyInfoPage(WebDriver driver, LoginMyInfoModel loginMyInfoModel, int secondsForExplicitWait) {

        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver, this);

        if(loginMyInfoModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);

        this.loginMyInfoModel = loginMyInfoModel;

    }

    //Page functions.
    public void fillLoginForm() throws IOException {
        clear(userName);
        typeInto(userName, loginMyInfoModel.getUserName());

        clear(password);
        typeInto(password, loginMyInfoModel.getPassword());
        doSubmit(loginSubmit);
    }

    public void fillMyInfo(LoginMyInfoModel dataform){
        try{
            scrollTo(editButton);
            clickOn(editButton);

            scrollTo(firstname);
            clear(firstname);
            typeInto(firstname, dataform.getFirstName());

            scrollTo(middleName);
            clear(middleName);
            typeInto(middleName, dataform.getMiddleName());

            scrollTo(lastName);
            clear(lastName);
            typeInto(lastName, dataform.getLastName());

            scrollTo(otherid);
            clear(otherid);
            typeInto(otherid, dataform.getOtherid());

            scrollTo(licenseNumber);
            clear(licenseNumber);
            typeInto(licenseNumber, dataform.getLicenseNumber());

            scrollTo(ssNumber);
            clear(ssNumber);
            typeInto(ssNumber, dataform.getSsNumber());

            scrollTo(siNumber);
            clear(siNumber);
            typeInto(siNumber, dataform.getSiNumber());

            switch (dataform.getGender()){
                case MALE:
                    scrollTo(genderMale);
                    clickOn(genderMale);
                    break;

                case FEMALE:
                    scrollTo(genderFemale);
                    clickOn(genderFemale);
                    break;
                default:
            }

            switch (dataform.getMaritialStatus()){
                case SINGLE:
                    scrollTo(maritalSingle);
                    clickOn(maritalSingle);
                    break;

                case MARRIED:
                    scrollTo(maritalMarried);
                    clickOn(maritalMarried);
                    break;

                case OTHER:
                    scrollTo(maritalOther);
                    clickOn(maritalOther);
                    break;
                default:
            }

            scrollTo(nationalityButton);
            clickOn(nationalityButton);


            scrollTo(nickName);
            clear(nickName);
            typeInto(nickName, dataform.getNickName());

            scrollTo(smokerButton);
            clickOn(smokerButton);

            scrollTo(militaryService);
            clear(militaryService);
            typeInto(militaryService, dataform.getMilitaryService());

            scrollTo(saveButton);
            clickOn(saveButton);


        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

    public List<String> isMyinfoDone() {
        List<String> submitedFormResult = new ArrayList<>();
        submitedFormResult.add(getText(firstname).trim());
        submitedFormResult.add(getText(middleName).trim());
        submitedFormResult.add(getText(lastName).trim());
        return submitedFormResult;
    }

    public String expected(int casos) {
        switch (casos) {
            case 1:
                return "Marco Luis Zapata";
            default:
                return "Default";
        }
    }

}
