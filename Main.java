
public class Main {

    public static void main(String[] args) {

        System.out.println("Coche 1: ");
        Coche Coche1 = new Coche ("FORD", "Fiesta", 2005);
        System.out.println(Coche1.mostrarInformacion());
        int EdadCarro = Coche.CalcularEdadAuto(2005);
        System.out.println("La edad del carro es: "+EdadCarro+ " años");
        System.out.println("Coche 2: ");
        Coche Coche2 = new Coche ("Renault", "Clio", 2002);
        System.out.println(Coche2.mostrarInformacion());
        EdadCarro = Coche.CalcularEdadAuto(2002);
        System.out.println("La edad del carro es: "+EdadCarro+" años");
        System.out.println("Coche 3: ");
        Coche Coche3 = new Coche (" Ferrari", " F40", 1992);
        System.out.println(Coche3.mostrarInformacion());
        EdadCarro = Coche.CalcularEdadAuto(1992);
    }
}