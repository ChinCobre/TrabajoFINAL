package PARTE1;

import java.util.List;

public interface GenericDAO<T> {
	/**
     * metodo para insertar nuevo objeto.
     * 
     * @param obj Objeto a insertar.
     * @return true si se ha podido, false si no.
     */
    boolean insertar(T obj);

    /**
     * actualizado los datos de un objeto.
     * 
     * @param obj objeto con los datos nuevos.
     * @return devuelve true si se ha podido actualizar, false si no.
     */
    boolean actualizar(T obj);

    /**
     * Elimina un objeto de la base de datos.
     * 
     * @param recibe el id del objeto para eliminarlo.
     * @return true si ha podido eliminarlo, false si no ha podido.
     */
    boolean eliminar(int id);

    /**
     * Busca y obtiene un un objeto por su id.
     * 
     * @param recibe el id de un objeto.
     * @return El objeto encontrado o null si no existe.
     */
    T obtenerPorId(int id);

    /**
     * Obtiene todos los registros guardados en la base datos.
     * 
     * @return Lista con la totalidad de objetos guardados.
     */
    List<T> obtenerTodos();
}
	