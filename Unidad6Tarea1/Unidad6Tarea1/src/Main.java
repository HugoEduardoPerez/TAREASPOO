import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String archivo = "tareas.txt";
        boolean salir = false;


        while (!salir) {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Escribir tarea");
            System.out.println("2. Leer tareas");
            System.out.println("3. Terminar");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la tarea: ");
                    String tarea = scanner.next();
                    agregarTarea(archivo, tarea);
                    System.out.println("Tarea guardada. ");
                    break;

                case 2:
                    leerTareas(archivo);
                    break;
                case 3:
                    salir = true;
                    break;

                    default:
                        System.out.println("Elija una opcion valida.");
                        break;

            }
        }


    }

    public static void agregarTarea(String archivo, String tarea) {
        try (BufferedWriter nuevo = new BufferedWriter(new FileWriter(archivo, true))) {
            nuevo.write(tarea);
            nuevo.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerTareas(String archivo) {
        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
            String linea;
            System.out.println("\nTareas guardadas:");
            while ((linea = leer.readLine()) != null) {
                System.out.println("- " + linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

}