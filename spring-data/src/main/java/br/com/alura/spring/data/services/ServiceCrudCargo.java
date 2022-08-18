package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.ORMCargo;
import br.com.alura.spring.data.repository.RepositoryCargo;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ServiceCrudCargo {

    private final RepositoryCargo repositoryCargo;

    public ServiceCrudCargo(RepositoryCargo repositoryCargo) {
        this.repositoryCargo = repositoryCargo;
    }

    public void init(Scanner scanner) {
        this.save(scanner);
    }

    private void save(Scanner scanner) {
        System.out.println("Descrição do Cargo");

        String description = scanner.next();
        ORMCargo cargo = new ORMCargo();

        cargo.setDescription(description);
        repositoryCargo.save(cargo);

        System.out.println("Salvo!");
    }
}
