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

        Texture portaTexture = new Texture(Gdx.files.internal("door.png"));
        Texture comodinoTexture = new Texture(Gdx.files.internal("kermit.png"));
        Texture lettoTexture = new Texture(Gdx.files.internal("letto.png"));

        Texture reactionConfusedTexture = new Texture(Gdx.files.internal("reactionSad.png"));
        Texture reactionNeutralTexture = new Texture(Gdx.files.internal("reactionNeutral.png"));
        Texture reactionAngryTexture = new Texture(Gdx.files.internal("reactionScared.png"));
        Texture reactionSurprisedTexture = new Texture(Gdx.files.internal("reactionSurprised.png"));
        Texture reactionHappyTexture = new Texture(Gdx.files.internal("reactionHappy.png"));





        String[] stringaOsservaPorta = new String[]  {"quella è la mia porta.." ,"bho...", "c'è nessuno?"};
        String[] stringaOsservaComodino = new String[] {"il comodino...","è un bel comodino...","c'è il pupazzo di kermit"};
        String[] stringaOsservaLetto = new String[] {"il mio letto...","a che ora mi sono svegliato?..."," vabbè  "};

        String[] stringaOsservaPorta1 = new String[]  {" osserva porta 1" ," osserva porta 2", " osserva porta 3"};
        String[] stringaOsservaComodino1 = new String[] {" osserva comodino 1"," osserva comodino 2"," osserva comodino 3"};
        String[] stringaOsservaLetto1 = new String[] {"osserva letto 1.","osserva letto 2"," osserva letto 3  "};

        //stringhe per debugging
        String[] stringaUsaPorta1 = new String[]  {" usa porta 1" ," usa porta 2", " usa porta 3","usa porta 4"};
        String[] stringaRaccogliComodino1 = new String[] {" raccogli comodino 1"," raccolgi comodino 2"};
        String[] stringaUsaLetto1 = new String[] {"usa letto 1.","usa letto 2"," usa letto 3  "};


        String[] stringaUsaPorta = new String[]  {"non si apre..." ,"è chiusa a chiave...", "la chiave sarà in giro"};
        String[] stringaRaccogliComodino = new String[] {"vediamo cosa c'è qui...","ho trovato la chiave!",};
        String[] stringaUsaLetto = new String[] {"...","non ho molto sonno..."," ho dormito abbastanza  "};

        //utilizzo il json per caricare il font
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

        Interazione door = new Interazione(portaTexture,stringaOsservaPorta1,stringaUsaPorta1,reactionConfusedTexture,reactionNeutralTexture);
        door.setSize(13,22);
        door.setSize(9,17);



        Interazione comodino = new Interazione(stringaOsservaComodino1,comodinoTexture,reactionAngryTexture,reactionSurprisedTexture,stringaRaccogliComodino1);
        comodino.setSize(18,23);




        Interazione letto = new Interazione(lettoTexture,stringaOsservaLetto1,stringaUsaLetto1,reactionNeutralTexture,reactionHappyTexture);
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
