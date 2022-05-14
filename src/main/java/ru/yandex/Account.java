package ru.yandex;

import io.qameta.allure.Step;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;
    private static final Pattern pattern = Pattern.compile("^(?=.{3,19}$)([a-zA-ZА-ЯЁа-яё]+ [a-zA-ZА-ЯЁа-яё]+)$");

    public Account(String name) {
        this.name = name;
    }

    @Step("Name meets requirements")
    public boolean checkNameToEmboss() {

        if (name == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

}
