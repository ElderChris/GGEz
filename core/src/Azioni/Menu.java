package Azioni;

import com.mygdx.game.MyGdxGame;

import WorldElement.Interazione;

import WorldElement.Combinazioni;
import WorldElement.Oggetto;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.badlogic.gdx.utils.Align;
import java.util.Iterator;

import static Azioni.Inventario.getLista;
import static Azioni.Inventario.getTable;




public class Menu extends Group  implements InputProcessor {
  public   Stage stage;
  public int capitoloAttuale;

    private Image plusButton;
    public boolean plus = false;
    public boolean combina = false;
    private boolean giaRaccolto = false;
    public Oggetto[] materialiCombinazione = {null, null};



   private Group menu;
    private Image reaction;
    private Image inventarioButton;
    private Image osservaButton;
    private Image raccogliButton;
    private Image usaButton;
    private Image combinaButton;
    private Image box;
    private Image parlaButton;

    private Label label;
    private Label labelOgg;
    private Label tutorial;
    private TextButton testButton;
    private Label labelTest;

    private int i=0;
    private int cont=0;

    private MyGdxGame partita;
    private  Interazione interazioneSelezionata;
    private String[] stringaSelezionata;
    final Puzzle puzzle = new Puzzle();

   // private Table table;

    final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    public Menu(int capitoloAttuale, MyGdxGame partita){
        this.partita=partita;
        this.capitoloAttuale = capitoloAttuale;
        //funzionamento del menù: clicci un oggetto interaggibile, viene evidenziato,vengono lette le informazioni dell'oggetto, viene mostrato il menù con i bottoni giusti
        stage = new Stage();

        //table = new Table(mySkin2); //usato per mostrare l'inventario
       getTable().setWidth(700);
        getTable().setHeight(150);
        getTable().align(Align.top|Align.left);
        getTable().setPosition(25,10);
        getTable().setVisible(false);
        getTable().padLeft(5);



         box = new Image(new Texture(Gdx.files.internal("box.png")));

         inventarioButton = new Image(new Texture(Gdx.files.internal("inventario.png")));

         osservaButton = new Image(new Texture(Gdx.files.internal("osserva.png")));

         raccogliButton = new Image(new Texture(Gdx.files.internal("raccogli.png")));

         usaButton = new Image(new Texture(Gdx.files.internal("usa.png")));

         combinaButton = new Image(new Texture(Gdx.files.internal("combina.png")));

         label = new Label(" ",mySkin2);

         labelOgg = new Label(" ",mySkin2);

        plusButton = new Image(new Texture(Gdx.files.internal("plusButton.png")));

        parlaButton = new Image(new Texture(Gdx.files.internal("parla.png")));







        menu = new Group();


        menu.addActor(box);
        menu.addActor(label);
        menu.addActor(labelOgg);
        menu.addActor(inventarioButton);
        menu.addActor(osservaButton);
        menu.addActor(parlaButton);
        menu.addActor(raccogliButton);
        menu.addActor(usaButton);
        menu.addActor(combinaButton);
        menu.addActor(plusButton);

        menu.addActor(getTable());

        box.setPosition(15,1);
        box.setTouchable(Touchable.disabled);
        inventarioButton.setPosition(600,142);
        osservaButton.setPosition(800,142);
        osservaButton.setVisible(false);

        parlaButton.setPosition(800,140);
        parlaButton.setVisible(false);

        raccogliButton.setPosition(800,92);
        raccogliButton.setVisible(false);

        usaButton.setPosition(800,32);
        usaButton.setVisible(false);

        combinaButton.setPosition(750,92);
        combinaButton.setVisible(false);

        plusButton.setPosition(760, 87);
        plusButton.setVisible(false);

        label.setPosition(200,80);
        label.setFontScale(0.6f);
        label.setVisible(false);

       labelOgg.setPosition(200,30);
       labelOgg.setFontScale(0.5f);
       labelOgg.setVisible(false);


        stage.addActor(menu);


        //qui creo i listener dei singoli bottoni

        plusButton.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                Gdx.app.log(" bottone test ","hai cliccato plus");
                plusButton.setVisible(false);
                labelOgg.setVisible(true);
                labelOgg.setText("clicca sul secondo oggetto");
                plus = true;
                return false;
            }
        });

        parlaButton.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                osservaButton.setTouchable(Touchable.disabled);
                parla(interazioneSelezionata);



                return false;
            }
        });


        inventarioButton.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                Gdx.app.log(" bottone test ","hai cliccato inventario");
                mostraInventario();



                return false;
            }
        });

        combinaButton.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                Gdx.app.log(" bottone test","hai cliccato combina");

                combinaButton.setVisible(false);
                labelOgg.setVisible(true);
                labelOgg.setText("Clicca sul primo oggetto e poi sul simbolo (+)");
                //metodo che prende 2 input, ovvero i prossimi 2 oggetti cliccati, li controlla se sono combinabili
                //se si ,vede se corrispondono ad un oggetto frutto di combinazione grazie agli ID,
                //se si, rimuove quegli oggetti e fa comparire il nuovo oggetto nell'inventario
                combina=true;
                plusButton.setVisible(true);



                return false;
            }
        });


        osservaButton.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                Gdx.app.log(" bottone test ","hai cliccato osserva");
                osserva(interazioneSelezionata);


                return false;
            }
        });


        raccogliButton.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                Gdx.app.log(" bottone test ","hai cliccato raccogli");
                if(raccogli(interazioneSelezionata))
                    interazioneSelezionata.getOggetto().setRaccolto(true);

                return false;
            }
        });

        usaButton.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log(" bottone test ","hai cliccato usa");
                usa(interazioneSelezionata);

                return false;
            }
        });

        //area grigia
        box.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //fai andare avanti il dialogo
                Gdx.app.log(" bottone test ","hai cliccato il box dei dialoghi");


               scorriDiscorso(stringaSelezionata,i);
               System.out.println("indice prima: "+ i);
               if(i<stringaSelezionata.length)
               i++;
               else i=0;
                System.out.println("indice dopo: "+ i);
                

                return false;
            }
        });

        getTable().addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                Oggetto hit = null;
                Oggetto risultato;
                hit = (Oggetto) getTable().hit(x, y, false); //hit rappresenta l'attore selezionato con un click
                if(hit != null){

                    Gdx.app.log("Ho cliccato un oggetto -->", hit.getDescrizione());

                    labelOgg.setText(hit.getDescrizione());
                    labelOgg.setVisible(true);

                    if(combina){
                        materialiCombinazione[0] = hit;
                        combina = false;
                    }

                    if(plus)
                        materialiCombinazione[1] = hit;

                    if(materialiCombinazione[1] != null){
                        risultato = combina(materialiCombinazione);
                        if (risultato != null) {
                            getLista().add(risultato);
                            getTable().add(risultato).padRight(15);
                            materialiCombinazione[0] = null;
                            materialiCombinazione[1] = null;
                            Gdx.app.log("Hai combinato 2 oggetti", null);
                        }
                    }
                }
                plus=false;
                combina=false;


                return false;
            }
        });

    }


    //ATTENZIONE: mi permette di cambiare gli stati degli oggetti? Si
    //crea il menù a seconda dell'oggetto interagibile
    public void selezionaInterazione(Interazione interazione){
        interazioneSelezionata= interazione;

        raccogliButton.setVisible(false);



        box.setTouchable(Touchable.disabled);

        //cambiare da enabled a disabled?
        parlaButton.setTouchable(Touchable.enabled);
        raccogliButton.setTouchable(Touchable.enabled);
        usaButton.setTouchable(Touchable.enabled);
        osservaButton.setTouchable(Touchable.enabled);


        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);

        if(reaction!=null)
        reaction.setVisible(false);

        label.setVisible(false);
        labelOgg.setVisible(false);


        nascondiInventario();

        inventarioButton.setVisible(true);
        osservaButton.setVisible(true);

        if(interazione.isNpc())
            parlaButton.setVisible(true);
        else parlaButton.setVisible(false);

        if(interazione.isUsabile()) {
            usaButton.setVisible(true);
        }else usaButton.setVisible(false);

        if(interazione.isRaccoglibile())
            raccogliButton.setVisible(true);
        //else raccogliButton.setVisible(false);


        if(interazione.isRaccoglibileContenitore())
            raccogliButton.setVisible(true);
       // else raccogliButton.setVisible(false);

        if(interazione.isRaccolto())
        raccogliButton.setVisible(false);
    }

    private void mostraInventario(){
        inventarioButton.setVisible(false);
        usaButton.setVisible(false);
        raccogliButton.setVisible(false);
        osservaButton.setVisible(false);
        parlaButton.setVisible(false);
        combinaButton.setVisible(true);
        label.setVisible(false);
        if(reaction!=null)
            reaction.setVisible(false);

        getTable().setVisible(true);

    }

    private void nascondiInventario(){
        combinaButton.setVisible(false);
        plusButton.setVisible(false);
        combina = false;
        plus = false;
        getTable().setVisible(false);
        labelOgg.setVisible(false);
        //verrà nascosta pure la group o la table degli oggetti
    }

    private void osserva(Interazione interazioneSelezionata){
        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);



        label.setText(interazioneSelezionata.getStringaOsserva()[0]);
        label.setVisible(true);
        stringaSelezionata=interazioneSelezionata.getStringaOsserva();

        reaction = new Image(interazioneSelezionata.getReactionFaceOsserva());

        osservaButton.setTouchable(Touchable.disabled);
        mostraReazione(reaction);
    }

    private void parla(Interazione interazioneSelezionata){
        //gli npc sputano stringhe in base se hai un oggetto nell'inventario o meno.
        //a loro si consegnano gli oggetti che spariscono dalla table ma non dalla lista (per poter continuare a usare la stringa puzzleFinito
        //infine ti consegnano oggetti invisibili (solo nella lista) utile solo al proseguimento del livello
        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);

        if(cercaOggetto("pallone")) {
            interazioneSelezionata.setPuzzleRisolto(true);

            if(!Combinazioni.giaRaccoltoChapter2) {
                getLista().add(Combinazioni.perCapitolo3);

                Combinazioni.giaRaccoltoChapter2=true;
            }
        }

        if(cercaOggetto("sogno")){
            interazioneSelezionata.setPuzzleRisolto(true);

            if(!Combinazioni.giaRaccoltoChapter3) {
                getLista().add(Combinazioni.perCapitolo4);
                Combinazioni.giaRaccoltoChapter3=true;
            }
        }


        if(!interazioneSelezionata.isPuzzleRisolto()) {
            label.setText(interazioneSelezionata.getStringaParla()[0]);
            label.setVisible(true);
            stringaSelezionata = interazioneSelezionata.getStringaParla();

            reaction = new Image(interazioneSelezionata.getReactionFaceParla());


        }else{

            label.setText(interazioneSelezionata.getStringaPuzzleRisolto()[0]);
            label.setVisible(true);
            stringaSelezionata = interazioneSelezionata.getStringaPuzzleRisolto();

            reaction = new Image(interazioneSelezionata.getReactionFaceParlaPuzzleRisolto());

        }

        parlaButton.setTouchable(Touchable.disabled);
        mostraReazione(reaction);

    }




        public boolean cercaOggetto(String idPuzzle){
        boolean check = false;
            for(Oggetto oggetto : getLista()) {
                if (oggetto.getIdPuzzle().equals(idPuzzle))
                    check=true;
            }

        return  check;
        }


    private void mostraReazione(Actor reaction){
        reaction.setName("reaction");
        menu.addActor(reaction);
        reaction.setPosition(30,30);
        reaction.setVisible(true);
        box.setTouchable(Touchable.enabled);

    }

    private boolean raccogli(Interazione interazioneSelezionata){
        boolean check = false;

        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);

        label.setText(interazioneSelezionata.getStringaRaccogli()[0]);
        label.setVisible(true);

        stringaSelezionata=interazioneSelezionata.getStringaRaccogli();

        reaction = new Image(interazioneSelezionata.getReactionFaceRaccogli());

        //Solo per quanto riguarda il pallone,questo IF gestisce la sua specialità (è raccoglibile solo se possiedi la fionda carica)

        if(interazioneSelezionata.getDescrizione().equals("pallone")){
            Gdx.app.log(" pallone puzzle "," hai fatto raccogli sul pallone");

            if(cercaOggetto("fiondaCarica")){
                Gdx.app.log(" pallone puzzle ","hai raccolto il pallone grazie alla fionda caricata");
                interazioneSelezionata.setPuzzleRisolto(true);
                label.setText("*hai usato la fionda caricata* ");
                getLista().add(interazioneSelezionata.getOggetto());
                check=true;
                getTable().add(interazioneSelezionata.getOggetto()).padRight(15);


                if(interazioneSelezionata.isRaccoglibile())
                    interazioneSelezionata.setRimuovibile(true);
            }
        }else {


            //qui aggiungi l'oggetto alla lista
            if (!interazioneSelezionata.getOggetto().isRaccolto()) {
                getLista().add(interazioneSelezionata.getOggetto());
                check = true;
            }
            //e va aggiunto alla table
            getTable().add(interazioneSelezionata.getOggetto()).padRight(15);


            if(interazioneSelezionata.isRaccoglibile())
                interazioneSelezionata.setRimuovibile(true);



            if(interazioneSelezionata.isRaccoglibileContenitore())
                interazioneSelezionata.setRaccolto(true);



        }




        raccogliButton.setTouchable(Touchable.disabled);
        mostraReazione(reaction);

        return check;

    }

    private void usa(Interazione interazioneSelezionata) {




        puzzle.selezionaPuzzle(capitoloAttuale, interazioneSelezionata,partita);



        if (menu.findActor("reaction") != null)
            menu.removeActor(reaction);

        label.setText(interazioneSelezionata.getStringaUsa()[0]);
        label.setVisible(true);
        stringaSelezionata = interazioneSelezionata.getStringaUsa();

        reaction = new Image(interazioneSelezionata.getReactionFaceUsa());

        usaButton.setTouchable(Touchable.disabled);
        mostraReazione(reaction);
    }



    //La funzione combina genera il nuovo oggetto e rimuove i materiali dalla lista
    private Oggetto combina(Oggetto[] materialiCombinazione){
        Oggetto oggetto = null;
        if (!materialiCombinazione[0].getIdCombinazione().equals("X")) {
            if (!materialiCombinazione[1].getIdCombinazione().equals("X")) {
                if (materialiCombinazione[1].getIdCombinazione().equals(materialiCombinazione[0].getIdCombinazione())){
                    if(!materialiCombinazione[1].equals(materialiCombinazione[0])) {

                        switch (materialiCombinazione[0].getIdCombinazione()) {
                            case "test":
                                Iterator<Oggetto> it = getLista().iterator();
                                while (it.hasNext()) {
                                    Oggetto ogg = it.next();
                                    if (ogg.getIdCombinazione().equals("test")) {
                                        it.remove();
                                        getTable().removeActor(ogg);
                                    }
                                }
                                oggetto = Combinazioni.prova;
                                break;

                            case "fiondaCarica":
                                it = getLista().iterator();
                                while (it.hasNext()) {
                                    Oggetto ogg = it.next();
                                    if (ogg.getIdCombinazione().equals("fiondaCarica")) {
                                        it.remove();
                                        getTable().removeActor(ogg);
                                    }
                                }
                                oggetto = Combinazioni.fiondaCarica;
                                break;

                            case "potatoChip":
                                it = getLista().iterator();
                                while (it.hasNext()) {
                                    Oggetto ogg = it.next();
                                    if (ogg.getIdCombinazione().equals("potatoChip")) {
                                        it.remove();
                                        getTable().removeActor(ogg);
                                    }
                                }
                                oggetto = Combinazioni.potatoChip;
                                break;

                            case "potatoOs":
                                it = getLista().iterator();
                                while (it.hasNext()) {
                                    Oggetto ogg = it.next();
                                    if (ogg.getIdCombinazione().equals("potatoOs")) {
                                        it.remove();
                                        getTable().removeActor(ogg);
                                    }
                                }
                                oggetto = Combinazioni.potatoOs;
                                break;

                            case "chargedPotato":
                                it = getLista().iterator();
                                while (it.hasNext()) {
                                    Oggetto ogg = it.next();
                                    if (ogg.getIdCombinazione().equals("chargedPotato")) {
                                        it.remove();
                                        getTable().removeActor(ogg);
                                    }
                                }
                                oggetto = Combinazioni.potatoCarica;
                                break;

                            default:
                                Gdx.app.log("ERRORE", " ");
                                labelOgg.setText("Per logica, sceglierei prima un oggetto ");
                                break;

                        }
                    }else
                        labelOgg.setText("Non sembra una cosa intelligente");

                }else
                    labelOgg.setText("Non sembra una cosa intelligente");
            }else
                labelOgg.setText("Non sembra una cosa intelligente");

        }else
            labelOgg.setText("Non sembra una cosa intelligente");

        materialiCombinazione[0]=null;
        materialiCombinazione[1]=null;
        combina = false;
        plus = false;

        combinaButton.setVisible(true);

        return oggetto;
    }


    private void scorriDiscorso(String[] stringa,int i){
                if(i+1<stringa.length)
                label.setText(stringa[i+1]);
                else label.setText(stringa[0]);
    }


    public void rimuoviOggetto(String idPuzzle){

        Iterator<Oggetto> it = getLista().iterator();
        while (it.hasNext()) {
            Oggetto ogg = it.next();
            if (ogg.getIdPuzzle().equals(idPuzzle)) {
                it.remove();
            }
        }

    }

    //controlla sempre se un Interazione copia ha subito una modifica ai parametri, se sì, trasferisce le modifiche all'Interazione reale
    private void modificaInterazione(Interazione interazione){
        if(interazioneSelezionata.isRaccolto())
            interazione.setRaccolto(true);



    }
    public boolean isRimuovibile(Interazione interazioneSelezionata){

    return interazioneSelezionata.isRimuovibile();
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {

        stage.draw();
    }

    @Override
    public void act(float delta) {
        stage.act(delta);
    }

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public Stage getStage() {
        return super.getStage();
    }
}
