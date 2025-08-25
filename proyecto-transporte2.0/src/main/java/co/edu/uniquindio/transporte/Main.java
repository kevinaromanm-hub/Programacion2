package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.model.*;

import javax.swing.*;
import java.util.List;

public class Main {
    private static ModelFactory modelFactory = ModelFactory.getInstance();

    public static void main(String[] args) {
        while(true){
            String opcion = JOptionPane.showInputDialog(
                    "Menú de Empresa de Transporte\n" +
                            "1. Listar Propietarios\n" +
                            "2. Crear Propietario\n" +
                            "3. Actualizar Propietario\n" +
                            "4. Eliminar Propietario\n" +
                            "5. Listar Vehiculos de Carga\n" +
                            "6. Crear Vehiculo de Carga\n" +
                            "7. Actualizar Vehiculo de Carga\n" +
                            "8. Eliminar Vehiculo de Carga\n" +
                            "9. Listar Vehiculos de Pasajeros\n" +
                            "10. Crear Vehiculo de Pasajeros\n" +
                            "11. Actualizar Vehiculo de Pasajeros\n" +
                            "12. Eliminar Vehiculo de Pasajeros\n" +
                            "13. Asociar Vehiculo a Propietario\n" +
                            "14. Buscar Vehiculo Carga por Placa\n" +
                            "15. Buscar Propietario por Nombre\n" +
                            "16. Propietarios con Vehiculo > Peso\n" +
                            "17. Pasajeros transportados por Vehiculo\n" +
                            "18. Propietarios mayores de 40 años\n" +
                            "19. Salir"
            );

            if(opcion == null) break;

            switch(opcion){
                case "1": // Listar Propietarios
                    StringBuilder sb1 = new StringBuilder("Propietarios:\n");
                    for(Propietario p: modelFactory.getEmpresaTransporte().getListaPropietarios()) sb1.append(p).append("\n");
                    JOptionPane.showMessageDialog(null,sb1.toString());
                    break;
                case "2": // Crear Propietario
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String id = JOptionPane.showInputDialog("ID:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String celular = JOptionPane.showInputDialog("Celular:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    if(modelFactory.agregarPropietario(nombre,id,email,celular,edad))
                        JOptionPane.showMessageDialog(null,"Propietario agregado");
                    else JOptionPane.showMessageDialog(null,"Ya existe");
                    break;
                case "3": // Actualizar Propietario
                    id = JOptionPane.showInputDialog("ID del propietario a actualizar:");
                    nombre = JOptionPane.showInputDialog("Nuevo Nombre:");
                    String idNuevo = JOptionPane.showInputDialog("Nuevo ID:");
                    email = JOptionPane.showInputDialog("Nuevo Email:");
                    celular = JOptionPane.showInputDialog("Nuevo Celular:");
                    edad = Integer.parseInt(JOptionPane.showInputDialog("Nueva Edad:"));
                    if(modelFactory.actualizarPropietario(nombre,id,idNuevo,email,celular,edad))
                        JOptionPane.showMessageDialog(null,"Actualizado");
                    else JOptionPane.showMessageDialog(null,"No encontrado");
                    break;
                case "4": // Eliminar Propietario
                    id = JOptionPane.showInputDialog("ID del propietario a eliminar:");
                    if(modelFactory.eliminarPropietario(id))
                        JOptionPane.showMessageDialog(null,"Eliminado");
                    else JOptionPane.showMessageDialog(null,"No encontrado");
                    break;
                case "5": // Listar VehiculosCarga
                    StringBuilder sb2 = new StringBuilder("Vehiculos de Carga:\n");
                    for(VehiculoCarga v: modelFactory.getEmpresaTransporte().getListaVehiculosCarga()) sb2.append(v).append("\n");
                    JOptionPane.showMessageDialog(null,sb2.toString());
                    break;
                case "6": // Crear VehiculoCarga
                    String placa = JOptionPane.showInputDialog("Placa:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    String marca = JOptionPane.showInputDialog("Marca:");
                    String color = JOptionPane.showInputDialog("Color:");
                    double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Capacidad Carga:"));
                    int ejes = Integer.parseInt(JOptionPane.showInputDialog("Numero de Ejes:"));
                    modelFactory.getEmpresaTransporte().getListaVehiculosCarga().add(new VehiculoCarga(placa,modelo,marca,color,capacidad,ejes));
                    JOptionPane.showMessageDialog(null,"Vehiculo de Carga agregado");
                    break;
                case "7": // Actualizar VehiculoCarga
                    placa = JOptionPane.showInputDialog("Placa a actualizar:");
                    VehiculoCarga vcActualizar = null;
                    for(VehiculoCarga v: modelFactory.getEmpresaTransporte().getListaVehiculosCarga()){
                        if(v.getPlaca().equalsIgnoreCase(placa)){ vcActualizar = v; break; }
                    }
                    if(vcActualizar != null){
                        modelo = JOptionPane.showInputDialog("Nuevo Modelo:");
                        marca = JOptionPane.showInputDialog("Nueva Marca:");
                        color = JOptionPane.showInputDialog("Nuevo Color:");
                        capacidad = Double.parseDouble(JOptionPane.showInputDialog("Nueva Capacidad:"));
                        ejes = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Numero de Ejes:"));
                        vcActualizar.setModelo(modelo); vcActualizar.setMarca(marca); vcActualizar.setColor(color);
                        vcActualizar.setCapacidadCarga(capacidad); vcActualizar.setNumeroEjes(ejes);
                        JOptionPane.showMessageDialog(null,"Vehiculo actualizado");
                    } else JOptionPane.showMessageDialog(null,"No encontrado");
                    break;
                case "8": // Eliminar VehiculoCarga
                    placa = JOptionPane.showInputDialog("Placa a eliminar:");
                    modelFactory.getEmpresaTransporte().getListaVehiculosCarga().removeIf(v->v.getPlaca().equalsIgnoreCase(placa));
                    JOptionPane.showMessageDialog(null,"Eliminado si existia");
                    break;
                case "9": // Listar VehiculosPasajero
                    StringBuilder sb3 = new StringBuilder("Vehiculos de Pasajeros:\n");
                    for(VehiculoPasajero v: modelFactory.getEmpresaTransporte().getListaVehiculosPasajero()) sb3.append(v).append("\n");
                    JOptionPane.showMessageDialog(null,sb3.toString());
                    break;
                case "10": // Crear VehiculoPasajero
                    placa = JOptionPane.showInputDialog("Placa:");
                    modelo = JOptionPane.showInputDialog("Modelo:");
                    marca = JOptionPane.showInputDialog("Marca:");
                    color = JOptionPane.showInputDialog("Color:");
                    int maxPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Max Pasajeros:"));
                    modelFactory.getEmpresaTransporte().getListaVehiculosPasajero().add(new VehiculoPasajero(placa,modelo,marca,color,maxPasajeros));
                    JOptionPane.showMessageDialog(null,"Vehiculo de Pasajero agregado");
                    break;
                case "11": // Actualizar VehiculoPasajero
                    placa = JOptionPane.showInputDialog("Placa a actualizar:");
                    VehiculoPasajero vpActualizar = null;
                    for(VehiculoPasajero v: modelFactory.getEmpresaTransporte().getListaVehiculosPasajero()){
                        if(v.getPlaca().equalsIgnoreCase(placa)){ vpActualizar = v; break; }
                    }
                    if(vpActualizar != null){
                        modelo = JOptionPane.showInputDialog("Nuevo Modelo:");
                        marca = JOptionPane.showInputDialog("Nueva Marca:");
                        color = JOptionPane.showInputDialog("Nuevo Color:");
                        maxPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Max Pasajeros:"));
                        vpActualizar.setModelo(modelo); vpActualizar.setMarca(marca); vpActualizar.setColor(color);
                        vpActualizar.setNumeroMaximoPasajeros(maxPasajeros);
                        JOptionPane.showMessageDialog(null,"Vehiculo actualizado");
                    } else JOptionPane.showMessageDialog(null,"No encontrado");
                    break;
                case "12": // Eliminar VehiculoPasajero
                    placa = JOptionPane.showInputDialog("Placa a eliminar:");
                    modelFactory.getEmpresaTransporte().getListaVehiculosPasajero().removeIf(v->v.getPlaca().equalsIgnoreCase(placa));
                    JOptionPane.showMessageDialog(null,"Eliminado si existia");
                    break;
                case "13": // Asociar Vehiculo a Propietario
                    String idProp = JOptionPane.showInputDialog("ID Propietario:");
                    Propietario prop = modelFactory.obtenerPropietario(idProp);
                    if(prop != null){
                        placa = JOptionPane.showInputDialog("Placa Vehiculo a asociar:");
                        Vehiculo veh = null;
                        for(VehiculoCarga v: modelFactory.getEmpresaTransporte().getListaVehiculosCarga())
                            if(v.getPlaca().equalsIgnoreCase(placa)){ veh=v; break; }
                        if(veh==null) for(VehiculoPasajero v: modelFactory.getEmpresaTransporte().getListaVehiculosPasajero())
                            if(v.getPlaca().equalsIgnoreCase(placa)){ veh=v; break; }
                        if(veh!=null){ prop.getListaVehiculosAsociados().add(veh); JOptionPane.showMessageDialog(null,"Asociado"); }
                        else JOptionPane.showMessageDialog(null,"Vehiculo no encontrado");
                    } else JOptionPane.showMessageDialog(null,"Propietario no encontrado");
                    break;
                case "14": // Buscar Vehiculo a por Placa
                    placa = JOptionPane.showInputDialog("Placa:");
                    String info = modelFactory.buscarVehiculoCargaPlaca(placa);
                    JOptionPane.showMessageDialog(null,info.isEmpty()?"No encontrado":info);
                    break;
                case "15": // Buscar Propietario por Nombre
                    nombre = JOptionPane.showInputDialog("Nombre:");
                    info = modelFactory.buscarPropietarioNombre(nombre);
                    JOptionPane.showMessageDialog(null,info.isEmpty()?"No encontrado":info);
                    break;
                case "16": // Propietarios con Vehiculo > Peso
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso mínimo:"));
                    List<Propietario> listaPeso = modelFactory.getEmpresaTransporte().propietariosPorPeso(peso);
                    StringBuilder sbPeso = new StringBuilder();
                    for(Propietario p: listaPeso) sbPeso.append(p).append("\n");
                    JOptionPane.showMessageDialog(null,sbPeso.length()>0?sbPeso.toString():"Ninguno");
                    break;
                case "17": // Pasajeros transportados por Vehiculo
                    placa = JOptionPane.showInputDialog("Placa Vehiculo Pasajero:");
                    int cant = modelFactory.getEmpresaTransporte().pasajerosPorVehiculo(placa);
                    JOptionPane.showMessageDialog(null,"Pasajeros: "+cant);
                    break;
                case "18": // Propietarios mayores de 40 años
                    int cont = modelFactory.getEmpresaTransporte().contarPropietariosMayores40();
                    JOptionPane.showMessageDialog(null,"Total: "+cont);
                    break;
                case "19":
                    System.exit(0);
            }
        }
    }
}
