public class ListaSimpleEnlazadaCircular<T extends Comparable<T>> {

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

    public void ordenNatural(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);

        //Si la lista está vacía, el nuevo nodo apunta a sí mismo
        if(primero == null){
            primero = nuevo;
            nuevo.setProximo(primero);

        //Si el nuevo es menor que el primero, se inserta al inicio y el último (antiguo primero) debe actualizar su enlace
        //y seguir apuntando al primero
        } else if (dato.compareTo(primero.getDato()) < 0){
            Nodo<T> ultimo = primero;
            while (ultimo.getProximo() != primero){
                ultimo = ultimo.getProximo();
            }
            nuevo.setProximo(primero);
            primero = nuevo;
            ultimo.setProximo(primero);

        //Ahora se recorre la lista en busca del lugar adecuado.
        } else {
            Nodo<T> actual = primero;
            while(actual.getProximo() != primero && dato.compareTo(actual.getProximo().getDato()) >= 0){
                actual = actual.getProximo();
            }

            nuevo.setProximo(actual.getProximo());
            actual.setProximo(nuevo);
        }
        tam++;
    }
}