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
        boolean continuar = true;
        while (continuar) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del propietario:");
            String identificacion = JOptionPane.showInputDialog("Ingrese la identificación:");
            String email = JOptionPane.showInputDialog("Ingrese el email:");
            String celular = JOptionPane.showInputDialog("Ingrese el número de celular:");

            String tipoVehiculo = JOptionPane.showInputDialog("Ingrese el tipo de vehículo (carga/pasajeros):");
            String placa = JOptionPane.showInputDialog("Ingrese la placa:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
            String marca = JOptionPane.showInputDialog("Ingrese la marca:");
            String color = JOptionPane.showInputDialog("Ingrese el color:");

            Vehiculo vehiculo;
            if ("carga".equalsIgnoreCase(tipoVehiculo)) {
                double capacidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga (toneladas):"));
                int ejes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de ejes:"));
                vehiculo = new VehiculoCarga(placa, modelo, marca, color, capacidad, ejes);
            } else {
                int pasajeros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de pasajeros:"));
                vehiculo = new VehiculoPasajeros(placa, modelo, marca, color, pasajeros);
            }

            Propietario propietario = new Propietario(nombre, identificacion, email, celular, vehiculo);
            empresa.agregarPropietario(propietario);

            JOptionPane.showMessageDialog(null, "Propietario agregado:\n" + propietario);

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro propietario?", "Continuar", JOptionPane.YES_NO_OPTION);
            if (opcion != JOptionPane.YES_OPTION) {
                continuar = false;
            }
        }

        StringBuilder datos = new StringBuilder("Propietarios registrados en " + empresa.getNombre() + ":\n\n");
        for (Propietario p : empresa.getPropietarios()) {
            datos.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null, datos.toString());
    }

    public EmpresaTransporte getEmpresa() {
        return empresa;
    }
}




