public class EnvioNacional extends Envio {

    private String departamentoDestino;
    private double distanciaKilometros;

    //constructor
    public EnvioNacional(String codigoenvio, String nombre, double pesoKg, String departamentoDestino, double distanciaKilometros) {
        super(codigoenvio, nombre, pesoKg); // Inicializa los atributos y envia los datos al  padre
        this.departamentoDestino = departamentoDestino;
        this.distanciaKilometros = distanciaKilometros;
    }

        @Override//sobre escritura
        public double calcularCostoFinal(){
            return super.calcularCostoBase() + (this.distanciaKilometros * 0.50);
        }

// sobreescritura
    @Override
    public void Resumen(boolean desgloseCompleto) {
        if (desgloseCompleto) {
            System.out.println("--- RESUMEN ENVÍO NACIONAL ---");
            System.out.println("Código: " + getCodigoenvio());
            System.out.println("Destinatario: " + getNombre());
            System.out.println("Departamento Destino: " + departamentoDestino);
            System.out.println("Distancia: " + distanciaKilometros + " km");
            System.out.println("Peso: " + getPesoKg() + " kg");
            System.out.println("Costo Base: Q" + calcularCostoBase());
            System.out.println("Cargo por Distancia: Q" + (distanciaKilometros * 0.50));
            System.out.println("Costo Final: Q" + calcularCostoFinal());
        } else {
            Resumen();
        }
    }

    public String getDepartamentoDestino() {
        return departamentoDestino;
    }

    public double getDistanciaKilometros() {
        return distanciaKilometros;
    }
}
