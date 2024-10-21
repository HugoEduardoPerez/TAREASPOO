package menu;

import hospital.Hospital;
import usuarios.Usuario;
import usuarios.Administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Hospital hospital = new Hospital();

    public void login() {
        int intentosMaximos = 5, intentosUsuario = 0;

        while (intentosUsuario < intentosMaximos) {
            System.out.println("\n*** Bienivenido ***");
            System.out.println("Inicia sesión para continuar\n");

            System.out.println("Ingresa tu usuario");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contrasenia");
            String contrasenia = scanner.nextLine();

            Usuario usuarioEnSesion = hospital.validarInicioSesion(usuario, contrasenia);

            if (usuarioEnSesion instanceof Usuario) {
                if (usuarioEnSesion.getRol() == Rol.PACIENTE) {
                    Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;
                    MenuPaciente menuPaciente = new MenuPaciente();
                    int opcion = 0;
                    while (opcion != 4) {
                        opcion = menuPaciente.mostrarMenu();
                        menuPaciente.procesarDatosMenu(opcion, hospital, pacienteEnSesion);
                    }
                    intentosUsuario = 0;
                } else if (usuarioEnSesion.getRol() == Rol.MEDICO) {
                    Medico medicoEnSesion = (Medico) usuarioEnSesion;
                    MenuMedico menuMedico = new MenuMedico();
                    int opcion = 0;
                    while (opcion != 7) {
                        opcion = menuMedico.mostrarMenu();
                        menuMedico.procesarDatosMenu(opcion, medicoEnSesion, hospital);
                    }
                    intentosUsuario = 0;
                } else {
                    Administrador administradorEnSesion = (Administrador) usuarioEnSesion;
                    MenuAdministrador menuAdmin = new MenuAdministrador();
                    int opcion = 0;
                    while (opcion != 12) {
                        opcion = menuAdmin.mostrarMenu();
                        menuAdmin.procesarDatosMenu(opcion, hospital, administradorEnSesion);
                    }
                    intentosUsuario = 0;
                }
            } else {
                intentosUsuario = mostrarErrorInicioSesion(intentosUsuario);
            }
        }

        System.out.println("Intentos máximos permitidos alcanzados.");
    }

    private int mostrarErrorInicioSesion(int intentosUsuario) {
        System.out.println("\nUsuario o contrasenia incorrectos, intenta de nuevo");
        return intentosUsuario + 1;
    }
}