package br.com.alura.loja.tests;

import br.com.alura.loja.dao.CategoryDAO;
import br.com.alura.loja.dao.ProductDAO;
import br.com.alura.loja.model.Category;
import br.com.alura.loja.model.Product;
import br.com.alura.loja.utils.Utils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class NewProduct {
    public static void main(String[] args) {
//        Long id = 1L;
//        createNewProduct();
//        findById(id);
//        findAll();
//        findByName("Xiaomi Redmi");
//        findByCategory("Mobile");
//        getPriceProductByName("Xiaomi Redmi");
    }

    public static void createNewProduct() {
        Category cat = new Category("Mobile");
        Product prod = new Product("Xiaomi Redmi", "120G Storage", new BigDecimal("800"), cat);

        EntityManager em = Utils.getEntityManager();

        em.getTransaction().begin();

        ProductDAO pd = new ProductDAO(em);
        CategoryDAO cd = new CategoryDAO(em);

        cd.create(cat);
        pd.create(prod);

        em.getTransaction().commit();
        em.close();
    }

    public static void getPriceProductByName(String name) {
        EntityManager em = Utils.getEntityManager();
        ProductDAO pd = new ProductDAO(em);

        BigDecimal price = pd.getPriceProductByName(name);
        System.out.println(price);
    }

    public static void findByCategory(String name) {
        EntityManager em = Utils.getEntityManager();
        ProductDAO pd = new ProductDAO(em);

        List<Product> products = pd.findByCategory(name);
        products.forEach(System.out::println);
    }

    public static void findByName(String name) {
        EntityManager em = Utils.getEntityManager();
        ProductDAO pd = new ProductDAO(em);

        List<Product> products = pd.findByName(name);
        products.forEach(System.out::println);
    }

    public static void findAll() {
        EntityManager em = Utils.getEntityManager();
        ProductDAO pd = new ProductDAO(em);

        List<Product> all = pd.findAll();
        all.forEach(System.out::println);
    }

    public static Product findById(Long id) {
        EntityManager em = Utils.getEntityManager();
        ProductDAO pd = new ProductDAO(em);

        Product prod = pd.findById(id);
        System.out.println(prod.getId() + ";" + prod.getName() + ";" + prod.getPrice() + ";" + prod.getDescription() + ";" + prod.getDateRegister() + ";" + prod.getCategory());
        return prod;
    }

}
