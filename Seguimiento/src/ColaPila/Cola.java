package ColaPila;

public class Cola <T> {
    T frente;
    T fin;
    int tamano;

    public Cola(T fin, T frente, int tamano) {
        this.fin = fin;
        this.frente = frente;
        this.tamano = tamano;
    }

    public T getFin() {
        return fin;
    }

    public void setFin(T fin) {
        this.fin = fin;
    }

    public T getFrente() {
        return frente;
    }

    public void setFrente(T frente) {
        this.frente = frente;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
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
