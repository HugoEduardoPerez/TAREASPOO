import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Habitacion habitacion1 = new Habitacion("Individual",50.00,true);
        Habitacion habitacion2 = new Habitacion("Doble",75.00,true);
        Habitacion habitacion3 = new Habitacion("Suite",150.00,true);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("--- Sistema de Reservas de Habitaciones ---");
            System.out.println("1.- Mostrar detalles de la habitacion: ");
            System.out.println("2.- Realizar una reserva: ");
            System.out.println("3.- Liberar una habitacion: ");
            System.out.println("4.- Salir: ");
            System.out.println("\n Seleccione una opcion; ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    habitacion1.mostrarDetalles();
                    habitacion2.mostrarDetalles();
                    habitacion3.mostrarDetalles();
                    break;
                    case 2:
                        System.out.print("Ingrese el número de habitación (1: Individual, 2: Doble, 3: Suite): ");
                        System.out.print("Ingrese el número de habitación (1, 2, o 3): ");
                        int numeroHabitacion = scanner.nextInt();
                        System.out.print("Ingrese el número de noches: ");
                        int noches = scanner.nextInt();
                        try {
                            switch (numeroHabitacion) {
                                case 1:
                                    habitacion1.reservar(noches);
                                    break;
                                case 2:
                                    habitacion2.reservar(noches);
                                    break;
                                case 3:
                                    habitacion3.reservar(noches);
                                    break;
                                default:
                                    System.out.println("Número de habitación no válido.");
                            }
                        } catch (Habitacion.HabitacionNoDisponibleException | Habitacion.NumeroDeNochesInvalidoException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                case 3:
                    System.out.print("Ingrese el número de habitación para liberar (1: Individual, 2: Doble, 3: Suite): ");
                    int habitacionLiberar = scanner.nextInt();
                    switch (habitacionLiberar){
                        case 1:
                            habitacion1.liberar();
                            break;
                        case 2:
                            habitacion2.liberar();
                            break;
                        case 3:
                            habitacion3.liberar();
                            break;

                            default:
                                System.out.println("Ingrese una opcion valida");
                                break;
                    }
                case 4:

                    break;

            }
        }

    }
}