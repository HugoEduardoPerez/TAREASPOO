package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.Administrador.Administrador;
import usuarios.Usuario;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
//
public class MenuAdministrador {
    private Scanner scanner = new Scanner(System.in);
    public int mostrarMenu() {
            System.out.println("\n*** SISTEMA HOSPITAL*");
            System.out.println("1.Registrar Paciente ");
            System.out.println("2.Registrar Medico ");
            System.out.println("3.Registrar Consultorio ");
            System.out.println("4.Registrar Consulta ");
            System.out.println("5.Mostrar Pacientes ");
            System.out.println("6.Mostrar Medicos");
            System.out.println("7.Mostrar Consultorios");
            System.out.println("8. Mostrar consultas");
            System.out.println("9. Mostrar Paciente por Id");
            System.out.println("10. Mostrar Medicos por Id");
        System.out.println("11.- Mostrar info admin: ");
            System.out.println("12. Salir");
            System.out.println("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
    }

    public void procesarDatosMenu(int opcion, Hospital hospital, Administrador administrador) {
            switch (opcion) {
                case 1:
                    System.out.println("\nSeleccionaste la opción para registrar un paciente");

                    String idPaciente = hospital.generarIdPaciente();


                    ArrayList<String> datosPaciente = this.obtenerDatosComun(Rol.PACIENTE);

                    String nombrePaciente = datosPaciente.get(0);

                    String apellidoPaciente = datosPaciente.get(1);

                    LocalDate fechaNacimientoPaciente= LocalDate.parse(datosPaciente.get(2));

                    String numeroTelefonoPaciente = datosPaciente.get(3);

                    String contraseniaPaciente = datosPaciente.get(4);


                    System.out.println("Ingresa el tipo de sangre del paciente: ");
                    String tipoDeSangre = scanner.nextLine();

                    scanner.nextLine();

                    System.out.println("Ingresa el sexo del paciente: ");
                    char sexo = scanner.next().charAt(0);


                    Paciente paciente = new Paciente(idPaciente,nombrePaciente,apellidoPaciente,fechaNacimientoPaciente,numeroTelefonoPaciente,tipoDeSangre,sexo,contraseniaPaciente);

                    hospital.registrarPaciente(paciente);

                    System.out.println("\nPaciente registrado correctamente ");
                    System.out.println("id:"+idPaciente);
                    break;

                case 2:
                    System.out.println("\nSeleccionaste la opción para registrar un medico");


                    ArrayList<String> datosMedico = this.obtenerDatosComun(Rol.MEDICO);

                    String nombreMedico = datosMedico.get(0);

                    String apellidoMedico = datosMedico.get(1);

                    LocalDate fechaNacimientoMedico = LocalDate.parse(datosMedico.get(2));

                    String numeroTelefonoMedico = datosMedico.get(3);

                    String contraseniaMedico = datosMedico.get(4);

                    System.out.println("Ingresa el RFC del medico: ");
                    String rfcMedico = scanner.nextLine();
                    String idMedico = hospital.generarIdMedico(nombreMedico, String.valueOf(fechaNacimientoMedico));
                    Medico medico = new Medico(idMedico,nombreMedico,apellidoMedico,fechaNacimientoMedico,numeroTelefonoMedico,rfcMedico,contraseniaMedico);
                    hospital.registrarMedico(medico);
                    System.out.println("\nMedico con el id: "+idMedico+" registrado correctamente ");
                    break;

                case 3:
                    System.out.println("\nSeleccionaste la opción para Registrar Consultorio ");
                    String idConsultorio = hospital.generarIdConsultorio();
                    System.out.println("Ingrese el piso del consultorio: ");
                    int piso = scanner.nextInt();
                    System.out.println("Ingrese el numero del consultorio: ");
                    int numeroConsultorio= scanner.nextInt();
                    Consultorio consultorio = new Consultorio(idConsultorio,piso,numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    break;
                case 4:
                    System.out.println("\nSeleccionaste la opción para Registrar Consulta ");
                    LocalDateTime fechaConsulta = null;
                    boolean fechaValida = false;

                    while (!fechaValida) {
                        System.out.println("Ingresa el dia de la consulta deseada: ");
                        int diaConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingresa el mes de la consulta deseada: ");
                        int mesConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingresa el año de la consulta deseada: ");
                        int anioConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingrese la hora de la consulta deseada: ");
                        int horaConsulta = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Ingresa los minutos de la consulta deseada: ");
                        int minutosConsulta = scanner.nextInt();
                        scanner.nextLine();

                        fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);

                        if (!hospital.validarFechaConsulta(fechaConsulta)) {
                            System.out.println("La fecha no puede estar en el pasado. Intente de nuevo.");
                        } else {
                            fechaValida = true; // Salir del bucle si la fecha es válida
                        }
                    }

                    Paciente pacienteConsulta = null;
                    while (pacienteConsulta == null) {
                        System.out.println("Ingresa el id del paciente: ");
                        String pacienteId = scanner.nextLine();

                        pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);

                        if (pacienteConsulta == null) {
                            System.out.println("Paciente no encontrado. Intente de nuevo");
                        }
                    }
                    Medico medicoConsulta = null;

                    while (medicoConsulta == null) {
                        System.out.println("Ingresa el id del medico: ");
                        String medicoId = scanner.nextLine();

                        medicoConsulta = hospital.obtenerMedicoPorId(medicoId);

                        if (medicoConsulta == null) {
                            System.out.println("Médico no encontrado. Intente de nuevo.");
                        }
                    }
                    System.out.println("Ingresa el numero del consultorio: ");
                    numeroConsultorio = scanner.nextInt();
                    scanner.nextLine();

                    Consultorio consultorioConsulta = null;
                    for (Consultorio consultorio2 : hospital.listaConsultorios) {
                        if (consultorio2.getNumeroConsultorio() == numeroConsultorio) {
                            consultorioConsulta = consultorio2;
                            break;
                        }
                    }
                    if (consultorioConsulta == null) {
                        System.out.println("Consultorio no encontrado.");
                        break;
                    }

                    Consulta nuevaConsulta = new Consulta(numeroConsultorio, fechaConsulta, pacienteConsulta, medicoConsulta, consultorioConsulta);
                    if (hospital.validarConsulta(fechaConsulta, numeroConsultorio, medicoConsulta.getId())) {
                        hospital.registrarConsulta(nuevaConsulta);
                        System.out.println("Consulta registrada correctamente.");
                    } else {
                        System.out.println("No se pudo registrar la consulta. El consultorio o el médico no están disponibles en esa fecha.");
                    }

                    break;


                case 5:
                    System.out.println("\nSeleccionaste la opción para Mostrar Pacientes ");
                    hospital.mostrarPacientes();
                    break;
                case 6:
                    System.out.println("\nSeleccionaste la opción para Mostrar Medicos");
                    hospital.mostrarMedicos();
                    break;

                case 7:
                    System.out.println("\nSeleccionaste la opción para Mostrar Consultorios");
                    hospital.mostrarConsultorios();
                    break;
                case 8:
                    System.out.println("\nSeleccionaste la opción para Mostrar Consulta");
                    hospital.mostrarConsultas();
                    break;

                case 9:
                    System.out.println("/nSeleccionaste la opcion de Mostrar Paciente por Id ingresalo");
                    String idPacienteM =scanner.nextLine();

                    hospital.mostrarPacientePorId(idPacienteM);
                    break;
                case 10:
                    System.out.println("\nSeleccionaste la opcion de mostrar Medicos por su ID, ingresalo:");
                    String idDeConsultorio =scanner.nextLine();
                    hospital.mostrarMedicoPorId(idDeConsultorio);
                    break;
                case 11:
                    hospital.mostrarInfoAdmin(administrador);
                    break;

                case 12:
                    return;
            }

        }

