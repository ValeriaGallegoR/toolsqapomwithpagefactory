package co.com.sofka.util;

public enum MaritalStatus {

    SINGLE("Single"),
    MARRIED("Married"),
    OTHER("other");

    private final String value;

    public String getValue() {
        return value;
    }

    MaritalStatus(String value) {
        this.value = value;
    }
}
