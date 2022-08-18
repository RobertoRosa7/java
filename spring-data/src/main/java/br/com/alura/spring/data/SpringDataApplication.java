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
            System.out.println("MENU DE OPÇÕES:\nQual ação você quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Novo Cargo");
            System.out.println("2 - Listar todos Cargos");
            System.out.println("3 - Atualizar Cargo");
            System.out.println("4 - Excluir Cargo");

            int action = scanner.nextInt();
            switch (action) {
                case 0: {
                    System.out.println("Não executado - fechando....\n");
                    this.system = false;
                    break;
                }
                case 1: {
                    System.out.println("Salvando no banco de dados...\n");
                    this.serviceCargo.save(scanner);
                    break;
                }
                case 2: {
                    System.out.println("Buscando no banco de dados...\n");
                    this.serviceCargo.read();
                    break;
                }
                case 3: {
                    System.out.println("Atualizando cargo no banco de dados...\n");
                    this.serviceCargo.update(scanner);
                    break;
                }
                case 4: {
                    System.out.println("Excluindo no banco de dados...\n");
                    this.serviceCargo.remove(scanner);
                    break;
                }
                default: {
                    System.out.println("Não executado - fechando....\n");
                    this.system = false;
                }
            }
        }
    }
}
