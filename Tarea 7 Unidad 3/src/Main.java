//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SeguroAuto seguroAuto = new SeguroAuto("Juan perez",20000,65);
        SeguroHogar seguroHogar = new SeguroHogar("Hugo Perez",100000,true);
        SeguroVida seguroVida = new SeguroVida("David Zamora",500000,20);


        seguroHogar.detallesSeguro();

        System.out.println("\n------------------------\n");

        seguroVida.detallesSeguro();

        System.out.println("\n------------------------\n");

        seguroAuto.detallesSeguro();


    }
}