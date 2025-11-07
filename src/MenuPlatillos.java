import java.util.LinkedList;
import java.util.Scanner;

public class MenuPlatillos {
    private LinkedList<Platillo> menu;

    public MenuPlatillos() {
        menu = new LinkedList<>();

        menu.add(new Platillo("Burrito", 60));
        menu.add(new Platillo("Pozole", 90));
        menu.add(new Platillo("Tamales", 25));
        menu.add(new Platillo("Sopes", 35));
        menu.add(new Platillo("Chilaquiles", 75));
    }
    public void agregarInicio(String nombre, double precio) {
        menu.addFirst(new Platillo(nombre, precio));
        System.out.println("Plato agregado al inicio");
    }

    public void agregarFinal(String nombre, double precio) {
        menu.addLast(new Platillo(nombre, precio));
        System.out.println("Plato agregado al final");
    }

    public void eliminarPrimero() {
        if (!menu.isEmpty()) {
            menu.removeFirst();
            System.out.println("Primer platoo eliminado");
        } else {
            System.out.println("Menu Vacio");
        }
    }

    public void eliminarEspecifico(int indice) {
        if (indice >= 0 && indice < menu.size()) {
            menu.remove(indice);
            System.out.println("Plato eliminado");
        } else {
            System.out.println("No valido");
        }
    }

    public void eliminarFinal() {
        if (!menu.isEmpty()) {
            menu.removeLast();
            System.out.println("Ultimo plato eliminado");
        } else {
            System.out.println("Menu Vacio");
        }
    }

    public void buscarPlatillo(String nombre) {
        boolean buscando = false;
        for (int index = 0; index < menu.size(); index++) {
            if (menu.get(index).nombre.equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado en" + index + ": " + menu.get(index));
                buscando = true;
            }
        }
        if (!buscando) {
            System.out.println("Plato no encontrado");
        }
    }

    public void mostrarMenu() {
        System.out.println("\nMenuuuuu");
        if (menu.isEmpty()) {
            System.out.println("Menu Vacio");
        } else {
            for (int index = 0; index < menu.size(); index++) {
                System.out.println("  " + index + ". " + menu.get(index));
            }
        }
        System.out.println("----------");
    }
    public void administrarMenu(Scanner sc) {
        while (true) {
            System.out.println("\nADMINISTRACION DEL MENU");
            System.out.println("1. Agregar inicio");
            System.out.println("2. Agregar final");
            System.out.println("3. Eliminar primero");
            System.out.println("4. Eliminar especifico");
            System.out.println("5. Eliminar final");
            System.out.println("6. Buscar plato");
            System.out.println("7. Regresar");
            System.out.println("----------");
            System.out.print("Opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String n1 = sc.nextLine();
                    System.out.print("Precio: ");
                    double p1 = sc.nextDouble();
                    agregarInicio(n1, p1);
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String n2 = sc.nextLine();
                    System.out.print("Precio: ");
                    double p2 = sc.nextDouble();
                    agregarFinal(n2, p2);
                    break;
                case 3:
                    eliminarPrimero();
                    break;
                case 4:
                    mostrarMenu();
                    System.out.print("Indice: ");
                    int ind = sc.nextInt();
                    eliminarEspecifico(ind);
                    break;
                case 5:
                    eliminarFinal();
                    break;
                case 6:
                    System.out.print("Nombre del platillo: ");
                    String nombre = sc.nextLine();
                    buscarPlatillo(nombre);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("No validoo");
            }
        }
    }
}