import java.util.Stack;

public class HistorialPedidos {
    private Stack<Pedido> historial;

    public HistorialPedidos() {
        historial = new Stack<>();
    }
    public void guardarPedido(Pedido pedido) {
        if (pedido != null) {
            historial.push(pedido);
        }
    }

    public void guardarCobrado(Pedido pedido) {
        if (pedido != null) {
            pedido.pagado = true;
            historial.push(pedido);
            System.out.println("Pedido cobrado y guardado en historial");
        }
    }

    public void mostrarHistorial() {
        System.out.println("\nHISTORIAL DE ACITVIDAD DEL DIA");
        if (historial.isEmpty()) {
            System.out.println("  No hay historial");
        } else {
            for (Pedido p : historial) {
                System.out.println("  " + p);
            }
        }
        System.out.println("----------");
    }

    public void mostrarCorteCaja() {
        System.out.println("\nCORTE DE CAJA TOTAL DEL DIA");
        double total = 0;
        int totalPedidos = 0;

        for (Pedido p : historial) {
            if (p.pagado) {
                total += p.precio;
                totalPedidos++;
            }
        }

        System.out.println("  Total de pedidos: " + totalPedidos);
        System.out.println("  Total recaudado: $" + total);
        System.out.println("----------");
    }

    public void mostrarInformacionDia() {
        System.out.println("\nINFORMACION GENERAL DEL DIAA");
        System.out.println("  Total de pedidos: " + historial.size());
        System.out.println("----------");
    }
}
