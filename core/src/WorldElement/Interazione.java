package WorldElement;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

// vedere bene la documentazione per gli attori / Image
public class Interazione extends Image { //meglio extends Actor oppure Image?

    //da rendere privati?
    public Texture texture;
    public Sprite sprite;
    public String[] stringaOsserva; //ogni interazione è osservabile
    public String descrizioneInventario;
    public String[] stringaUsa;
    public String[] stringaRaccogli;

    public boolean usabile;
    public boolean raccoglibileContenitore; //da usare per gli oggetti come armadi,comodini che per esempio contengono altri oggetti
    public boolean raccoglibile; //da usare per gli oggetti che possono essere presi e rimossi dalla scena come il pallone del capitolo 2.
    public Texture reactionFaceOsserva;
    private Texture reactionFaceUsa;
    private Texture reactionFaceRaccogli;


    //costruzione interazione personalizzata
    public Interazione(Texture texture, String[] stringaOsserva, String[] stringaUsa, String[] stringaRaccogli, String descrizioneInventario, boolean usabile,
                       boolean raccoglibileContenitore, boolean raccoglibile,Texture reactionFaceOsserva, Texture reactionFaceRaccogli, Texture reactionFaceUsa) {
        super(texture);
        this.stringaOsserva = stringaOsserva;
        this.descrizioneInventario=descrizioneInventario;
        this.stringaUsa=stringaUsa;
        this.stringaRaccogli=stringaRaccogli;
        this.usabile=usabile;
        this.raccoglibileContenitore=raccoglibileContenitore;
        this.raccoglibile=raccoglibile;
        this.reactionFaceOsserva = reactionFaceOsserva;
        this.reactionFaceRaccogli=reactionFaceRaccogli;
        this.reactionFaceUsa=reactionFaceUsa;



    }

    //interazione dove l'utente può premere 'usa' (bottoni, porte...)
    public Interazione(Texture texture,String[] stringaOsserva,String[] stringaUsa,Texture reactionFaceOsserva, Texture reactionFaceUsa){
        super(texture);
        this.stringaOsserva=stringaOsserva;
        this.reactionFaceOsserva = reactionFaceOsserva;
        this.reactionFaceUsa=reactionFaceUsa;
        this.stringaUsa=stringaUsa;
        usabile=true;
        raccoglibile=false;
        raccoglibileContenitore=false;

        this.setName("usabile");

    }

    //interazione dove l'utente può premere 'raccogli'(oggetti rimuovibili dalla scena)
    public Interazione(Texture texture, Texture reactionFaceOsserva, Texture reactionFaceRaccogli, String[] stringaOsserva, String[] stringaRaccogli){
        super(texture);
        this.stringaOsserva=stringaOsserva;
        this.stringaRaccogli=stringaRaccogli;
        this.reactionFaceOsserva = reactionFaceOsserva;
        this.reactionFaceRaccogli = reactionFaceRaccogli;
        raccoglibile=true;
        usabile=false;
        raccoglibileContenitore=false;
        this.setName("raccoglibile");

    }

    //interazione dove l'utente può premere 'raccogli' (contenitori, armadi..)
    public Interazione(String[] stringaOsserva, Texture texture, Texture reactionFaceOsserva, Texture reactionFaceRaccogli, String[] stringaRaccogli){
        super(texture);
        this.reactionFaceOsserva = reactionFaceOsserva;
        this.reactionFaceRaccogli = reactionFaceRaccogli;
        this.stringaRaccogli=stringaRaccogli;
        this.stringaOsserva=stringaOsserva;
        raccoglibileContenitore=true;
        usabile=false;
        raccoglibile=false;
        this.setName("contenitore");


    }


    //per debug
    public Interazione(String[] array){
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

    }


    //fare classe per gli oggetti quelli dell'inventario (è sempre un custom actor che disegna la sua icona nell'inventario



    @Override
    public void act(float delta) {

        super.act(delta);
        setBounds(getX(),getY(),getWidth(),getHeight());
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        ((TextureRegionDrawable)getDrawable()).draw(batch,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight()
                ,getScaleX(),getScaleY(),getRotation());


    }

    @Override
    public void setDrawable(Drawable drawable) {
        super.setDrawable(drawable);
    }


    //GETTER AND SETTER


    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Texture getReactionFaceUsa() {
        return reactionFaceUsa;
    }

    public void setReactionFaceUsa(Texture reactionFaceUsa) {
        this.reactionFaceUsa = reactionFaceUsa;
    }

    public Texture getReactionFaceRaccogli() {
        return reactionFaceRaccogli;
    }

    public void setReactionFaceRaccogli(Texture reactionFaceRaccogli) {
        this.reactionFaceRaccogli = reactionFaceRaccogli;
    }

    public String[] getStringaOsserva() {
        return stringaOsserva;
    }

    public void setStringaOsserva(String[] stringaOsserva) {
        this.stringaOsserva = stringaOsserva;
    }


    public String getDescrizioneInventario() {
        return descrizioneInventario;
    }

    public void setDescrizioneInventario(String descrizioneInventario) {
        this.descrizioneInventario = descrizioneInventario;
    }

    public String[] getStringaUsa() {
        return stringaUsa;
    }

    public void setStringaUsa(String[] stringaUsa) {
        this.stringaUsa = stringaUsa;
    }

    public String[] getStringaRaccogli() {
        return stringaRaccogli;
    }

    public void setStringaRaccogli(String[] stringaRaccogli) {
        this.stringaRaccogli = stringaRaccogli;
    }


    public boolean isUsabile() {
        return usabile;
    }

    public void setUsabile(boolean usabile) {
        this.usabile = usabile;
    }

    public boolean isRaccoglibileContenitore() {
        return raccoglibileContenitore;
    }

    public void setRaccoglibileContenitore(boolean raccoglibileContenitore) {
        this.raccoglibileContenitore = raccoglibileContenitore;
    }

    public boolean isRaccoglibile() {
        return raccoglibile;
    }

    public void setRaccoglibile(boolean raccoglibile) {
        this.raccoglibile = raccoglibile;
    }

    public Texture getReactionFaceOsserva() {
        return reactionFaceOsserva;
    }

    public void setReactionFaceOsserva(Texture reactionFaceOsserva) {
        this.reactionFaceOsserva = reactionFaceOsserva;
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return super.hit(x, y, touchable);
    }
}
