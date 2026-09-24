package PARTE1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LibroRepository implements GenericDAO<Libro>  {

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
		// TODO Auto-generated method stub
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





