public class Main {
    public static void main(String[] args) {

        Figura[] figuras = {

                new Circulo("Circulo Rojo ", 5.0),
                new Rectangulo("Rectángulo Verde ", 4.0, 6.0),
                new Triangulo("Triángulo Azul ", 3.0, 8.0)
        };
        System.out.println("--- CALCULO DE AREAS DE FIGURAS GEOMETRICAS ---\n");

        // recorrido con for
        for (Figura figura : figuras) {
            figura.mostrarInformacion();
            System.out.println ("Area: " +String.format("%.2f", figura.calcularArea()));
        }
    }
}