package co.edu.uniquindio.hotel.services;

import co.edu.uniquindio.hotel.model.Habitacion;
import java.util.List;

public interface IHotelServices {
    List<Habitacion> listarHabitacionesConServicio(String nombreServicio);
}




