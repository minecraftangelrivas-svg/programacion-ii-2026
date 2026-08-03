import java.util.Scanner;


public class tarea2
{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("========= DESAFÍOS LÓGICOS =========\n");// menu de entrada
        System.out.println("1. Generar una secuencia: ");
        System.out.println("2. Realizar un conteo regresivo: ");
        System.out.println("3. Analizar números: ");
        System.out.println("4. Dibujar una pirámide: ");
        System.out.println("5. Validar palabra secreta: ");
        System.out.println("6. Salir: ");
        System.out.println("====================================");
        int llave  = entrada.nextInt();

        int secuenciar,  ignorado = 0 ,positivo = 0, negative = 0; //aqui ingrese estas variables para poder llamarlas mas facil en el futuro
        int cantidadp = 0, cantidadn =0, anaR;
        boolean caso3 = true;
        String ingreso;
        switch(llave) {//switch para iniciar el menu


            case 1:
                System.out.print("INGRESE NUMERO INICIAL DE LA SECUENCIA: ");// se solicitan los datos para que el programa funcione
                int numeroI = entrada.nextInt();
                System.out.print("INGRESE NUMERO FINAL DE LA SECUENCIA: ");
                int numeroF = entrada.nextInt();
                System.out.print("INGRESE NUMERO INCREMENTO DE LA SECUENCIA: ");
                int increment = entrada.nextInt();


                System.out.print("========= RESULTADO DE LA SECUENCIA =========\n");
                for (int i = numeroI; i <= numeroF; i += increment) {//proceso de creacion de la secuencia usando los datos dados

                    System.out.print(i + ". ");

                }

                System.out.println("FIN DE LA SECUENCIA");
                break;


            case 2:
                do {// ayuda a generar el bucle hasta que se cumplan las condiciones
                    System.out.print("INGRESE NUMERO ENTRE 10 Y 50 PARA LA SECUENCIA REGRESIVA : ");
                     secuenciar = entrada.nextInt();

                    if (secuenciar < 10 || secuenciar > 50) {// aqui lo uso para poder mostrar el mensaje

                        System.out.println("ERROR " + secuenciar + " NO ESTA DENTRO DEL RANGO");
                        System.out.println("INGRESA EL NUMERO NUEVAMENTE");
                    }
                }

                while (secuenciar < 10 || secuenciar > 50); // aqui analisa si cumple o no

                for (int i = secuenciar; i >= 0; i--) { // se procede a hacer la cuenta regresiva por una resta usando un for
                    if (i == 0){
                        System.out.println(i + " !DESPEGUE! ");
                    } else{ System.out.print(" " + i + " ");}

                }break;


            case 3:
                while (caso3) {
                    System.out.println("INGRESE UN NUMERO o USE 0 PARA TERMINAR: ");
                   int analista = entrada.nextInt();

                   if (analista == 0) {// saca del bucle si es 0
                       System.out.println("ESTA SALIENDO DEL BUCLE:");
                       break;
                   } if (analista % 5 == 0) {
                        System.out.println("EL NUMERO: " + analista + " FUE IGNORADO");
                        ignorado++;// contador de ignorados
                        continue;
                      }

                        if (analista > 0) {// systema para contar positivos y negarivos y sumarlos
                            positivo += analista;
                            cantidadp++;
                        } else {
                            negative += analista;
                            cantidadn++;
                        }

                }
                anaR = positivo + negative;
                System.out.println("========= RESULTADO DE EL ANALISIS =========");
                System.out.println("POSITIVO: " + cantidadp);
                System.out.println("NEGATIVOS: " + cantidadn);
                System.out.println("SUMA VALIDA: " + anaR);
                System.out.println("NUMERO IGNORADOS: " + ignorado);


                break;

            case 4:
                System.out.println("INGRESE EL NIVEL DE LA PIRAMIDE ES DE 3-10 DE ALLTURA");
                int limite = entrada.nextInt();

                if (limite < 3 || limite > 10) {
                    System.out.println("EL RANGO PERMITIDO ES DE 3-10");
                } else {
                    for (int i = 1; i <= limite; i++) {//creacion de filas
                        System.out.println();
                        for (int j = 1; j <= limite - i; j++) {//creacion de espacios
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= (i * 2) - 1; k++) {//creacion de * para la piramide
                            System.out.print("*");
                        }

                    }
                 }
                break;

            case 5:
                String secreta = "Guatemala";//la palabra secreta
                System.out.println("--- BIENVENIDO A LA PALABRA SECRETA ---");

                do {
                    System.out.print("ESCRIBA LA PALABRA SECRETA: ");// comienza el ciclo hasta que atinana a la palabra
                    ingreso = entrada.next().trim();// ignora espacios

                    if (!ingreso.equalsIgnoreCase(secreta)) { // Aqui use equalsIgnoreCase para poder ignorar mayusculas
                        System.out.println("Error. Intente nuevamente.");
                    }

                } while (!ingreso.equalsIgnoreCase(secreta)); // Aqui use equalsIgnoreCase para poder ignorar mayusculas

                System.out.println(" ¡CONOCES LA CLAVE! Palabra correcta.");

                break;

            case 6:
                System.out.println("Saliendo del programa ....");
                System.exit(0);

                break;

            default:
                System.out.println("Eso no es una Opcion");


        }










    }
}
