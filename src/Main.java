import java.util.Scanner;
 class Main {
    public static void main(String[] args) {
        int opcion;
        int opcionHistorial;
        MenuPlatillos menu = new MenuPlatillos();
        TomaPedidos colaPedidos = new TomaPedidos();
        HistorialPedidos historial = new HistorialPedidos();
        Scanner sc = new Scanner(System.in);

        //menu.mostrarMenu();
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
                        System.out.print("Numero de plato: ");
                        int index = sc.nextInt();
                        Platillo plato = menu.obtenerPlatillo(index);
                        if (plato != null) {
                            colaPedidos.agregarPedido(plato.nombre, plato.precio);
                        } else {
                            System.out.println("Platillo no válido");
                        }
                    }
                    break;
                case 2:
                    Pedido pedido = colaPedidos.eliminarPedido();
                    if (pedido != null) {
                        historial.guardarCobrado(pedido);
                    }
                    break;
                case 3:
                    colaPedidos.mostrarPedidos();
                    break;

                case 4:
                    try {
                        do {
                            System.out.println("1. Ver historial del día");
                            System.out.println("2. Ver corte de caja");
                            System.out.println("3. Ver información del día");
                            System.out.println("4. Volver");
                            opcionHistorial = sc.nextInt();
                            sc.nextLine();
                            switch (opcionHistorial) {
                                case 1:
                                    historial.mostrarHistorial();
                                    break;
                                case 2:
                                    historial.mostrarCorteCaja();
                                    break;
                                case 3:
                                    historial.mostrarInformacionDia();
                                    break;
                                case 4:
                                    break;
                                default:
                                    System.out.println("No valido");
                            }

                        } while (opcionHistorial != 4); // ✅ ahora sí se detiene

                    } catch (Exception e) {
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
