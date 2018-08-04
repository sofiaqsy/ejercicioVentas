package com.tcs.ventas.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaDetalle {
	
	private int codigoProducto;
	private int codigoVenta;
	private String nombreProducto;
	private BigDecimal precioUnitario;
	private BigDecimal cantidad;
	private BigDecimal subTotal;

	

}
