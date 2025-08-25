package co.edu.uniquindio.transporte.services;

import co.edu.uniquindio.transporte.model.VehiculoCarga;
import co.edu.uniquindio.transporte.model.VehiculoPasajero;
import co.edu.uniquindio.transporte.model.Propietario;
import java.util.List;

public interface IEmpresaTransportServices extends IPropietarioServices {

    // Vehículos de carga
    boolean agregarVehiculoCarga(VehiculoCarga vehiculo);
    VehiculoCarga obtenerVehiculoCarga(String placa);
    boolean actualizarVehiculoCarga(String placaActual, String placa, String modelo, String marca, String color, double capacidadCarga, int numeroEjes);
    boolean eliminarVehiculoCarga(String placa);
    List<VehiculoCarga> listarVehiculosCarga();

    // Vehículos de pasajeros
    boolean agregarVehiculoPasajero(VehiculoPasajero vehiculo);
    VehiculoPasajero obtenerVehiculoPasajero(String placa);
    boolean actualizarVehiculoPasajero(String placaActual, String placa, String modelo, String marca, String color, int numeroMaximoPasajeros);
    boolean eliminarVehiculoPasajero(String placa);
    List<VehiculoPasajero> listarVehiculosPasajero();

    // Asociación y consultas
    boolean asociarVehiculoAPropietario(String idPropietario, String placaVehiculo);
    List<Propietario> propietariosPorPeso(double pesoMinimo);
    int pasajerosPorVehiculo(String placa);
    int contarPropietariosMayores40();

    // Búsquedas
    String buscarPropietarioNombre(String nombre);
    String buscarVehiculoPorPlaca(String placa);
}
