public class EnvioInternacional extends Envio{

    private String paisDestino;
    private int cargoFijo = 75;

    //constructor
    public EnvioInternacional(String codigoenvio, String nombre, double pesoKg, String paisDestino) {
        super(codigoenvio, nombre, pesoKg); // Inicializa los atributos y envia los datos al  padre
        this.paisDestino = paisDestino;

    }

    @Override//sobre escritura
    public double calcularCostoFinal(){
        return super.calcularCostoBase() + cargoFijo + (this.calcularCostoBase() * 0.12);
    }

    // sobreescritura
    @Override
    public void Resumen(boolean desgloseCompleto) {
        if (desgloseCompleto) {
            System.out.println("--- RESUMEN ENVÍO INTERNACIONAL ---");
            System.out.println("Código: " + getCodigoenvio());
            System.out.println("Destinatario: " + getNombre());
            System.out.println("Pais de Destino: " + paisDestino);
            System.out.println("Peso: " + getPesoKg() + " kg");
            System.out.println("Costo Base: Q" + calcularCostoBase());
            System.out.println("Cargo Fijo Internacional: Q" + cargoFijo);
            System.out.println("Costo Final: Q" + calcularCostoFinal());
        } else {
            Resumen();
        }
    }

    public String getpaisDestino() {
        return paisDestino;
    }


}

