import java.util.LinkedList;
import java.util.Queue;
// clase que maneja una cola de pedidos
// usa una cola para guardar los pedidos
public class TomaPedidos {
    // cola que guarda los pedidos pendientes
    private Queue<Pedido> pedidos;
    // asigna un contador a cada pedido
    private int contadorPedidos;

    // constructor e inicia el contador en 1 tmbn
    public TomaPedidos() {
        pedidos = new LinkedList<>();
        contadorPedidos = 1;
    }
    // agrega un pedido a la cola
    public void agregarPedido(String platillo, double precio) {
        // se crea el pedido con un numero de pedido y el nombre del platillo y el precio pero no se marca como pagado
        Pedido pedido = new Pedido(contadorPedidos++, platillo, precio, false);
        pedidos.offer(pedido); // se agrega al final de la cola
        System.out.println("Pedido #" + pedido.numeroPedido + " agregado a la cola");
    }

    public Pedido eliminarPedido() {
        // se elimina el pedido del inicio de la cola con poll
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
