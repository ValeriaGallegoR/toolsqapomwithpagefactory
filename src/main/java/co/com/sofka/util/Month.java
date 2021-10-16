package co.com.sofka.util;

public enum Month {
    JAN ("Jan"),
    FEB ("feb"),
    MAR ("Mar"),
    APR ("Apr"),
    MAY ("May"),
    JUN ("Jun"),
    JUL ("Jul"),
    AUG ("Aug"),
    SEP ("Sep"),
    OCT ("Oct"),
    NOV ("Nov"),
    DEC ("Dec");
    private final String value;

    public String getValue() {
        return value;
    }

    Month(String value) {
        this.value = value;
    }
}
