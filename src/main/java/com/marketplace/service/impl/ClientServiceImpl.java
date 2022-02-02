package com.marketplace.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketplace.model.entity.Client;
import com.marketplace.model.repository.ClientRepository;
import com.marketplace.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	
	public Client create(Client client) {
		Client clienteCreado = clientRepository.save(client);
		return clienteCreado;
	}

	public Client update(Client cliente, int id) {
		
		 Optional<Client> clienteEncontrado = clientRepository.findById(id);
		 Client clienteAactualizar=null;
		 
		 if (clienteEncontrado.isPresent()) {
			 clienteAactualizar= clienteEncontrado.get();
			 clienteAactualizar.setEdad(cliente.getEdad());
			 clienteAactualizar.setEstado(cliente.getEstado());
			 clienteAactualizar.setName(cliente.getName());
			 
			clientRepository.save(clienteAactualizar);
		 }
		
		
		// TODO Auto-generated method stub
		return clienteAactualizar;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Client clienteEncontrado = clientRepository.findById(id).get();
		clientRepository.delete(clienteEncontrado  );
		
	}

	public Client getById(int id) {
		// TODO Auto-generated method stub
		Client clienteEcontrado = clientRepository.findById(id).get();
		return clienteEcontrado;
	}

	public List<Client> getAll() {
		// TODO Auto-generated method stub
		List<Client> allClients = (List<Client>) clientRepository.findAll();
		return allClients;
	}

	
	
}