        private ArrayList<String> obtenerDatosComun(Rol rol){
        String tipousuario = rol == Rol.PACIENTE ? "paciente" : rol == Rol.MEDICO ? "medico" : "administrador";
        ArrayList<String> datosEnComun = new ArrayList<>();

            System.out.println(String.format("Ingrese el nombre del %s",tipousuario));
            String nombre = scanner.nextLine();
            datosEnComun.add(nombre);
            System.out.println(String.format("Ingrese el apellido del %s",tipousuario));
            String apellido = scanner.nextLine();
            datosEnComun.add(apellido);

            datosEnComun.add(obtenerFechaNacimientoUsuario(tipousuario));

            System.out.println(String.format("Ingrese el telefono del:  %s",tipousuario));
            String telefono = scanner.nextLine();
            datosEnComun.add(telefono);
            System.out.println(String.format("Ingrese la contrasenIa del:  %s",tipousuario));
            String contrasenia = scanner.nextLine();
            datosEnComun.add(contrasenia);
            return datosEnComun;
        }

        private String obtenerFechaNacimientoUsuario (String tipoUsuario){
        boolean esFechaValida = false;
        LocalDate fechaNacimiento = LocalDate.now();

        while (!esFechaValida){
            System.out.println(String.format("Ingrese el anio de nacimiento del:  %s",tipoUsuario));
            int anio = scanner.nextInt();
            System.out.println(String.format("Ingrese el mes de nacimiento del:  %s",tipoUsuario));
            int mes = scanner.nextInt();
            System.out.println(String.format("Ingrese el dia de nacimiento del:  %s",tipoUsuario));
            int dia = scanner.nextInt();
            scanner.nextLine();
            fechaNacimiento = LocalDate.of(anio, mes, dia);
            if (fechaNacimiento.isAfter(LocalDate.now())) {
                System.out.println("La fecha de nacimiento no puede ser posterior al dia de hoy.");
            } else{
                esFechaValida = true;
            }
        }
        return fechaNacimiento.toString();
        }
        private boolean validarTelefonoRepetido(
                ArrayList<? extends Usuario>listaUsarios, String telefono
        ){
        for (Usuario usuario : listaUsarios) {
            if(usuario.getTelefono().equals(telefono)){
                System.out.println("Ya existe un usuario con ese telefono. Intenta de nuevo");
                return false;
            }
        }
        return true;
        }
    }

