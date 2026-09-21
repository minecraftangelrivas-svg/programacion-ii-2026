public class automovil extends vehiculo {
    private static final double TARIFA_POR_HORA = 10.00;

    public automovil(String placa, String propietario, String horaI, int horasUt) {
        super(placa, propietario, horaI, horasUt);
    }

    @Override
    public double calcularCosto() {
        double subtotal = getHorasUt() * TARIFA_POR_HORA;
        if (getHorasUt() > 5) {
            subtotal *= 0.90; // Apply 10% discount
        }
        return subtotal;
    }

    @Override
    public String getTipoVehiculo() {
        return "Automóvil";
    }
}