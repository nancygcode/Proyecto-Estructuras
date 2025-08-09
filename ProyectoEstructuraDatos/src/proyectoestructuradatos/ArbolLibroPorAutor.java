/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author fabii
 */
public class ArbolLibroPorAutor {

    private NodoLibro raiz;

    public ArbolLibroPorAutor() {
        this.raiz = null;
    }

    public boolean vacio() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    //para normalizar 
    private String norm(String s) {
        return (s == null) ? "" : s.trim().toLowerCase();
    }

    // Comparación: autor -> título -> id (para ubicar único)
    private int comparar(Libro a, Libro b) {
        int c1 = norm(a.getAutor()).compareTo(norm(b.getAutor()));
        if (c1 != 0) {
            return c1;
        }
        int c2 = norm(a.getTitulo()).compareTo(norm(b.getTitulo()));
        if (c2 != 0) {
            return c2;
        }
        return Integer.compare(a.getIdLibro(), b.getIdLibro());
    }

    private void insertarRec(NodoLibro actual, NodoLibro nuevo) {
        if (comparar(nuevo.getElemento(), actual.getElemento()) <= 0) {
            if (actual.getEnlaceIzq() == null) {
                actual.setEnlaceIzq(nuevo);
            } else {
                insertarRec(actual.getEnlaceIzq(), nuevo);
            }
        } else {
            if (actual.getEnlaceDer() == null) {
                actual.setEnlaceDer(nuevo);
            } else {
                insertarRec(actual.getEnlaceDer(), nuevo);
            }
        }
    }

    public void insertarManual() {
        Libro l = new Libro();
        l.setIdLibro(Integer.parseInt(JOptionPane.showInputDialog("ID del libro:")));
        l.setTitulo(JOptionPane.showInputDialog("Título:"));
        l.setAutor(JOptionPane.showInputDialog("Autor:"));
        l.setEditorial(JOptionPane.showInputDialog("Editorial:"));
        l.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Precio:")));
        l.setStock(Double.parseDouble(JOptionPane.showInputDialog("Stock:")));

        NodoLibro nuevo = new NodoLibro();
        nuevo.setElemento(l);

        if (vacio()) {
            raiz = nuevo;
        } else {
            insertarRec(raiz, nuevo);
        }

        JOptionPane.showMessageDialog(null, "Libro insertado en índice por AUTOR.");
    }

    public void insertar(Libro l) {
        NodoLibro nuevo = new NodoLibro();
        nuevo.setElemento(l);
        if (vacio()) {
            raiz = nuevo;
        } else {
            insertarRec(raiz, nuevo);
        }
    }

    private void inordenRec(NodoLibro n, StringBuilder sb) {
        if (n != null) {
            inordenRec(n.getEnlaceIzq(), sb);
            sb.append(n.getElemento().toString()).append("\n"); // usa toString()
            inordenRec(n.getEnlaceDer(), sb);
        }
    }

    public String mostrarInordenSB() {
        if (vacio()) {
            return "Árbol vacío";
        }
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString();
    }

    private String inordenRec(NodoLibro n) {
        if (n == null) {
            return "";
        }
        // Concatenación de los tres pasos del recorrido
        return inordenRec(n.getEnlaceIzq())
                + n.getElemento().toString() + "\n"
                + inordenRec(n.getEnlaceDer());
    }

    public String mostrarInorden() {
        if (vacio()) {
            return "Árbol vacío";
        }
        return inordenRec(raiz);
    }

    // Busca un libro por autor
    public Libro buscarUnoPorAutor(String autor) {
        String clave = norm(autor);
        NodoLibro actual = raiz;
        while (actual != null) {
            String k = norm(actual.getElemento().getAutor());
            int cmp = clave.compareTo(k);
            if (cmp == 0) {
                return actual.getElemento();
            } else if (cmp < 0) {
                actual = actual.getEnlaceIzq();
            } else {
                actual = actual.getEnlaceDer();
            }
        }
        return null;
    }

    //muestra todos los libros de un autor
    public String listarPorAutor(String autor) {
        StringBuilder sb = new StringBuilder();
        listarPorAutorRec(raiz, norm(autor), sb);
        return (sb.length() == 0) ? "Sin libros de ese autor." : sb.toString();
    }

    private void listarPorAutorRec(NodoLibro n, String autorNorm, StringBuilder sb) {
        if (n == null) {
            return;
        }
        listarPorAutorRec(n.getEnlaceIzq(), autorNorm, sb);
        if (norm(n.getElemento().getAutor()).equals(autorNorm)) {
            sb.append(n.getElemento().toString()).append("\n"); // usa toString()
        }
        listarPorAutorRec(n.getEnlaceDer(), autorNorm, sb);
    }

    public boolean eliminar(String autor, String titulo, int idLibro) {
        if (vacio()) {
            return false;
        }
        Libro clave = new Libro(idLibro, titulo, autor, "", 0.0);
        raiz = eliminarRec(raiz, clave);
        // Para saber si realmente se borró, podrías intentar buscar de nuevo y verificar.
        return true;
    }

    private NodoLibro eliminarRec(NodoLibro n, Libro clave) {
        if (n == null) {
            return null;
        }
        int cmp = comparar(clave, n.getElemento());
        if (cmp < 0) {
            n.setEnlaceIzq(eliminarRec(n.getEnlaceIzq(), clave));
        } else if (cmp > 0) {
            n.setEnlaceDer(eliminarRec(n.getEnlaceDer(), clave));
        } else {
            // Encontrado
            if (n.getEnlaceIzq() == null) {
                return n.getEnlaceDer();
            }
            if (n.getEnlaceDer() == null) {
                return n.getEnlaceIzq();
            }
            // 2 hijos: reemplazar con sucesor (mínimo del subárbol derecho)
            NodoLibro suc = n.getEnlaceDer();
            while (suc.getEnlaceIzq() != null) {
                suc = suc.getEnlaceIzq();
            }
            n.setElemento(suc.getElemento());
            n.setEnlaceDer(eliminarRec(n.getEnlaceDer(), suc.getElemento()));
        }
        return n;
    }

    public boolean modificar(String autor, String titulo, int idLibro) {
        // Para modificar campos que NO afectan el orden (editorial, precio, stock) basta encontrar el nodo:
        NodoLibro nodo = buscarNodo(raiz, new Libro(idLibro, titulo, autor, "", 0.0));
        if (nodo == null) {
            return false;
        }

        Libro l = nodo.getElemento();
        l.setEditorial(JOptionPane.showInputDialog("Nueva editorial:", l.getEditorial()));
        l.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:", l.getPrecio())));
        l.setStock(Double.parseDouble(JOptionPane.showInputDialog("Nuevo stock:", l.getStock())));
        // Si cambias AUTOR o TÍTULO: debes eliminar + reinsertar con nuevos datos
        return true;
    }

    private NodoLibro buscarNodo(NodoLibro n, Libro clave) {
        if (n == null) {
            return null;
        }
        int cmp = comparar(clave, n.getElemento());
        if (cmp == 0) {
            return n;
        }
        if (cmp < 0) {
            return buscarNodo(n.getEnlaceIzq(), clave);
        }
        return buscarNodo(n.getEnlaceDer(), clave);
    }

    public NodoLibro buscarNodo(String autor, String titulo, int idLibro) {
        Libro clave = new Libro(idLibro, titulo, autor, "", 0.0);
        return buscarNodo(raiz, clave);
    }
}
