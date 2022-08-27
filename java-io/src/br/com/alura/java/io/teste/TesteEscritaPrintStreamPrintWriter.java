package br.com.alura.java.io.teste;

import java.io.IOException;
import java.io.PrintWriter;

public class TesteEscritaPrintStreamPrintWriter {

    public static void main(String[] args) throws IOException {
//        PrintStream ps = new PrintStream("lorem4.txt");  // first mode
//        PrintStream ps = new PrintStream(new File("lorem4.txt")); // second mode
        PrintWriter ps = new PrintWriter("lorem4.txt"); // third mode

        ps.println("Output using PrintStream");
        ps.println();
        ps.println("any another text");

        ps.close();
    }
}
