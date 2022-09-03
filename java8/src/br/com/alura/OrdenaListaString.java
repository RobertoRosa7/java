package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaListaString {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();

        palavras.add("alura online");
        palavras.add("editora da casa do código");
        palavras.add("caelum");

        Comparator<String> comparator = new ComparadorPorTamanho();
        Collections.sort(palavras, comparator);
        System.out.println(palavras);
        palavras.sort(comparator);
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        palavras.forEach(consumer);

        palavras.forEach(s -> System.out.println(s)); // java 8 lambda
        palavras.forEach(System.out::println); // java 8 lambda
        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length())); // java 8
        palavras.sort(Comparator.comparing(String::length)); // java 8

        System.out.println(palavras);
    }
}

