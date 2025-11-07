import java.util.LinkedList;
import java.util.Queue;

public class TomaPedidos {
    private Queue<Pedido> pedidos;
    private int contadorPedidos;

    public TomaPedidos() {
        pedidos = new LinkedList<>();
        contadorPedidos = 1;
    }
    public void agregarPedido(String platillo, double precio) {
        Pedido pedido = new Pedido(contadorPedidos++, platillo, precio, false);
        pedidos.offer(pedido);
        System.out.println("Pedido #" + pedido.numeroPedido + " agregado a la cola");
    }

    public Pedido eliminarPedido() {
        Pedido pedido = pedidos.poll();
        if (pedido != null) {
            System.out.println("Pedido atendido: " + pedido);
            return pedido;
        } else {
            System.out.println("No hay pedidos");
            return null;
        }
    }

    // lo puse pero no se usa
    public void verPrimerPedido() {
        Pedido pedido = pedidos.peek();
        if (pedido != null) {
            System.out.println("Primer pedido: " + pedido);
        } else {
            System.out.println("No hay pedidos");
        }
    }
    // lo puse pero no se usa
    public void verTotalPedidos() {
        System.out.println("Total de pedidos" + pedidos.size());
    }
    // lo puse pero no se usa
    public boolean hayPedidos() {
        return !pedidos.isEmpty();
    }

    public void mostrarPedidos() {
        System.out.println("\nPEDIDOS PENDIENTES");
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes");
        } else {
            for (Pedido p : pedidos) {
                System.out.println("  " + p);
            }
        }
        System.out.println("----------");
    }
}
