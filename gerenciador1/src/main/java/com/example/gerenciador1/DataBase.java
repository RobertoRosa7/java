package com.example.gerenciador1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBase {
    private static final List<Company> companies = new ArrayList<>();
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


    public void add(Company company) {
        company.setId(DataBase.keySequential++);
        DataBase.companies.add(company);
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
}
