import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el precio del producto: ");
            double precio = scanner.nextDouble();

            System.out.println("Ingrese la cantidad en inventario: ");
            int cantidad = scanner.nextInt();

            Producto producto = new Producto (nombre,precio,cantidad);
            producto.mostrarDetalles();

        } catch (Producto.ProductoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Producto.PrecioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Producto.CantidadInvalidaException e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }


    }
}