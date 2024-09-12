
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los datos del primer rectangulo: ");
        Double base = sc.nextDouble();
        Double altura = sc.nextDouble();
        Rectangulo rectangulo = new Rectangulo(base,altura);
        Double area = rectangulo.Calculararea(base, altura);
        System.out.println("AREA: " + area);
        Rectangulo rectangulo2 = new Rectangulo(base,2.4);
        System.out.println("Ingrese la base del segundo rectangulo: (la altura es 2.4) ");
        base = sc.nextDouble();
        double area2 = rectangulo2.Calculararea(base, altura);
        System.out.println("AREA2: " + area2);

        System.out.println("\n Ingrese su sueldo o sus bonificaciones y horas extras (si las tiene)");
        System.out.println("SUELDO");
        double sueldo = sc.nextDouble();
        System.out.println(" bonificaciones: ");
        double bonificaciones = sc.nextDouble();
        System.out.println("H. Extras: ");
        double horasExtras = sc.nextDouble();
        Empleado empleado = new Empleado("Hugo Perez",23121093, sueldo);
        if (bonificaciones <= 0  && horasExtras <= 0) {
            double salarioFinal = Empleado.calcularSalario(sueldo);
            System.out.println("Salario final: " +"$"+ salarioFinal);
        } else if (bonificaciones > 0  && horasExtras <= 0) {
            double salarioFinal = Empleado.calcularSalario(sueldo, bonificaciones);
            System.out.println("Salario final: " +"$"+ salarioFinal);
        } else {
            double salarioFinal = Empleado.calcularSalario(sueldo,bonificaciones,horasExtras);
            System.out.println("Salario final: " + "$"+salarioFinal);
        }

        System.out.println("\n " +
                "\nEscriba 1 si solo va a usar los ingresos" +
                "\nEscriba 2 si va a usar las ventas y el porcentaje de ingresos" +
                "\nEscriba 3 para trabajar con los dividendos, impuestos y exencion");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Escriba los ingresos: ");
                int ingresos = sc.nextInt();
                Double Impfinal =  CalculadoraImpuestos.calcularImpuestos(ingresos);
                System.out.println("IMPUESTO FINAL: " + Impfinal);
                break;
                case 2:
                    System.out.println("Ingrese dividendos y porcentaje de impuestos: ");
                    Double dividendos = sc.nextDouble();
                    System.out.println("Ingrese porcentaje de impuestos: ");
                    Double porcentajeingresos = sc.nextDouble();
                    Double Impfinal2 = CalculadoraImpuestos.calcularImpuestos(dividendos,porcentajeingresos);
                    System.out.println("IMPUESTO FINAL: " + Impfinal2);
                    break;
                case 3:
                    System.out.println("Ingrese Dividendos, porcentaje de impuestos y exencion: ");
                    double dividendos2 = sc.nextDouble();
                    double porcentajeingresos2 = sc.nextDouble();
                    double exencion = sc.nextDouble();
                    double impfinal3 = CalculadoraImpuestos.calcularImpuestos(dividendos2,porcentajeingresos2,exencion);
                    System.out.println("IMPUESTO FINAL: " + impfinal3);
                    break;
                    default:
                        System.out.println("Ingrese una opcion valida");
        }
    }
}