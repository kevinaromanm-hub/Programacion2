package co.edu.uniquindio.hotel.model;

public class HabitacionEstandar extends Habitacion {
    public HabitacionEstandar(String numero, double precio) { super(numero, precio); }

    @Override
    public String toString() {
        return "HabitacionEstandar{" + super.toString() + "}";
    }
}
