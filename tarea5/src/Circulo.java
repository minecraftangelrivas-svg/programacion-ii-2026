public class Circulo extends Figura {
    private double radio;

    public Circulo(
            String nombre,
            double radio) {
        super(nombre);


        if (radio > 0) {
         this.radio = radio;
        }else{
            System.out.println("Radio es inválido es menor o igual a 0. Se asignó 1.0 por defecto.");
            this.radio = 1.0;
        }

    }

    @Override
    public double calcularArea() {//Math.pow hace la funcion para elevar a la dos el radio
        return Math.PI * Math.pow(radio, 2);
    }
}

