public class ListaSimpleEnlazadaCircular<T> {

    private Nodo<T> primero;
    private int tam;

    public ListaSimpleEnlazadaCircular() {
        primero = null;
        tam = 0;
    }

    public void agregarPrimero(T dato){
        Nodo<T> newNodo = new Nodo<>(dato);

        if (primero == null){
            primero = newNodo;
            newNodo.setProximo(primero);
        } else {

            Nodo<T> actual = primero;
            while(actual.getProximo() != primero){
                actual = actual.getProximo();
            }
            newNodo.setProximo(primero);
            actual.setProximo(newNodo);
            primero = newNodo;
        }

        tam++;
    }

    public void agregarUltimo(T dato){
        Nodo<T> newNodo = new Nodo<>(dato);
        if (primero == null){
            primero = newNodo;
            newNodo.setProximo(primero);
        }else{
            Nodo<T> actual = primero;
            while(actual.getProximo() != primero){
                actual = actual.getProximo();
            }
            actual.setProximo(newNodo);
            newNodo.setProximo(primero);
        }

        tam++;
    }
}