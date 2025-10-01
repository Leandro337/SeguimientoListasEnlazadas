package ColaPila;

public class Pila<T> {

    private  Nodo<T> cima;
    private int tam;

    public Pila() {
        this.cima = null;
        this.tam = 0;
    }

    //Metodo agregar
    public void agregarCima(T dato){
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setProximo(cima);
        cima = nuevo;
        tam++;
    }

    public T dasapilarDato(){
        if(cima == null){
            return null;
        }

        T dato = cima.getDato();
        cima = cima.getProximo();
        tam--;
        return dato;
    }
}
