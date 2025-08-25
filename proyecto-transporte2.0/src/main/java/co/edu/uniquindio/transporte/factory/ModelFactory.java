package co.edu.uniquindio.transporte.factory;

import co.edu.uniquindio.transporte.model.*;
import co.edu.uniquindio.transporte.services.IModelFactoryServices;

public class ModelFactory implements IModelFactoryServices {
    private static ModelFactory instance;
    private EmpresaTransporte empresa;

    private ModelFactory(){
        empresa = new EmpresaTransporte();
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

        // Vehiculos
        VehiculoCarga vc1 = new VehiculoCarga("RRD098","2020","Volvo","Blanco",12000,5);
        VehiculoCarga vc2 = new VehiculoCarga("XXX096","2019","Chevrolet","Azul",8000,3);
        VehiculoPasajero vp1 = new VehiculoPasajero("PAS123","2021","Toyota","Rojo",40);
        VehiculoPasajero vp2 = new VehiculoPasajero("PAS456","2022","Mercedes","Negro",30);

        // Asociaciones
        p1.getListaVehiculosAsociados().add(vc1);
        p2.getListaVehiculosAsociados().add(vc2);
        p2.getListaVehiculosAsociados().add(vp1);

        // Guardar en empresa
        empresa.getListaPropietarios().add(p1);
        empresa.getListaPropietarios().add(p2);
        empresa.getListaVehiculosCarga().add(vc1);
        empresa.getListaVehiculosCarga().add(vc2);
        empresa.getListaVehiculosPasajero().add(vp1);
        empresa.getListaVehiculosPasajero().add(vp2);
    }

    @Override
    public boolean agregarPropietario(String nombre, String numeroIdentificacion, String email, String numeroCelular, int edad){
        return empresa.agregarPropietario(nombre, numeroIdentificacion,email,numeroCelular,edad);
    }

    @Override
    public Propietario obtenerPropietario(String numeroIdentificacion){
        return empresa.obtenerPropietario(numeroIdentificacion);
    }

    @Override
    public boolean eliminarPropietario(String numeroIdentificacion){
        return empresa.eliminarPropietario(numeroIdentificacion);
    }

    @Override
    public boolean actualizarPropietario(String nombre, String numeroIdentificacionActual, String numeroIdentificacion, String email, String numeroCelular, int edad){
        return empresa.actualizarPropietario(nombre, numeroIdentificacionActual, numeroIdentificacion,email,numeroCelular,edad);
    }

    @Override
    public String buscarVehiculoCargaPlaca(String placa){
        return empresa.buscarVehiculoCargaPlaca(placa);
    }

    @Override
    public String buscarPropietarioNombre(String nombre){
        for(Propietario p: empresa.getListaPropietarios()){
            if(p.getNombre().equalsIgnoreCase(nombre)) return p.toString();
        }
        return "";
    }

    public EmpresaTransporte getEmpresaTransporte(){ return empresa; }
}
