package Modelo;



public class Pedido {

    private Libro objeto;


    public Pedido() {
    }

    public Pedido(Libro objeto) {
        this.objeto = objeto;
    }


    public Libro getObjeto() {
        return objeto;
    }

    public void setObjeto(Libro objeto) {
        this.objeto = objeto;
    }

  
}
