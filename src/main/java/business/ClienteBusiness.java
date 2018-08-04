package business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ventas.model.Cliente;
import com.tcs.ventas.repository.ClienteRepository;

@Service
public class ClienteBusiness {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> getAll() {
		return clienteRepository.getAll();
	}
	
	public Cliente getClienteByCodigoVenta(int codigoVenta) {
		return clienteRepository.getClienteByCodigoVenta(codigoVenta);
	}

}
