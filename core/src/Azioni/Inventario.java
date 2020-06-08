package Azioni;

import WorldElement.Oggetto;

import java.util.ArrayList;
import java.util.List;


public class Inventario {

    private static List<Oggetto> lista = new ArrayList<>();

    public static List<Oggetto> getLista(){
        return lista;
    }

    private void setLista(List<Oggetto> lista){
        this.lista=lista;
    }

    private void add(Oggetto oggetto){
        lista.add(oggetto);
    }

    private void remove(Oggetto oggetto) {
        lista.remove(oggetto);
    }

}
