package co.edu.uniquindio.hotel.services;

import co.edu.uniquindio.hotel.model.ServicioDeHabitacion;
import java.util.List;

public interface IServicioServices {
    boolean agregarServicio(ServicioDeHabitacion servicio);
    ServicioDeHabitacion obtenerServicio(String nombre);
    boolean actualizarServicio(String nombre, ServicioDeHabitacion servicio);
    boolean eliminarServicio(String nombre);
    List<ServicioDeHabitacion> listarServicios();
}

