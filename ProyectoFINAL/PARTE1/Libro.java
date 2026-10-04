package PARTE1;

/**
 * Entidad que representa un libro
 * Contiene la información básica del producto como ID, título, autor, precio y stock.
 * 
 * @author Sergio y Octavian
 */
public class Libro {

	/** Identificador único del libro en la base de datos o archivo. */
    protected int id;

    /** Título del libro. */
    protected String titulo;

    /** Nombre del autor del libro. */
    protected String autor;

    /** Precio del libro en euros. */
    protected Double precio;

    /** Cantidad de unidades disponibles en inventario. */
    protected int stock;
    
    /**
     * Constructor completo para instanciar un libro con todos sus datos.
     * 
     * @param id Identificador único del libro.
     * @param titulo Título de la obra.
     * @param autor Nombre del autor.
     * @param precio Precio de venta.
     * @param stock Cantidad disponible en almacén.
     */
	public Libro(int id, String titulo, String autor, Double precio, int stock) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.precio = precio;
		this.stock = stock;
	}
	public Libro() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + ", stock=" + stock
				+ "]";
	}
	
	
	
}
