package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Office;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCargo extends CrudRepository<Office, Integer> {
}
