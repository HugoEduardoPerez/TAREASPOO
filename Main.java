import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear productos
        Producto producto1 = new Producto("Iphone 16", 30000, 1);
        Producto producto2 = new Producto("Iphone 15", 25000);

        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n*** BIENVENIDO ***");
            System.out.println("Selecciona una opción: ");
            System.out.println("1. Añadir stock");
            System.out.println("2. Eliminar stock");
            System.out.println("3. Salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Selecciona el ID del producto (1 para iPhone 16, 2 para iPhone 15): ");
                    int idProductoAumentar = scanner.nextInt();
                    System.out.println("Cantidad a aumentar: ");
                    int cantidadAumentar = scanner.nextInt();

                    if (idProductoAumentar == 1) {
                        producto1.AumentarStock(cantidadAumentar);
                    } else if (idProductoAumentar == 2) {
                        producto2.AumentarStock(cantidadAumentar);
                    } else {
                        System.out.println("ID de producto no válido.");
                    }
                    break;

                case 2:
                    System.out.println("Selecciona el ID del producto (1 para iPhone 16, 2 para iPhone 15): ");
                    int idProductoReducir = scanner.nextInt();
                    System.out.println("Cantidad a reducir: ");
                    int cantidadReducir = scanner.nextInt();

                    if (idProductoReducir == 1) {
                        producto1.reducirStock(cantidadReducir);
                    } else if (idProductoReducir == 2) {
                        producto2.reducirStock(cantidadReducir);
                    } else {
                        System.out.println("ID de producto no válido.");
                    }
                    break;

                case 3:
                    System.out.println("ADIOS");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
    }
}