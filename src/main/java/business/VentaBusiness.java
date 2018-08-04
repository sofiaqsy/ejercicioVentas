package business;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ventas.model.Venta;
import com.tcs.ventas.model.VentaDetalle;
import com.tcs.ventas.repository.ClienteRepository;
import com.tcs.ventas.repository.VentaDetalleRepository;

@Service
public class VentaBusiness {
	
	@Autowired
	private VentaDetalleRepository ventaDetalleRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<VentaDetalle> getVentaDetalleByIdVenta(int codigoVenta) {
		return ventaDetalleRepository.getVentaDetalleByIdVenta(codigoVenta);
	}
	
	public Venta getVentaByCodigoVenta( int codigoVenta ){
		
		Venta venta = new Venta();
		
		BigDecimal itemCost  = BigDecimal.ZERO;
	    BigDecimal totalCost = BigDecimal.ZERO;
	
		List<VentaDetalle> ventaDetalle = ventaDetalleRepository.getVentaDetalleByIdVenta(codigoVenta);
		  
		for(VentaDetalle detalles : ventaDetalle) {
			 itemCost  = detalles.getCantidad().multiply(detalles.getPrecioUnitario());
		     totalCost = totalCost.add(itemCost);
		     detalles.setSubTotal(itemCost);
		}

		venta.setTotal(totalCost);
		venta.setCliente(clienteRepository.getClienteByCodigoVenta(codigoVenta));
		venta.setListVentaDetalle(ventaDetalle);
		return venta;
	}

}
