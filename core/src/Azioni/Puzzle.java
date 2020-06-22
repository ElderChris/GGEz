package Azioni;

import WorldElement.Interazione;
import WorldElement.Oggetto;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.MyGdxGame;
import schermate.Capitolo2;

import java.util.ArrayList;

import static Azioni.Inventario.getLista;

public class Puzzle {
    public Puzzle() {
    }

    public boolean selezionaPuzzle(int capitoloAttuale, Interazione interazione){
        boolean check = false;
        switch (capitoloAttuale){
            case 1:
                if(interazione.getDescrizione().equals("door")) {
                    if (puzzleCapitolo1())
                        check = true;
                }
                break;
            default: System.out.println("ERRORE");
                break;
        }
        return check;
    }

    public boolean puzzleCapitolo1(){
        boolean check = false;
        for(Oggetto oggetto : getLista()) {
            if (oggetto.getIdPuzzle().equals("key"))
                check = true;
        }
            return check;
    }



    //un puzzle ha il compito di bloccare/sbloccare certe interazioni che sono utili al proseguimento del livello, in input prende l'interazione e l'oggetto da utilizzare


}
