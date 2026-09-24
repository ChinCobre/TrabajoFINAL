package PARTE1;

import java.util.List;

public interface GenericDAO<T> {
    boolean insertar(T obj);
    boolean actualizar(T obj);
    boolean eliminar(int id);
    T obtenerPorId(int id);
    List<T> obtenerTodos();
}
	