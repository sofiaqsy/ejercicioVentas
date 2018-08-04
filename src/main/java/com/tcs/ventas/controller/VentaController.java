package com.tcs.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.ventas.business.VentaBusiness;
import com.tcs.ventas.model.Venta;
import com.tcs.ventas.model.VentaDetalle;

@RestController
public class VentaController {

	@Autowired
	private VentaBusiness ventaBusiness;

	@GetMapping("/venta/{codigoVenta}")
	public List<VentaDetalle> getVentaDetalleByIdVenta(@PathVariable int codigoVenta) {
		return ventaBusiness.getVentaDetalleByIdVenta(codigoVenta);
	}

	@GetMapping("/venta/detalle/{codigoVenta}")
	public Venta getVentaByCodigoVenta(@PathVariable int codigoVenta) {
		return ventaBusiness.getVentaByCodigoVenta(codigoVenta);
	}

}
