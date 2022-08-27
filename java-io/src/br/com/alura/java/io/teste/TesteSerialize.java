package br.com.alura.java.io.teste;

import java.io.*;

public class TesteSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String name = "Nico Steppat";
//        writeOutputStream(name);
        writeInputStream();
    }

    private static void writeInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
        String name = (String) ois.readObject();
        ois.close();
        System.out.println(name);
    }

    private static void writeOutputStream(String name) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
        oos.writeObject(name);
        oos.close();
    }


}
