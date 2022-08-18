package br.com.alura.spring.data.services;

import br.com.alura.spring.data.repository.RepositoryEmployee;

public class ServiceEmployee {

    private final RepositoryEmployee repositoryEmployee;

    public ServiceEmployee(RepositoryEmployee repositoryEmployee) {
        this.repositoryEmployee = repositoryEmployee;
    }
}
