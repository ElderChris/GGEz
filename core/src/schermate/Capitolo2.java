package schermate;

import Azioni.Menu;
import WorldElement.Interazione;
import WorldElement.Oggetto;
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
import WorldElement.InterazioniCap2;

public class Capitolo2 implements Screen {
    MyGdxGame partita;
    Stage stage;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;
    BitmapFont font;

    final float WORLD_WIDTH = 100;
    final float WORLD_HEIGHT = 75;


    public Capitolo2(final MyGdxGame partita){
        this.partita=partita;

        //inizializzazione texture

        Image sfondo = new Image(new Texture(Gdx.files.internal("foresta1_base.png")));




        //inizializzazione stringhe per interazioni






        //utilizzo il json per caricare il font e imposto telecamera visualizzazione
        final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        final float aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();

        camera = new OrthographicCamera(25*aspectRatio,25);
        camera.setToOrtho(false, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        stage = new Stage(new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera));
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));


        sfondo.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        sfondo.setTouchable(Touchable.enabled);

        final Protagonista pgTest = new Protagonista(new Texture("bimbo.png"));
        pgTest.setSize(16,22);

        //creazione oggetti raccoglibili e settare l'idPuzzle in modo che il sistema riconosca gli elementi chiave per superare i capitoli




        //creazione interazioni e inizializzazione dimensioni


        InterazioniCap2.getPorta().setSize(10,10);

        InterazioniCap2.getCartelloDestro().setSize(14,10);

        InterazioniCap2.getCartelloSinistro().setSize(10,10);

        InterazioniCap2.getSabbia().setSize(13,23);

        InterazioniCap2.getFiore().setSize(12,12);

        InterazioniCap2.getPuntoLuce().setSize(13,23);

        InterazioniCap2.getBambino().setSize(13,10);

        //imposto posizioni interazioni

        InterazioniCap2.getPorta().setPosition(82,30);
        InterazioniCap2.getCartelloDestro().setPosition(60,30);
        InterazioniCap2.getCartelloSinistro().setPosition(40,30);
        InterazioniCap2.getSabbia().setPosition(45,10);
        InterazioniCap2.getFiore().setPosition(35,50);
        InterazioniCap2.getPuntoLuce().setPosition(10,30);
        InterazioniCap2.getBambino().setPosition(23,23);

        pgTest.setPosition(70,18);



        final Group scena= new Group();
        //aggiungo interazioni alla scena

        scena.addActor(InterazioniCap2.getPorta());
        scena.addActor(InterazioniCap2.getCartelloDestro());
        scena.addActor(InterazioniCap2.getCartelloSinistro());
        scena.addActor(InterazioniCap2.getSabbia());
        scena.addActor(InterazioniCap2.getFiore());
        scena.addActor(InterazioniCap2.getPuntoLuce());
        scena.addActor(InterazioniCap2.getBambino());
        scena.addActor(pgTest);
        pgTest.setTouchable(Touchable.disabled);






        //creo il menù che gestisce le interazioni con gli oggetti e il puzzle del capitolo
        final Menu menu = new Menu(2,partita);


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
