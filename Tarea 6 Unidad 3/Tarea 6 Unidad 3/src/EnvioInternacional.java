public class EnvioInternacional extends Envio {

    public String pais;
    public int diasEntrega;

    public EnvioInternacional(double costoBase, double peso, String pais) {
        super(costoBase, peso);
        this.pais = pais;
    }



    @Override
    public String calcularTiempoYCostoEntrega() {
        //validarPeso();

        diasEntrega = 10;
        if (peso>10.00){
            diasEntrega=diasEntrega+3;
            double costoFinal= costoBase+costoBase*.20;
            return"Envio Internacional - Costo Total: $" + costoFinal + ", Tiempo de Entrega: " + diasEntrega + " días";
        } else {
            return "Envio Internacional - Costo Total: $" + costoBase;
        }
        //return "";
    }
}
