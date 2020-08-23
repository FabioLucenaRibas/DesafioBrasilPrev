package com.brasilprev.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brasilprev.desafio.dto.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, String>{

}
