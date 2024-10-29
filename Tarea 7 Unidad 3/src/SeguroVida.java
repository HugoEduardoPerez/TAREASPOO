public class SeguroVida extends Seguro{

    public int edadCliente;

    public SeguroVida(String nombreTitular, double valorAsegurado, int edadCliente) {
        super(nombreTitular, valorAsegurado);
        this.edadCliente = edadCliente;
    }

    @Override
    public double calcularPrima(){

        double primaBase= 400 + (valorAsegurado*0.015);

        if (edadCliente >60){

            primaBase = primaBase*.2;
        }

        return primaBase;
    }

}
