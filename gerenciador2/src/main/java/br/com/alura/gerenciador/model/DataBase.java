package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBase {
    private static final List<Company> companies = new ArrayList<>();
    private static final List<User> users = new ArrayList<>();
    private static Integer keySequential = 1;

    static {
        Company company1 = new Company();
        company1.setId(DataBase.keySequential++);
        company1.setName("Alura");

        Company company2 = new Company();
        company2.setId(DataBase.keySequential++);
        company2.setName("Google");

        DataBase.companies.add(company1);
        DataBase.companies.add(company2);
    }

    static {
        User user1 = new User();
        user1.setLogin("Nico");
        user1.setPassword("1234");

        User user2 = new User();
        user2.setLogin("Marco");
        user2.setPassword("1234");

        DataBase.users.add(user1);
        DataBase.users.add(user2);
    }


    public void add(Company company) {
        company.setId(DataBase.keySequential++);
        DataBase.companies.add(company);
    }

    public void userAdd(User user) {
        user.setId(DataBase.keySequential++);
        DataBase.users.add(user);
    }

    public void userRemove(Integer id) {
        DataBase.users.removeIf(user -> Objects.equals(user.getId(), id));
    }

    public User userFindId(Integer id) {
        return DataBase.users.stream().filter(user -> id.equals(user.getId())).findAny().orElse(null);
    }

    public List<User> getUsers() {
        return DataBase.users;
    }

    public List<Company> getCompanies() {
        return DataBase.companies;
    }

    public void companyRemove(Integer id) {
        DataBase.companies.removeIf(company -> Objects.equals(company.getId(), id));
    }

    public Company findId(Integer id) {
        return DataBase.companies.stream().filter(company -> id.equals(company.getId())).findAny().orElse(null);
    }

    public User existAuth(String login, String password) {
        return DataBase.users.stream().filter(user -> user.isEqual(login, password)).findAny().orElse(null);
    }
}
