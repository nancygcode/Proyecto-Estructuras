package Modelo;


private int id;
    private String nombre;
    private String correo;
    private String pass;

    public Cliente() {
        this.id = 0;
        this.nombre = "";
        this.correo = "";
        this.pass = "";
    }

    public Cliente(int id, String nombre, String correo, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Cliente {ID=" + id + ", Nombre= " + nombre
                + ", correo= " + correo + "}";
    }
}
