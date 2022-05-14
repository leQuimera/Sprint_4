package ru.yandex;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String accountName;
    private final Boolean status;
    private Account account;


    public AccountTest(String accountName, Boolean status) {
        this.accountName = accountName;
        this.status = status;
    }

    @Parameterized.Parameters
    public static Object[] checkStatus() {
        return new Object[][] {
                {"Тимоти Шаламе", true}, //Имя с пробелом 3<=n<=19 символов
                {"Т Ш", true}, //Имя с пробелом 3 символа
                {"Тимотитимоти Шаламе", true}, // Имя с пробелом 19 символов
                {"ТимотиШаламе", false}, //Имя в одно слово, без пробела
                {" Тимоти Шаламе", false}, //Пробел перед строкой
                {" Тимоти", false}, //Один пробел перед словом
                {"Тимоти Шаламе ", false}, //Пробел в конце строки
                {"Тимоти ", false}, //Один пробел после слова
                {"ТШ", false}, //Два символа в строке
                {"Тимотитимоти Шаламее", false}, //20 символов в строке
                {"Тимми Йорк Шалле", false}, //Два пробела в середине строки (три слова)
                {"Тимми  Шалле", false}, //Два пробела подряд
                {"   ", false}, //Пустая строка из трех пробелов
                {null, false}, //Не передана строка
                {"#$%^&", false}, // Передача в строке спецсимволов
        };
    }

    @Test
    @DisplayName("Name validation check")
    public void setValidNameTest() {
        account = new Account(accountName);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals(status, actual);
    }

}
