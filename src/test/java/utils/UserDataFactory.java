package utils;

import com.github.javafaker.Faker;

public class UserDataFactory {

    static Faker faker = new Faker();

    public static UserData generateValidUser() {
        UserData user = new UserData();
        user.firstName = faker.name().firstName();
        user.lastName = faker.name().lastName();
        user.email = faker.internet().emailAddress();
        user.address = faker.address().streetAddress();
        user.city = faker.address().city();
        user.state = "São Paulo";

        String cep = faker.address().zipCode().replaceAll("-", "");
        user.postcode = cep.substring(0, Math.min(cep.length(), 8));

        String phone = faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "");
        user.phone = phone.substring(0, Math.min(phone.length(), 11));

        user.country = "Brazil";
        return user;
    }

    public static UserData generateInvalidUser() {
        UserData user = new UserData();
        user.firstName = ""; // nome vazio
        user.lastName = "123"; // sobrenome numérico
        user.email = "emailinvalido.com"; // sem @
        user.address = "";
        user.city = "";
        user.state = "";
        user.postcode = "abc123";
        user.phone = "fone";
        user.country = "Narnia";
        return user;
    }
}
