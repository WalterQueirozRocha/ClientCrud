package com.example.clientCrudChallenge.clientChallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientCrudChallenge.clientChallenge.dto.ClientDTO;
import com.example.clientCrudChallenge.clientChallenge.repositories.ClientRepository;
import com.example.clientCrudChallenge.clientChallenge.services.ClientService;

@RestController
@RequestMapping(name = "/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ClientDTO dto;
	
	@Autowired
	private ClientService service;
	
	@GetMapping()
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
		Page<ClientDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
	}

}
