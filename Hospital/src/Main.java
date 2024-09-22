import java.util.Scanner;

import hospital.Hospital;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        while (opcion != 6){

            System.out.println("ELIGE LA OPCION QUE DESEAS DEL MENU: ");
            System.out.println("1.- Registrar paciente: ");
            System.out.println("2.- Registrar medico: ");
            System.out.println("3.- Registrar consulta");
            System.out.println(" 4.- Registrar Consultorio: ");
            System.out.println("5.- Salir");

            System.out.println("Selecciona una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    //if (!Hospital.validarDisponibilidadEnFechaConsulta()) {
                    // System.out.println("\nNo existen categorías en el sistema");
                    //break;
                    //}
                case 2:


                case 3:


                case 4:
                case 5:


            }


        }

    }
}
