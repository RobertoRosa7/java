package br.com.alura.loja.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity // => indicate that it is a database table
@Table(name = "products") // => indicate that is a plural
public class Product {

    @Id // => indicate that is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // => indicate that primary key will generate by database
    private Long id;
    private String name;
    //    @Column(name = "description") // => if the name of column on database is different
    private String description;
    private BigDecimal price;
    @Column(name = "date_register")
    private LocalDate dateRegister = LocalDate.now();

    //    @Enumerated(EnumType.STRING) // => register use by string on database
    //    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Product(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product() {

    }

    public LocalDate getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDate dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %f %s %s", this.id, this.name, this.description, this.price, this.dateRegister, this.category);
    }
}
