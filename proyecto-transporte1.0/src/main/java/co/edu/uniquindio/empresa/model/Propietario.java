package co.edu.uniquindio.empresa.model;

public class Propietario {
    private String nombre;
    private String identificacion;
    private String correo;
    private String celular;
    private Vehiculo vehiculo;

    public Propietario(String nombre, String identificacion, String correo, String celular, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
        this.celular = celular;
        this.vehiculo = vehiculo;
    }

    public String getNombre()
    {
        return nombre;
    }
    public String getIdentificacion()
    {
        return identificacion;
    }
    public String getCorreo()
    {
        return correo;
    }
    public String getCelular()
    {
        return celular;
    }
    public Vehiculo getVehiculo()
    {
        return vehiculo;
    }

    @Override
    public String toString()
    {
        return "Propietario: " + nombre + " (" + identificacion + ")\n" +
                "Correo: " + correo + ", Celular: " + celular + "\n" +
                "Vehículo: " + vehiculo;
    }
}






