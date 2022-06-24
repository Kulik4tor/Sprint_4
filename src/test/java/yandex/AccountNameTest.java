package yandex;

import static org.junit.Assert.assertEquals;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@DisplayName("Проверка валидации имени и фамилии на карте")
public class AccountNameTest {

    private final String name;
    private final boolean expected;

    public AccountNameTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тест имя = \"{0}\" ОР = \"{1}\"")
    public static Object[][] getTestName() {
        return new Object[][]{
                {"Кирилл Кулик", true}, //позитив
                {"К К", true}, //длина 3
                {"Кирилл Куликккккккк", true}, //длина 19
                {" Кирилл Кулик", false}, //пробел в начале
                {"Кирилл Кулик ", false}, //пробел в конце
                {"", false},
                {" ", false}, //просто пробел
                {"    ", false}, //4 пробела
                {null, false},
                {"КириллКулик", false}, //нет пробела
                {"Кирилл Куликкккккккk", false}, //длина 20
                {"Кирилл Куликкккккккkdkdkdkkdkdkdkdkdkdkdkkdk", false}, //длина сильно больше
                {" K", false}, //длина 2
                {"k-k", false}, // "-" вместо пробела
                {"Кирилл  Kulik", false}, //два пробела
        };
    }

    @Test
    public void ValidationNameCheck() {
        Account account = new Account(name);
        boolean actualResult = account.checkNameToEmboss();

        assertEquals("Ошибка валидации имени " + "'" + name + "'", expected, actualResult);
    }
}