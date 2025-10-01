package ColaPila;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    public Cola(Nodo<T> fin, Nodo<T> frente, int tamano) {
        this.fin = fin;
        this.frente = frente;
        this.tamano = tamano;
    }

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public Nodo<T> getFrente() {
        return frente;
    }

    public void setFrente(Nodo<T> frente) {
        this.frente = frente;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public Nodo<T> desencolar() {
        if (frente == null) {
            return null;
        }

        Nodo<T> aux = frente;
        frente = frente.getProximo();
        tamano--;
        return aux;
    }

    public void encolar(T dato){
        Nodo<T> newNodo = new Nodo<>(dato);
        if(frente == null){
            frente = newNodo;
            fin = newNodo;
            tamano++;
        }

        fin.setProximo(newNodo);
        fin = newNodo;
        tamano++;

    }

    @Override
    public String toString() {
        return "Cola{" +
                "fin=" + fin +
                ", frente=" + frente +
                ", tamano=" + tamano +
                '}';
    }
}
