public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    public void setNombre(String nombre) {
    }

    public void setStock(int stock) {
    }

    public void setPrecio(double precio) {
    }

    public Producto(String nombre, double precio, int stock) {
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);

}


    public Producto(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
        setStock(0);
}
    public void AumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad; // Actualizar el stock
            System.out.println("El stock ha sido aumentado. Stock actual: " + this.stock);
        } else {
            System.out.println("La cantidad a aumentar debe ser mayor que 0.");
        }
    }
    public void reducirStock(int cantidad) {
        if (cantidad > 0 && this.stock >= cantidad) {
            this.stock -= cantidad; // Actualizar el stock
            System.out.println("El stock ha sido reducido. Stock actual: " + this.stock);
        } else if (cantidad <= 0) {
            System.out.println("La cantidad a reducir debe ser mayor que 0.");
        } else {
            System.out.println("No se puede reducir más stock del disponible.");
        }
    }
}