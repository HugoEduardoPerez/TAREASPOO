public abstract class Seguro {
    public String nombreTitular;
    public double valorAsegurado;

    public abstract double calcularPrima();

    public Seguro(String nombreTitular, double valorAsegurado) {
        this.nombreTitular = nombreTitular;
        this.valorAsegurado = valorAsegurado;
    }

    public void detallesSeguro() {
        System.out.println("Nombre: " + getNombreTitular());
        System.out.println("Valor asegurado: "+getValorAsegurado());
        System.out.println("Prima calculada: "+calcularPrima());
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public double getValorAsegurado() {
        return valorAsegurado;
    }

    public void setValorAsegurado(double valorAsegurado) {
        this.valorAsegurado = valorAsegurado;
    }
}
