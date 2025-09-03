package co.edu.uniquindio.hotel.services;

import co.edu.uniquindio.hotel.model.Reserva;
import java.util.List;

public interface IReservaServices {
    boolean agregarReserva(String idReserva, String idCliente, String numeroHabitacion, String fechaEntrada, String fechaSalida);
    Reserva obtenerReserva(String idReserva);
    boolean actualizarReserva(String idReserva, String idCliente, String numeroHabitacion, String fechaEntrada, String fechaSalida);
    boolean eliminarReserva(String idReserva);
    List<Reserva> listarReservas();
}



