package com.tcs.ventas.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.ventas.model.Venta;

@Repository
public class VentaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;



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
