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
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;

public class Capitolo1 implements Screen {


    public String nomegiocatore="James";
    MyGdxGame partita;
    public SpriteBatch batch;
    public Texture img;
    public Texture texture1;
    public TextButton prova;

    Sprite png;
    BitmapFont font;
  public Stage stage;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;

    final float WORLD_WIDTH = 100;
    final float WORLD_HEIGHT = 75;


    // È SOLO UNA DEMO, LE FUNZIONALITÀ ANDRANNO IMPLEMENTATE COME CLASSI DI ATTORI E GRUPPI PERSONALIZZATI OLTRE CHE I MENÙ SARANNO DI INPUT PROCESSOR,
    //Negli screen avvengono solo le sequenze scriptate della storia per ogni capitolo

    //cose da fare 1)
    //                creare il Group menù e il Group Scene (ogni livello ha una scena) in Capitolo1 c'è solo enigma e cutscene
    //                menù con inventario, e azioni
    //                le azioni del menù devono essere più generali possibile quindi si applicano su qualsiasi oggetto
    public Capitolo1(MyGdxGame partita,String nomegiocatore){
        this.partita=partita;

        String stringaPorta="è una porta";
        String stringaComodino="è un comodino";
        String stringaLetto= "è un letto";

        final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        final float aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();

        camera = new OrthographicCamera(25*aspectRatio,25);
        camera.setToOrtho(false, WORLD_WIDTH/2, WORLD_HEIGHT/2);

        stage = new Stage(new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera));
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));



        Image sfondo = new Image(new Texture(Gdx.files.internal("camera_ospedale_base.png")));
        sfondo.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        sfondo.setTouchable(Touchable.enabled);


     final   Protagonista pgTest = new Protagonista(nomegiocatore,new Texture("bimbo.png"));
        pgTest.setSize(23,28);


        //creare già le texture e stringhe inizializzatee così è più facile assegnarle agli attori

        Interazione door = new Interazione(new Texture(Gdx.files.internal("door.png")),"la stupida porta di camera mia","non si apre",new Texture(Gdx.files.internal("reactionConfusion.png")),new Texture(Gdx.files.internal("reactionNeutral.png")));
        door.setSize(13,22);
        door.setSize(9,17);


        Interazione comodino = new Interazione("È un comodino brutto",new Texture(Gdx.files.internal("kermit.png")),new Texture(Gdx.files.internal("reactionAngry.png")),new Texture(Gdx.files.internal("reactionSurprised.png")),"hey ho trovato una chiave");
        comodino.setSize(18,23);




        Interazione letto = new Interazione(new Texture(Gdx.files.internal("letto.png"))," il mio letto...  ","ho già dormito abbastanza ",new Texture(Gdx.files.internal("reactionNeutral.png")),new Texture(Gdx.files.internal("reactionHappy.png")));
        letto.setSize(40,24);



        door.setPosition(3,20);
        comodino.setPosition(43,23);
        letto.setPosition(66,17);
        pgTest.setPosition(65,17);


        final Group scena = new Group();

        scena.addActor(door);
        scena.addActor(comodino);
        scena.addActor(letto);
        scena.addActor(pgTest);
        pgTest.setTouchable(Touchable.disabled);




   //     final Dialog dialog= new Dialog("Benvenuto "+nomegiocatore,mySkin2);
   //     dialog.setSize(3,3);
   /*     final Dialog portaDialog= new Dialog(stringaPorta,mySkin2);
        portaDialog.setSize(3,3);
        final Dialog comodinoDialog = new Dialog(stringaComodino,mySkin2);
        comodinoDialog.setSize(3,3);
        final Dialog lettoDialog = new Dialog(stringaLetto,mySkin2);
        lettoDialog.setSize(3,3);
*/
   /*
        Timer.schedule(new Timer.Task(){
            public void run(){
                dialog.hide();
            }

        },2);
*/
       final Menu menu = new Menu();

        scena.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

             //   Gdx.app.log("Mouse Event","Click at " + x + "," + y);
                Vector3 worldCoordinates = camera.unproject(new Vector3(x,y,0));
            //    Gdx.app.log("Mouse Event","Projected at " + worldCoordinates.x + "," + worldCoordinates.y);

                    /*
                    MoveToAction move = new MoveToAction();
                    move.setPosition(x,y);
                    move.setDuration(2f);
                    pgTest.addAction(move);
                    */
                  //  Vector2 coord = stage.screenToStageCoordinates(new Vector2(x, y))

                    //ATTENZIONE potrebbe crashare per colpa di  "java.lang.ClassCastException: WorldElement.Protagonista cannot be cast to WorldElement.Interazione" ,
                    //SOLUZIONI: da mettere l'eccezione o si risolverà quando cambio il modo di movimento del personaggio oppure togliere il personaggio dal Group
                Interazione hit = null;
                try {
                     hit = (Interazione) scena.hit(x, y, false); //hit rappresenta l'attore selezionato con un click
                }catch (Exception ClassCastException){ }

                    if (hit!=null){


                        menu.selezionaInterazione(hit);

                        Gdx.app.log(" attore test ",hit.getName());

                    }

                return false;
            }
        });


        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(menu.stage);
        Gdx.input.setInputProcessor(multiplexer);

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
