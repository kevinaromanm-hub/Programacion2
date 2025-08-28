package co.edu.uniquindio.transporte.model;

public abstract class Vehiculo {
    protected String placa;
    protected String modelo;
    protected String marca;
    protected String color;

    public Vehiculo(String placa, String modelo, String marca, String color){
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Modelo: " + modelo + ", Marca: " + marca + ", Color: " + color;
    }
}

