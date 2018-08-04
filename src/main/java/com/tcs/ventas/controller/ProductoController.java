package com.tcs.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ventas.model.Producto;

import business.ProductoBusiness;

@RestController
public class ProductoController {

	@Autowired
	private ProductoBusiness productoBusiness;

	@GetMapping("/producto")
	public List<Producto> getAll() {
		return productoBusiness.getAll();
	}

	@GetMapping("/producto/{codigoProducto}")
	public Producto getById(@PathVariable int codigoProducto) {
		return productoBusiness.getById(codigoProducto);
	}

	@PutMapping("/producto")
	public Producto update(@RequestBody Producto producto) {
		productoBusiness.update(producto);
		return producto;
	}

	@PostMapping("/producto")
	public Producto save(@RequestBody Producto producto) {
		int codigoProducto = productoBusiness.save(producto);
		producto.setCodigo(codigoProducto);
		return producto;
	}

	@DeleteMapping("/producto/{id}")
	public Producto delete(@PathVariable("id") int codigoProducto) {
		Producto productoAEliminar = productoBusiness.getById(codigoProducto);
		productoBusiness.remove(codigoProducto);
		return productoAEliminar;
	}
}
