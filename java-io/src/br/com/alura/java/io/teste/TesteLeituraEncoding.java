package br.com.alura.java.io.teste;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteLeituraEncoding {

    public static void main(String[] args) throws Exception {

        String c = "C";
        System.out.printf("with codePointAt: %s%n", c.codePointAt(0));

        Charset charset = Charset.defaultCharset();
        System.out.printf("charset default: %s%n", charset.displayName());

        byte[] b = c.getBytes();
        System.out.printf("bytes: %d %s%n", b.length, charset.displayName());

        byte[] bWindows = c.getBytes("windows-1252");
        System.out.printf("bytes: %d windows-1252%n", bWindows.length);

        byte[] bUtf16 = c.getBytes(StandardCharsets.UTF_16);
        System.out.printf("bytes: %d %s%n", bUtf16.length, StandardCharsets.UTF_16);

        byte[] bUtf8 = c.getBytes(StandardCharsets.UTF_8);
        System.out.printf("bytes: %d %s%n", bUtf8.length, StandardCharsets.UTF_8);

        String bNew = new String(bUtf8);
        System.out.printf("string: %s%n", bNew);

        byte[] bAscii = c.getBytes(StandardCharsets.US_ASCII);
        System.out.printf("bytes: %d %s%n", bAscii.length, StandardCharsets.US_ASCII);


    }
}
