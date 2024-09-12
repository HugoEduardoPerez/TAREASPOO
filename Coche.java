public class Coche {
    public String marca;
    public String modelo;
    public int year;
    public Coche(String marca, String modelo, int year) {
        this.marca = marca;
        this.modelo = modelo;
        this.year=year;
    }
    public String mostrarInformacion() {
        return  "marca: "
                +this.marca
                +"año: "+this.year
                +", modelo : "
                +this.modelo;
    }
    public static int CalcularEdadAuto (int year) {
        return 2024-year;
    }


}
