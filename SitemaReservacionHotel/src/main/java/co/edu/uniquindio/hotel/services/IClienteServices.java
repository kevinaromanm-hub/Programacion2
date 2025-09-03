package co.edu.uniquindio.hotel.services;

import co.edu.uniquindio.hotel.model.Cliente;
import java.util.List;

public interface IClienteServices {
    boolean agregarCliente(String nombre, String id, String telefono, String correo, int edad);
    Cliente obtenerCliente(String id);
    boolean actualizarCliente(String nombre, String idActual, String id, String telefono, String correo, int edad);
    boolean eliminarCliente(String id);
    List<Cliente> listarClientes();
}


