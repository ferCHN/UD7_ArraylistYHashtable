package main;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex1_NotaMediaAlumnosApp {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		1.Crea una aplicación que calcule la nota media de los
		alumnos pertenecientes al curso de programación. Una vez
		calculada la nota media se guardara esta información en un
		diccionario de datos que almacene la nota media de cada
		alumno. Todos estos datos se han de proporcionar por
		pantalla
		*/
		// Declaro los Hashtable para guardar los alumnos y sus notas
		Hashtable<String, double[]> alumnosNotas = new Hashtable<String, double[]>();
		Hashtable<String, Double> alumnosNotaMedia = new Hashtable<String, Double>();

		boolean salir = false;
		while (!salir) {
			System.out.println("Que quieres hacer?\n1 - Insertar alumno\n2 - Ver la nota media de un alumno\n3 - Salir");
			int opcion = teclado.nextInt();
			System.out.println();

			switch (opcion) {
			case 1:
				insertarAlumno(alumnosNotas, alumnosNotaMedia);
				break;

			case 2:
				verNotaMedia(alumnosNotaMedia);
				break;

			case 3:
				salir = true;
				break;

			default:
				System.out.println("Has introducido mal la opcion, pon un numero del 1 al 3");
				break;
			}

		}
	}

	// METODO PARA INTRODUCIR ALUMNOS EN AMBAS TABLAS
	public static void insertarAlumno(Hashtable<String, double[]> alumnosNotas,
			Hashtable<String, Double> alumnosNotaMedia) {
		String nombreAlumno;
		double[] notasAlumno = new double[3];

		System.out.println("Introduce el nombre del alumno:");
		nombreAlumno = teclado.next();

		for (int i = 0; i < notasAlumno.length; i++) {
			System.out.println("Introduce la nota del semestre " + (i + 1));
			notasAlumno[i] = teclado.nextDouble();
		}
		System.out.println();

		// Introduzo las variables pedidas por teclado al las Hashtable
		alumnosNotas.put(nombreAlumno, notasAlumno);
		alumnosNotaMedia.put(nombreAlumno, calcularNotaMedia(notasAlumno));

	}

	// METODO PARA CALCULAR LA NOTA MEDIA
	public static double calcularNotaMedia(double[] notas) {
		double suma = 0;
		double notaMedia;

		for (int i = 0; i < notas.length; i++) {
			suma += notas[i];
		}

		notaMedia = suma / notas.length;

		return notaMedia;

	}

	// METODO PARA VER LA NOTA MEDIA DE UN ALUMNO
	public static void verNotaMedia(Hashtable<String, Double> alumnosNotaMedia) {

		// Guardo las keys en un Enumeration
		Enumeration<String> nombresKey = alumnosNotaMedia.keys();
		String alumno;

		System.out.println("De que alumno quieres saber la nota media?");

		// Listo todas las keys
		while (nombresKey.hasMoreElements()) {
			System.out.println("[" + nombresKey.nextElement() + "]");
		}
		System.out.print("Alumno:");
		alumno = teclado.next();
		System.out.println();
		
		// Vuelvo a guardar las keys en Enumeration para que el puntero este al inicio
		nombresKey = alumnosNotaMedia.keys();

		// Si la key que me ha dado el usuario coincide le enseño el elemento asociado a
		// esa key
		while (nombresKey.hasMoreElements()) {
			if (nombresKey.nextElement().equals(alumno)) {
				System.out.println("La nota media de " + alumno + " es: " + alumnosNotaMedia.get(alumno));
				System.out.println();
			}
		}

	}

}