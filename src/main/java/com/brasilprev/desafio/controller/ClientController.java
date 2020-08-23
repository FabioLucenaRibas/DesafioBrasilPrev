package com.brasilprev.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brasilprev.desafio.dto.Client;
import com.brasilprev.desafio.exception.BusinessException;
import com.brasilprev.desafio.service.ClientService;

@RestController
public class ClientController {
	@Autowired
	ClientService clientService;

	@GetMapping("/clients")
	public List<Client> getAll() {
		return clientService.getAllClients();
	}

	@GetMapping("/clients/{cpf}")
	public ResponseEntity<Client> getClient(@PathVariable("cpf") String cpf) {
		Client client = clientService.getClientById(cpf);
		if (client == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(client);
	}

	@PostMapping("/clients")
	public ResponseEntity<Object> save(@RequestBody @Valid Client client) {
		try {
			clientService.register(client);
			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			return ResponseEntity.badRequest().body(e.getError());
		}
	}

	@PutMapping("/clients")
	public ResponseEntity<Object> update(@RequestBody @Valid Client client) {
		try {
			clientService.update(client);
			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			return ResponseEntity.status(e.getError().getCode()).body(e.getError());
		}
	}

	@DeleteMapping("/clients/{cpf}")
	public ResponseEntity<Object> delete(@PathVariable("cpf") String cpf) {
		try {
			clientService.delete(cpf);
			return ResponseEntity.ok().build();
		} catch (BusinessException e) {
			return ResponseEntity.status(e.getError().getCode()).body(e.getError());
		}
	}
}
