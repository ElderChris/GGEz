package schermate;

import Azioni.Menu;
import WorldElement.Interazione;
import WorldElement.InterazioniCap2;
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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;
import WorldElement.InterazioniCap3;

public class SchermataFinale implements Screen {
    MyGdxGame partita;
    Stage stage;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;
    BitmapFont font;


    final float WORLD_WIDTH = 100;
    final float WORLD_HEIGHT = 75;




    public SchermataFinale(final MyGdxGame partita){
        this.partita=partita;

        Label scritta;





        //utilizzo il json per caricare il font e imposto telecamera visualizzazione
        final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        final float aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();


        camera = new OrthographicCamera(25*aspectRatio,25);
        camera.setToOrtho(false, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        stage = new Stage(new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera));
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));

        Image sfondo = new Image(new Texture(Gdx.files.internal("sfondoFine2.png")));
        sfondo.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        sfondo.setTouchable(Touchable.enabled);

        final Protagonista pgTest = new Protagonista(new Texture("bimbo.png"));




        Texture bimboTexture = new Texture(Gdx.files.internal("bambinoHappy.png"));
        Texture protagonistaTexture = new Texture(Gdx.files.internal("reactionHappy.png"));
        Texture professoreTexture = new Texture(Gdx.files.internal("surprised_gurghi.png"));


        Image bimbo = new Image(bimboTexture);
        Image protagonista = new Image(protagonistaTexture);
        Image professore = new Image(professoreTexture);

        //inizializzazione dimensioni Interazioni


        pgTest.setSize(16,22);
        InterazioniCap2.getBambino().setSize(13,18);
        InterazioniCap3.getDottore().setSize(13,20);


        protagonista.setSize(10,10);
        professore.setSize(10,10);
        bimbo.setSize(10,10);


        //imposto posizioni interazioni


        InterazioniCap2.getBambino().setPosition(35,45);

        InterazioniCap3.getDottore().setPosition(49,45);

        pgTest.setPosition(23,45);


        protagonista.setPosition(23,30);
        bimbo.setPosition(35,30);
        professore.setPosition(49,30);

        final Group scena= new Group();
        //aggiungo interazioni alla scena

        scena.addActor(pgTest);
        scena.addActor(InterazioniCap3.getDottore());
        scena.addActor(InterazioniCap2.getBambino());
        scena.addActor(bimbo);
        scena.addActor(professore);
        scena.addActor(protagonista);





        //creo il menù che gestisce le interazioni con gli oggetti e il puzzle del capitolo
        final Menu menu = new Menu(3,partita);













        //creo l'interfaccia con la mappa
        stage.addActor(sfondo);
        stage.addActor(scena);


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
