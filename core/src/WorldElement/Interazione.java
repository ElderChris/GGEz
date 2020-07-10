package WorldElement;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Interazione extends Image {

    private Texture texture;
    private Sprite sprite;
    private String[] stringaOsserva; //ogni interazione è osservabile
    private String descrizione;
    private String[] stringaUsa;
    private String[] stringaRaccogli;
    private String[] stringaParla;
    private String[] stringaPuzzleRisolto; //stringa che comunicano i personaggi dopo aver sbloccato un puzzle

    private boolean usabile;
    private boolean raccoglibileContenitore; //da usare per gli oggetti come armadi,comodini che per esempio contengono altri oggetti
    private boolean raccoglibile; //da usare per gli oggetti che possono essere presi e rimossi dalla scena come il pallone del capitolo 2.
    private Texture reactionFaceOsserva;
    private Texture reactionFaceUsa;
    private Texture reactionFaceRaccogli;
    private Texture reactionFaceParla;
    private Texture reactionFaceParlaPuzzleRisolto;
    private Oggetto oggetto;

    private boolean rimuovibile; //se vero, il suo oggetto interno è stato raccolto e ora l'interazione può essere rimosso dalla scena
    private boolean raccolto; //se vero, il suo oggetto inteerno è stato raccolto e ora non più possibile rifare 'raccogli'
    private boolean npc; //se vero, allora rappresenta un personaggio non giocante
    private  boolean puzzleRisolto;

    //costruzione interazione personalizzata
    public Interazione(Texture texture, String[] stringaOsserva, String[] stringaUsa, String[] stringaRaccogli, String descrizione, boolean usabile,
                       boolean raccoglibileContenitore, boolean raccoglibile,Texture reactionFaceOsserva, Texture reactionFaceRaccogli, Texture reactionFaceUsa) {
        super(texture);
        this.stringaOsserva = stringaOsserva;
        this.descrizione=descrizione;
        this.stringaUsa=stringaUsa;
        this.stringaRaccogli=stringaRaccogli;
        this.usabile=usabile;
        this.raccoglibileContenitore=raccoglibileContenitore;
        this.raccoglibile=raccoglibile;
        this.reactionFaceOsserva = reactionFaceOsserva;
        this.reactionFaceRaccogli=reactionFaceRaccogli;
        this.reactionFaceUsa=reactionFaceUsa;



    }
    //interazione SOLO osservabile
    public Interazione(Texture texture,String [] stringaOsserva,Texture reactionFaceOsserva){
        super(texture);
        this.stringaOsserva=stringaOsserva;
        this.reactionFaceOsserva=reactionFaceOsserva;
        usabile=false;
        raccoglibile=false;
        raccoglibileContenitore=false;


    }
    //interazione dove l'utente può premere 'usa' (bottoni, porte...)
    public Interazione(String descrizione,Texture texture,String[] stringaOsserva,String[] stringaUsa,Texture reactionFaceOsserva, Texture reactionFaceUsa){
        super(texture);
        this.descrizione=descrizione;
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
    public Interazione(Texture texture, Texture reactionFaceOsserva, Texture reactionFaceRaccogli, String[] stringaOsserva, String[] stringaRaccogli,Oggetto oggetto){
        super(texture);
        this.stringaOsserva=stringaOsserva;
        this.stringaRaccogli=stringaRaccogli;
        this.reactionFaceOsserva = reactionFaceOsserva;
        this.reactionFaceRaccogli = reactionFaceRaccogli;
        raccoglibile=true;
        usabile=false;
        raccoglibileContenitore=false;
        this.oggetto=oggetto;
        rimuovibile=false;


        descrizione= " ";
        this.setName("raccoglibile");

    }

    //interazione dove l'utente può premere 'raccogli' (contenitori, armadi..)
    public Interazione(String[] stringaOsserva, Texture texture, Texture reactionFaceOsserva, Texture reactionFaceRaccogli, String[] stringaRaccogli,Oggetto oggetto){
        super(texture);
        this.reactionFaceOsserva = reactionFaceOsserva;
        this.reactionFaceRaccogli = reactionFaceRaccogli;
        this.stringaRaccogli=stringaRaccogli;
        this.stringaOsserva=stringaOsserva;
        raccoglibileContenitore=true;
        usabile=false;
        raccoglibile=false;
        this.oggetto=oggetto;
        raccolto=false;

        descrizione= " ";
        this.setName("contenitore");

    }
    //costruttore per i personaggi, con loro è disponibile solo il tasto parla, il giocatore può ricevere / consegnare oggetti ai personaggi (per puzzle)
    public Interazione(Texture texture,Texture reactionFace,Texture reactionFacePuzzleRisolto ,String[] stringaParla, String[] stringaPuzzleRisolto){
        super(texture);
        this.stringaParla=stringaParla;
        this.reactionFaceParla=reactionFace;
        this.stringaParla=stringaParla;
        this.stringaPuzzleRisolto=stringaPuzzleRisolto;
        this.reactionFaceParlaPuzzleRisolto= reactionFacePuzzleRisolto;
        npc=true;
        puzzleRisolto=false;

        //stratagemma per evitare un crash raro
        stringaOsserva = new String[] {""};
        reactionFaceOsserva = reactionFaceParlaPuzzleRisolto;

        this.setName("npc");
    }


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

    public Interazione getInterazione(){
        return this;
    }

    public String[] getStringaParla() {
        return stringaParla;
    }

    public void setStringaParla(String[] stringaParla) {
        this.stringaParla = stringaParla;
    }

    public String[] getStringaPuzzleRisolto() {
        return stringaPuzzleRisolto;
    }

    public void setStringaPuzzleRisolto(String[] stringaPuzzleRisolto) {
        this.stringaPuzzleRisolto = stringaPuzzleRisolto;
    }

    public Texture getReactionFaceParlaPuzzleRisolto() {
        return reactionFaceParlaPuzzleRisolto;
    }

    public void setReactionFaceParlaPuzzleRisolto(Texture reactionFaceParlaPuzzleRisolto) {
        this.reactionFaceParlaPuzzleRisolto = reactionFaceParlaPuzzleRisolto;
    }

    public boolean isPuzzleRisolto() {
        return puzzleRisolto;
    }

    public void setPuzzleRisolto(boolean puzzleRisolto) {
        this.puzzleRisolto = puzzleRisolto;
    }

    public Texture getReactionFaceParla() {
        return reactionFaceParla;
    }

    public void setReactionFaceParla(Texture reactionFaceParla) {
        this.reactionFaceParla = reactionFaceParla;
    }

    public boolean isNpc() {
        return npc;
    }

    public void setNpc(boolean npc) {
        this.npc = npc;
    }


    public boolean isRaccolto() {
        return raccolto;
    }

    public void setRaccolto(boolean raccolto) {
        this.raccolto = raccolto;
    }

    public boolean isRimuovibile() {
        return rimuovibile;
    }

    public void setRimuovibile(boolean rimuovibile) {
        this.rimuovibile = rimuovibile;
    }

    public void setOggetto(Oggetto oggetto){
        this.oggetto=oggetto;
    }

    public Oggetto getOggetto(){
        return oggetto;
    }

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


    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizioneInventario) {
        this.descrizione = descrizioneInventario;
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
