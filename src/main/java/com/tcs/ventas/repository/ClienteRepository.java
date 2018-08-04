package com.tcs.ventas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.ventas.model.Cliente;

@Repository
public class ClienteRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Cliente> getAll() {
		String sql = "SELECT c_codigo_cliente, c_nombre_cliente, c_apellido_paterno_cliente, c_apellido_materno_cliente FROM t_cliente";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Cliente cliente = new Cliente();
			cliente.setCodigo(rs.getInt("c_codigo_cliente"));
			cliente.setNombre(rs.getString("c_nombre_cliente"));
			cliente.setApellidoPaterno(rs.getString("c_apellido_paterno_cliente"));
			cliente.setApellidoMaterno(rs.getString("c_apellido_materno_cliente"));

			return cliente;
		});
	}

	public Cliente getClienteByCodigoVenta(int codigoVenta) {
		String sql = "SELECT  t_cliente.c_codigo_cliente, c_nombre_cliente, c_apellido_paterno_cliente, c_apellido_materno_cliente"
				+ " FROM (t_cliente" + " INNER JOIN t_venta ON (t_cliente.c_codigo_cliente = t_venta.c_codigo_cliente))"
				+ " WHERE t_venta.c_codigo_venta = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			Cliente cliente = new Cliente();
			cliente.setNombre(rs.getString("c_nombre_cliente"));
			cliente.setApellidoPaterno(rs.getString("c_apellido_paterno_cliente"));
			cliente.setApellidoMaterno(rs.getString("c_apellido_materno_cliente"));
			return cliente;

		}, codigoVenta);

	}

}
