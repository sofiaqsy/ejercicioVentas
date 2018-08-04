package com.tcs.ventas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.ventas.model.Venta;
import com.tcs.ventas.model.VentaDetalle;

@Repository
public class VentaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<VentaDetalle> getVentaDetalleByIdVenta(int codigoVenta) {
		String sql = "SELECT c_codigo_producto, c_precio_unitario, c_cantidad FROM t_venta_detalle"
				+ " WHERE c_codigo_venta = ?";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			VentaDetalle ventaDetalle = new VentaDetalle();
			ventaDetalle.setCodigoProducto(rs.getInt("c_codigo_producto"));
			ventaDetalle.setPrecioUnitario(rs.getBigDecimal("c_precio_unitario"));
			ventaDetalle.setCantidad(rs.getBigDecimal("c_cantidad"));

			return ventaDetalle;
		}, codigoVenta);
	}

	public Venta getVentaByCodigo(int codigoVenta) {

		String sql = "SELECT c_codigo_venta, c_total FROM t_venta" + " WHERE c_codigo_venta = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			Venta venta = new Venta();
			venta.setCodigo(rs.getInt("c_codigo_venta"));
			venta.setTotal(rs.getBigDecimal("c_total"));
			return venta;
		}, codigoVenta);

	}

}
