import java.util.ArrayList;
public class Estudiante {
    public String nombre;
    public String idEstudiante;
    public ArrayList<Curso> listaCursos = new ArrayList<Curso>();
    public Estudiante(String nombre, String idEstudiante) {
        this.nombre = nombre;
        this.idEstudiante = idEstudiante;
    }
    public void AgregarCurso(Curso curso) {
        this.listaCursos.add(curso);
    }
    public void MostrarInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Id de estudiante: " + this.idEstudiante);
        System.out.println("Cursos inscritos: " + this.listaCursos);
        for (Curso curso : listaCursos) {
            System.out.println(" - " + curso);
        }
}
}