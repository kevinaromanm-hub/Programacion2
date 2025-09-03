package co.edu.uniquindio.hotel.model;

public class Reserva {
    private String id;
    private Cliente cliente;
    private Habitacion habitacion;
    private String fechaEntrada;
    private String fechaSalida;

    public Reserva(String id, Cliente cliente, Habitacion habitacion, String fechaEntrada, String fechaSalida) {
        this.id = id;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Habitacion getHabitacion() { return habitacion; }
    public String getFechaEntrada() { return fechaEntrada; }
    public String getFechaSalida() { return fechaSalida; }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "Reserva {" +
                "ID='" + id + '\'' +
                ", Cliente='" + cliente.getNombre() + '\'' +
                ", Habitación='" + habitacion.getNumero() + '\'' +
                ", Entrada='" + fechaEntrada + '\'' +
                ", Salida='" + fechaSalida + '\'' +
                '}';
    }

}
