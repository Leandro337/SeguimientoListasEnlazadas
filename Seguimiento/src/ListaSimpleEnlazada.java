import java.util.Iterator;

public class ListaSimpleEnlazada<T extends Comparable<T>> implements Iterable<T> {

    private Nodo<T> primero;
    private int tam;

    public ListaSimpleEnlazada() {
        primero = null;
        tam = 0;
    }

    public void agregarPrimero(T dato) {
        Nodo<T> newNodo = new Nodo(dato);

        if (primero == null) {
            primero = newNodo;
            tam++;
        } else {
            newNodo.setProximo(primero);
            primero = newNodo;
            tam++;
        }
    }

    public void mostrar() {
        Nodo<T> actual = primero;
        String mensaje = "[";
        do {
            mensaje += actual.getDato() + " ";
            actual = actual.getProximo();
        } while (actual != null);

        mensaje += "]";
        System.out.println(mensaje);
    }

    public void agregarUltimo(T dato) {
        Nodo<T> newNodo = new Nodo(dato);
        if (primero == null) {
            primero = newNodo;
            tam++;
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != null) {
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            tam++;
        }
    }

    public boolean esVacio() {
        return (primero == null && tam == 0) ? true : false;
    }

    //Localizar es retornar ese elemento, buscar es retornar un booleano (si está o no)
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
        return -1; //Indicar que no está en lista
    }

    //Buscar nodo, no se retorna un int si no un booleano
    public boolean buscar(T datoBusqueda) {
        Nodo<T> actual = primero;
        boolean flag = false;

        while (actual != null) {
            if (actual.getDato().equals(datoBusqueda)) {
                flag = true;
            }
            actual = actual.getProximo();
        }

        return flag;
    }

    //Eliminar/Suprimir cabeza    1. Eliminar primer elemento -> el segundo se vuelve el primero
    public boolean eliminar(T datoBusqueda) {
        Nodo<T> actual = primero;

        if (actual.getDato().equals(datoBusqueda)) {
            primero = actual.getProximo();
            tam--;
            return true;
        } else { //Cuando se elimine cualquier otro elemento

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

    //Agregar en orden natural
    public void insertarOrdenNatural(T dato) {
        Nodo<T> nuevo = new Nodo<T>(dato);

        if (primero == null || dato.compareTo(primero.getDato()) < 0) {
            nuevo.setProximo(primero);
            primero = nuevo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getProximo() != null && dato.compareTo(actual.getProximo().getDato()) > 0) {
                actual = actual.getProximo();
            }
            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
        }

        tam++;
    }


    @Override
    public Iterator<T> iterator() {
        return new IteradorLista(primero);
    }
}