
public class Main {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Hugo Pérez","23121093");
        Estudiante estudiante2 = new Estudiante("Juan Pérez","23121094");
        Curso Lectura = new Curso("Lectura","1234A","David Zamora");
        Curso Matematicas = new Curso("Matematicas","1234B","David Zamora");
        Curso Ingles = new Curso("Ingles","1234C","David Zamora");

        estudiante1.AgregarCurso(Lectura);
        estudiante1.AgregarCurso(Matematicas);
        estudiante2.AgregarCurso(Ingles);
        estudiante2.AgregarCurso(Matematicas);

        System.out.println("\nInformación de los estudiantes:");
        estudiante1.MostrarInfo();
        System.out.println();
        estudiante2.MostrarInfo();

        }
    }
