package PARTE1;

import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Creamos las instancias
		LibroRepository libroSql = new LibroRepository();
		LibroRepositoryArchivo libroArchivo = new LibroRepositoryArchivo();

		// Preguntamos con qué trabajar al arrancar
		System.out.println("¿Con qué repositorio quieres trabajar?");
		System.out.println("1. MySQL");
		System.out.println("2. Archivo");
		int origen = Integer.parseInt(sc.nextLine());

		// Asignamos el activo a una variable genérica
		GenericDAO<Libro> libro;
		if (origen == 1) {
			libro = libroSql;
		} else {
			libro = libroArchivo;
		}

		System.out.println("Selecciona una operación");
		System.out.println("1. Mostrar todos los libros");
		System.out.println("2. Buscar libro por título");
		System.out.println("3. Buscar libros por autor");
		System.out.println("4. Buscar libros por rango de precios");
		System.out.println("5. Buscar libros por cantidad mínima en stock");
		System.out.println("6. Insertar nuevo libro");
		System.out.println("7. Eliminar libro por título");
		System.out.println("8. Hacer copia");
		System.out.println("0. Salir");

		int eleccion;
		do {
			eleccion = Integer.parseInt(sc.nextLine());

			switch (eleccion) {
			case 1:
				System.out.println(libro.obtenerTodos());
				break;
			case 2:
				System.out.println("Dime el titulo del libro");
				String nombre = sc.nextLine();
				if (origen == 1) {
					System.out.println(libroSql.buscarPorTitulo(nombre));
				} else {
					System.out.println(libroArchivo.buscarPorTitulo(nombre));
				}
				break;
			case 3:
				System.out.println("Dime el autor del que quieres buscar el libro");
				String autor = sc.nextLine();
				if (origen == 1) {
					System.out.println(libroSql.buscarPorAutor(autor));
				} else {
					System.out.println(libroArchivo.buscarPorAutor(autor));
				}
				break;
			case 4:
				System.out.println("Dime el precio minimo");
				double min = Double.parseDouble(sc.nextLine());
				System.out.println("Dime el precio maximo");
				double max = Double.parseDouble(sc.nextLine());
				if (origen == 1) {
					System.out.println(libroSql.buscarPorRangoDePrecios(min, max));
				} else {
					System.out.println(libroArchivo.buscarPorRangoDePrecios(min, max));
				}
				break;
			case 5:
				System.out.println("Dime el stock minimo");
				int stock = Integer.parseInt(sc.nextLine());
				if (origen == 1) {
					System.out.println(libroSql.buscarPorCantidadMinima(stock));
				} else {
					System.out.println(libroArchivo.buscarPorCantidadMinma(stock));
				}
				break;
			case 6:
				System.out.println("Dime los datos de un nuevo libro");
				System.out.println("ID: ");
				int id = Integer.parseInt(sc.nextLine());
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
				} else {
					System.out.println("No se ha podido añadir");
				}
				break;
			case 7:
				System.out.println("Dime el título del libro que quieres eliminar:");
				String tituloABorrar = sc.nextLine();

				Libro l = null;
				if (origen == 1) {
					l = libroSql.buscarPorTitulo(tituloABorrar);
				} else {
					l = libroArchivo.buscarPorTitulo(tituloABorrar);
				}

				if (l == null) {
					System.out.println("No se encontró ningún libro con ese título.");
				} else {
					if (libro.eliminar(l.getId())) {
						System.out.println("Libro eliminado correctamente.");
					} else {
						System.out.println("Error al eliminar el libro.");
					}
				}
				break;
			case 8:
				if (origen == 1) {
					List<Libro> lista = libroSql.obtenerTodos();
					for (Libro item : lista) {
						libroArchivo.insertar(item);
					}
					System.out.println("Copiado de MySQL a Archivo con éxito.");
				} else {
					List<Libro> lista = libroArchivo.obtenerTodos();
					for (Libro item : lista) {
						libroSql.insertar(item);
					}
					System.out.println("Copiado de Archivo a MySQL con éxito.");
				}
				break;
			case 0:
				System.out.println("Fin de programa");
				break;
			default:
				break;
			}
		} while (eleccion != 0);
	}
}