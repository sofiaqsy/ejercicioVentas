package com.tcs.ventas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ventas.model.Producto;
import com.tcs.ventas.repository.ProductoRepository;

@Service
public class ProductoBusiness {

	@Autowired
	private ProductoRepository productoRepository;

	public List<Producto> getAll() {
		return productoRepository.getAll();
	}

	public Producto getById(int codigoProducto) {
		return productoRepository.getById(codigoProducto);
	}

	public int save(Producto producto) {
		return productoRepository.insert(producto);
	}

	public int update(Producto producto) {
		return productoRepository.update(producto);
	}

	public int remove(int codigoProducto) {
		return productoRepository.delete(codigoProducto);
	}

}
