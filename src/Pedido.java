// representa un pedido
// tiene un numero de pedido, el nombre del platillo, el precio y el estado de pago
public class Pedido {
    int numeroPedido;
    String nombrePlatillo;
    double precio;
    boolean pagado;


    // crea el constructor con todos los atributos
    public Pedido (int numeroPedido, String nombrePlatillo, double precio, boolean pagado) {
        this.numeroPedido = numeroPedido;
        this.nombrePlatillo = nombrePlatillo;
        this.precio = precio;
        this.pagado = pagado;
    }
    // define ese metodo para que se pueda imprimir el pedido de la forma en que se desea
    @Override
    public String toString() {
        return "Pedido [#=  " + numeroPedido + ", Plato=  " + nombrePlatillo + ", Precio=  " + precio + ", Estado de pago=  " + pagado + "]";
    }

}
