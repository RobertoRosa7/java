package br.com.alura.java.io.teste;

import java.io.*;

public class TesteEscrita {

    /**
     * Stream: input stream of bytes
     * <p>
     * Reader: reading character streams
     * <p>
     * OutputStream
     * <p>
     * BufferedWriter extends Writer
     *
     * @param args inputs
     * @throws IOException Exception Generic
     */
    public static void main(String[] args) throws IOException {
        OutputStream fs = new FileOutputStream("lorem2.txt");
        Writer outputReader = new OutputStreamWriter(fs);
        BufferedWriter bufferedWriter = new BufferedWriter(outputReader);

        bufferedWriter.write("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("any another text");

        bufferedWriter.close();
    }
}
