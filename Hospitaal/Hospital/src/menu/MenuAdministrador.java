package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.Administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

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
                    System.out.println("\nSeleccionaste la opción para Registrar Paciente");

                    String id=hospital.generarIdPaciente();

                    System.out.println("Ingresa el nombre del paciente ");
                    String nombre= scanner.nextLine();

                    System.out.println("Ingresa el apellido del paciente ");
                    String apellido= scanner.nextLine();

                    System.out.println("Ingresa el año de nacimiento del paciente: ");
                    int anio = scanner.nextInt();

                    System.out.println("Ingresa el mes de nacimiento del paciente: ");
                    int mes = scanner.nextInt();

                    System.out.println("Ingresa el dia de nacimiento del paciente: ");
                    int dia = scanner.nextInt();

                    LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
                    System.out.println("Ingresa el tipo de sangre del paciente ");
                    String tipoSangre= scanner.nextLine();

                    System.out.println("Ingresa el telefono del paciente ");
                    String numeroTelefono= scanner.nextLine();

                    System.out.println("Ingresa el sexo del paciente: ");
                    String sexoString= scanner.nextLine();
                    System.out.println("Ingresa la contrasenia del paceinte: ");
                    String contrasenia = scanner.nextLine();
                    char sexo= sexoString.charAt(0);
                    Paciente paciente =new Paciente(id,nombre,apellido,fechaNacimiento,tipoSangre,numeroTelefono,sexo, contrasenia);
                    hospital.registrarPaciente(paciente);

                    System.out.println(" Paciente registrado correctamente ");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del medico ");
                    String nombreMedico= scanner.nextLine();
                    System.out.println("Ingresa el apellido del medico ");
                    String apellidoMedico= scanner.nextLine();
                    System.out.println("Ingrese la contrasenia del medico: ");
                    String contraseniaM = scanner.nextLine();
                    System.out.println("Ingresa el año de nacimiento del paciente: ");
                    int anioMedico = scanner.nextInt();
                    System.out.println("Ingresa el mes de nacimiento del paciente: ");
                    int mesMedico = scanner.nextInt();

                    System.out.println("Ingresa el dia de nacimiento del paciente: ");
                    int diaMedico = scanner.nextInt();
                    LocalDate anoMedico = LocalDate.of(anioMedico, mesMedico, diaMedico );
                    String idMedico = hospital.generarIdMedico(nombreMedico, String.valueOf(anioMedico));
                    String telefonoMedico = null;
                    boolean telefonoUnico = false;
                    while (!telefonoUnico) {
                        System.out.println("Ingresa el número de teléfono: ");
                        telefonoMedico = scanner.nextLine();
                        telefonoUnico = true;
                        for (Medico medicoExistente : hospital.listaMedicos) {
                            if (medicoExistente.getTelefono().equals(telefonoMedico)) {
                                System.out.println("Ya existe un médico con este número de teléfono. Intente de nuevo.");
                                telefonoUnico = false;
                                break;
                            }
                        }
                    }
                    String rfcMedico = null;
                    boolean rfcUnico = false;
                    while (!rfcUnico) {
                        System.out.println("Ingresa el RFC del médico: ");
                        rfcMedico = scanner.nextLine();
                        rfcUnico = true;
                        for (Medico medicoExistente : hospital.listaMedicos) {
                            if (medicoExistente.getRfc().equals(rfcMedico)) {
                                System.out.println("Ya existe un médico con este RFC. Intente de nuevo.");
                                rfcUnico = false;
                                break;
                            }
                        }
                    }
                    Medico medico = new Medico(idMedico, apellidoMedico, nombreMedico, anoMedico, telefonoMedico, rfcMedico, contraseniaM);
                    hospital.registrarMedico(medico);

                    System.out.println("Médico registrado correctamente.");
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
                    String idPaciente =scanner.nextLine();

                    hospital.mostrarPacientePorId(idPaciente);
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
    }

