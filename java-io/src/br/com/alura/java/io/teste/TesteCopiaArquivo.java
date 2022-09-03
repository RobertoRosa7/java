package br.com.alura.java.io.teste;

import java.io.*;
import java.net.Socket;

public class TesteCopiaArquivo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = readFile();
        BufferedWriter bufferedWriter = writeFile();

//        BufferedWriter bufferedWriter = console();
//        BufferedReader bufferedReader = userInput();

        String line = bufferedReader.readLine();
        while (line != null && !line.isEmpty()) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static BufferedReader readFile() throws FileNotFoundException {
        FileInputStream fileInput = new FileInputStream("lorem.txt");
        InputStreamReader inputReader = new InputStreamReader(fileInput);
        return new BufferedReader(inputReader);
    }

    public static BufferedWriter writeFile() throws FileNotFoundException {
        OutputStream fileOutput = new FileOutputStream("lorem2.txt");
        Writer outputReader = new OutputStreamWriter(fileOutput);
        return new BufferedWriter(outputReader);
    }

    public static BufferedReader userInput() throws FileNotFoundException {
        InputStream fileInput = System.in;
        InputStreamReader inputReader = new InputStreamReader(fileInput);
        return new BufferedReader(inputReader);
    }

    public static BufferedWriter console() {
        OutputStream fileOutput = System.out;
        Writer outputReader = new OutputStreamWriter(fileOutput);
        return new BufferedWriter(outputReader);
    }

    public static BufferedReader socketInput() throws IOException {
        InputStream socketInput;
        try (Socket socket = new Socket()) {
            socketInput = socket.getInputStream();
        }
        Reader inputReader = new InputStreamReader(socketInput);
        return new BufferedReader(inputReader);
    }

    public static BufferedWriter socketOutput() throws IOException {
        OutputStream socketOutput;
        try (Socket socket = new Socket()) {
            socketOutput = socket.getOutputStream();
        }
        Writer outputWriter = new OutputStreamWriter(socketOutput);
        return new BufferedWriter(outputWriter);
    }
}
