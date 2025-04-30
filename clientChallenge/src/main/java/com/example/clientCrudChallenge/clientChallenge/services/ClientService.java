package com.example.clientCrudChallenge.clientChallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.clientCrudChallenge.clientChallenge.dto.ClientDTO;
import com.example.clientCrudChallenge.clientChallenge.entities.Client;
import com.example.clientCrudChallenge.clientChallenge.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;

	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> client = repository.findAll(pageable);
		return client.map(x -> new ClientDTO(x));
	}

}
