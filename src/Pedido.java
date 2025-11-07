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
        return "Pedido [N.0=" + numeroPedido + ", Plato=" + nombrePlatillo + ", Precio=" + precio + ", Estado=" + pagado + "]";
    }

}
