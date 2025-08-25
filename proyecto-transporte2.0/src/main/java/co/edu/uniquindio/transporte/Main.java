package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.model.Propietario;
import co.edu.uniquindio.transporte.model.VehiculoCarga;
import co.edu.uniquindio.transporte.model.VehiculoPasajero;

import javax.swing.*;
import java.util.List;

public class Main {

    private static final ModelFactory modelFactory = ModelFactory.getInstance();

    public static void main(String[] args) {

        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "=== Empresa de Transporte ===\n" +
                            "---- Propietarios ----\n" +
                            "1. Listar Propietarios\n" +
                            "2. Crear Propietario\n" +
                            "3. Actualizar Propietario\n" +
                            "4. Eliminar Propietario\n" +
                            "---- Vehículos de Carga ----\n" +
                            "5. Listar Vehículos de Carga\n" +
                            "6. Crear Vehículo de Carga\n" +
                            "7. Actualizar Vehículo de Carga\n" +
                            "8. Eliminar Vehículo de Carga\n" +
                            "---- Vehículos de Pasajero ----\n" +
                            "9. Listar Vehículos de Pasajero\n" +
                            "10. Crear Vehículo de Pasajero\n" +
                            "11. Actualizar Vehículo de Pasajero\n" +
                            "12. Eliminar Vehículo de Pasajero\n" +
                            "---- Asociación ----\n" +
                            "13. Asociar Vehículo a Propietario (múltiples)\n" +
                            "---- Búsquedas ----\n" +
                            "14. Buscar Vehículo por Placa (unificado)\n" +
                            "15. Buscar Propietario por Nombre\n" +
                            "---- Cálculos/Requisitos ----\n" +
                            "16. Propietarios con vehículos > Peso X\n" +
                            "17. Pasajeros transportados por placa\n" +
                            "18. Propietarios mayores de 40 años\n" +
                            "---- Sistema ----\n" +
                            "19. Salir"
            );

            if (opcion == null) break;

