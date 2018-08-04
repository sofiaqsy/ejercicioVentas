package com.tcs.ventas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.tcs.ventas.model.VentaDetalle;

@Repository
public class VentaDetalleRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<VentaDetalle> getVentaDetalleByIdVenta(int codigoVenta) {
		String sql = "SELECT t_venta_detalle.c_codigo_producto, c_precio_unitario, c_cantidad, c_nombre_producto "+
					 "FROM (t_venta_detalle "+
					 " INNER JOIN t_producto ON (t_venta_detalle.c_codigo_producto = t_producto.c_codigo_producto))"+
				     " WHERE t_venta_detalle.c_codigo_venta = ?";
		
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			VentaDetalle ventaDetalle = new VentaDetalle();
			ventaDetalle.setCodigoProducto(rs.getInt("c_codigo_producto"));
			ventaDetalle.setPrecioUnitario(rs.getBigDecimal("c_precio_unitario"));
			ventaDetalle.setCantidad(rs.getBigDecimal("c_cantidad"));
			ventaDetalle.setNombreProducto(rs.getString("c_nombre_producto"));

			return ventaDetalle;
		}, codigoVenta);
	}
	
	

}
