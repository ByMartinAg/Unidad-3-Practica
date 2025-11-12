import java.util.Scanner;
// clase principal que ejecuta el programa
 class Main {
    public static void main(String[] args) {
        int opcion;
        int opcionHistorial;
        // objetos que son los componentes de cada sistema
        MenuPlatillos menu = new MenuPlatillos();
        TomaPedidos colaPedidos = new TomaPedidos();
        HistorialPedidos historial = new HistorialPedidos();
        Scanner sc = new Scanner(System.in);

        //menu.mostrarMenu();
        // ciclo principal para la ejecucion del programa
        while (true) {
            // menu principal
            System.out.println("RESTAURANTE");
            System.out.println("1. Tomar pedido");
            System.out.println("2. Atender pedido (marcar pagado)");
            System.out.println("3. Ver pedidos pendientes");
            System.out.println("4. Ver historial");
            System.out.println("5. Administrar menu");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();
            // case de opciones
            switch (opcion) {
                case 1:
                    // muestra el menu
                    menu.mostrarMenu();
                    if (menu.menuSize() > 0) {
                        System.out.print("Numero de plato: ");
                        int index = sc.nextInt();
                        // se obtiene pedido
                        Platillo plato = menu.obtenerPlatillo(index);
                        if (plato != null) {
                            // se agrega a la cola si existe
                            colaPedidos.agregarPedido(plato.nombre, plato.precio);
                        } else {
                            System.out.println("Platillo no valido");
                        }
                    }
                    break;
                case 2:
                    // se saca el pedido de la cola
                    Pedido pedido = colaPedidos.eliminarPedido();
                    // se habia pedido se guarda en historial como cobrado
                    if (pedido != null) {
                        historial.guardarCobrado(pedido);
                    }
                    break;
                case 3:
                    // muestra los pedidos que estan en la cola
                    colaPedidos.mostrarPedidos();
                    break;

                case 4: // es para ver el historial
                    try {
                        do {
                            // es el submenu
                            System.out.println("1. Ver historial del dia");
                            System.out.println("2. Ver corte de caja");
                            System.out.println("3. Ver información del dia");
                            System.out.println("4. Volver");
                            opcionHistorial = sc.nextInt();
                            sc.nextLine();
                            // opciones para tipo de historial que se desea
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

                        } while (opcionHistorial != 4);

                    } catch (Exception e) {
                        System.out.println("No valido");
                    }
                    break;


                case 5:
                    // administra el menu si es necesario
                    menu.administrarMenu(sc);
                    break;
                case 0:
                    // sale del programa
                    System.out.println("Saliendoooo...");
                    return;
                default:
                    System.out.println("No valido");
            }
        }
    }
}
