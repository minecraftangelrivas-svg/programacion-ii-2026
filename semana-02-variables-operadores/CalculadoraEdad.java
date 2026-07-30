import java.util.Scanner;

public class CalculadoraEdad {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");//Esta parte se encarga del ingreso de datos
        String nombre = entrada.nextLine();

        System.out.print("Ingrese su CARNET: ");//Esta parte se encarga del ingreso de datos
        String carnet = entrada.nextLine();

        System.out.print("Ingrese su año de nacimiento: ");
        int anioNacimiento = entrada.nextInt();

        System.out.print("Ingrese año presente: ");
        int aniopresente = entrada.nextInt();


        int edadproxima = aniopresente - anioNacimiento; // Esta parte se encarga del proceso matematico la edad proxima
        int edadmes = edadproxima * 12;                  // edad visto en meses
        boolean mayor = edadproxima >= 18;               // la condicion para saber si es true o false determinando que si es mayor


         System.out.println("----------RESULTADO----------");
          System.out.println("Nombre: " + nombre);
        System.out.println("Carnet: " + carnet);
          System.out.println("Edad Proximada: " + edadproxima);
          System.out.println("Edad en meses: " + edadmes);
          System.out.println("¿Es mayor de edad?: " + (mayor ? "si es mayor de edad": "no es mayor de edad"));

    }
}