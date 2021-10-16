package co.com.sofka.model.LoginMyInfoModel;

import co.com.sofka.util.Gender;
import co.com.sofka.util.MaritalStatus;
import co.com.sofka.util.Month;

import java.util.List;

public class LoginMyInfoModel {

    // for login
    private String userName;
    private String password;
    //for my info
    private String firstName;
    private String middleName;
    private String lastName;
    private String otherid;
    private String licenseNumber;
    private String year;
    private String month;
    private String day;
    private String ssNumber;
    private String siNumber;
    private Gender gender;
    private MaritalStatus maritialStatus;
    private String nationality;
    private String nickName;
    private String militaryService;
    private List<String> subjects;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOtherid() {
        return otherid;
    }

    public void setOtherid(String otherid) {
        this.otherid = otherid;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getSsNumber() {
        return ssNumber;
    }

    public void setSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
    }

    public String getSiNumber() {
        return siNumber;
    }

    public void setSiNumber(String siNumber) {
        this.siNumber = siNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritialStatus() {
        return maritialStatus;
    }

    public void setMaritialStatus(MaritalStatus maritialStatus) {
        this.maritialStatus = maritialStatus;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMilitaryService() {
        return militaryService;
    }

    public void setMilitaryService(String militaryService) {
        this.militaryService = militaryService;
    }
}
