package main;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex2_FlujoVentasSupermercadoApp {
	
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		/* 2.Crea una aplicación que gestione el flujo de ventas de una
		caja de supermercado. El programa guardara la cantidades del
		carrito de compra dentro de una lista. Mostrará por pantalla la
		siguiente informacion:
		• IVA aplicado (21% o 4%)
		• precio total bruto y precio mas IVA.
		• Numero de artículos comprados.
		• Cantidad pagada.
		• Cambio a devolver al cliente.
		*/
	}

	public static void verProducto(Hashtable<String, ArrayList<String>> productos) {

		System.out.println("Introduce el codigo del producto que quieres ver");
		String codigoPedido = teclado.next();

		// Guardo las keys en un Enumeration
		Enumeration<String> codigosProductos = productos.keys();

		// Creo un ArrayList para guardar el ArrayList de cada elemento del Hashtable
		ArrayList<String> datosProductos = new ArrayList<String>();

		// Creo un String para guardarme el codigo del elemento que este recorriendo la
		// tabla
		String codigoActual;

		// Listo los productos
		while (codigosProductos.hasMoreElements()) {
			codigoActual = codigosProductos.nextElement();

			if (codigoActual.equals(codigoPedido)) {
				datosProductos = productos.get(codigoActual);

				System.out.println("[Codigo: " + codigoActual + "] - Nombre: " + datosProductos.get(0) + " | "
						+ "Precio: " + datosProductos.get(1) + " | " + "Cantidad: " + datosProductos.get(2));
				System.out.println();
			}

		}

	}

}