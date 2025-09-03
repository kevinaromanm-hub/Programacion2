package co.edu.uniquindio.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Habitacion> listaHabitaciones = new ArrayList<>();
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<ServicioDeHabitacion> listaServicios = new ArrayList<>();

    public List<Cliente> getListaClientes() { return listaClientes; }
    public List<Habitacion> getListaHabitaciones() { return listaHabitaciones; }
    public List<Reserva> getListaReservas() { return listaReservas; }
    public List<ServicioDeHabitacion> getListaServicios() { return listaServicios; }
}







