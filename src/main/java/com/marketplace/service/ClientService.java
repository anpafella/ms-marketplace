package com.marketplace.service;

import java.util.List;

import com.marketplace.model.entity.Client;

public interface ClientService {

	Client create(Client client);

	Client update(Client cliente, int id);

	void delete(int id);

	Client getById(int id);

	List<Client> getAll();
}
