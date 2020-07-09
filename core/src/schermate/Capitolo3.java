package schermate;

import Azioni.Menu;
import WorldElement.Interazione;
import WorldElement.Protagonista;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;
import WorldElement.InterazioniCap3;
import static Azioni.Inventario.getLista;


public class Capitolo3 implements Screen {
    MyGdxGame partita;
    Stage stage;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;
    BitmapFont font;

    final float WORLD_WIDTH = 100;
    final float WORLD_HEIGHT = 75;



    //puzzle capitolo3, il dottore ti dice che per tornare a casa dovrai entrare nella sua macchina, però non funziona!
    // dovrai costruire l'oggetto mancante richiesto dal dottore, esso è una combinazione di 4 oggetti in totale:
    // ingranaggi,circuiti e 2 oggetti fantasiosi
    //per farti capire cosa combinare, lo scienziato ti fa un indovinello dicendo: " "


    public Capitolo3(final MyGdxGame partita){
        this.partita=partita;








        //utilizzo il json per caricare il font e imposto telecamera visualizzazione
        final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        final float aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();

        camera = new OrthographicCamera(25*aspectRatio,25);
        camera.setToOrtho(false, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        stage = new Stage(new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera));
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));

        Image sfondo = new Image(new Texture(Gdx.files.internal("lab1_sfondo.png")));
        sfondo.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        sfondo.setTouchable(Touchable.enabled);

        final Protagonista pgTest = new Protagonista(new Texture("bimbo.png"));
        pgTest.setSize(16,22);

        // settare l'idPuzzle in modo che il sistema riconosca gli elementi chiave per superare i capitoli




        // inizializzazione dimensioni Interazioni

        InterazioniCap3.getPortaSx().setSize(16,31);
        InterazioniCap3.getTelecamera().setSize(7,7);
        InterazioniCap3.getKermit().setSize(11,22);
        InterazioniCap3.getRobot().setSize(16,20);
        InterazioniCap3.getPortaDx().setSize(13.4f,32);
        InterazioniCap3.getLiane().setSize(26,19);



        //imposto posizioni interazioni

        InterazioniCap3.getPortaDx().setPosition(1,30);
        InterazioniCap3.getTelecamera().setPosition(82,61.5f);
        InterazioniCap3.getKermit().setPosition(44,33);
        InterazioniCap3.getRobot().setPosition(20,32);
        InterazioniCap3.getLiane().setPosition(57,38);
        InterazioniCap3.getPortaSx().setPosition(85,30);

        pgTest.setPosition(70,20);




        final Group scena= new Group();
        //aggiungo interazioni alla scena

        scena.addActor(pgTest);
        scena.addActor(InterazioniCap3.getPortaSx());
        scena.addActor(InterazioniCap3.getTelecamera());
        scena.addActor(InterazioniCap3.getKermit());
        scena.addActor(InterazioniCap3.getRobot());
        scena.addActor(InterazioniCap3.getPortaDx());
        scena.addActor(InterazioniCap3.getLiane());



        //creo il menù che gestisce le interazioni con gli oggetti e il puzzle del capitolo
        final Menu menu = new Menu(3,partita);

        //rimuovo il pallone dall'inventario Logico così da resettare l'interazione con il dottore
        menu.rimuoviOggetto("pallone");

        if(menu.cercaOggetto("pallone"))
            Gdx.app.log(" RIMOZIONE TEST","NON rimosso il pallone");
        else Gdx.app.log("RIMOZIONE TEST", "hai hai rimosso il pallone");






        scena.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {


                Interazione hit = null;
                try {
                    hit = (Interazione) scena.hit(x, y, false); //hit rappresenta l'attore selezionato con un click
                }catch (Exception ClassCastException){ }

                if (hit!=null){

                    //passo al menù l'interazione cliccata
                    menu.selezionaInterazione(hit);

                    if(menu.isRimuovibile(hit))
                        scena.removeActor(hit);


                    Gdx.app.log(" attore test ",hit.getName());

                }


                return false;
            }
        });

        //imposto il gestore degli input
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(menu.stage);
        Gdx.input.setInputProcessor(multiplexer);

        //creo l'interfaccia con la mappa
        stage.addActor(sfondo);
        stage.addActor(scena);
        stage.addActor(menu);

    }


    public void show() {

    }


    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.6f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        stage.act();
        stage.draw();

    }


    public void resize(int width, int height) {

    }

    public void pause() {

    }


    public void resume() {

    }


    public void hide() {

    }

    public void dispose() {

    }
}
