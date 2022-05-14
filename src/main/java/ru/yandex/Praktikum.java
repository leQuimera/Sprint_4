package ru.yandex;

import com.sun.nio.sctp.SctpSocketOption;

import java.security.PrivateKey;

public class Praktikum {

    public static void main(String[] args) {

        String accountName = "Тимоти Шаламе";

        /*
             В этом методе заложи логику работы с классом Account.
             Нужно создать экземпляр класса Account: в качестве аргумента передать тестируемое имя
             и вызвать метод, который проверяет, можно ли использовать фамилию и имя для печати на банковской карте.
         */

        Account account = new Account(accountName);
        if(account.checkNameToEmboss()) {
            System.out.println("Name " + accountName + " is valid");
        } else {
            System.out.println("Name " + accountName + " is not valid");
        }
    }

}
