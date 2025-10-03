package ListaSimpleDobleEnlazada;

import ListaDobleEnlazadaCircular.NodoDoble;

public class ListaSimpleDobleEnlazada<T extends Comparable<T>> {

    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int tam;


    public void ordenNatural(T dato){
        ListaDobleEnlazadaCircular.NodoDoble<T> nuevo = new ListaDobleEnlazadaCircular.NodoDoble<>(dato);

        //El nuevo nodo apunta como siguiente al antiguo primero y este se actualiza como el nuevo anterior
        if(primero == null || dato.compareTo(primero.getDato()) < 0){
            nuevo.setSiguiente(primero);
            if(primero != null){
                primero.setAnterior(nuevo);
            }
            primero = nuevo;


            //Se realiza una inserción en el medio, ajustando 4 referencias
            //nuevo.sguiente = actual.sigueinte -> El nuevo nodo(X) debe apuntar hacia adelamte a lo que venía despues de actual(C)
            //A ⇆ B → X → C
            //nuevo.anteriori = actual -> El nuevo nodo(x) debe apuntar hacia atrás a actual(b)
            //A ⇆ B → X → C
            //     ↑
            //     X.anterior = B
            //actual.siguente.anterior = nuevo -> El nodo que estaba después de actual(c) shora debe saber que su anterior ya no es B sino X
            //A ⇆ B → X ⇆ C
            //actual.siguiente = nuevo -> El nodo actual (B) apunte hacia adelante al nuevo nodo (X) en lugar de a C
            //A ⇆ B ⇆ X ⇆ C
        } else {
            NodoDoble<T> actual = primero;
            while(actual.getSiguiente() != null && dato.compareTo(actual.getSiguiente().getDato()) >= 0){
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            if(actual.getSiguiente() != null){
                actual.getSiguiente().setAnterior(nuevo);
            }
            nuevo.setAnterior(actual);
            actual.setSiguiente(nuevo);
        }
        tam++;
    }
}
