public class Producto {
    public String nombre;
    public double precio;
    public int cantidad;


    public static class ProductoInvalidoException extends Exception {
        public ProductoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class PrecioInvalidoException extends Exception {
        public PrecioInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class CantidadInvalidaException extends Exception {
        public CantidadInvalidaException(String mensaje) {
            super(mensaje);
        }
    }

    public Producto(String nombre, double precio, int cantidad) throws ProductoInvalidoException, PrecioInvalidoException, CantidadInvalidaException {
        if (nombre == null || nombre.isEmpty()) {
            throw new ProductoInvalidoException("El nombre del producto no puede estar vacío o ser nulo.");
        }
        if (precio <= 0) {
            throw new PrecioInvalidoException("El precio debe ser mayor que cero.");
        }
        if (cantidad < 0) {
            throw new CantidadInvalidaException("La cantidad no puede ser negativa.");
        }

        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double calcularValorTotal(){
        return precio*cantidad;
    }

    public void mostrarDetalles() {
        System.out.println("Producto: " + getNombre());
        System.out.println("Precio: " + getPrecio()+" $");
        System.out.println("Cantidad: " + getCantidad()+" unidades");
        System.out.println("Valor total "+calcularValorTotal()+" $");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
