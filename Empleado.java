public class Empleado {
    public String nombre;
    public int idEmpleado;
    public double sueldo;

    public Empleado(String nombre, int idEmpleado, double sueldo) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
    }
    public static Double calcularSalario(Double SueldoBase, Double bonificacion, Double horasExtras ) {
        return SueldoBase+bonificacion+(horasExtras*20);
    }
    public static Double calcularSalario(Double SueldoBase, Double bonificacion) {
        return SueldoBase+bonificacion;
    }
    public static Double calcularSalario(Double SueldoBase) {
        return SueldoBase;
    }

}
