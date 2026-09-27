package PARTE1;

import java.util.List;
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
		System.out.println("4. Buscar libros por rango de precios: permite buscar libros dentro de un rango de precios indicado por el usuario.");
		System.out.println("5. Buscar libros por cantidad mínima en stock: permite buscar libros con stock igual o mayor al especificado.");
		System.out.println("6. Insertar nuevo libro: el usuario proporcionará id, título, autor, precio y stock del nuevo libro.");
		System.out.println("7. Eliminar libro por título: elimina un libro por su título. Si hay varios con el mismo título, el usuario elige por id.");
		System.out.println("8. Hacer copia: copia todos los datos del repositorio activo al otro (de archivo a MySQL o viceversa).");

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
				System.out.println(libro.buscarPorTitulo(nombre));
				break;
			case 3:
				System.out.println("Dime el autor del que quieres buscar el libro");
				String autor = sc.nextLine();
				System.out.println(libro.buscarPorAutor(autor));
				break;
			case 4:
				double min = 0;
				double max = 0;
				System.out.println("Dime el precio minimo");
				min = Double.parseDouble(sc.nextLine());
				System.out.println("Dime el precio maximo");
				max = Double.parseDouble(sc.nextLine());
				System.out.println(libro.buscarPorRangoDePrecios(min, max));
				break;
			case 5:
				System.out.println("Dime el stock minimo");
				int stock = Integer.parseInt(sc.nextLine());
				System.out.println(libro.buscarPorCantidadMinima(stock));
				break;
			case 6:
				System.out.println("Dime los datos de un nuevo libro");
				System.out.println("ID: ");
				int id= Integer.parseInt(sc.nextLine());
				System.out.println("Titulo: ");
				String titulo = sc.nextLine();
				System.out.println("Autor: ");
				String autor2 = sc.nextLine();
				System.out.println("Precio: ");
				Double precio = Double.parseDouble(sc.nextLine());
				System.out.println("Stock: ");
				int stock1 = Integer.parseInt(sc.nextLine());
				Libro libro2 = new Libro(id, titulo, autor2, precio, stock1);
				if (libro.insertar(libro2)) {
					System.out.println("Se ha añadido correctamente");
				}else
					System.out.println("No se ha podido añadir");
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
