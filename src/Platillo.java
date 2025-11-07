public class Platillo {
    String nombre;
    double precio;

    public Platillo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
