import java.util.LinkedList;
import java.util.Scanner;

class Plato {
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    @Override
    public String toString() {
        return String.format("%-30s $%.2f", nombre, precio);
    }
}

// Clase principal del menú del restaurante
public class MenuPlatillos {
    private LinkedList<Plato> menu;

    public MenuPlatillos() {
        menu = new LinkedList<>();
        inicializarMenu();
    }

    // Inicializar el menú con platillos predeterminados
    private void inicializarMenu() {
        menu.add(new Plato("Tacos", 85.00));
        menu.add(new Plato("Enchiladas", 120.00));
        menu.add(new Plato("Pozole", 95.00));
        menu.add(new Plato("Hamburguesa", 65.00));
        menu.add(new Plato("Pizza", 155.00));
        menu.add(new Plato("Sushi", 135.00));
    }

    // Agregar platillo al inicio del menú
    public void agregarAlInicio(Plato p) {
        menu.addFirst(p);
        System.out.println("Platillo agregado al inicio");
    }

    // Agregar platillo al final del menú
    public void agregarAlFinal(Plato p) {
        menu.addLast(p);
        System.out.println("Platillo agregado al final");
    }

    // Eliminar el primer platillo
    public void eliminarPrimero() {
        if (!menu.isEmpty()) {
            Plato eliminado = menu.removeFirst();
            System.out.println("Eliminado: " + eliminado.getNombre());
        } else {
            System.out.println("El menu está vacio");
        }
    }

    // Eliminar el último platillo
    public void eliminarUltimo() {
        if (!menu.isEmpty()) {
            Plato eliminado = menu.removeLast();
            System.out.println("Eliminado: " + eliminado.getNombre());
        } else {
            System.out.println("El menu está vacio");
        }
    }

    // Buscar platillo por nombre
    public void buscarPlatillo(String nombre) {
        boolean encontrado = false;
        for (Plato p : menu) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun platillo");
        }
    }

    // Mostrar menú completo
    public void mostrarMenuCompleto() {
        if (menu.isEmpty()) {
            System.out.println("El menu está vacio");
            return;
        }

        System.out.println("Menu");
        int i = 1;
        for (Plato p : menu) {
            System.out.println(i + ". " + p);
            i++;
        }
        System.out.println("\nTotal de platillos: " + menu.size());
    }

    // Calcular precio total del menú
    public void calcularPrecioTotal() {
        double total = 0;
        for (Plato p : menu) {
            total += p.getPrecio();
        }
        System.out.printf("\nPrecio total de todos los platillos: $%.2f\n", total);
    }
    public void MostrarMenu(){
        MenuPlatillos restaurante = new MenuPlatillos();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Menu Completo");
            System.out.println("2. Agregar al inicio");
            System.out.println("3. Agregar al final");
            System.out.println("4. Eliminar primer platillo");
            System.out.println("5. Eliminar último platillo");
            System.out.println("6. Buscar platillo");
            System.out.println("7. Calcular precio total");
            System.out.println("0. Salir");
            System.out.print("\nSeleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    restaurante.mostrarMenuCompleto();
                    break;
                case 2:
                    System.out.print("Nombre del platillo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: $");
                    double precio = sc.nextDouble();
                    sc.nextLine();
                    Plato nuevo = new Plato(nombre, precio);
                    restaurante.agregarAlInicio(nuevo);
                    break;
                case 3:
                    System.out.print("Nombre del platillo: ");
                    String nombreUltimo = sc.nextLine();
                    System.out.print("Precio: $");
                    double precioUltimo = sc.nextDouble();
                    Plato ultimo = new Plato(nombreUltimo, precioUltimo);
                    restaurante.agregarAlFinal(ultimo);
                    break;

                case 4:
                    restaurante.eliminarPrimero();
                    break;

                case 5:
                    restaurante.eliminarUltimo();
                    break;

                case 6:
                    System.out.print("Nombre del platillo a buscar: ");
                    String buscar = sc.nextLine();
                    restaurante.buscarPlatillo(buscar);
                    break;

                case 7:
                    restaurante.calcularPrecioTotal();
                    break;

                case 0:
                    System.out.println("\nSaliendo...........");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);

        sc.close();
    }
}