package com.example.clientCrudChallenge.clientChallenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.clientCrudChallenge.clientChallenge.dto.ClientDTO;
import com.example.clientCrudChallenge.clientChallenge.entities.Client;
import com.example.clientCrudChallenge.clientChallenge.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> client = repository.findAll(pageable);
		return client.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long Id) {
		Optional<Client> result = repository.findById(Id);
		Client client = result.get();
		ClientDTO dto = new ClientDTO(client);
		return dto;
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client entity = new Client();
		
		entity.setName(dto.getName());
		entity.setIncome(dto.getIncome());
		entity.setCpf(dto.getCpf());
		entity.setChildren(dto.getChildren());
		entity.setBirthDate(dto.getBirthDate());

		entity = repository.save(entity);
		return new ClientDTO(entity);
	}

}
