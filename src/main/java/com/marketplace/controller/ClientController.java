package com.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.model.dto.ProductByClientDTO;
import com.marketplace.model.entity.Client;
import com.marketplace.service.ClientService;

//api de clientes
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	// EndPoint para crear
	@PostMapping("/crear")
	public Client crear(@RequestBody Client client) {
		Client clienteRecibido = clientService.create(client);

		return clienteRecibido;
	}

	// endPoint para eliminar
	@DeleteMapping("/{id}/delete")
	public void delete(@PathVariable(value = "id") Integer id) {
		clientService.delete(id);

	}

	// end point para actualziar
	@PutMapping("/{id}/update")
	public Client update(@RequestBody Client client, @PathVariable(value = "id") Integer id) {
		Client clienteActualizado = clientService.update(client, id);
		return clienteActualizado;

	}

	// end point para obtener cliente por id
	@GetMapping("/{id}/get")
	public Client getByid(@PathVariable(value = "id") Integer id) {
		Client clienteObtenido = clientService.getById(id);
		return clienteObtenido;
	}

	// endpoint para obtener all

	@GetMapping("/get")
	public List<Client> getAll() {

		return clientService.getAll();
	}

	// endpoint para obtener id de producto

	@GetMapping("/{clientId}/get/product/{productId}")
	public ProductByClientDTO getProductById(@PathVariable(value = "clientId") Integer clientId,
			@PathVariable(value = "productId") Integer productId) {

		System.out.println("clientId:" + clientId);
		System.out.println("productId:" + productId);
		// aqui buscamos el producto por id;

		ProductByClientDTO productByClient = clientService.getProductsByClient(clientId, productId);
		return productByClient;
	}

}
