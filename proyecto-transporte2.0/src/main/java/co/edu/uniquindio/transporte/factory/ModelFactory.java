package co.edu.uniquindio.transporte.factory;

import co.edu.uniquindio.transporte.model.*;
import co.edu.uniquindio.transporte.services.IModelFactoryServices;

import java.util.List;

public class ModelFactory implements IModelFactoryServices {

    private static ModelFactory instance;
    private final EmpresaTransporte empresa;

    private ModelFactory(){
        this.empresa = new EmpresaTransporte();
        inicializarDatos();
    }

    public static ModelFactory getInstance(){
        if(instance == null) instance = new ModelFactory();
        return instance;
    }

    private void inicializarDatos(){
        // Propietarios
        Propietario p1 = new Propietario("Pedro","978978798","pedro@gmail.com","3001234567",45);
        Propietario p2 = new Propietario("Ana","234242323","ana@gmail.com","3019876543",30);

        // Vehículos
        VehiculoCarga vc1 = new VehiculoCarga("RRD098","2020","Volvo","Blanco",12000,5);
        VehiculoCarga vc2 = new VehiculoCarga("XXX096","2019","Chevrolet","Azul",8000,3);
        VehiculoPasajero vp1 = new VehiculoPasajero("PAS123","2021","Toyota","Rojo",40);
        VehiculoPasajero vp2 = new VehiculoPasajero("PAS456","2022","Mercedes","Negro",30);

        // Guardar
        empresa.listarPropietarios().add(p1);
        empresa.listarPropietarios().add(p2);
        empresa.listarVehiculosCarga().add(vc1);
        empresa.listarVehiculosCarga().add(vc2);
        empresa.listarVehiculosPasajero().add(vp1);
        empresa.listarVehiculosPasajero().add(vp2);

        // Asociaciones
        p1.getListaVehiculosAsociados().add(vc1);
        p2.getListaVehiculosAsociados().add(vc2);
        p2.getListaVehiculosAsociados().add(vp1);
    }

    // === Propietarios ===
    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int edad) {
        return empresa.agregarPropietario(nombre, numeroIdentificacion, email, numeroCelular, edad);
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) { return empresa.obtenerPropietario(numeroIdentificacion); }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) { return empresa.eliminarPropietario(numeroIdentificacion); }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion, String email, String numeroCelular, int edad) {
        return empresa.actualizarPropietario(nombre, numeroIdentificacionActual, numeroIdentificacion, email, numeroCelular, edad);
    }

    @Override
    public List<Propietario> listarPropietarios() { return empresa.listarPropietarios(); }

    // === Vehículos de Carga ===
    @Override
    public boolean agregarVehiculoCarga(VehiculoCarga vehiculo) { return empresa.agregarVehiculoCarga(vehiculo); }

    @Override
    public VehiculoCarga obtenerVehiculoCarga(String placa) { return empresa.obtenerVehiculoCarga(placa); }

    @Override
    public boolean actualizarVehiculoCarga(String placaActual, String placa, String modelo, String marca, String color, double capacidadCarga, int numeroEjes) {
        return empresa.actualizarVehiculoCarga(placaActual, placa, modelo, marca, color, capacidadCarga, numeroEjes);
    }

    @Override
    public boolean eliminarVehiculoCarga(String placa) { return empresa.eliminarVehiculoCarga(placa); }

    @Override
    public List<VehiculoCarga> listarVehiculosCarga() { return empresa.listarVehiculosCarga(); }

    // === Vehículos de Pasajero ===
    @Override
    public boolean agregarVehiculoPasajero(VehiculoPasajero vehiculo) { return empresa.agregarVehiculoPasajero(vehiculo); }

    @Override
    public VehiculoPasajero obtenerVehiculoPasajero(String placa) { return empresa.obtenerVehiculoPasajero(placa); }

    @Override
    public boolean actualizarVehiculoPasajero(String placaActual, String placa, String modelo, String marca, String color, int numeroMaximoPasajeros) {
        return empresa.actualizarVehiculoPasajero(placaActual, placa, modelo, marca, color, numeroMaximoPasajeros);
    }

    @Override
    public boolean eliminarVehiculoPasajero(String placa) { return empresa.eliminarVehiculoPasajero(placa); }

    @Override
    public List<VehiculoPasajero> listarVehiculosPasajero() { return empresa.listarVehiculosPasajero(); }

    // === Asociación y Consultas ===
    @Override
    public boolean asociarVehiculoAPropietario(String idPropietario, String placaVehiculo) {
        return empresa.asociarVehiculoAPropietario(idPropietario, placaVehiculo);
    }

    @Override
    public List<Propietario> propietariosPorPeso(double pesoMinimo) { return empresa.propietariosPorPeso(pesoMinimo); }

    @Override
    public int pasajerosPorVehiculo(String placa) { return empresa.pasajerosPorVehiculo(placa); }

    @Override
    public int contarPropietariosMayores40() { return empresa.contarPropietariosMayores40(); }

    // === Búsquedas ===
    @Override
    public String buscarPropietarioNombre(String nombre) { return empresa.buscarPropietarioNombre(nombre); }

    @Override
    public String buscarVehiculoPorPlaca(String placa) { return empresa.buscarVehiculoPorPlaca(placa); }
}
