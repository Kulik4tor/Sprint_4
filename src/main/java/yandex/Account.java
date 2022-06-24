package yandex;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        return name != null && name.matches("\\S+ \\S+") && name.length() >= 3 && name.length() <= 19;
    }
}