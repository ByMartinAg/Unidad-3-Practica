import java.util.Scanner;
import javax.swing.*;
 class Main {
    public static void main(String[] args) {
        int opcion;
        int opcionHistorial;
        MenuPlatillos menu = new MenuPlatillos();
        TomaPedidos cola = new TomaPedidos();
        HistorialPedidos historial = new HistorialPedidos();
        Scanner sc = new Scanner(System.in);

        menu.mostrarMenu();
        while (true) {
            System.out.println("RESTAURANTE");
            System.out.println("1. Tomar pedido");
            System.out.println("2. Atender pedido (marcar pagado)");
            System.out.println("3. Ver pedidos pendientes");
            System.out.println("4. Ver historial");
            System.out.println("5. Administrar menú");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    menu.mostrarMenu();
                    if (menu.menuSize() > 0) {
                        System.out.print("Índice del platillo: ");
                        int ind = sc.nextInt();
                        Platillo p = menu.obtenerPlatillo(ind);
                        if (p != null) {
                            cola.agregarPedido(p.nombre, p.precio);
                        } else {
                            System.out.println("Platillo no válido");
                        }
                    }
                    break;
                case 2:
                    Pedido pedido = cola.eliminarPedido();
                    if (pedido != null) {
                        historial.guardarCobrado(pedido);
                    }
                    break;
                case 3:
                    cola.mostrarPedidos();
                    break;

                case 4:
                    System.out.println("1. Ver historial del día");
                    System.out.println("2. Ver corte de caja");
                    System.out.println("3. Ver información del día");
                    System.out.println("4. Volver");
                    opcionHistorial = sc.nextInt();
                    sc.nextLine();
                    try {
                        do {
                            if (opcionHistorial == 1){
                                historial.mostrarHistorial();
                            } else if (opcionHistorial == 2) {
                                historial.mostrarCorteCaja();
                            } else if (opcionHistorial == 3){
                                historial.mostrarInformacionDia();
                            }else {
                                System.out.println("No valido");
                            }
                        }while (opcionHistorial != 4);
                    }catch (Exception e) {
                        System.out.println("No valido");
                    }
                    break;

                case 5:
                    menu.administrarMenu(sc);
                    break;
                case 0:
                    System.out.println("Saliendoooo...");
                    sc.close();
                    return;
                default:
                    System.out.println("No valido");
            }
        }
    }

}
