package Azioni;

import WorldElement.Interazione;
import WorldElement.Oggetto;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.Iterator;

import static Azioni.Inventario.getLista;





//creare bottoni che si attiveranno ad ogni attore cliccato, saranno tutti in un group
public class Menu extends Group  implements InputProcessor {
  public   Stage stage;


   private Group menu;
    private Image reaction;
    private Image inventarioButton;
    private Image osservaButton;
    private Image raccogliButton;
    private Image usaButton;
    private Image combinaButton;
    private Image box;

    private Label label;
    private Label labelOgg;
    private Label tutorial;
    private TextButton testButton;
    private Label labelTest;

    private int i=0;
    private int cont=0;


    private  Interazione interazioneSelezionata;
    private String[] stringaSelezionata;

    private Table table; //capire come funziona

    final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    public Menu(){

        //funzionamento del menù: clicci un oggetto interaggibile, viene evidenziato,vengono lette le informazioni dell'oggetto, viene mostrato il menù con i bottoni giusti

        stage = new Stage();

        table = new Table(mySkin2); //usato per mostrare l'inventario
       table.setWidth(700);
       table.setHeight(150);
        table.align(Align.top|Align.left);
        table.setPosition(25,10);
        table.setVisible(false);
        table.padLeft(5);


        //per debug
        table.debugTable();
        table.debug();
        table.debugAll();


      /*DA FARE: far sparire gli oggetti raccolti dalla scena (FATTO, da testare)

                X CAPITOLO 1     -Sistema di puzzle che cerca l'oggetto nella lista e sblocca porte (serve idOggetto che identifica l'ogg e idCOmbinazione per combinarli)

                  -trovare il modo di far modificare i parametri dell'oggetto cliccato e non alla sua copia

               X CAPITOLO2     -finire di implementare l'interazione con gli NPC (aggiungi bottone parla)

               X CAPITOLO2  -sistema di combinazione degli oggetti(IN CORSO)



                 >)FINISCI CAPITOLO1
                            scrivi testo, finisci ambientazione, sistema oggetti,
       */
         box = new Image(new Texture(Gdx.files.internal("box.png")));

         inventarioButton = new Image(new Texture(Gdx.files.internal("inventario.png")));

         osservaButton = new Image(new Texture(Gdx.files.internal("osserva.png")));

         raccogliButton = new Image(new Texture(Gdx.files.internal("raccogli.png")));

         usaButton = new Image(new Texture(Gdx.files.internal("usa.png")));

         combinaButton = new Image(new Texture(Gdx.files.internal("combina.png")));

         label = new Label(" ",mySkin2);

         labelOgg = new Label(" ",mySkin2);


         Image testTable = new Image(new Texture(Gdx.files.internal("key.png")));
         Image testTable2 = new Image(new Texture(Gdx.files.internal("key.png")));





        menu = new Group();


        menu.addActor(box);
        menu.addActor(label);
        menu.addActor(labelOgg);
        menu.addActor(inventarioButton);
        menu.addActor(osservaButton);
        menu.addActor(raccogliButton);
        menu.addActor(usaButton);
        menu.addActor(combinaButton);
        menu.addActor(table);

        box.setPosition(15,1);
        box.setTouchable(Touchable.disabled);
        inventarioButton.setPosition(600,140);
        osservaButton.setPosition(800,140);
        osservaButton.setVisible(false);

        raccogliButton.setPosition(800,90);
        raccogliButton.setVisible(false);

        usaButton.setPosition(800,30);
        usaButton.setVisible(false);

        combinaButton.setPosition(750,90);
        combinaButton.setVisible(false);

        label.setPosition(200,80);
        label.setFontScale(0.6f);
        label.setVisible(false);

       labelOgg.setPosition(400,30);
       labelOgg.setFontScale(0.5f);
       labelOgg.setVisible(false);


        stage.addActor(menu);


        //qui creo i listener dei singoli bottoni

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
                labelOgg.setText("Clicca su due oggetti per combinarli");
                //metodo che prende 2 input, ovvero i prossimi 2 oggetti cliccati, li controlla se sono combinabili
                //se si ,vede se corrispondono ad un oggetto frutto di combinazione grazie agli ID,
                //se si, rimuove quegli oggetti e fa comparire il nuovo oggetto nell'inventario




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
                raccogli(interazioneSelezionata);

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

        table.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Oggetto hit = null;
                hit = (Oggetto) table.hit(x, y, false); //hit rappresenta l'attore selezionato con un click
                if(hit != null){


                    labelOgg.setText(hit.getDescrizione());
                    labelOgg.setVisible(true);
                }


                return false;
            }
        });



    }
    //ATTENZIONE: mi permette di cambiare gli stati degli oggetti? da vedere nei livelli successivi
    //Si salva una copia dell'oggetto e crea il menù a seconda dell'oggetto interagibile
    public void selezionaInterazione(Interazione interazione){


        interazioneSelezionata= interazione;



        box.setTouchable(Touchable.disabled);
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

        if(interazione.isUsabile())
            usaButton.setVisible(true);
        else usaButton.setVisible(false);

        if(interazione.isRaccolto())
            raccogliButton.setVisible(false);
        else raccogliButton.setVisible(true);

        if(interazione.isRaccoglibile())
            raccogliButton.setVisible(true);
        else raccogliButton.setVisible(false);

        if(interazione.isRaccoglibileContenitore())
            raccogliButton.setVisible(true);
        else raccogliButton.setVisible(false);
    }

    public void mostraInventario(){
        inventarioButton.setVisible(false);
        usaButton.setVisible(false);
        raccogliButton.setVisible(false);
        osservaButton.setVisible(false);
        combinaButton.setVisible(true);
        label.setVisible(false);
        if(reaction!=null)
            reaction.setVisible(false);

        table.setVisible(true);

    }

    public void nascondiInventario(){
        combinaButton.setVisible(false);
        table.setVisible(false);
        labelOgg.setVisible(false);
        //verrà nascosta pure la group o la table degli oggetti
    }

    public void osserva(Interazione interazioneSelezionata){
        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);


        label.setText(interazioneSelezionata.getStringaOsserva()[0]);
        label.setVisible(true);
        stringaSelezionata=interazioneSelezionata.getStringaOsserva();

        reaction = new Image(interazioneSelezionata.getReactionFaceOsserva());

        osservaButton.setTouchable(Touchable.disabled);
        mostraReazione(reaction);
    }


    public void mostraReazione(Actor reaction){
        reaction.setName("reaction");
        menu.addActor(reaction);
        reaction.setPosition(30,30);
        reaction.setVisible(true);
        box.setTouchable(Touchable.enabled);

    }

    public void raccogli(Interazione interazioneSelezionata){
        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);
        label.setText(interazioneSelezionata.getStringaRaccogli()[0]);
        label.setVisible(true);
        stringaSelezionata=interazioneSelezionata.getStringaRaccogli();

        reaction = new Image(interazioneSelezionata.getReactionFaceRaccogli());

        //qui aggiungi l'oggetto alla lista
        getLista().add(cont,interazioneSelezionata.getOggetto());
        //e va aggiunto alla table
          table.add(getLista().get(cont)).padRight(15);
          cont++;



          if(interazioneSelezionata.isRaccoglibile())
              interazioneSelezionata.setRimuovibile(true);
          if(interazioneSelezionata.isRaccolto())
              interazioneSelezionata.setRaccolto(true);


        raccogliButton.setTouchable(Touchable.disabled);
        mostraReazione(reaction);

    }

    public void usa(Interazione interazioneSelezionata){
        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);

        label.setText(interazioneSelezionata.getStringaUsa()[0]);
        label.setVisible(true);
        stringaSelezionata=interazioneSelezionata.getStringaUsa();

        reaction = new Image(interazioneSelezionata.getReactionFaceUsa());

        usaButton.setTouchable(Touchable.disabled);
        mostraReazione(reaction);

    }

    public void scorriDiscorso(String[] stringa,int i){
                if(i+1<stringa.length)
                label.setText(stringa[i+1]);
                else label.setText(stringa[0]);
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
