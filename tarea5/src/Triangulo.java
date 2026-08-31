public class Triangulo extends Figura {

    private double base;
    private double altura;

    public Triangulo(
            String nombre,
            double base,
            double altura) {

        super(nombre);

        if (base > 0) {
            this.base = base;

        }else{
            System.out.println("Base es inválido por ser menor o igual a 0. Se asignó 1.0 por defecto a base");
            this.base= 1.00;
        }
        if (altura > 0) {
            this.altura = altura;

        }else{
            System.out.println("Altura es inválido por ser menor o igual a 0. Se asignó 1.0 por defecto a altura");
            this.altura = 1.00;
        }
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2.0;
    }
}