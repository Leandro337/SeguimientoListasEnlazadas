package ColaPila;

public class Nodo<T> {
    private Nodo<T> dato;
    private Nodo<T> proximo; //Referencia al siguiente elemento

    public Nodo(Nodo<T> dato, Nodo<T> proximo) {
        this.dato = dato;
        this.proximo = proximo;
    }

    public Nodo<T> getDato() {
        return dato;
    }

    public void setDato(Nodo<T> dato) {
        this.dato = dato;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }


}
