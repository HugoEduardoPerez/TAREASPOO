public class Curso {
    public String nombreCurso;
    public String codigoCurso;
    public String instructor;

    public Curso(String nombreCurso, String codigoCurso, String instructor) {
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.instructor = instructor;
    }

    public  void MostrarInfoCurso() {
        System.out.println("Nombre del curso: " + nombreCurso);
        System.out.println("Codigo del curso: " + codigoCurso);
        System.out.println("Instructor: " + instructor);
    }
    public String getNombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    public String getCodigoCurso() {
        return codigoCurso;
    }
    public String toString() {
        return "Curso: " + nombreCurso + ", Código: " + codigoCurso + ", Profesor: " + instructor;
    }
}
