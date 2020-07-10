package WorldElement;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


public class Oggetto extends Image {

private Texture icon;
private String descrizione; //ciò che appare graficamente nell'inventario
private String idCombinazione; //se l'id è uguale allora si possono combinare
private String idPuzzle;        //id utile al controllo se il puzzle è stato risolto
private boolean combinabile;
private boolean combinato; //variabile non più utilizzata
private boolean selezionato; //variabile non più utilizzata
    private boolean raccolto;



    //oggetto classico,
    public Oggetto(Texture icon, String descrizione,String idPuzzle,String idCombinazione,boolean raccolto) {
        super(icon);
        this.descrizione=descrizione;
        this.idPuzzle=idPuzzle;
        this.idCombinazione=idCombinazione;
        this.raccolto=raccolto;
        selezionato=false;
        setBounds(getX(),getY(),getWidth(),getHeight());
    }





    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        ((TextureRegionDrawable)getDrawable()).draw(batch,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight()
                ,getScaleX(),getScaleY(),getRotation());
    }


    //GETTER AND SETTER

    public boolean isRaccolto() {
        return raccolto;
    }

    public void setRaccolto(boolean raccolto) {
        this.raccolto = raccolto;
    }


    public String getIdPuzzle() {
        return idPuzzle;
    }

    public void setIdPuzzle(String idPuzzle) {
        this.idPuzzle = idPuzzle;
    }

    public String getIdCombinazione() {
        return idCombinazione;
    }

    public void setIdCombinazione(String idCombinazione) {
        this.idCombinazione = idCombinazione;
    }

    public boolean isCombinato() {
        return combinato;
    }

    public void setCombinato(boolean combinato) {
        this.combinato = combinato;
    }

    public boolean isSelezionato() {
        return selezionato;
    }

    public void setSelezionato(boolean selezionato) {
        this.selezionato = selezionato;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isCombinabile() {
        return combinabile;
    }

    public void setCombinabile(boolean combinabile) {
        this.combinabile = combinabile;
    }


}
