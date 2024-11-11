public class Habitacion {
    public String tipo;
    public double precioPorNoche;
    public boolean disponible;

    public Habitacion(String tipo, double precioPorNoche, boolean disponible) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = disponible;
    }


    public void reservar(int noches) throws HabitacionNoDisponibleException, NumeroDeNochesInvalidoException {
        if (!disponible) {
            throw new HabitacionNoDisponibleException("La habitación no está disponible para reservar.");
        }
        if (noches < 1) {
            throw new NumeroDeNochesInvalidoException("El número de noches debe ser de al menos 1.");
        }
        disponible = false;
        System.out.println("Reserva exitosa para " + noches + " noches. Costo total: $" + calcularCosto(noches));
    }

    public void liberar() {
        disponible = true;
        System.out.println("La habitación ha sido liberada y está disponible para reservas.");
    }

    public void mostrarDetalles(){
        System.out.println("Tipo de habitacion: "+getTipo());
        System.out.println("Precio por noche: "+getPrecioPorNoche());
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }

    public double calcularCosto(int noches) {
        return precioPorNoche * noches;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public static class HabitacionNoDisponibleException extends Exception {
        public HabitacionNoDisponibleException(String mensaje) {
            super(mensaje);
        }
    }

    public static class NumeroDeNochesInvalidoException extends Exception {
        public NumeroDeNochesInvalidoException(String mensaje) {
            super(mensaje);
        }
    }


}