            switch (opcion) {
                case "1" -> { // Listar Propietarios
                    List<Propietario> propietarios = modelFactory.listarPropietarios();
                    if (propietarios.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay propietarios.");
                    } else {
                        StringBuilder sb = new StringBuilder("Propietarios:\n");
                        for (Propietario p : propietarios) sb.append(p).append("\n");
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                }
                case "2" -> { // Crear Propietario
                    String nombre = JOptionPane.showInputDialog("Nombre:");
                    String id = JOptionPane.showInputDialog("Número de identificación:");
                    String email = JOptionPane.showInputDialog("Email:");
                    String celular = JOptionPane.showInputDialog("Número de celular:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                    boolean ok = modelFactory.agregarPropietario(nombre, id, email, celular, edad);
                    JOptionPane.showMessageDialog(null, ok ? "Propietario creado." : "Ya existe un propietario con ese ID.");
                }
                case "3" -> { // Actualizar Propietario
                    String idActual = JOptionPane.showInputDialog("ID actual del propietario:");
                    String nombre = JOptionPane.showInputDialog("Nuevo nombre:");
                    String idNuevo = JOptionPane.showInputDialog("Nuevo ID:");
                    String email = JOptionPane.showInputDialog("Nuevo email:");
                    String celular = JOptionPane.showInputDialog("Nuevo celular:");
                    int edad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:"));
                    boolean ok = modelFactory.actualizarPropietario(nombre, idActual, idNuevo, email, celular, edad);
                    JOptionPane.showMessageDialog(null, ok ? "Propietario actualizado." : "No se encontró el propietario.");
                }
                case "4" -> { // Eliminar Propietario
                    String id = JOptionPane.showInputDialog("ID del propietario a eliminar:");
                    boolean ok = modelFactory.eliminarPropietario(id);
                    JOptionPane.showMessageDialog(null, ok ? "Propietario eliminado." : "No se encontró el propietario.");
                }

                // === Vehículos de Carga ===
                case "5" -> {
                    List<VehiculoCarga> lista = modelFactory.listarVehiculosCarga();
                    if (lista.isEmpty()) JOptionPane.showMessageDialog(null, "No hay vehículos de carga.");
                    else {
                        StringBuilder sb = new StringBuilder("Vehículos de Carga:\n");
                        for (VehiculoCarga v : lista) sb.append(v).append("\n");
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                }
                case "6" -> {
                    String placa = JOptionPane.showInputDialog("Placa:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    String marca = JOptionPane.showInputDialog("Marca:");
                    String color = JOptionPane.showInputDialog("Color:");
                    double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Capacidad de carga:"));
                    int ejes = Integer.parseInt(JOptionPane.showInputDialog("Número de ejes:"));
                    boolean ok = modelFactory.agregarVehiculoCarga(new VehiculoCarga(placa, modelo, marca, color, capacidad, ejes));
                    JOptionPane.showMessageDialog(null, ok ? "Vehículo de carga creado." : "Ya existe un vehículo de carga con esa placa.");
                }
                case "7" -> {
                    String placaActual = JOptionPane.showInputDialog("Placa actual:");
                    String placa = JOptionPane.showInputDialog("Nueva placa:");
                    String modelo = JOptionPane.showInputDialog("Nuevo modelo:");
                    String marca = JOptionPane.showInputDialog("Nueva marca:");
                    String color = JOptionPane.showInputDialog("Nuevo color:");
                    double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Nueva capacidad de carga:"));
                    int ejes = Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de ejes:"));
                    boolean ok = modelFactory.actualizarVehiculoCarga(placaActual, placa, modelo, marca, color, capacidad, ejes);
                    JOptionPane.showMessageDialog(null, ok ? "Vehículo actualizado." : "No se encontró el vehículo.");
                }
                case "8" -> {
                    String placa = JOptionPane.showInputDialog("Placa a eliminar:");
                    boolean ok = modelFactory.eliminarVehiculoCarga(placa);
                    JOptionPane.showMessageDialog(null, ok ? "Vehículo eliminado." : "No se encontró el vehículo.");
                }

                // === Vehículos de Pasajero ===
                case "9" -> {
                    List<VehiculoPasajero> lista = modelFactory.listarVehiculosPasajero();
                    if (lista.isEmpty()) JOptionPane.showMessageDialog(null, "No hay vehículos de pasajero.");
                    else {
                        StringBuilder sb = new StringBuilder("Vehículos de Pasajero:\n");
                        for (VehiculoPasajero v : lista) sb.append(v).append("\n");
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                }
                case "10" -> {
                    String placa = JOptionPane.showInputDialog("Placa:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    String marca = JOptionPane.showInputDialog("Marca:");
                    String color = JOptionPane.showInputDialog("Color:");
                    int maxPas = Integer.parseInt(JOptionPane.showInputDialog("Número máximo de pasajeros:"));
                    boolean ok = modelFactory.agregarVehiculoPasajero(new VehiculoPasajero(placa, modelo, marca, color, maxPas));
                    JOptionPane.showMessageDialog(null, ok ? "Vehículo de pasajero creado." : "Ya existe un vehículo de pasajero con esa placa.");
                }
                case "11" -> {
                    String placaActual = JOptionPane.showInputDialog("Placa actual:");
                    String placa = JOptionPane.showInputDialog("Nueva placa:");
                    String modelo = JOptionPane.showInputDialog("Nuevo modelo:");
                    String marca = JOptionPane.showInputDialog("Nueva marca:");
                    String color = JOptionPane.showInputDialog("Nuevo color:");
                    int maxPas = Integer.parseInt(JOptionPane.showInputDialog("Nuevo número máximo de pasajeros:"));
                    boolean ok = modelFactory.actualizarVehiculoPasajero(placaActual, placa, modelo, marca, color, maxPas);
                    JOptionPane.showMessageDialog(null, ok ? "Vehículo actualizado." : "No se encontró el vehículo.");
                }
                case "12" -> {
                    String placa = JOptionPane.showInputDialog("Placa a eliminar:");
                    boolean ok = modelFactory.eliminarVehiculoPasajero(placa);
                    JOptionPane.showMessageDialog(null, ok ? "Vehículo eliminado." : "No se encontró el vehículo.");
                }

                // === Asociación ===
                case "13" -> {
                    String idProp = JOptionPane.showInputDialog("ID del propietario:");
                    String placa = JOptionPane.showInputDialog("Placa del vehículo a asociar (carga o pasajero):");
                    boolean ok = modelFactory.asociarVehiculoAPropietario(idProp, placa);
                    JOptionPane.showMessageDialog(null, ok ? "Asociación realizada." : "No se pudo asociar (verifique ID y placa).");
                }

                // === Búsquedas ===
                case "14" -> {
                    String placa = JOptionPane.showInputDialog("Placa del vehículo:");
                    String info = modelFactory.buscarVehiculoPorPlaca(placa);
                    JOptionPane.showMessageDialog(null, info);
                }
                case "15" -> {
                    String nombre = JOptionPane.showInputDialog("Nombre del propietario:");
                    String info = modelFactory.buscarPropietarioNombre(nombre);
                    JOptionPane.showMessageDialog(null, info.isEmpty() ? "No encontrado" : info);
                }

                // === Cálculos/Requisitos ===
                case "16" -> {
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso mínimo (kg):"));
                    List<Propietario> lista = modelFactory.propietariosPorPeso(peso);
                    if (lista.isEmpty()) JOptionPane.showMessageDialog(null, "Ningún propietario supera ese peso con sus vehículos de carga asociados.");
                    else {
                        StringBuilder sb = new StringBuilder("Propietarios con vehículos > " + peso + " kg:\n");
                        for (Propietario p : lista) sb.append(p).append("\n");
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                }
                case "17" -> {
                    String placa = JOptionPane.showInputDialog("Placa del vehículo de pasajeros:");
                    int total = modelFactory.pasajerosPorVehiculo(placa);
                    JOptionPane.showMessageDialog(null, "Número de pasajeros transportados (capacidad): " + total);
                }
                case "18" -> {
                    int total = modelFactory.contarPropietariosMayores40();
                    JOptionPane.showMessageDialog(null, "Propietarios mayores de 40: " + total);
                }
                case "19" -> System.exit(0);

                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}
