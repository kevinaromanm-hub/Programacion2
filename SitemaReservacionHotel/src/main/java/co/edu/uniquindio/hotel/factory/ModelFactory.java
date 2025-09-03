
package co.edu.uniquindio.hotel.factory;

import co.edu.uniquindio.hotel.builder.ClienteBuilder;
import co.edu.uniquindio.hotel.model.*;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    private static ModelFactory instance;
    private Hotel hotel;

    private ModelFactory() { hotel = new Hotel(); }

    public static ModelFactory getInstance() {
        if (instance == null) instance = new ModelFactory();
        return instance;
    }

    // Clientes
    public boolean agregarCliente(Cliente c) {
        return hotel.getListaClientes().add(c);
    }

    public Cliente obtenerCliente(String id) {
        for (Cliente c : hotel.getListaClientes()) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }
    public boolean modificarCliente(String idCliente, String nuevoNombre, String nuevoTelefono, String nuevoCorreo, int nuevaEdad) {
        for (Cliente c : hotel.getListaClientes()) {
            if (c.getId().equals(idCliente)) {
                c.setNombre(nuevoNombre);
                c.setTelefono(nuevoTelefono);
                c.setCorreo(nuevoCorreo);
                c.setEdad(nuevaEdad);
                return true; // Modificado correctamente
            }
        }
        return false; // No se encontró el cliente
    }


    public boolean eliminarCliente(String id) {
        Cliente c = obtenerCliente(id);
        if (c != null) return hotel.getListaClientes().remove(c);
        return false;
    }

    public List<Cliente> listarClientes() { return hotel.getListaClientes(); }

    // Habitaciones
    public boolean agregarHabitacion(Habitacion h) { return hotel.getListaHabitaciones().add(h); }

    public Habitacion obtenerHabitacion(String numero) {
        for (Habitacion h : hotel.getListaHabitaciones()) {
            if (h.getNumero().equals(numero)) return h;
        }
        return null;
    }

    public boolean modificarHabitacion(String numeroHabitacion, double nuevoPrecio) {
        for (Habitacion h : hotel.getListaHabitaciones()) {
            if (h.getNumero().equals(numeroHabitacion)) {
                h.setPrecio(nuevoPrecio);
                return true; // Modificado correctamente
            }
        }
        return false; // No se encontró la habitación
    }

    public boolean eliminarHabitacion(String numero) {
        Habitacion h = obtenerHabitacion(numero);
        if (h != null) return hotel.getListaHabitaciones().remove(h);
        return false;
    }

    public List<Habitacion> listarHabitaciones() { return hotel.getListaHabitaciones(); }

    // Reservas
    public boolean agregarReserva(String idReserva, String idCliente, String numeroHabitacion, String fechaEntrada, String fechaSalida) {
        Cliente c = obtenerCliente(idCliente);
        Habitacion h = obtenerHabitacion(numeroHabitacion);
        if (c != null && h != null) {
            Reserva r = new Reserva(idReserva, c, h, fechaEntrada, fechaSalida);
            c.getReservas().add(r);
            return hotel.getListaReservas().add(r);
        }
        return false;
    }

    public Reserva obtenerReserva(String idReserva) {
        for (Reserva r : hotel.getListaReservas()) {
            if (r.getId().equals(idReserva)) return r;
        }
        return null;
    }

    public boolean eliminarReserva(String idReserva) {
        Reserva r = obtenerReserva(idReserva);
        if (r != null) {
            r.getCliente().getReservas().remove(r);
            return hotel.getListaReservas().remove(r);
        }
        return false;
    }
    public boolean modificarReserva(String idReserva, String nuevoIdCliente, String nuevoNumeroHabitacion, String nuevaFechaEntrada, String nuevaFechaSalida) {
        for (Reserva r : hotel.getListaReservas()) {
            if (r.getId().equals(idReserva)) {
                Cliente c = obtenerCliente(nuevoIdCliente);
                Habitacion h = obtenerHabitacion(nuevoNumeroHabitacion);
                if (c != null && h != null) {
                    r.setCliente(c);
                    r.setHabitacion(h);
                    r.setFechaEntrada(nuevaFechaEntrada);
                    r.setFechaSalida(nuevaFechaSalida);
                    return true; // Modificado correctamente
                } else {
                    return false; // Cliente o habitación no encontrados
                }
            }
        }
        return false; // No se encontró la reserva
    }

    public List<Reserva> listarReservas() { return hotel.getListaReservas(); }

    // Servicios
    public boolean agregarServicio(ServicioDeHabitacion s, String numeroHabitacion) {
        Habitacion h = obtenerHabitacion(numeroHabitacion);
        if (h != null) {
            h.getServicios().add(s);
            return hotel.getListaServicios().add(s);
        }
        return false;
    }

    public ServicioDeHabitacion obtenerServicio(String nombre) {
        for (ServicioDeHabitacion s : hotel.getListaServicios()) {
            if (s.getNombre().equals(nombre)) return s;
        }
        return null;
    }
    public boolean modificarServicio(String idServicio, String nuevoNombre, double nuevoPrecio, String nuevaDescripcion) {
        for (ServicioDeHabitacion s : hotel.getListaServicios()) {
            if (s.getIdServicio().equals(idServicio)) {
                s.setNombre(nuevoNombre);
                s.setPrecio(nuevoPrecio);
                s.setDescripcion(nuevaDescripcion);
                return true; // Se modificó correctamente
            }
        }
        return false; // No se encontró el servicio
    }

    public boolean eliminarServicio(String nombre) {
        ServicioDeHabitacion s = obtenerServicio(nombre);
        if (s != null) return hotel.getListaServicios().remove(s);
        return false;
    }

    public List<ServicioDeHabitacion> listarServicios() { return hotel.getListaServicios(); }

    // Métodos de ejemplo
    public Reserva buscarReservaPorId(String id) { return obtenerReserva(id); }

    public List<Cliente> buscarClientesMayoresA(int edad) {
        List<Cliente> res = new ArrayList<>();
        for (Cliente c : hotel.getListaClientes()) {
            if (c.getEdad() > edad) res.add(c);
        }
        return res;
    }


    // Devuelve todas las habitaciones que tienen un servicio específico
    public List<Habitacion> listarHabitacionesConServicio(String nombreServicio) {
        List<Habitacion> resultado = new ArrayList<>();
        for (Habitacion h : hotel.getListaHabitaciones()) {
            for (ServicioDeHabitacion s : h.getServicios()) {
                if (s.getNombre().equalsIgnoreCase(nombreServicio)) {
                    resultado.add(h);
                    break; // una vez encontrado, no hace falta seguir revisando ese h
                }
            }
        }
        return resultado;
    }

    public List<Reserva> listarReservasDeCliente(String idCliente) {
        Cliente c = obtenerCliente(idCliente);
        if (c != null) {
            return c.getReservas(); // devuelve la lista de reservas del cliente
        }
        return new ArrayList<>(); // si no existe el cliente, devuelve lista vacía
    }

    // Inicializar datos de prueba
    public void inicializarDatos() {
        // Clientes con builder, datos opcionales nulos
        agregarCliente(new ClienteBuilder().id("001").nombre("Walter").telefono("3001112222").correo("walter@gmail.com").edad(25).build());
        agregarCliente(new ClienteBuilder().id("002").nombre("Elena").telefono("3003334444").correo("Elena@mail.com").edad(35).build());
        agregarCliente(new ClienteBuilder().id("003").build());

        // Habitaciones
        Habitacion h1 = new HabitacionEstandar("101", 100000);
        Habitacion h2 = new HabitacionSuite("201", 250000);
        agregarHabitacion(h1);
        agregarHabitacion(h2);

        // Servicios asociados
        ServicioDeHabitacion s1 = new ServicioDeHabitacion("S1", "Servicio de comida a la habitación", 50000, "Incluye desayuno en la habitación");
        ServicioDeHabitacion s2 = new ServicioDeHabitacion("S2", "Servicio de limpieza extra", 30000, "Limpieza adicional bajo pedido");

        agregarServicio(s1, "101");
        agregarServicio(s2, "201");

        // Reservas
        agregarReserva("R1", "001", "101", "2025-09-01", "2025-09-03");
        agregarReserva("R2", "002", "201", "2025-09-05", "2025-09-08");
    }
}

