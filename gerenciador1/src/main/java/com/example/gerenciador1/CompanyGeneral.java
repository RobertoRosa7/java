package com.example.gerenciador1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompanyGeneral {

    private String name;
    private String date;
    private String id;

    CompanyGeneral(String name, String date) {
        this.name = name;
        this.date = date;
    }

    CompanyGeneral(String name, String date, String id) {
        this.name = name;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(this.date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return Integer.valueOf(this.id);
    }

    public void setId(String id) {
        this.id = id;
    }
}
