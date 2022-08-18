package br.com.alura.spring.data;

import br.com.alura.spring.data.services.ServiceCrudCargo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
    private final ServiceCrudCargo serviceCargo;
    private boolean system = true;

    public SpringDataApplication(ServiceCrudCargo serviceCargo) {
        this.serviceCargo = serviceCargo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (system) {
            System.out.println("Qual ação você quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");

            int action = scanner.nextInt();
            if (action == 1) {
                this.serviceCargo.init(scanner);
                System.out.println("Savando no banco de dados...");
            } else {
                this.system = false;
                System.out.println("Não executado - fechando....");
            }
        }
    }
}
