package menu;

import hospital.Hospital;
import usuarios.pacientes.Paciente;

import java.util.Scanner;

public class MenuPaciente {
    private Scanner scanner = new Scanner(System.in);
    public int mostrarMenu() {
        int opcion;
            System.out.println("\n**SISTEMA HOSPITAL**");
            System.out.println("1.-Ver mis consultas");
            System.out.println("2.- Ver informacion personal");
            System.out.println("3.-Ver mi expediente ");
            System.out.println("4.-Salir");

            System.out.println("Selecciona una opcion: ");
            opcion = scanner.nextInt();

            return opcion;

    }
    public void procesarDatosMenu(int opcion, Hospital hospital, Paciente paciente) {
        switch (opcion){
            case 1:
                hospital.verConsultasPaciente(paciente.getId());

            case 2:
                hospital.mostrarInfoPaciente(paciente);
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}