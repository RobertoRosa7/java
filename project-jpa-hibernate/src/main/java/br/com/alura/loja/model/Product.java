package br.com.alura.loja.model;

import javax.persistence.*;
import java.math.BigDecimal;

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
}
