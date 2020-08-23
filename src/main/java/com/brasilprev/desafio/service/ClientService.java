package com.brasilprev.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.brasilprev.desafio.dto.Client;
import com.brasilprev.desafio.exception.BusinessException;
import com.brasilprev.desafio.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<>();
		clientRepository.findAll().forEach(clients::add);
		return clients;
	}

	public Client getClientById(String cpf) {
		Optional<Client> client = clientRepository.findById(cpf);

		if (client.isPresent()) {
			return client.get();
		}
		return null;
	}

	public void register(Client client) throws BusinessException {
		if (verifyExist(client)) {
			throw new BusinessException(BusinessException.ERROR_EXISTS);
		}
		clientRepository.save(client);
	}

	public void update(Client client) throws BusinessException {
		if (!verifyExist(client)) {
			throw new BusinessException(BusinessException.ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		clientRepository.save(client);
	}

	public void delete(String cpf) throws BusinessException {
		if (getClientById(cpf) == null) {
			throw new BusinessException(BusinessException.ERROR_NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		clientRepository.deleteById(cpf);
	}

	private boolean verifyExist(Client client) {
		return getClientById(client.getCpf()) != null;
	}
}
