/**
 * @author Sergio y Octavian
 */

package PARTE1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository implements GenericDAO<Libro> {
	/**
	 * Elimina un libro de la base de datos si el id coincide con un id de la base de datos.
	 * 
	 * @param id recibe el id del libro que quiere borrar.
	 * @return true o false, depende de si pudo o no borrar.
	 * @throws SQLException si no se puede acceder a la base de datos.
	 */
	@Override
	public boolean eliminar(int id) {
		 String sql = "DELETE FROM libro WHERE id = ?";
		    
		    try (Connection con = ConexionBD.getConnection();
		         PreparedStatement ps = con.prepareStatement(sql)) {
		         
		        ps.setInt(1, id);
		        int filasAfectadas = ps.executeUpdate();
		        return filasAfectadas > 0;

		    } catch (SQLException e) {
		        System.out.println("Error al eliminar libro: " + e.getMessage());
		    }

		    return false;
		}
	

	/**
	 * Actualiza los datos de un objeto libro.
	 * 
	 * @param Objeto libro.
	 * @return devuelve true o false si se ha actualizado o no.
	 * 
	 */
	@Override
	public boolean actualizar(Libro obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * Busca un libro segun el id introducido.
	 * 
	 * @param id a buscar.
	 * @return devuelve el libro correspondiente al id introducido.
	 * 
	 */
	@Override
	public Libro obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Mostrará por pantalla todos los libros disponibles en el sistema.
	 * 
	 * @return devuelve la lista de los libros.
	 * @throws SQLException si no se puede acceder a la base de datos.
	 */
	@Override
	public List<Libro> obtenerTodos() {
		List<Libro> lista = new ArrayList<>();
		String sql = "SELECT * FROM libro";
		try (Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				lista.add(mapear(rs));
			}
		} catch (SQLException e) {
			System.out.println("Error obteniendo plataformas: " + e.getMessage());
		}
		return lista;
	}
	
	
	/**
	 * Muestra los libros con el mismo
	 * 
	 * @param titulo
	 * @return
	 */
	public Libro buscarPorTitulo(String titulo) {

		String sql = "SELECT * FROM libro WHERE titulo = ?";

		try (Connection con = ConexionBD.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, titulo);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return mapear(rs);
				}
			}

		} catch (SQLException e) {
			System.out.println("Error buscando libro por título: " + e.getMessage());
		}

		
		return null;
	}
	
	/* 3. Buscar libros por autor: permite buscar libros de un autor específico.*/
	public List<Libro> buscarPorAutor(String autor) {
	    List<Libro> lista = new ArrayList<>();
	    String sql = "SELECT * FROM libro WHERE autor = ?";

	    try (Connection con = ConexionBD.getConnection(); 
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, autor);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                lista.add(mapear(rs));
	            }
	        }

	    } catch (SQLException e) {
	        System.out.println("Error buscando libros por autor: " + e.getMessage());
	    }

	    return lista;
	}
	
	
	/* 4. Buscar libros por rango de precios: permite buscar libros dentro de un rango de precios indicado por
	el usuario.*/
	public List<Libro> buscarPorRangoDePrecios(double min, double max) {
	    List<Libro> lista = new ArrayList<>();
	    String sql = "SELECT * FROM libro WHERE precio BETWEEN ? AND ?";

	    try (Connection con = ConexionBD.getConnection(); 
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setDouble(1, min);
	        ps.setDouble(2, max);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                lista.add(mapear(rs));
	            }
	        }

	    } catch (SQLException e) {
	        System.out.println("Error buscando libros por rango de precios: " + e.getMessage());
	    }

	    return lista;
	}
	/* 5. Buscar libros por cantidad mínima en stock: permite buscar libros con stock igual o mayor al
		especificado.*/ 
	public List<Libro> buscarPorCantidadMinima(int stock) {
	    List<Libro> lista = new ArrayList<>();
	    String sql = "SELECT * FROM libro WHERE stock>=? ";

	    try (Connection con = ConexionBD.getConnection(); 
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1,stock);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                lista.add(mapear(rs));
	            }
	        }

	    } catch (SQLException e) {
	        System.out.println("Error buscando libros por rango de precios: " + e.getMessage());
	    }

	    return lista;
	}
	/* 6. Insertar nuevo libro: el usuario proporcionará id, título, autor, precio y stock del nuevo libro.
	*/ 
	@Override
	public boolean insertar(Libro obj) {
	
	 String sql = "INSERT INTO libro (id, titulo, autor, precio, stock) VALUES (?, ?, ?, ?, ?)";
	    try (Connection con = ConexionBD.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	          ps.setInt(1, obj.getId());
	          ps.setString(2, obj.getTitulo());
	          ps.setString(3, obj.getAutor());
	          ps.setDouble(4, obj.getPrecio());
	          ps.setInt(5, obj.getStock());
	          int filas = ps.executeUpdate();
	          if (filas > 0) {
	                ResultSet rs = ps.getGeneratedKeys();
	                if (rs.next()) {
	                	obj.setId(rs.getInt(1));
	                }
	                return true;
	            }
	      } catch (SQLException e) {
	            System.out.println("Error al insertar: " + e.getMessage());
	      }
	        return false;
	    }
	/* 7. Eliminar libro por título: elimina un libro por su título. Si hay varios con el mismo título, el usuario
	elige por id.
	*/
	public boolean eliminarPorTitulo(String titulo) {
	    String sql = "DELETE FROM libro WHERE titulo = ?";
	    
	    try (Connection con = ConexionBD.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	         
	        ps.setString(1, titulo);
	        int filasAfectadas = ps.executeUpdate();
	        return filasAfectadas > 0;

	    } catch (SQLException e) {
	        System.out.println("Error al eliminar libro: " + e.getMessage());
	    }

	    return false;
	}
	

	
	
	private Libro mapear(ResultSet rs) throws SQLException {
		Libro s = new Libro();
		s.setId(rs.getInt("id"));
		s.setTitulo(rs.getString("titulo"));
		s.setAutor(rs.getString("autor"));
		s.setPrecio(rs.getDouble("precio"));
		s.setStock(rs.getInt("stock"));

		return s;
	}
}
