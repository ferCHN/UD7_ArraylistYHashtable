package main;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

//import javax.management.StringValueExp;

public class Ex3_StockProductosApp {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		3.Crea una base de datos de 10 artículos para controlar el
		stock de productos de una tienda por medio de un diccionario
		de datos (articulo:precio). El usuario podrá añadir, por medio
		de interfaz visual artículos nuevos y cantidades de estos. El
		usario podrá consultar la información almacenada en el
		diccionario referente a un articulo concreto e incluso listar toda
		la información en la terminal del programa.
		*/
		// Declaro la Hashtable para guardar los productos con su codigo, nombre, precio y cantidad
		Hashtable<String, ArrayList<String>> productos = new Hashtable<String, ArrayList<String>>();

		boolean salir = false;
		while (!salir) {
			System.out.println(
					"Que quieres hacer?\n1 - Insertar producto\n2 - Ver todos los productos\n3 - Buscar producto\n4 - Salir");
			int opcion = teclado.nextInt();
			System.out.println();

			switch (opcion) {
			case 1:
				insertarProducto(productos);
				break;

			case 2:
				verTodo(productos);
				break;
			case 3:
				verProducto(productos);
				break;

			case 4:
				salir = true;
				break;

			default:
				System.out.println("Has introducido mal la opcion, pon un numero del 1 al 4");
				break;
			}

		}

	}

	public static void insertarProducto(Hashtable<String, ArrayList<String>> productos) {

		ArrayList<String> datosProducto = new ArrayList<String>();

		String codigoProducto;
		String nombreProducto;

		double precio;
		String precioString;

		int cantidad;
		String cantidadString;

		System.out.println("Introduce el codigo del producto:");
		codigoProducto = teclado.next();
		System.out.println("Introduce el nombre del producto:");
		nombreProducto = teclado.next();
		System.out.println("Introduce el precio de " + nombreProducto);
		precio = teclado.nextDouble();
		precioString = String.valueOf(precio);
		System.out.println("Introduce la cantidad de " + nombreProducto);
		cantidad = teclado.nextInt();
		cantidadString = String.valueOf(cantidad);
		System.out.println();

		// Añado los datos en el ArrayList para introducirla en el Hashtable
		datosProducto.add(nombreProducto);
		datosProducto.add(precioString);
		datosProducto.add(cantidadString);

		// Introduzo las variables pedidas por teclado al Hashtable
		productos.put(codigoProducto, datosProducto);

	}

	public static void verTodo(Hashtable<String, ArrayList<String>> productos) {

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
			datosProductos = productos.get(codigoActual);

			System.out.println("[Codigo: " + codigoActual + "] - Nombre: " + datosProductos.get(0) + " | " + "Precio: "
					+ datosProductos.get(1) + " | " + "Cantidad: " + datosProductos.get(2));
			System.out.println();
		}

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