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

public class Capitolo3_2 implements Screen {
    MyGdxGame partita;
    Stage stage;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;
    BitmapFont font;

    final float WORLD_WIDTH = 100;
    final float WORLD_HEIGHT = 75;




    public Capitolo3_2(final MyGdxGame partita){
        this.partita=partita;







        //utilizzo il json per caricare il font e imposto telecamera visualizzazione
        final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        final float aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();

        camera = new OrthographicCamera(25*aspectRatio,25);
        camera.setToOrtho(false, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        stage = new Stage(new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera));
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));

        Image sfondo = new Image(new Texture(Gdx.files.internal("lab2_baseFix.png")));
        sfondo.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        sfondo.setTouchable(Touchable.enabled);

        final Protagonista pgTest = new Protagonista(new Texture("bimbo.png"));


        // settare l'idPuzzle in modo che il sistema riconosca gli elementi chiave per superare i capitoli




        //inizializzazione dimensioni Interazioni


        InterazioniCap3.getPortaBack().setSize(27,46);
        InterazioniCap3.getMacchina().setSize(14,25);
        InterazioniCap3.getCestino().setSize(9,10);
        InterazioniCap3.getDottore().setSize(14,19);
        InterazioniCap3.getComputer().setSize(8,5);
        InterazioniCap3.getPatataInterazione().setSize(5,4);
        pgTest.setSize(16,22);


        //imposto posizioni interazioni

        InterazioniCap3.getPortaBack().setPosition(82,20);
        InterazioniCap3.getMacchina().setPosition(30,26);
        InterazioniCap3.getPatataInterazione().setPosition(63.5f,34.5f);
        InterazioniCap3.getCestino().setPosition(18,25);
        InterazioniCap3.getDottore().setPosition(45,23);
        InterazioniCap3.getComputer().setPosition(56,36);

        pgTest.setPosition(66,18);


        final Group scena= new Group();
        //aggiungo interazioni alla scena

        scena.addActor(pgTest);
        scena.addActor(InterazioniCap3.getPortaBack());
        scena.addActor(InterazioniCap3.getMacchina());


        //investiga sul bug della patata fantasma
        if(!InterazioniCap3.getPatataInterazione().isRimuovibile())
        scena.addActor(InterazioniCap3.getPatataInterazione());

        scena.addActor(InterazioniCap3.getCestino());
        scena.addActor(InterazioniCap3.getDottore());
        scena.addActor(InterazioniCap3.getComputer());


        //creo il menù che gestisce le interazioni con gli oggetti e il puzzle del capitolo
        final Menu menu = new Menu(3,partita);


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

                    //da mettere in render?
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
