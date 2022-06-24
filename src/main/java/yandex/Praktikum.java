package yandex;

import yandex.Account;

public class Praktikum {

    public static void main(String[] args) {
        String name;
        Account account = new Account("name");
        System.out.println(account.checkNameToEmboss());
    }
}