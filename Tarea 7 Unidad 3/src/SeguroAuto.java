public class SeguroAuto extends Seguro{
    public int edadTitular;
    public SeguroAuto(String nombreTitular, double valorAsegurado,int edadTitular) {
        super(nombreTitular, valorAsegurado);
        this.edadTitular = edadTitular;
    }



    @Override
    public double calcularPrima (){
        double valorBase = 300.00+(0.5*valorAsegurado);

        if(edadTitular < 25){
            valorBase = valorBase *0.05 +valorBase;
        }
        return valorBase;
    }


}
