package co.edu.uniquindio.empresa.factory;

import co.edu.uniquindio.empresa.model.*;
import javax.swing.*;


/**
 * Singleton que controla la creación de propietarios y vehículos,
 * inicialización de datos de prueba y cálculos de pasajeros y carga.
 */
public class ModelFactory {
    private static ModelFactory instance;
    private EmpresaTransporte empresa;

    private ModelFactory()
    {
        empresa = new EmpresaTransporte("La Carreta");
    }

    public static ModelFactory getInstance()
    {
        if (instance == null)
        {
            instance = new ModelFactory();
        }
        return instance;
    }

    /*
     * BLOQUE TRY-CATCH
     *
     * Se utiliza para intentar convertir el valor ingresado por el usuario a un número (double).
     * - try: contiene el código que puede generar un error (Double.parseDouble(input)).
     * - catch: se ejecuta si ocurre una excepción (NumberFormatException),
     *          mostrando un mensaje de error y evitando que el programa se detenga.
     *
     * Permite manejar entradas inválidas de manera segura y continuar el flujo del programa.
     */

    public void iniciarPrograma()
    {
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
                    String entrada = JOptionPane.showInputDialog("Ingrese el peso mínimo (kg):");
                    if (entrada != null && !entrada.isEmpty()) {
                        try {
                            double pesoMinimo = Double.parseDouble(entrada);
                            propietariosConCargaMayor(pesoMinimo);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                        }
                    }
                }
                default ->
                {

                }
            }
        } while (opcion != 4);
    }

    private void inicializarDatosDePrueba() {


        VehiculoCarga vc1 = new VehiculoCarga("CAB123", "2022", "Volvo", "Blanco", 12000, 4);
        Propietario pc1 = new Propietario("Carlos Pérez", "123", "carlos@gmail.com", "3001234567", vc1);
        empresa.agregarPropietario(pc1);

        VehiculoCarga vc2 = new VehiculoCarga("KII345", "2018","Chevrolet","Verde",10000,4);
        Propietario pc2 = new Propietario("Adrian Roman","964", "adrian@gmail.com","366242136", vc2);
        empresa.agregarPropietario(pc2);

        VehiculoPasajeros vp1 = new VehiculoPasajeros("PXY789", "2021", "Chevrolet", "Rojo", 45, 30);
        Propietario pp1 = new Propietario("Ana Gómez", "789", "ana@gmail.com", "3029876543", vp1);
        empresa.agregarPropietario(pp1);

        VehiculoPasajeros vp2 = new VehiculoPasajeros("PLM321", "2020", "Mercedes", "Azul", 30, 20);
        Propietario pp2 = new Propietario("Juan Torres", "321", "juan@gmail.com", "3031112233", vp2);
        empresa.agregarPropietario(pp2);

        VehiculoPasajeros vp3 = new VehiculoPasajeros("PQR654", "2023", "Ford", "Negro", 20, 15);
        Propietario pp3 = new Propietario("Luisa Martínez", "654", "luisa@gmail.com", "3044445566", vp3);
        empresa.agregarPropietario(pp3);

        mostrarPropietarios();
    }

    /** Permite agregar un propietario y su vehículo manualmente mediante JOption */


    private void agregarPropietarioManual() {
        String nombre = JOptionPane.showInputDialog("Nombre del propietario:");
        String id = JOptionPane.showInputDialog("Identificación:");
        String email = JOptionPane.showInputDialog("Email:");
        String celular = JOptionPane.showInputDialog("Celular:");

        /*
         * SELECCIÓN DEL TIPO DE VEHÍCULO
         *
         * Muestra un cuadro de diálogo con dos opciones: "Carga" y "Pasajeros".
         * Devuelve un número según la selección:
         *   0 -> Carga -> crea VehiculoCarga
         *   1 -> Pasajeros -> crea VehiculoPasajeros
         * Luego se asocia el vehículo al propietario y se agrega a la empresa.
         *
         * int opcion = JOptionPane.showOptionDialog(
        componentePadre,      // normalmente null si quieres centrarlo
        mensaje,              // texto que aparece en la ventana
        titulo,               // título de la ventana
        tipoDeOpciones,       // por ejemplo, JOptionPane.DEFAULT_OPTION
        tipoDeMensaje,        // icono de la ventana (QUESTION_MESSAGE, INFORMATION_MESSAGE, etc.)
        iconoPersonalizado,   // null si no quieres icono personalizado
        opciones,             // arreglo de Strings que serán los botones
        opcionPorDefecto      // botón seleccionado por defecto


         */

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



    /*

 * StringBuilder se utiliza para construir mensajes dinámicos de texto de manera
 * eficiente, evitando crear múltiples objetos String al concatenar.
 *
 * MÉTODOS PRINCIPALES USADOS:
 *   - append(String s): agrega texto o información de objetos al final.
 *       Ejemplo: sb.append("Propietario: ").append(p.getNombre());
 *   - toString(): convierte el contenido de StringBuilder en un String
 *       para mostrarlo en consola o JOptionPane.
 *
 * IMPLEMENTACIÓN EN EL PROYECTO:
 *   1. mostrarPropietarios()
 *       - Se crea un StringBuilder con un título inicial.
 *       - Se recorre la lista de propietarios y se agrega cada uno con append().
 *       - Se agregan saltos de línea ("\n\n") para separar los registros.
 *       - Se convierte a String con toString() y se muestra en ventana.
 *
 *   2. calcularTotalPasajeros()
 *       - Se construye un reporte de pasajeros transportados hoy.
 *       - Cada vehículo de pasajeros agrega su información con append().
 *       - Se añade el total al final y se muestra con toString().
 *
 *   3. propietariosConCargaMayor(double peso)
 *       - Se lista únicamente propietarios con vehículos de carga que superen el peso dado.
 *       - Cada coincidencia se agrega con append().
 *       - Si no hay coincidencias, se agrega un mensaje indicándolo.
 *       - Resultado final mostrado por consola y en ventana usando toString().

     */

    /** Calcula y muestra el total de pasajeros transportados hoy. */
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
    /** Lista los propietarios cuyo vehículo de carga supera un peso dado. */

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







