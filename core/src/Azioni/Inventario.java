package Azioni;

import WorldElement.Oggetto;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;
import java.util.List;


public class Inventario {


    private static Table table=new Table(new Skin(Gdx.files.internal("skin/glassy-ui.json")));

    private static List<Oggetto> lista = new ArrayList<>();

    public static List<Oggetto> getLista(){
        return lista;
    }

    public static Table getTable(){
        return table;
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
