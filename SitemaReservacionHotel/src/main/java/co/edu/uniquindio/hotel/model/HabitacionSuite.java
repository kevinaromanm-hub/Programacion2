package co.edu.uniquindio.hotel.model;

public class HabitacionSuite extends Habitacion {
    public HabitacionSuite(String numero, double precio) { super(numero, precio); }

    @Override
    public String toString() {
        return "HabitacionSuite{" + super.toString() + "}";
    }
}