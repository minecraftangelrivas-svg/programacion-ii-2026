public class Envio {

    private String codigoenvio;
    private String nombre;
    private double pesoKg;

    // Constructor
    public Envio(String codigoenvio, String nombre, double pesoKg) {
        this.codigoenvio = codigoenvio;
        this.nombre = nombre;

    }

    // Métodos de Cálculo
    public double calcularCostoBase() {
        return this.pesoKg * 10.00;
    }

    public double calcularCostoFinal() {
        return calcularCostoBase();
    }

    // SOBRECARGA
    public void Resumen() {
        System.out.println("Código: " + codigoenvio);
        System.out.println("Destinatario: " + nombre);
        System.out.println("Costo Final: Q" + String.format("%.2f", calcularCostoFinal()));
    }

    // SOBRECARGA
    public void Resumen(boolean desgloseCompleto) {
        if (desgloseCompleto) {
            System.out.println("--- RESUMEN DETALLADO DE ENVÍO ---");
            System.out.println("Código: " + codigoenvio);
            System.out.println("Destinatario: " + nombre);
            System.out.println("Peso: " + pesoKg + " kg");
            System.out.println("Costo Base: Q" + String.format("%.2f", calcularCostoBase()));
            System.out.println("Cargos Adicionales: Q0.00");
            System.out.println("Costo Final: Q" + String.format("%.2f", calcularCostoFinal()));
        } else {
            Resumen();
        }
    }
//Encapsulamiento
    public String getCodigoenvio() {
        return codigoenvio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPesoKg() {
        return pesoKg;
    }
}