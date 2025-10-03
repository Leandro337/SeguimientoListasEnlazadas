package ColaPila;

public class BiCola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tam;

    public BiCola() {
        frente = null;
        fin = null;
        tam = 0;
    }

    public void agregarFrente(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (frente == null) {
            frente = fin = nuevo;
        } else {
            nuevo.setProximo(frente);
            frente = nuevo;
        }
        tam++;
    }

    public void agregarFin(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.setProximo(nuevo);
            fin = nuevo;
        }
        tam++;
    }
    public T eliminarFrente(){
        if (frente == null){
            System.out.println("La biCola está vacía.");
            return null;
        }
        T dato = frente.getDato();
        frente = frente.getProximo();
        if (frente == null){
            fin = null;
        }
        tam--;
        return dato;
    }
    public T eliminarFin(){
        if (fin == null){
            System.out.println("La biCola está vacía.");
            return null;
        }

        T dato = fin.getDato();
    if (frente == fin){
        frente = fin = null;
    }else {
        Nodo<T> actual = frente;
        while (actual.getProximo() != fin){
            actual = actual.getProximo();
        }
        actual.setProximo(null);
        fin = actual;
    }

    tam--;
    return dato;
    }
}
