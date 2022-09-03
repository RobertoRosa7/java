package br.com.alura.java.io.teste;

import java.io.*;

public class TesteSerialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String name = "Nico Steppat";
        TesteClient client = new TesteClient("teste1", "000.000.000-00");

//        writeOutputStream(name);
//        writeInputStream();

//        writeOutputClassStream(client);
        writeInputClassStream();
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

    private static void writeOutputClassStream(Object client) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("client.bin"));
        oos.writeObject(client);
        oos.close();
    }

    private static void writeInputClassStream() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("client.bin"));
        TesteClient client = (TesteClient) ois.readObject();
        ois.close();
        System.out.println(client.getName());
    }
}
