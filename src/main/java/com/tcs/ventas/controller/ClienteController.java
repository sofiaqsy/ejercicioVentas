package com.tcs.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ventas.business.ClienteBusiness;
import com.tcs.ventas.model.Cliente;

@RestController
public class ClienteController {

	@Autowired
	private ClienteBusiness clienteBusiness;

	@GetMapping("/cliente")
	public List<Cliente> getAll() {
		return clienteBusiness.getAll();

	}

	@GetMapping("/cliente/venta/{codigoVenta}")
	public Cliente getClienteByCodigoVenta(@PathVariable int codigoVenta) {
		return clienteBusiness.getClienteByCodigoVenta(codigoVenta);
	}

}
