public class CalculadoraImpuestos {
    public int Ingresos;
    public Double porcentajeImpuestos;
    public Double exencion;
    public Double dividendos;
    public CalculadoraImpuestos(int Ingresos, Double exencion, Double porcentajeImpuestos, Double dividendos) {
        this.Ingresos = Ingresos;
        this.porcentajeImpuestos = porcentajeImpuestos;
        this.exencion = exencion;
        this.dividendos = dividendos;
    }
    public static Double calcularImpuestos(int Ingresos) {
        return Ingresos+0.15;
    }
    public static Double calcularImpuestos(Double Ingresos, Double porcentajeImpuestos) {
        return Ingresos * (porcentajeImpuestos / 100);
    }
        public static double calcularImpuestos(double dividendos, double porcentajeImpuestos, double exencion) {
            double impuestos = dividendos * (porcentajeImpuestos / 100);
        if (impuestos>exencion) {
    return impuestos-exencion;
        }
        else {
            return impuestos = dividendos*(porcentajeImpuestos/100);
        }
        }
    }
    
    