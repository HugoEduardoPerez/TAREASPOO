public class EnvioNacional extends Envio {

    public int distanciaEnKM;
    public int diasEntrega;
    public EnvioNacional(double costoBase, double peso, int distanciaEnKM) {
        super(costoBase, peso);
        this.distanciaEnKM = distanciaEnKM;
        //this.diasEntrega = diasEntrega;
    }

    @Override
    public String calcularTiempoYCostoEntrega(){

        int diasEntrega = 1;  // Mínimo un día de entrega
        if (distanciaEnKM > 200 && distanciaEnKM <= 400) {
            diasEntrega = 2;
        } else if (distanciaEnKM > 400 && distanciaEnKM <= 600) {
            diasEntrega = 3;
        } else if (distanciaEnKM > 600 && distanciaEnKM <= 800) {
            diasEntrega = 4;
        } else if (distanciaEnKM > 800 && distanciaEnKM <= 1000) {
            diasEntrega = 5;
    }
        if (peso >5){
             double costoFinal = costoBase + costoBase*.05;
            return "Envio Nacional - Costo Total: $" + costoFinal + ", Tiempo de Entrega: " + diasEntrega + " días";
        } else {

            return costoBase + "Envio Internacional - Costo Total: $" + costoBase + ", Tiempo de Entrega: " + diasEntrega + " días";
        }


}
}
