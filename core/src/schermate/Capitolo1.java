package schermate;

import Azioni.Menu;
import WorldElement.Protagonista;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
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
    public String stringaPorta,stringaComodino,stringaLetto;
    Sprite png;
    BitmapFont font;
  public Stage stage;
    OrthographicCamera camera;

    final float WORLD_WIDTH = 100;
    final float WORLD_HEIGHT = 75;


    // È SOLO UNA DEMO, LE FUNZIONALITÀ ANDRANNO IMPLEMENTATE COME CLASSI DI ATTORI E GRUPPI PERSONALIZZATI OLTRE CHE I MENÙ SARANNO DI INPUT PROCESSOR,
    //Negli screen avvengono solo le sequenze scriptate della storia per ogni capitolo

    //cose da fare 1) cambiare mySKin come nel video
    //                creare il Group menù e il Group Scene (ogni livello ha una scena) in Capitolo1 c'è solo enigma e cutscene
    //                menù con inventario, e azioni
    //                le azioni del menù devono essere più generali possibile quindi si applicano su qualsiasi oggetto
    public Capitolo1(MyGdxGame partita,String nomegiocatore){
        this.partita=partita;

        stringaPorta="è una porta";
        stringaComodino="è un comodino";
        stringaLetto= "è un letto";

        final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        final float aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();

        camera = new OrthographicCamera(25*aspectRatio,25);
        camera.setToOrtho(false, WORLD_WIDTH/2, WORLD_HEIGHT/2);

        stage = new Stage(new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera));
        Gdx.input.setInputProcessor(stage);
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));



        Image sfondo = new Image(new Texture(Gdx.files.internal("sfondo.png")));
        sfondo.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        sfondo.setTouchable(Touchable.enabled);


        final Image pgTest = new Image(new Texture(Gdx.files.internal("test.png")));
        pgTest.setSize(13,18);

        final Image door = new Image(new Texture(Gdx.files.internal("door.png")));
        door.setSize(13,22);
        //door.setBounds(); //provare a usare il setBounds al posto del SetSize
        final Image comodino = new Image(new Texture(Gdx.files.internal("comodino.png")));
        comodino.setSize(11,14);
        final Image letto=new Image(new Texture(Gdx.files.internal("letto.png")));
        letto.setSize(23,10);

        door.setPosition(3,20);

        comodino.setPosition(43,23);

        letto.setPosition(66,10);

        pgTest.setPosition(30,30);
        pgTest.setTouchable(Touchable.disabled);

        final Group interazioni = new Group();

        interazioni.addActor(door);
        interazioni.addActor(comodino);
        interazioni.addActor(letto);
        interazioni.addActor(pgTest);

        //da fixare
        final Protagonista pg = new Protagonista("lollo");
        pg.setSize(1,1);

   //     final Dialog dialog= new Dialog("Benvenuto "+nomegiocatore,mySkin2);
   //     dialog.setSize(3,3);
        final Dialog portaDialog= new Dialog(stringaPorta,mySkin2);
        portaDialog.setSize(3,3);
        final Dialog comodinoDialog = new Dialog(stringaComodino,mySkin2);
        comodinoDialog.setSize(3,3);
        final Dialog lettoDialog = new Dialog(stringaLetto,mySkin2);
        lettoDialog.setSize(3,3);

        Timer.schedule(new Timer.Task(){
            public void run(){
    //            dialog.hide();
            }

        },2);

  /*      final TextButton usa = new TextButton("Usa",mySkin2);
        usa.setVisible(false);
        usa.setScale(3,3);
        final TextButton osserva = new TextButton("Osserva",mySkin2);
        osserva.setVisible(false);
        osserva.setScale(3,3);
        final  TextButton raccogli = new TextButton("Raccogli",mySkin2);
        raccogli.setVisible(false);
  */


        interazioni.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                Gdx.app.log("Mouse Event","Click at " + x + "," + y);
                Vector3 worldCoordinates = camera.unproject(new Vector3(x,y,0));
                Gdx.app.log("Mouse Event","Projected at " + worldCoordinates.x + "," + worldCoordinates.y);

              //  usa.setPosition(worldCoordinates.x,worldCoordinates.y);
               // raccogli.setPosition(x+50,y+50);
               // osserva.setPosition(x, y-100);



                    MoveToAction move = new MoveToAction();
                    move.setPosition(x,y);
                    move.setDuration(2f);
                    pgTest.addAction(move);

                  //  Vector2 coord = stage.screenToStageCoordinates(new Vector2(x, y))
                    Actor hit= interazioni.hit(x,y,false);

                    if (hit!=null){
                        Gdx.app.log("Mouse Event","Click at " + x + "," + y);
                    }





                return true;
            }
        });

        Menu menu = new Menu();


        stage.addActor(sfondo);

        stage.addActor(interazioni);
      //  stage.addActor(pgTest);


        stage.addActor(menu); //perchè il protagonista scompare?

     //   stage.addActor(usa);
     //   stage.addActor(raccogli);
     //   stage.addActor(osserva);


      //  dialog.show(stage);


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
