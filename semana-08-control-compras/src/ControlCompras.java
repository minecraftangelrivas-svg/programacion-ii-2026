import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class ControlCompras {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Producto> listaProductos = new ArrayList<>();
        HashSet<String> categoriasSet = new HashSet<>();
        HashMap<String, Double> totalesPorCategoria = new HashMap<>();

        System.out.println("   SISTEMA DE CONTROL DE COMPRAS          ");
        System.out.println("Debe registrar como minimo 5 productos validos\n");

        int productosRe = 0;
        int contadorI = 1;

        // Registro de productos con validaciones
        while (productosRe < 5) {
            System.out.println("    Ingreso de Producto " + contadorI + "    ");

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine().trim();

            System.out.print("Precio unitario: ");
            double precioUnitario = Double.parseDouble(scanner.nextLine());

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            // Parte 3: Validaciones
            if (nombre.isEmpty()) {
                System.out.println("\nERROR Producto no registrado: el nombre no puede estar vacío.\n");
                continue;
            }

            if (categoria.isEmpty()) {
                System.out.println("\nERROR Producto no registrado: la categoría no puede estar vacía.\n");
                continue;
            }

            if (precioUnitario <= 0) {
                System.out.println("\nERROR Producto no registrado: el precio debe ser mayor que cero.\n");
                continue;
            }

            if (cantidad <= 0) {
                System.out.println("\nERROR Producto no registrado: la cantidad debe ser mayor que cero.\n");
                continue;
            }

            Producto nuevoProducto = new Producto(nombre, categoria, precioUnitario, cantidad);
            listaProductos.add(nuevoProducto);
            categoriasSet.add(categoria);

            double subtotalActual = nuevoProducto.calcularSubtotal();
            if (totalesPorCategoria.containsKey(categoria)) {
                double acumulado = totalesPorCategoria.get(categoria);
                totalesPorCategoria.put(categoria, acumulado + subtotalActual);
            } else {
                totalesPorCategoria.put(categoria, subtotalActual);
            }

            productosRe++;
            contadorI++;
            System.out.println(" Producto registrado con éxito.\n");
        }

        System.out.println("\n===== RESUMEN DE COMPRAS =====\n");

        double totalGeneral = 0.0;
        Producto productoMayorGasto = listaProductos.get(0);
        Producto productoMenorGasto = listaProductos.get(0);

        for (Producto p : listaProductos) {
            double subtotal = p.calcularSubtotal();
            totalGeneral += subtotal;

            System.out.println(p.getNombre() + " | " + p.getCategoria() + " | Q" + p.getPrecioUnitario() + " x " + p.getCantidad() + " | Subtotal: Q" + subtotal);

            if (subtotal > productoMayorGasto.calcularSubtotal()) {
                productoMayorGasto = p;
            }

            if (subtotal < productoMenorGasto.calcularSubtotal()) {
                productoMenorGasto = p;
            }
        }

        System.out.println("\nCategorías registradas:");
        System.out.println(categoriasSet);

        System.out.println("\nTotal por categoría:");
        String categoriaMayorGasto = "";
        double mGastoCategoria = -1.0;

        for (String cat : totalesPorCategoria.keySet()) {
            double totalCat = totalesPorCategoria.get(cat);
            System.out.println(cat + ": Q" + totalCat);

            if (totalCat > mGastoCategoria) {
                mGastoCategoria = totalCat;
                categoriaMayorGasto = cat;
            }
        }

        System.out.println("\nProductos registrados: " + listaProductos.size());

        System.out.println("\nTotal general: Q" + totalGeneral);

        System.out.println("\nProducto con mayor gasto:");
        System.out.println(productoMayorGasto.getNombre() + " - Q" + productoMayorGasto.calcularSubtotal());

        System.out.println("\nProducto con menor gasto:");
        System.out.println(productoMenorGasto.getNombre() + " - Q" + productoMenorGasto.calcularSubtotal());

        System.out.println("\nCategoría con mayor gasto:");
        System.out.println(categoriaMayorGasto + " - Q" + mGastoCategoria);

        System.out.println("\n==========================================");
        System.out.print("Ingrese una categoría para consultar: ");
        String categoriaBuscada = scanner.nextLine().trim();

        if (totalesPorCategoria.containsKey(categoriaBuscada)) {
            double gastoConsultado = totalesPorCategoria.get(categoriaBuscada);
            System.out.println("Total gastado en " + categoriaBuscada + ": Q" + gastoConsultado);
        } else {
            System.out.println("La categoría ingresada no se encuentra registrada.");
        }

        scanner.close();
    }
}