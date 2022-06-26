package yandex;

import yandex.Account;

public class Praktikum {

    public static void main(String[] args) {
        for (String arg : args) {
            Account account = new Account(arg);
            System.out.println(account.checkNameToEmboss());
        }
    }
}