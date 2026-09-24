package PARTE1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository implements GenericDAO<Libro> {

	@Override
	public boolean insertar(Libro obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(Libro obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Libro obtenerPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

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
	
	

	private Libro mapear(ResultSet rs) throws SQLException {
		Libro s = new Libro();
		s.setId(rs.getInt("id"));
		s.setTitulo(rs.getString("titulo"));
		s.setAutor(rs.getString("autor"));
		s.setPrecio(rs.getDouble("precio"));
		s.setId(rs.getInt("stock"));

		return s;
	}
}
