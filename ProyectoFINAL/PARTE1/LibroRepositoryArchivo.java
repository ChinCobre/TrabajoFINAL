package PARTE1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibroRepositoryArchivo implements GenericDAO<Libro> {

	
		private final String ruta = "libros.txt";

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


		public Libro buscarPorTitulo(String titulo) {
			for (Libro l : obtenerTodos()) {
				if (l.getTitulo().equalsIgnoreCase(titulo)) return l;
			}
			return null;
		}

		public List<Libro> buscarTodosPorTitulo(String titulo) {
			List<Libro> lista = new ArrayList<>();
			for (Libro l : obtenerTodos()) {
				if (l.getTitulo().equalsIgnoreCase(titulo)) lista.add(l);
			}
			return lista;
		}

		public List<Libro> buscarPorAutor(String autor) {
			List<Libro> lista = new ArrayList<>();
			for (Libro l : obtenerTodos()) {
				if (l.getAutor().equalsIgnoreCase(autor)) lista.add(l);
			}
			return lista;
		}

		public List<Libro> buscarPorRangoDePrecios(double min, double max) {
			List<Libro> lista = new ArrayList<>();
			for (Libro l : obtenerTodos()) {
				if (l.getPrecio() >= min && l.getPrecio() <= max) lista.add(l);
			}
			return lista;
		}

		public List<Libro> buscarPorCantidadMinima(int stock) {
			List<Libro> lista = new ArrayList<>();
			for (Libro l : obtenerTodos()) {
				if (l.getStock() >= stock) lista.add(l);
			}
			return lista;
		}

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

		@Override
		public boolean eliminar(int id) {
			List<Libro> lista = obtenerTodos();
			boolean eliminado = lista.removeIf(l -> l.getId() == id);
			if (eliminado) guardarTodos(lista);
			return eliminado;
		}

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

		private Libro parsear(String linea) {
			String[] c = linea.split("\\^");
			return new Libro(Integer.parseInt(c[0]), c[1], c[2], Double.parseDouble(c[3]), Integer.parseInt(c[4]));
		}

		@Override
		public boolean actualizar(Libro obj) { return false; }

		@Override
		public Libro obtenerPorId(int id) {
			for (Libro l : obtenerTodos()) {
				if (l.getId() == id) return l;
			}
			return null;
		}
	}

