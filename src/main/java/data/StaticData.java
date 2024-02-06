package data;

public enum StaticData {

    LOGIN_EMAIL_ADDRESS("test@test123test123.test"),
    LOGIN_PASSWD("Parola!2"),
    LOGIN_INVALID_EMAIL_ADDRESS("test@test123test123");

    private final String data;

    StaticData(String data) { this.data = data; }

    public String getData() { return this.data; }
}
