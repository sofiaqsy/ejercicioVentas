package com.tcs.ventas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.ventas.model.Producto;

@Repository
public class ProductoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Producto> getAll() {
		String sql = "SELECT c_codigo_producto, c_nombre_producto, c_precio_base FROM t_producto";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Producto producto = new Producto();
			producto.setCodigo(rs.getInt("c_codigo_producto"));
			producto.setNombre(rs.getString("c_nombre_producto"));
			producto.setPrecio(rs.getBigDecimal("c_precio_base"));
			return producto;
		});
	}

	public Producto getById(int codigoProducto) {
		String sql = "SELECT c_codigo_producto, c_nombre_producto, c_precio_base FROM t_producto"
				+ " WHERE c_codigo_producto = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			Producto producto = new Producto();
			producto.setCodigo(rs.getInt("c_codigo_producto"));
			producto.setNombre(rs.getString("c_nombre_producto"));
			producto.setPrecio(rs.getBigDecimal("c_precio_base"));
			return producto;
		}, codigoProducto);
	}

	private int getNextId() {
		String sql = "SELECT MAX(c_codigo_producto) + 1 FROM t_producto";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	public int insert(Producto producto) {
		String sql = "INSERT INTO t_producto (c_codigo_producto, c_nombre_producto, c_precio_base)"
				+ " VALUES (?, ?, ?)";
		int newId = getNextId();
		System.out.println(newId);
		jdbcTemplate.update(sql, newId, producto.getNombre(), producto.getPrecio());
		return newId;
	}

	public int update(Producto producto) {
		String sql = "UPDATE t_producto SET" + " c_nombre_producto = ?," + " c_precio_base = ?"
				+ " WHERE c_codigo_producto = ?";
		return jdbcTemplate.update(sql, producto.getNombre(), producto.getPrecio(), producto.getCodigo());
	}

	public int delete(int codigoProducto) {
		String sql = "DELETE FROM t_producto WHERE c_codigo_producto = ?";
		return jdbcTemplate.update(sql, codigoProducto);
	}

}
