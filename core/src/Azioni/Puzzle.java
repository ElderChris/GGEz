package Azioni;

import WorldElement.Interazione;
import WorldElement.Oggetto;
import com.mygdx.game.MyGdxGame;
import schermate.*;


import static Azioni.Inventario.getLista;

public class Puzzle {
    public Puzzle() {
    }

    public void selezionaPuzzle(int capitoloAttuale, Interazione interazione,MyGdxGame partita) {
        boolean check = false;

        if(interazione.getDescrizione().equals("travelPointForest"))
            partita.setScreen(new Capitolo2_2(partita));

        if(interazione.getDescrizione().equals("travelPointForestBack"))
            partita.setScreen(new Capitolo2(partita));

        if(interazione.getDescrizione().equals("travelPointLaboratory"))
            partita.setScreen(new Capitolo3_2(partita));

        if(interazione.getDescrizione().equals("travelPointLaboratoryBack"))
            partita.setScreen(new Capitolo3(partita));


        switch (capitoloAttuale) {
            case 1:
                if (interazione.getDescrizione().equals("door")) {
                    if (puzzleCapitolo1())
                        partita.setScreen(new Capitolo2(partita));

                }
                break;

            case 2:
                if(interazione.getDescrizione().equals("toChapter3")){
                    if(puzzleCapitolo2())
                        partita.setScreen(new Capitolo3(partita));

                }
                break;

            case 3:
                if(interazione.getDescrizione().equals("toChapter4")){
                    if(puzzleCapitolo3())
                        partita.setScreen(new SchermataFinale(partita));
                }
                break;


            default:
                System.out.println("ERRORE");
                break;
        }

    }

    private boolean puzzleCapitolo1() {
        boolean check = false;
        for (Oggetto oggetto : getLista()) {
            if (oggetto.getIdPuzzle().equals("key"))
                check = true;
        }
        return check;
    }

    private boolean puzzleCapitolo2() {
        boolean check = false;
        for(Oggetto oggetto :getLista()) {
            if(oggetto.getIdPuzzle().equals("toChapter3"))
                check=true;
        }
        return check;
    }

    private boolean puzzleCapitolo3() {
        boolean check = false;
        for(Oggetto oggetto :getLista()) {
            if(oggetto.getIdPuzzle().equals("toChapter4"))
                check=true;
        }
        return check;
    }



    //un puzzle ha il compito di bloccare/sbloccare certe interazioni che sono utili al proseguimento del livello, in input prende l'interazione e l'oggetto da utilizzare


}
