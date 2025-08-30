package co.edu.uniquindio.transporte.factory;

import co.edu.uniquindio.transporte.model.*;
import co.edu.uniquindio.transporte.services.IModelFactoryServices;
import co.edu.uniquindio.transporte.builder.PropietarioBuilder;

import java.util.List;

public class ModelFactory implements IModelFactoryServices {

    // Instancia singleton
    private static ModelFactory instance;

    // Empresa principal que gestiona toda la información
    private final EmpresaTransporte empresa;

    private ModelFactory(){
        this.empresa = new EmpresaTransporte();
        inicializarDatos();
    }

    // Obtener instancia singleton
    public static ModelFactory getInstance(){
        if(instance == null) instance = new ModelFactory();
        return instance;
    }

    // Inicialización de datos de ejemplo
    private void inicializarDatos(){
        // === Propietarios ===
        Propietario p1 = new PropietarioBuilder()
                .conNombre("Pedro")
                .conNumeroIdentificacion("978978798")
                .conEmail("pedro@gmail.com")
                .conNumeroCelular("3001234567")
                .conEdad(45)
                .construir();

        Propietario p2 = new PropietarioBuilder()
                .conNombre("Ana")
                .conNumeroIdentificacion("234242323")
                .conEmail("ana@gmail.com")
                .conNumeroCelular("3019876543")
                .conEdad(30)
                .construir();

        // === Vehículos de carga ===
        VehiculoCarga vc1 = new VehiculoCarga("RRD098","2020","Volvo","Blanco",12000,5);
        VehiculoCarga vc2 = new VehiculoCarga("XXX096","2019","Chevrolet","Azul",8000,3);

        // === Vehículos de pasajeros ===
        VehiculoPasajero vp1 = new VehiculoPasajero("PAS123","2021","Toyota","Rojo",40);
        VehiculoPasajero vp2 = new VehiculoPasajero("PAS456","2022","Mercedes","Negro",30);

        // Guardar propietarios y vehículos en la empresa
        empresa.listarPropietarios().add(p1);
        empresa.listarPropietarios().add(p2);
        empresa.listarVehiculosCarga().add(vc1);
        empresa.listarVehiculosCarga().add(vc2);
        empresa.listarVehiculosPasajero().add(vp1);
        empresa.listarVehiculosPasajero().add(vp2);

        // Asociaciones de vehículos a propietarios
        p1.getListaVehiculosAsociados().add(vc1);
        p2.getListaVehiculosAsociados().add(vc2);
        p2.getListaVehiculosAsociados().add(vp1);
    }

    // === Propietarios ===
    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int edad) {
        // Crear propietario usando Builder
        Propietario p = new PropietarioBuilder()
                .conNombre(nombre)
                .conNumeroIdentificacion(numeroIdentificacion)
                .conEmail(email)
                .conNumeroCelular(numeroCelular)
                .conEdad(edad)
                .construir();
        return empresa.listarPropietarios().add(p);
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion) { return empresa.obtenerPropietario(numeroIdentificacion); }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion) { return empresa.eliminarPropietario(numeroIdentificacion); }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion,
                                         String email, String numeroCelular, int edad)
    {
        Propietario p = empresa.obtenerPropietario(numeroIdentificacionActual);
        if(p == null) return false;

        // Actualizar propietario usando Builder
        Propietario actualizado = new PropietarioBuilder()
                .conNombre(nombre)
                .conNumeroIdentificacion(numeroIdentificacion)
                .conEmail(email)
                .conNumeroCelular(numeroCelular)
                .conEdad(edad)
                .construir();

        p.setNombre(actualizado.getNombre());
        p.setNumeroIdentificacion(actualizado.getNumeroIdentificacion());
        p.setEmail(actualizado.getEmail());
        p.setNumeroCelular(actualizado.getNumeroCelular());
        p.setEdad(actualizado.getEdad());

        return true;
    }

    @Override
    public List<Propietario> listarPropietarios() { return empresa.listarPropietarios(); }

    // === Vehículos de carga ===
    @Override public boolean agregarVehiculoCarga(VehiculoCarga vehiculo)
    {
        return empresa.agregarVehiculoCarga(vehiculo); }

    @Override public VehiculoCarga obtenerVehiculoCarga(String placa)
    {
        return empresa.obtenerVehiculoCarga(placa); }

    @Override public boolean actualizarVehiculoCarga(String placaActual, String placa, String modelo, String marca,
                                                     String color, double capacidadCarga, int numeroEjes)
    {
        return empresa.actualizarVehiculoCarga(placaActual, placa, modelo, marca, color, capacidadCarga, numeroEjes);
    }
    @Override public boolean eliminarVehiculoCarga(String placa)
    { return empresa.eliminarVehiculoCarga(placa); }
    @Override public List<VehiculoCarga> listarVehiculosCarga()
    { return empresa.listarVehiculosCarga(); }

    // === Vehículos de pasajeros ===
    @Override public boolean agregarVehiculoPasajero(VehiculoPasajero vehiculo)
    { return empresa.agregarVehiculoPasajero(vehiculo); }
    @Override public VehiculoPasajero obtenerVehiculoPasajero(String placa)
    { return empresa.obtenerVehiculoPasajero(placa); }
    @Override public boolean actualizarVehiculoPasajero(String placaActual, String placa, String modelo, String marca, String color, int numeroMaximoPasajeros) {
        return empresa.actualizarVehiculoPasajero(placaActual, placa, modelo, marca, color, numeroMaximoPasajeros);
    }
    @Override public boolean eliminarVehiculoPasajero(String placa) { return empresa.eliminarVehiculoPasajero(placa); }
    @Override public List<VehiculoPasajero> listarVehiculosPasajero() { return empresa.listarVehiculosPasajero(); }

    // === Asociación y consultas ===
    @Override public boolean asociarVehiculoAPropietario(String idPropietario, String placaVehiculo)
    { return empresa.asociarVehiculoAPropietario(idPropietario, placaVehiculo); }
    @Override public List<Propietario> propietariosPorPeso(double pesoMinimo)
    { return empresa.propietariosPorPeso(pesoMinimo); }
    @Override public int pasajerosPorVehiculo(String placa)
    { return empresa.pasajerosPorVehiculo(placa); }
    @Override public int contarPropietariosMayores40() { return empresa.contarPropietariosMayores40(); }

    // === Búsquedas ===
    @Override public String buscarPropietarioNombre(String nombre)
    { return empresa.buscarPropietarioNombre(nombre); }
    @Override public String buscarVehiculoPorPlaca(String placa)
    { return empresa.buscarVehiculoPorPlaca(placa); }
}
