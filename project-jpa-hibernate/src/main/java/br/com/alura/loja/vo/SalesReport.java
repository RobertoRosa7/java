package br.com.alura.loja.vo;

import java.time.LocalDate;

public class SalesReport {
    private final String nameProduct;
    private final Long saleQuantity;
    private final LocalDate saleLast;

    public SalesReport(String nameProduct, Long saleQuantity, LocalDate saleLast) {
        this.nameProduct = nameProduct;
        this.saleQuantity = saleQuantity;
        this.saleLast = saleLast;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Long getSaleQuantity() {
        return saleQuantity;
    }

    public LocalDate getSaleLast() {
        return saleLast;
    }

    @Override
    public String toString() {
        return "SalesReport{" + "nameProduct='" + nameProduct + '\'' + ", saleQuantity=" + saleQuantity + ", saleLast=" + saleLast + '}';
    }
}
