package Modelo;
import Controlador.CtrlCatalogo;


public class Pedido {

    private CtrlCatalogo objeto;
   

    public Pedido() {
    }

    public Pedido(CtrlCatalogo objeto) {
       
        this.objeto = objeto;
    }
    

    public CtrlCatalogo getObjeto() {
        return objeto;
    }

    public void setObjeto(CtrlCatalogo objeto) {
        this.objeto = objeto;
    }
}
