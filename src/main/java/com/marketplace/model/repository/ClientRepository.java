package com.marketplace.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.model.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>{
	
	

}
