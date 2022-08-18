package br.com.alura.spring.data.services;

import br.com.alura.spring.data.orm.Office;
import br.com.alura.spring.data.repository.RepositoryCargo;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ServiceCrudCargo {

    private final RepositoryCargo repositoryCargo;

    public ServiceCrudCargo(RepositoryCargo repositoryCargo) {
        this.repositoryCargo = repositoryCargo;
    }

    public void save(Scanner scanner) {
        System.out.println("Digite a descrição do cargo:\n");

        String description = scanner.next();
        Office cargo = new Office();

        cargo.setDescription(description);
        repositoryCargo.save(cargo);

        System.out.println("Salvo!\n");
    }

    public void update(Scanner scanner) {
        System.out.println("Digite o id do cargo:\n");
        Integer id = scanner.nextInt();

        System.out.println("Digite a nova descrição!\n");
        String description = scanner.next();

        Office cargo = new Office();
        cargo.setId(id);
        cargo.setDescription(description);

        repositoryCargo.save(cargo);

        System.out.println("Atualizado!\n");
    }

    public void remove(Scanner scanner) {
        System.out.println("Digite o ID do cargo!");
        Integer id = scanner.nextInt();

        repositoryCargo.deleteById(id);
        System.out.println("excluído!\n");
    }

    public void read() {
        Iterable<Office> cargos = repositoryCargo.findAll();
        cargos.forEach(System.out::println);
        System.out.println("Feito!\n");
    }
}
