package ListaDobleEnlazadaCircular;

public class ListaDobleEnlazadaCircular<T extends Comparable<T>> {

    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int tam;

    public ListaDobleEnlazadaCircular() {
        primero = null;
        ultimo = null;
        tam = 0;
    }

    public void agregarPrimero(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(ultimo);
        } else {
            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);
            primero.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            primero = nuevo;
        }
        tam++;
    }

    public void agregarUltimo(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (ultimo == null) {
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(ultimo);
        } else {
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);
            ultimo = nuevo;
        }
        tam++;
    }

    public void insertarOrdenNatural(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (primero == null) {
            primero = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(primero);
        } else if (dato.compareTo(primero.getDato()) < 0) {
            NodoDoble<T> ultimo = primero.getAnterior();

            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);

            primero.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);

            primero = nuevo;
        } else {
            NodoDoble<T> actual = primero;
            while (actual.getSiguiente() != primero && dato.compareTo(actual.getSiguiente().getDato()) >= 0) {
                actual = actual.getSiguiente();
            }

            nuevo.setSiguiente(actual.getSiguiente());
            nuevo.setAnterior(actual);

            actual.getSiguiente().setAnterior(nuevo);
            actual.setSiguiente(nuevo);
        }
        tam++;
    }

}