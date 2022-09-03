package br.com.alura;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now(); // 2022-09-01
        LocalDateTime agora = LocalDateTime.now();

        System.out.println(LocalDate.of(2019, Month.JUNE, 5)); // 2019-06-05
        System.out.println(hoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // 01/09/2022
        System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"))); // 01/09/2022 08:48:47
        System.out.println(LocalTime.of(15, 30)); // 15:30
    }
}
