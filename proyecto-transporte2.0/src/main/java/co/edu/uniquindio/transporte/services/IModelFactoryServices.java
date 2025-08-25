package co.edu.uniquindio.transporte.services;

import co.edu.uniquindio.transporte.model.Propietario;

public interface IModelFactoryServices extends IPropietarioServices {
    String buscarVehiculoCargaPlaca(String placa);
    String buscarPropietarioNombre(String nombre);
}
