package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryEmployee extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);
}
