package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteLeitura {

    /**
     * Stream - input stream of bytes
     * Reader - reading character streams
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fs = new FileInputStream("lorem.txt");
        InputStreamReader inputReader = new InputStreamReader(fs);
        BufferedReader bufferedReader = new BufferedReader(inputReader);

        String line = bufferedReader.readLine();

        while (line != null) {
            System.out.printf("%s\n", line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
    }
}
