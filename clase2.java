 import java.util.Scanner;


public class clase2 {

    public static double gastor( double a, double b, double c) {

        return a + b + c;
    }

    public static double gastor( double a, double b, double c, double x) {
    double resultado = x+b+c;
    double afinal = a - resultado;
        return afinal;
    }

    public static String estado (double a, double v) {
       if( a > v){
           return "Dentro del presupuesto";
       }else if (a == v){
           return "PRESUPUESTO AGOTADA";
        }
       else{
           return"EXCEDIO EL PRESUPUESTO";
       }
    }
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);


        System.out.print(" Ingrese su nombre\n ");
        String nombre = entrada.nextLine();


        System.out.print(" Ingrese su Presupuesto Semanal ");
        double presupuesto = entrada.nextDouble();

        System.out.print(" Ingrese su Gasto de Alimentacion ");
        double alimento = entrada.nextDouble();

        System.out.print(" Ingrese su Gasto de Trasporte ");
        double trasporte = entrada.nextDouble();

        System.out.print(" Ingrese Gasto de otro ");
        double otro = entrada.nextDouble();

        System.out.print(" ======== RESUMEN SEMANAL ========\n ");
        System.out.println("NOMBRE: " + nombre );
        System.out.println("PRESUPUESTO: " + presupuesto);
        System.out.println("TOTAL GASTADO: " + gastor(alimento, trasporte, otro));
        System.out.println("SALDO RESTANTE: " + gastor(presupuesto, trasporte, otro, alimento));
        System.out.println("ESTADO: " + estado(presupuesto,gastor(alimento,trasporte,otro)));




    }
}
