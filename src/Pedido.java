public class Pedido {
    int numeroPedido;
    String nombrePlatillo;
    double precio;
    boolean pagado;

    public Pedido (int numeroPedido, String nombrePlatillo, double precio, boolean pagado) {
        this.numeroPedido = numeroPedido;
        this.nombrePlatillo = nombrePlatillo;
        this.precio = precio;
        this.pagado = pagado;
    }
    @Override
    public String toString() {
        return "Pedido [#=  " + numeroPedido + ", Plato=  " + nombrePlatillo + ", Precio=  " + precio + ", Estado de pago=  " + pagado + "]";
    }

}
