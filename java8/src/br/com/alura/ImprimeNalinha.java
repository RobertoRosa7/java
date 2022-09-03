package br.com.alura;

import java.util.function.Consumer;

public class ImprimeNalinha implements Consumer {

    @Override
    public void accept(Object o) {
        System.out.println(o);
    }
}
