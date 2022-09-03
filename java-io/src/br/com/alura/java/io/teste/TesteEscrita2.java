package br.com.alura.java.io.teste;

import java.io.FileWriter;
import java.io.IOException;

public class TesteEscrita2 {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("lorem3.txt");

        fileWriter.write("new file written by FileWrite lib");
        fileWriter.write(System.lineSeparator());
        fileWriter.write("Another line written by FileWriter lib");
        fileWriter.close();
    }
}
