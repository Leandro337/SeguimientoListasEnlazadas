import java.util.Iterator;

public class ListaSimpleEnlazada<T extends Comparable<T>> implements Iterable<T> {

    private Nodo<T> primero;
    private int tam;

    public ListaSimpleEnlazada() {
        primero = null;
        tam = 0;
    }

    public void agregarPrimero(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);

        if (primero == null) {
            primero = newNodo;
        } else {
            newNodo.setProximo(primero);
            primero = newNodo;
        }
        tam++;
    }

    public void mostrar() {
        Nodo<T> actual = primero;
        String mensaje = "[";

        while (actual != null) {
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        }

        mensaje += "]";
        System.out.println(mensaje);
    }

    public void agregarUltimo(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);
        if (primero == null) {
            primero = newNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
        }
        tam++;
    }

    public boolean esVacio() {
        return primero == null && tam == 0;
    }

    public int localizar(T datoBusqueda) {
        Nodo<T> actual = primero;
        int indexBusqueda = 0;

        while (actual != null) {
            if (actual.getDato().equals(datoBusqueda)) {
                return indexBusqueda;
            }
            indexBusqueda++;
            actual = actual.getProximo();
        }
        return -1;
    }

    public boolean buscar(T datoBusqueda) {
        Nodo<T> actual = primero;

        while (actual != null) {
            if (actual.getDato().equals(datoBusqueda)) {
                return true;
            }
            actual = actual.getProximo();
        }

        return false;
    }

    public boolean eliminar(T datoBusqueda) {
        Nodo<T> actual = primero;

        if (actual == null) return false;

        if (actual.getDato().equals(datoBusqueda)) {
            primero = actual.getProximo();
            tam--;
            return true;
        } else {
            while (actual.getProximo() != null) {
                if (actual.getProximo().getDato().equals(datoBusqueda)) {
                    actual.setProximo(actual.getProximo().getProximo());
                    tam--;
                    return true;
                }
                actual = actual.getProximo();
            }
        }
        return false;
    }

    public void insertarOrdenNatural(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (primero == null || dato.compareTo(primero.getDato()) < 0) {
            nuevo.setProximo(primero);
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;

            while (actual.getProximo() != null && dato.compareTo(actual.getProximo().getDato()) >= 0) {
                actual = actual.getProximo();
            }

            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
        }

        tam++;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista<>(primero);
    }
}
