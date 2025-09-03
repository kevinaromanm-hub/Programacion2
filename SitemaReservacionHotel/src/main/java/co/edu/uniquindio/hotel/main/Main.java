package co.edu.uniquindio.hotel.main;

import co.edu.uniquindio.hotel.builder.ClienteBuilder;
import co.edu.uniquindio.hotel.factory.ModelFactory;
import co.edu.uniquindio.hotel.model.*;

import javax.swing.*;
import java.util.List;

public class Main {

    private static final ModelFactory factory = ModelFactory.getInstance();

    public static void main(String[] args) {
        factory.inicializarDatos(); // inicializa datos de prueba usando builder con nulos
        menuPrincipal();
    }

    private static void menuPrincipal() {
        String[] opciones = {"Clientes", "Habitaciones", "Reservas", "Servicios", "Ejercicios", "Salir"};
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Hotel v2",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case 0 -> menuClientes();
                case 1 -> menuHabitaciones();
                case 2 -> menuReservas();
                case 3 -> menuServicios();
                case 4 -> menuEjercicios();
            }
        } while (opcion != 5);
    }

    // Menu Clientes
    private static void menuClientes() {
        String[] opciones = {"Listar", "Agregar", "Modificar", "Eliminar", "Volver"};
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Clientes", "Menu Clientes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case 0 -> listarClientes();
                case 1 -> agregarCliente();
                case 2 -> modificarCliente();
                case 3 -> eliminarCliente();
            }
        } while (opcion != 4);
    }

    private static void listarClientes() {
        List<Cliente> clientes = factory.listarClientes();
        String res = "Clientes:\n";
        for (Cliente c : clientes) res += c + "\n";
        JOptionPane.showMessageDialog(null, res);
    }

    private static void agregarCliente() {
        String id = JOptionPane.showInputDialog("ID obligatorio:");
        if (id == null || id.isEmpty()) return;
        String nombre = JOptionPane.showInputDialog("Nombre (opcional):");
        String telefono = JOptionPane.showInputDialog("Teléfono (opcional):");
        String correo = JOptionPane.showInputDialog("Correo (opcional):");
        int edad = 0;
        String edadStr = JOptionPane.showInputDialog("Edad (opcional, entero):");
        if (edadStr != null && !edadStr.isEmpty()) {
            try { edad = Integer.parseInt(edadStr); } catch (NumberFormatException ignored) {}
        }
        factory.agregarCliente(new ClienteBuilder().id(id).nombre(nombre).telefono(telefono).correo(correo).edad(edad).build());
    }

    private static void modificarCliente() {
        String idActual = JOptionPane.showInputDialog("ID Cliente a modificar:");
        Cliente c = factory.obtenerCliente(idActual);
        if (c == null) { JOptionPane.showMessageDialog(null,"No existe ese cliente"); return; }
        String nombre = JOptionPane.showInputDialog("Nuevo Nombre:", c.getNombre());
        String telefono = JOptionPane.showInputDialog("Nuevo Teléfono:", c.getTelefono());
        String correo = JOptionPane.showInputDialog("Nuevo Correo:", c.getCorreo());
        String edadStr = JOptionPane.showInputDialog("Nueva Edad:", c.getEdad());
        int edad = c.getEdad();
        if (edadStr != null && !edadStr.isEmpty()) {
            try { edad = Integer.parseInt(edadStr); } catch (NumberFormatException ignored) {}
        }
        factory.modificarCliente(idActual, nombre, telefono, correo, edad);
    }

    private static void eliminarCliente() {
        String id = JOptionPane.showInputDialog("ID Cliente a eliminar:");
        factory.eliminarCliente(id);
    }

    // Menu Habitaciones
    private static void menuHabitaciones() {
        String[] opciones = {"Listar", "Agregar Estandar", "Agregar Suite", "Modificar", "Eliminar", "Volver"};
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Habitaciones", "Menu Habitaciones",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case 0 -> listarHabitaciones();
                case 1 -> agregarHabitacionEstandar();
                case 2 -> agregarHabitacionSuite();
                case 3 -> modificarHabitacion();
                case 4 -> eliminarHabitacion();
            }
        } while (opcion != 5);
    }

    private static void listarHabitaciones() {
        List<Habitacion> habitaciones = factory.listarHabitaciones();
        String res = "Habitaciones:\n";
        for (Habitacion h : habitaciones) {
            res += h + " Servicios: ";
            for (ServicioDeHabitacion s : h.getServicios()) res += s.getNombre() + " ";
            res += "\n";
        }
        JOptionPane.showMessageDialog(null, res);
    }

    private static void agregarHabitacionEstandar() {
        String numero = JOptionPane.showInputDialog("Número:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
        factory.agregarHabitacion(new HabitacionEstandar(numero, precio));
    }

    private static void agregarHabitacionSuite() {
        String numero = JOptionPane.showInputDialog("Número:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
        factory.agregarHabitacion(new HabitacionSuite(numero, precio));
    }

    private static void modificarHabitacion() {
        String numeroActual = JOptionPane.showInputDialog("Número de habitación a modificar:");
        Habitacion h = factory.obtenerHabitacion(numeroActual);
        if (h == null) { JOptionPane.showMessageDialog(null,"No existe esa habitación"); return; }
        String numeroNuevo = JOptionPane.showInputDialog("Nuevo número:", h.getNumero());
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", h.getPrecio()));
        Habitacion nueva = h instanceof HabitacionSuite ? new HabitacionSuite(numeroNuevo, precio) : new HabitacionEstandar(numeroNuevo, precio);
        factory.modificarHabitacion(numeroActual, precio);
    }

    private static void eliminarHabitacion() {
        String numero = JOptionPane.showInputDialog("Número de habitación a eliminar:");
        factory.eliminarHabitacion(numero);
    }

    // Menu Reservas
    private static void menuReservas() {
        String[] opciones = {"Listar", "Agregar", "Modificar", "Eliminar", "Volver"};
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Reservas", "Menu Reservas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case 0 -> listarReservas();
                case 1 -> agregarReserva();
                case 2 -> modificarReserva();
                case 3 -> eliminarReserva();
            }
        } while (opcion != 4);
    }

    private static void listarReservas() {
        List<Reserva> reservas = factory.listarReservas();
        String res = "Reservas:\n";
        for (Reserva r : reservas) res += r + "\n";
        JOptionPane.showMessageDialog(null, res);
    }

    private static void agregarReserva() {
        String id = JOptionPane.showInputDialog("ID Reserva:");
        String idCliente = JOptionPane.showInputDialog("ID Cliente:");
        String numeroH = JOptionPane.showInputDialog("Número de habitación:");
        String fechaEntrada = JOptionPane.showInputDialog("Fecha Entrada:");
        String fechaSalida = JOptionPane.showInputDialog("Fecha Salida:");
        factory.agregarReserva(id, idCliente, numeroH, fechaEntrada, fechaSalida);
    }

    private static void modificarReserva() {
        String idReserva = JOptionPane.showInputDialog("ID Reserva a modificar:");
        Reserva r = factory.obtenerReserva(idReserva);
        if (r == null) { JOptionPane.showMessageDialog(null,"No existe esa reserva"); return; }
        String idCliente = JOptionPane.showInputDialog("Nuevo ID Cliente:", r.getCliente().getId());
        String numeroH = JOptionPane.showInputDialog("Nueva Habitación:", r.getHabitacion().getNumero());
        String fechaEntrada = JOptionPane.showInputDialog("Nueva Fecha Entrada:", r.getFechaEntrada());
        String fechaSalida = JOptionPane.showInputDialog("Nueva Fecha Salida:", r.getFechaSalida());
        factory.modificarReserva(idReserva, idCliente, numeroH, fechaEntrada, fechaSalida);
    }

    private static void eliminarReserva() {
        String id = JOptionPane.showInputDialog("ID Reserva a eliminar:");
        factory.eliminarReserva(id);
    }

    // Menu Servicios
    private static void menuServicios() {
        String[] opciones = {"Listar", "Agregar a Habitacion", "Modificar", "Eliminar", "Volver"};
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Servicios", "Menu Servicios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case 0 -> listarServicios();
                case 1 -> agregarServicio();
                case 2 -> modificarServicio();
                case 3 -> eliminarServicio();
            }
        } while (opcion != 4);
    }

    private static void listarServicios() {
        List<ServicioDeHabitacion> servicios = factory.listarServicios();
        String res = "Servicios:\n";
        for (ServicioDeHabitacion s : servicios) res += s + "\n";
        JOptionPane.showMessageDialog(null, res);
    }

    private static void agregarServicio() {
        String idServicio = JOptionPane.showInputDialog("ID del servicio:");
        String nombre = JOptionPane.showInputDialog("Nombre del servicio:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio:"));
        String descripcion = JOptionPane.showInputDialog("Descripción del servicio:");
        String numeroH = JOptionPane.showInputDialog("Número de habitación para agregar:");

        ServicioDeHabitacion servicio = new ServicioDeHabitacion(idServicio, nombre, precio, descripcion);
        factory.agregarServicio(servicio, numeroH);
    }

    private static void modificarServicio() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del servicio a modificar:");
        String nombre = JOptionPane.showInputDialog("Nuevo nombre:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:"));
        String descripcion = JOptionPane.showInputDialog("Nueva descripción:");

        factory.modificarServicio(id, nombre, precio, descripcion);
        JOptionPane.showMessageDialog(null, "Servicio modificado correctamente.");
    }

    private static void eliminarServicio() {
        String nombre = JOptionPane.showInputDialog("Nombre de servicio a eliminar:");
        factory.eliminarServicio(nombre);
    }

    // Ejercicios
    private static void menuEjercicios() {
        String[] opciones = {
                "Buscar Reserva por ID",
                "Clientes mayores a cierta edad",
                "Listar Reservas de un Cliente",
                "Listar Habitaciones por Servicio",
                "Volver"
        };
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Ejercicios", "Menu Ejercicios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case 0 -> {
                    String id = JOptionPane.showInputDialog("ID Reserva:");
                    Reserva r = factory.buscarReservaPorId(id);
                    JOptionPane.showMessageDialog(null, r != null ? r : "No encontrada");
                }
                case 1 -> {
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad mínima:"));
                    List<Cliente> clientes = factory.buscarClientesMayoresA(edad);
                    JOptionPane.showMessageDialog(null, clientes.isEmpty() ? "No hay clientes" : clientes);
                }
                case 2 -> {
                    String idCliente = JOptionPane.showInputDialog("ID Cliente:");
                    List<Reserva> reservas = factory.listarReservasDeCliente(idCliente);
                    JOptionPane.showMessageDialog(null, reservas.isEmpty() ? "No tiene reservas" : reservas);
                }
                case 3 -> {
                    String nombreServicio = JOptionPane.showInputDialog("Nombre del Servicio:");
                    List<Habitacion> habitaciones = factory.listarHabitacionesConServicio(nombreServicio);
                    JOptionPane.showMessageDialog(null, habitaciones.isEmpty() ? "No hay habitaciones con ese servicio" : habitaciones);
                }
            }
        } while (opcion != 4);
    }
}

