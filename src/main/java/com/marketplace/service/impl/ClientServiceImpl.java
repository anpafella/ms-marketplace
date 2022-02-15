package com.marketplace.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.marketplace.model.dto.ProductByClientDTO;
import com.marketplace.model.dto.ProductDTO;
import com.marketplace.model.entity.Client;
import com.marketplace.model.repository.ClientRepository;
import com.marketplace.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	RestTemplate restTemplate;

	public Client create(Client client) {
		Client clienteCreado = clientRepository.save(client);
		return clienteCreado;
	}

	public Client update(Client client, int id) {

		Optional<Client> clienteEncontrado = clientRepository.findById(id);
		Client clienteAactualizar = null;

		if (clienteEncontrado.isPresent()) {
			clienteAactualizar = clienteEncontrado.get();
			clienteAactualizar.setEdad(client.getEdad());
			clienteAactualizar.setEstado(client.getEstado());
			clienteAactualizar.setName(client.getName());

			clientRepository.save(clienteAactualizar);
		}

		// TODO Auto-generated method stub
		return clienteAactualizar;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Client clienteEncontrado = clientRepository.findById(id).get();
		clientRepository.delete(clienteEncontrado);

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

	public ProductByClientDTO getProductsByClient(Integer clientId, Integer productId) {

		ProductByClientDTO productoByClientDTOtoReturn = new ProductByClientDTO();

		Optional<Client> clienteEncontrado = clientRepository.findById(clientId);
		if (clienteEncontrado.isPresent()) {

			productoByClientDTOtoReturn.setName(clienteEncontrado.get().getName());
			productoByClientDTOtoReturn.setEdad(clienteEncontrado.get().getEdad());
			productoByClientDTOtoReturn.setEstado(clienteEncontrado.get().getEstado());
			productoByClientDTOtoReturn.setId(clienteEncontrado.get().getId());

			String url = "http://localhost:8081/product/" + productId + "/get";
			ProductDTO productResponse = restTemplate.getForObject(url, ProductDTO.class);

			productoByClientDTOtoReturn.setProductDTO(productResponse);

		}

		return productoByClientDTOtoReturn;
	}

}
