package Modelo;


public class Libro {
    private int idLibro;
    private String titulo;
    private String autor;
    private String editorial;
    private double precio;
    private double stock;

    public Libro() {
         this.idLibro = 0;
        this.titulo = " ";
        this.autor = " ";
        this.editorial = " ";
        this.precio= 0;
        this.stock=0;
       
    }

    public Libro(int idLibro, String titulo, String autor, String editorial, double precio, double stock) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio= precio;
        this.stock=stock;
    }
    
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
     
    
}

