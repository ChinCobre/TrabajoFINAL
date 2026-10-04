package PARTE1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Repositorio de Libros que guarda los datos en un archivo de texto.
 * 
 * @author Sergio y Octavian
 */
public class LibroRepositoryArchivo implements GenericDAO<Libro> {

	
		private final String ruta = "libros.txt";
		/**
	     * Obtiene todos los libros del archivo.
	     * 
	     * @return Lista con todos los libros.
	     * @throws IOException Si ocurre un error al leer el archivo.
	     */
		@Override
		public List<Libro> obtenerTodos() {
			List<Libro> lista = new ArrayList<>();
			File f = new File(ruta);
			if (!f.exists()) return lista;
			try (BufferedReader br = new BufferedReader(new FileReader(f))) {
				String linea;
				while ((linea = br.readLine()) != null) {
					if (!linea.isBlank()) lista.add(parsear(linea));
				}
			} catch (IOException e) {
				System.out.println("Error al leer el archivo: " + e.getMessage());
			}
			return lista;
		}

		/**
	     * Busca el primer libro con el título indicado.
	     * 
	     * @param titulo Título a buscar.
	     * @return El libro encontrado o null.
	     */
		public Libro buscarPorTitulo(String titulo) {
			for (Libro l : obtenerTodos()) {
				if (l.getTitulo().equalsIgnoreCase(titulo)) return l;
			}
			return null;
		}
		/**
	     * Busca todos los libros que tengan el mismo título.
	     * 
	     * @param titulo Título a buscar.
	     * @return Lista de libros coincidentes.
	     */
		public List<Libro> buscarTodosPorTitulo(String titulo) {
			List<Libro> lista = new ArrayList<>();
			for (Libro l : obtenerTodos()) {
				if (l.getTitulo().equalsIgnoreCase(titulo)) lista.add(l);
			}
			return lista;
		}
		/**
	     * Busca todos los libros de un autor.
	     * 
	     * @param autor Autor a buscar.
	     * @return Lista de libros del autor.
	     */
		public List<Libro> buscarPorAutor(String autor) {
			List<Libro> lista = new ArrayList<>();
			for (Libro l : obtenerTodos()) {
				if (l.getAutor().equalsIgnoreCase(autor)) lista.add(l);
			}
			return lista;
		}
		/**
	     * Filtra libros por rango de precio.
	     * 
	     * @param min Precio mínimo.
	     * @param max Precio máximo.
	     * @return Lista de libros en ese rango.
	     */
		public List<Libro> buscarPorRangoDePrecios(double min, double max) {
			List<Libro> lista = new ArrayList<>();
			for (Libro l : obtenerTodos()) {
				if (l.getPrecio() >= min && l.getPrecio() <= max) lista.add(l);
			}
			return lista;
		}
		/**
	     * Filtra libros que tengan al menos el stock indicado.
	     * 
	     * @param stock Stock mínimo.
	     * @return Lista de libros filtrados.
	     */
		public List<Libro> buscarPorCantidadMinima(int stock) {
			List<Libro> lista = new ArrayList<>();
			for (Libro l : obtenerTodos()) {
				if (l.getStock() >= stock) lista.add(l);
			}
			return lista;
		}
		/**
	     * Guarda un nuevo libro al final del archivo.
	     * 
	     * @param obj Libro a guardar.
	     * @return true si se guardó, false si falló.
	     * @throws IOException Si ocurre un error al escribir en el archivo.
	     */
		@Override
		public boolean insertar(Libro obj) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {
				bw.write(obj.getId() + "^" + obj.getTitulo() + "^" + obj.getAutor() + "^" + obj.getPrecio() + "^" + obj.getStock());
				bw.newLine();
				return true;
			} catch (IOException e) {
				System.out.println("Error al insertar en el archivo: " + e.getMessage());
				return false;
			}
		}
		/**
	     * Elimina un libro por su ID.
	     * 
	     * @param id ID del libro a borrar.
	     * @return true si se borró, false si no existía.
	     */
		@Override
		public boolean eliminar(int id) {
			List<Libro> lista = obtenerTodos();
			boolean eliminado = lista.removeIf(l -> l.getId() == id);
			if (eliminado) guardarTodos(lista);
			return eliminado;
		}
		/**
	     * Reescribe el archivo con la lista completa de libros.
	     * 
	     * @param lista Lista actualizada de libros.
	     * @throws IOException Si ocurre un error al reescribir el archivo.
	     */
		private void guardarTodos(List<Libro> lista) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
				for (Libro l : lista) {
					bw.write(l.getId() + "^" + l.getTitulo() + "^" + l.getAutor() + "^" + l.getPrecio() + "^" + l.getStock());
					bw.newLine();
				}
			} catch (IOException e) {
				System.out.println("Error al guardar el archivo: " + e.getMessage());
			}
		}
		/**
	     * Convierte una línea del archivo en un objeto Libro.
	     * 
	     * @param linea Texto de la línea.
	     * @return Objeto Libro creado.
	     * @throws NumberFormatException Si los datos numéricos de la línea están mal formateados.
	     * @throws ArrayIndexOutOfBoundsException Si la línea no contiene todos los campos requeridos.
	     */
		private Libro parsear(String linea) {
			String[] c = linea.split("\\^");
			return new Libro(Integer.parseInt(c[0]), c[1], c[2], Double.parseDouble(c[3]), Integer.parseInt(c[4]));
		}
		/**
	     * Actualiza un libro existente.
	     * 
	     * @param obj Libro con los datos actualizados.
	     * @return false (no implementado).
	     */
		@Override
		public boolean actualizar(Libro obj) { return false; }
		/**
	     * Busca un libro por su ID.
	     * 
	     * @param id ID a buscar.
	     * @return El libro encontrado o null.
	     */
		@Override
		public Libro obtenerPorId(int id) {
			for (Libro l : obtenerTodos()) {
				if (l.getId() == id) return l;
			}
			return null;
		}
	}

