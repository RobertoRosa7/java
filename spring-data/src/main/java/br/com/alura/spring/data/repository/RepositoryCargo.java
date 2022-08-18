package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.ORMCargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCargo extends CrudRepository<ORMCargo, Integer> {
}
