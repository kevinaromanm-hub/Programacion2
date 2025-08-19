package co.edu.uniquindio.empresa.factory;

import co.edu.uniquindio.empresa.model.*;
import javax.swing.*;

public class ModelFactory {
    private static ModelFactory instance;
    private EmpresaTransporte empresa;

    private ModelFactory() {
        empresa = new EmpresaTransporte("La Carreta");
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public void iniciarPrograma() {
        String[] opciones = {
                "Inicializar datos de prueba",
                "Agregar propietario manualmente",
                "Calcular total pasajeros hoy",
                "Propietarios con carga mayor a un peso",
                "Salir"
        };
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción",
                    "Menú Empresa Transporte", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0 -> inicializarDatosDePrueba();
                case 1 -> agregarPropietarioManual();
                case 2 -> calcularTotalPasajeros();
                case 3 -> {
                    String input = JOptionPane.showInputDialog("Ingrese el peso mínimo (kg):");
                    if (input != null && !input.isEmpty()) {
                        try {
                            double pesoMinimo = Double.parseDouble(input);
                            propietariosConCargaMayor(pesoMinimo);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                        }
                    }
                }
                default -> {}
            }
        } while (opcion != 4);
    }

    private void inicializarDatosDePrueba() {
        empresa.getPropietarios().clear(); // Limpiar antes de inicializar

        VehiculoCarga vc1 = new VehiculoCarga("C123AB", "2022", "Volvo", "Blanco", 12000, 4);
        Propietario pc1 = new Propietario("Carlos Pérez", "123", "carlos@mail.com", "3001234567", vc1);
        empresa.agregarPropietario(pc1);

        VehiculoPasajeros vp1 = new VehiculoPasajeros("P789XY", "2021", "Chevrolet", "Rojo", 45, 30);
        Propietario pp1 = new Propietario("Ana Gómez", "789", "ana@mail.com", "3029876543", vp1);
        empresa.agregarPropietario(pp1);

        VehiculoPasajeros vp2 = new VehiculoPasajeros("P321LM", "2020", "Mercedes", "Azul", 30, 20);
        Propietario pp2 = new Propietario("Juan Torres", "321", "juan@mail.com", "3031112233", vp2);
        empresa.agregarPropietario(pp2);

        VehiculoPasajeros vp3 = new VehiculoPasajeros("P654QR", "2023", "Ford", "Negro", 20, 15);
        Propietario pp3 = new Propietario("Luisa Martínez", "654", "luisa@mail.com", "3044445566", vp3);
        empresa.agregarPropietario(pp3);

        mostrarPropietarios();
    }

    private void agregarPropietarioManual() {
        String nombre = JOptionPane.showInputDialog("Nombre del propietario:");
        String id = JOptionPane.showInputDialog("Identificación:");
        String email = JOptionPane.showInputDialog("Email:");
        String celular = JOptionPane.showInputDialog("Celular:");

        String[] tipos = {"Carga", "Pasajeros"};
        int tipo = JOptionPane.showOptionDialog(null, "Tipo de vehículo:", "Vehículo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

        Vehiculo vehiculo = null;
        String placa = JOptionPane.showInputDialog("Placa:");
        String modelo = JOptionPane.showInputDialog("Modelo:");
        String marca = JOptionPane.showInputDialog("Marca:");
        String color = JOptionPane.showInputDialog("Color:");

        if (tipo == 0) {
            double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Capacidad de carga (kg):"));
            int ejes = Integer.parseInt(JOptionPane.showInputDialog("Número de ejes:"));
            vehiculo = new VehiculoCarga(placa, modelo, marca, color, capacidad, ejes);
        } else if (tipo == 1) {
            int maxPasajeros = Integer.parseInt(JOptionPane.showInputDialog("Número máximo de pasajeros:"));
            int pasajerosHoy = Integer.parseInt(JOptionPane.showInputDialog("Pasajeros transportados hoy:"));
            vehiculo = new VehiculoPasajeros(placa, modelo, marca, color, maxPasajeros, pasajerosHoy);
        }

        Propietario propietario = new Propietario(nombre, id, email, celular, vehiculo);
        empresa.agregarPropietario(propietario);
        mostrarPropietarios();
    }

    private void calcularTotalPasajeros() {
        int total = 0;
        StringBuilder detalle = new StringBuilder("Pasajeros transportados hoy:\n\n");
        for (Propietario p : empresa.getPropietarios()) {
            if (p.getVehiculo() instanceof VehiculoPasajeros vp) {
                int pasajeros = vp.getPasajerosHoy();
                total += pasajeros;
                detalle.append("Vehículo ").append(vp.getPlaca())
                        .append(": ").append(pasajeros).append(" pasajeros\n");
            }
        }
        detalle.append("\nTotal de pasajeros: ").append(total);
        JOptionPane.showMessageDialog(null, detalle.toString());
    }

    public void propietariosConCargaMayor(double pesoMinimo) {
        StringBuilder sb = new StringBuilder("Propietarios con vehículos que superan " + pesoMinimo + " kg:\n\n");
        boolean encontrado = false;

        for (Propietario p : empresa.getPropietarios()) {
            if (p.getVehiculo() instanceof VehiculoCarga vc) {
                if (vc.getCapacidadCarga() > pesoMinimo) {
                    sb.append(p).append("\n\n");
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            sb.append("No hay propietarios con vehículos que superen ese peso.");
        }

        System.out.println(sb.toString());
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private void mostrarPropietarios() {
        StringBuilder sb = new StringBuilder("Propietarios registrados:\n\n");
        for (Propietario p : empresa.getPropietarios()) {
            sb.append(p).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}







