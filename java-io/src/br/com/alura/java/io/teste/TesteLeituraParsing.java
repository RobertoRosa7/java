package br.com.alura.java.io.teste;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraParsing {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("contas.csv"), StandardCharsets.UTF_8);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Scanner lineScanner = new Scanner(line);
            lineScanner.useLocale(Locale.US);
            lineScanner.useDelimiter(",");

            String tipoConta = lineScanner.next();
            int agencia = lineScanner.nextInt();
            int numero = lineScanner.nextInt();
            String titular = lineScanner.next();
            double saldo = lineScanner.nextDouble();

//            String[] values = line.split(",");
            System.out.format(new Locale("pt", "BR"), "%s %04d %08d %s %05.2f%n",
                    tipoConta, agencia, numero, titular, saldo);
            lineScanner.close();
        }
        scanner.close();
    }
}
