import java.util.Stack;
// esta clase maneja el historial de los pedidos cobrados
// usa una pila para guardar los pedidos
public class HistorialPedidos {
    // pila que almacena los pedidos
    private Stack<Pedido> historial;
    // es el constructor
    public HistorialPedidos() {
        historial = new Stack<>();
    }
    // agrega un pedido a la pila y tambien lo marca como pagado
    public void guardarCobrado(Pedido pedido) {
        if (pedido != null) {
            pedido.pagado = true;
            historial.push(pedido);
            System.out.println("Pedido cobrado y guardado en historial");
        }
    }
    // muestra el historial de los pedidos hechos en un dia
    public void mostrarHistorial() {
        System.out.println("\nHISTORIAL DE ACITVIDAD DEL DIA");
        if (historial.isEmpty()) {
            System.out.println("  No hay historial");
        } else {
            // se recorre la pila para mostrar pedidos
            for (Pedido p : historial) {
                System.out.println("  " + p);
            }
        }
        System.out.println("----------");
    }
    // este muestra la cantidad de dinero recaudado en el dia
    public void mostrarCorteCaja() {
        System.out.println("\nCORTE DE CAJA TOTAL DEL DIA");
        double total = 0;
        int totalPedidos = 0;
        // se recorre la pila y a su vez va sumando los precios
        for (Pedido p : historial) {
            if (p.pagado) {
                total = total + p.precio;
                totalPedidos++;
            }
        }
        // muestra los resultados
        System.out.println("  Total de pedidos: " + totalPedidos);
        System.out.println("  Total recaudado: $" + total);
        System.out.println("----------");
    }
    // muestra una informacion general del dia
    public void mostrarInformacionDia() {
        System.out.println("\nINFORMACION GENERAL DEL DIAA");
        System.out.println("  Total de pedidos: " + historial.size());
        System.out.println("----------");
    }
}
