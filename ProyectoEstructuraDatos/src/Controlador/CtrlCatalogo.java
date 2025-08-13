package Controlador;


import Modelo.Libro;
import Nodos.NodoArbol;
import javax.swing.JOptionPane;



    private final ArbolLibro arbolTitulo = new ArbolLibro();                 // índice por TÍTULO
    private final ArbolLibroPorAutor arbolAutor = new ArbolLibroPorAutor();  // índice por AUTOR→TÍTULO→ID

    // Agregar libro
    public void agregar() {
        Libro l = new Libro();

        l.setIdLibro(Integer.parseInt(JOptionPane.showInputDialog("ID del libro:")));
        l.setTitulo(JOptionPane.showInputDialog("Título:"));
        l.setAutor(JOptionPane.showInputDialog("Autor:"));
        l.setEditorial(JOptionPane.showInputDialog("Editorial:"));
        l.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Precio:")));
        l.setStock(Double.parseDouble(JOptionPane.showInputDialog("Stock:")));

        arbolTitulo.insertar(l);
        arbolAutor.insertar(l);

        JOptionPane.showMessageDialog(null, "Libro agregado.");
    }

    // Eliminar libro
    public void eliminar() {
        String autor = JOptionPane.showInputDialog("Autor del libro a eliminar:");
        String titulo = JOptionPane.showInputDialog("Título del libro a eliminar:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del libro a eliminar:"));

        NodoArbol nodo = arbolAutor.buscarNodo(autor, titulo, id);
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ese libro.");
            return;
        }

        Libro l = nodo.getElemento();
        arbolAutor.eliminar(autor, titulo, id);
        arbolTitulo.eliminarPorTitulo(l.getTitulo());

        JOptionPane.showMessageDialog(null, "Libro eliminado en catálogo.");
    }

    // Modificar libro
    public void modificar() {
        String autor = JOptionPane.showInputDialog("Autor del libro a modificar:");
        String titulo = JOptionPane.showInputDialog("Título del libro a modificar:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del libro a modificar:"));

        NodoArbol nodo = arbolAutor.buscarNodo(autor, titulo, id);
        if (nodo == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ese libro.");
            return;
        }

        Libro actual = nodo.getElemento();

        // Pedir valores con el actual como valor por defecto (si cancelan o dejan vacío, se conserva)
        String nuevoAutor = JOptionPane.showInputDialog(null, "Nuevo autor:", actual.getAutor());
        if (nuevoAutor == null || nuevoAutor.trim().isEmpty()) nuevoAutor = actual.getAutor();

        String nuevoTitulo = JOptionPane.showInputDialog(null, "Nuevo título:", actual.getTitulo());
        if (nuevoTitulo == null || nuevoTitulo.trim().isEmpty()) nuevoTitulo = actual.getTitulo();

        String nuevaEdit = JOptionPane.showInputDialog(null, "Nueva editorial:", actual.getEditorial());
        if (nuevaEdit == null || nuevaEdit.trim().isEmpty()) nuevaEdit = actual.getEditorial();

        String rPrecio = JOptionPane.showInputDialog(null, "Nuevo precio:", String.valueOf(actual.getPrecio()));
        double nuevoPrecio = (rPrecio == null || rPrecio.trim().isEmpty())
                ? actual.getPrecio()
                : Double.parseDouble(rPrecio);

        String rStock = JOptionPane.showInputDialog(null, "Nuevo stock:", String.valueOf(actual.getStock()));
        double nuevoStock = (rStock == null || rStock.trim().isEmpty())
                ? actual.getStock()
                : Double.parseDouble(rStock);

        //Cambio autor o titulo? (comparación case-insensitive y sin espacios extremos)
        boolean cambiaAutor = !nuevoAutor.trim().equalsIgnoreCase(
                actual.getAutor() == null ? "" : actual.getAutor().trim());
        boolean cambiaTitulo = !nuevoTitulo.trim().equalsIgnoreCase(
                actual.getTitulo() == null ? "" : actual.getTitulo().trim());

        if (cambiaAutor || cambiaTitulo) {
            //reindexar: eliminar de ambos índices e insertar como nuevo
            arbolAutor.eliminar(actual.getAutor(), actual.getTitulo(), actual.getIdLibro());
            arbolTitulo.eliminarPorTitulo(actual.getTitulo());

            Libro nuevo = new Libro(actual.getIdLibro(), nuevoTitulo, nuevoAutor, nuevaEdit, nuevoPrecio, nuevoStock);
            arbolTitulo.insertar(nuevo);
            arbolAutor.insertar(nuevo);

            JOptionPane.showMessageDialog(null, "Libro reindexado y actualizado.");
        } else {
            // modificar campos que no afectan el orden
            actual.setEditorial(nuevaEdit);
            actual.setPrecio(nuevoPrecio);
            actual.setStock(nuevoStock);
            JOptionPane.showMessageDialog(null, "Libro actualizado.");
        }
    }



    // Menú de gestión
    public void menucatalogo() {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "GESTIÓN DEL CATÁLOGO\n"
                  + "1) Agregar\n"
                  + "2) Eliminar\n"
                  + "3) Modificar\n"
                  + "4) Buscar\n"
                  + "5) Mostrar (ordenado por TÍTULO)\n"
                  + "6) Mostrar (ordenado por AUTOR)\n"
                  + "0) Volver"
            ));
            switch (op) {
                case 1 -> agregar();
                case 2 -> eliminar();
                case 3 -> modificar();
                case 4 -> buscar();
                case 5 -> JOptionPane.showMessageDialog(null, arbolTitulo.mostrarInordenSB());
                case 6 -> JOptionPane.showMessageDialog(null, arbolAutor.mostrarInorden());
                case 0 -> { /* salir */ }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (op != 0);
    }
}
  
}
