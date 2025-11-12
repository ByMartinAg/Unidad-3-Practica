// es una clase que representa un platillo
// tiene un nombre y un precio
public class Platillo {
    // crea el constructor con todos los atributos
    String nombre;
    double precio;

    // constructor para crear el platillo
    public Platillo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // define ese metodo para que se pueda imprimir el platillo de la forma en que se desea
    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
