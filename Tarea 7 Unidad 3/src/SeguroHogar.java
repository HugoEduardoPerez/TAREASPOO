public class SeguroHogar extends Seguro{
    public boolean zonaRiesgo;

    public SeguroHogar(String nombreTitular, double valorAsegurado, boolean zonaRiesgo) {
        super(nombreTitular, valorAsegurado);
        this.zonaRiesgo = zonaRiesgo;
    }

    @Override
    public double calcularPrima(){
        double primaBase=500 + (0.2 * valorAsegurado);

        if(zonaRiesgo){
            primaBase=primaBase*.20;
            return primaBase;
        }
        return primaBase;

    }

}
