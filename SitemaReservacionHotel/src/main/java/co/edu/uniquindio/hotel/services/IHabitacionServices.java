package co.edu.uniquindio.hotel.services;

import co.edu.uniquindio.hotel.model.Habitacion;
import java.util.List;

public interface IHabitacionServices {
    boolean agregarHabitacion(Habitacion habitacion);
    Habitacion obtenerHabitacion(String numero);
    boolean actualizarHabitacion(String numeroActual, Habitacion habitacion);
    boolean eliminarHabitacion(String numero);
    List<Habitacion> listarHabitaciones();
}




