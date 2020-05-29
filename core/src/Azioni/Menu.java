package Azioni;

import WorldElement.Interazione;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//creare bottoni che si attiveranno ad ogni attore cliccato, saranno tutti in un group
public class Menu extends Group  implements InputProcessor {
  public   Stage stage;
    String string= " questa è una stringa di prova";
    String stringOgg= "questa è una stringa di prova2";
   private Group menu;
    private Image reaction;
    private Image inventarioButton;
    private Image osservaButton;
    private Image raccogliButton;
    private Image usaButton;
    private Image combinaButton;

    private Label label;
    private Label labelOgg;


    private  Interazione interazioneSelezionata;

    final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    public Menu(){

        //funzionamento del menù: clicci un oggetto interaggibile, viene evidenziato,vengono lette le informazioni dell'oggetto, viene mostrato il menù con i bottoni giusti

        stage = new Stage();


        Image box = new Image(new Texture(Gdx.files.internal("box.png")));

         inventarioButton = new Image(new Texture(Gdx.files.internal("inventario.png")));

         osservaButton = new Image(new Texture(Gdx.files.internal("osserva.png")));

         raccogliButton = new Image(new Texture(Gdx.files.internal("raccogli.png")));

         usaButton = new Image(new Texture(Gdx.files.internal("usa.png")));

         combinaButton = new Image(new Texture(Gdx.files.internal("combina.png")));

         label = new Label(string,mySkin2);

         labelOgg = new Label(stringOgg,mySkin2);

        menu = new Group();


        menu.addActor(box);
        menu.addActor(label);
        menu.addActor(labelOgg);
        menu.addActor(inventarioButton);
        menu.addActor(osservaButton);
        menu.addActor(raccogliButton);
        menu.addActor(usaButton);
        menu.addActor(combinaButton);

        box.setPosition(15,1);
        inventarioButton.setPosition(600,140);
        osservaButton.setPosition(800,140);
        osservaButton.setVisible(false);

        raccogliButton.setPosition(800,90);
        raccogliButton.setVisible(false);

        usaButton.setPosition(800,30);
        usaButton.setVisible(false);

        combinaButton.setPosition(500,90);
        combinaButton.setVisible(false);

        label.setPosition(200,80);
        label.setFontScale(0.6f);
        label.setVisible(false);

       labelOgg.setPosition(150,30);
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


        box.addCaptureListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //fai andare avanti il dialogo

                Gdx.app.log(" bottone test ","hai cliccato il box dei dialoghi");

                return false;
            }
        });



    }
    //Si salva una copia dell'oggetto e crea il menù a seconda dell'oggetto interagibile
    public void selezionaInterazione(Interazione interazione){


        interazioneSelezionata= interazione;



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

    }

    public void nascondiInventario(){
        combinaButton.setVisible(false);
        //verrà nascosta pure la group o la table degli oggetti
    }

    public void osserva(Interazione interazioneSelezionata){
        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);

        label.setText(interazioneSelezionata.stringaOsserva);
        label.setVisible(true);
        reaction = new Image(interazioneSelezionata.getReactionFaceOsserva());

        mostraReazione(reaction);
    }


    public void mostraReazione(Actor reaction){
        reaction.setName("reaction");
        menu.addActor(reaction);
        reaction.setPosition(30,30);
        reaction.setVisible(true);

    }

    public void raccogli(Interazione interazioneSelezionata){
        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);
        label.setText(interazioneSelezionata.stringaRaccogli);
        label.setVisible(true);
        reaction = new Image(interazioneSelezionata.getReactionFaceRaccogli());

        mostraReazione(reaction);

    }

    public void usa(Interazione interazioneSelezionata){
        if(menu.findActor("reaction")!=null)
            menu.removeActor(reaction);

        label.setText(interazioneSelezionata.stringaUsa);
        label.setVisible(true);
        reaction = new Image(interazioneSelezionata.getReactionFaceUsa());

        mostraReazione(reaction);

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
