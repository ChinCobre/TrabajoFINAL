package PARTE1;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LibroRepository libro = new LibroRepository();
		Scanner sc = new Scanner(System.in);

		System.out.println("Selecciona una operación");

		System.out.println(
				"1. Mostrar todos los libros: mostrará por pantalla todos los libros disponibles en el sistema.");
		System.out.println("2. Buscar libro por título: permite buscar un libro específico por su título.");
		System.out.println("3. Buscar libros por autor: permite buscar libros de un autor específico.");
		System.out.println(
				"4. Buscar libros por rango de precios: permite buscar libros dentro de un rango de precios indicado por el usuario.");
		System.out.println(
				"5. Buscar libros por cantidad mínima en stock: permite buscar libros con stock igual o mayor al especificado.");
		System.out.println(
				"6. Insertar nuevo libro: el usuario proporcionará id, título, autor, precio y stock del nuevo libro.");
		System.out.println(
				"7. Eliminar libro por título: elimina un libro por su título. Si hay varios con el mismo título, el usuario elige por id.");
		System.out.println(
				"8. Hacer copia: copia todos los datos del repositorio activo al otro (de archivo a MySQL o viceversa).");

		int eleccion ;
		do {
			eleccion = Integer.parseInt(sc.nextLine());

			switch (eleccion) {
			case 1:
				System.out.println(libro.obtenerTodos());
				break;
			case 2:
				System.out.println("Dime el titulo del libro");
				String nombre = sc.nextLine();
				System.out.println(nombre+" asdasd");
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;
			case 7:

				break;
			case 8:

				break;
			case 0:
				System.out.println("Fin de programa");
			default:
				break;
			}
		} while (eleccion != 0);
	}

}
