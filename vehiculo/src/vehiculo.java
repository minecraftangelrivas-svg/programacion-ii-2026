public abstract class vehiculo {
    private String placa;
    private String propietario;
    private String horaI;//horaIngreso
    private int horasUt;//horasUtilizadas

    public vehiculo(String placa, String propietario, String horaI, int horasUt) {
        this.placa = placa;
        this.propietario = propietario;
        this.horaI = horaI;
        this.horasUt = horasUt;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getHoraI() {
        return horaI;
    }

    public void setHoraIngreso(String horaI) {
        this.horaI = horaI;
    }

    public int getHorasUt() {
        return horasUt;
    }

    public void setHorasUt(int horasUt) {
        this.horasUt = horasUt;
    }

    //polimorfismo
    public abstract double calcularCosto();

    // Método abstracto para el tipo
    public abstract String getTipoVehiculo();

    public void mostrarInformacion() {
        System.out.println("Placa: " + placa);
        System.out.println("Propietario: " + propietario);
        System.out.println("Hora de Ingreso: " + horaI);
        System.out.println("Horas Utilizadas: " + horasUt);
        System.out.println("Tipo: " + getTipoVehiculo());
        System.out.println("Costo Total: Q" + calcularCosto());
    }
}