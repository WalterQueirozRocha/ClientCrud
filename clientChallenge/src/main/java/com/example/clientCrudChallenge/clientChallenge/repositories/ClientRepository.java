package com.example.clientCrudChallenge.clientChallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clientCrudChallenge.clientChallenge.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
