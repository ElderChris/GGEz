package schermate;

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
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Timer;
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
    Stage stage;
    OrthographicCamera camera;


    // È SOLO UNA DEMO, LE FUNZIONALITÀ ANDRANNO IMPLEMENTATE COME CLASSI DI ATTORI E GRUPPI PERSONALIZZATI OLTRE CHE I MENÙ SARANNO DI INPUT PROCESSOR,
    //Negli screen avvengono solo le sequenze scriptate della storia per ogni capitolo
    public Capitolo1(MyGdxGame partita,String nomegiocatore){
        this.partita=partita;

        stringaPorta="è una porta";
        stringaComodino="è un comodino";
        stringaLetto= "è un letto";

        final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        camera = new OrthographicCamera();
        camera.setToOrtho(false, MyGdxGame.larghezza, MyGdxGame.altezza);

        stage = new Stage(new StretchViewport(MyGdxGame.larghezza,MyGdxGame.altezza,camera));
        Gdx.input.setInputProcessor(stage);
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));



        Image sfondo = new Image(new Texture(Gdx.files.internal("sfondo.png")));
        sfondo.setHeight(Gdx.graphics.getHeight());
        sfondo.setWidth(Gdx.graphics.getWidth());
        sfondo.setTouchable(Touchable.enabled);


        final Image pgTest = new Image(new Texture(Gdx.files.internal("test.png")));
        final Image door = new Image(new Texture(Gdx.files.internal("door.png")));
        final Image comodino = new Image(new Texture(Gdx.files.internal("comodino.png")));
        final Image letto=new Image(new Texture(Gdx.files.internal("letto.png")));

        door.setName("Porta");
        door.setPosition(5,270);
        comodino.setName("Comodino");
        comodino.setPosition(460,170);
        letto.setName("Letto");
        letto.setPosition(800,300);

        final Group interazioni = new Group();

        interazioni.addActor(door);
        interazioni.addActor(comodino);
        interazioni.addActor(letto);

        //da fixare
        final Protagonista pg = new Protagonista("lollo");

        final Dialog dialog= new Dialog("Benvenuto "+nomegiocatore,mySkin2);
        final Dialog portaDialog= new Dialog(stringaPorta,mySkin2);
        final Dialog comodinoDialog = new Dialog(stringaComodino,mySkin2);
        final Dialog lettoDialog = new Dialog(stringaLetto,mySkin2);
        dialog.setBounds(100,100,100,100);

        Timer.schedule(new Timer.Task(){
            public void run(){
                dialog.hide();
            }

        },2);

        final TextButton usa = new TextButton("Usa",mySkin2);
        usa.setVisible(false);
        usa.setScale(30,30);
        final TextButton osserva = new TextButton("Osserva",mySkin2);
        osserva.setVisible(false);
        osserva.setScale(30,30);
        final  TextButton raccogli = new TextButton("Raccogli",mySkin2);
        raccogli.setVisible(false);



        interazioni.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {



                usa.setPosition(x,y);
                raccogli.setPosition(x+50,y+50);
                osserva.setPosition(x, y-100);

                    MoveToAction move = new MoveToAction();
                    move.setPosition(x-100, y-150);
                    move.setDuration(2f);
                    pgTest.addAction(move);

                  //  Vector2 coord = stage.screenToStageCoordinates(new Vector2(x, y))
                    Actor hit= interazioni.hit(x,y,false);

                    if (hit!=null){
                        switch (hit.getName()){
                            case "Porta":
                                usa.setVisible(true);
                                raccogli.setVisible(false);
                                osserva.setVisible(false);
                                portaDialog.show(stage);
                                Timer.schedule(new Timer.Task(){
                                    public void run(){
                                        portaDialog.hide();
                                    }
                                },2);
                                break;

                            case "Comodino":
                                raccogli.setVisible(true);
                                usa.setVisible(false);
                                osserva.setVisible(false);
                                comodinoDialog.show(stage);
                                Timer.schedule(new Timer.Task(){
                                    public void run(){
                                        comodinoDialog.hide();
                                    }
                                },2);

                                break;

                            case "Letto":
                                osserva.setVisible(true);
                                usa.setVisible(true);
                                raccogli.setVisible(false);
                                lettoDialog.show(stage);
                                Timer.schedule(new Timer.Task(){
                                    public void run(){
                                        lettoDialog.hide();
                                    }
                                },2);

                                break;

                        }
                    }





                return true;
            }
        });


        stage.addActor(sfondo);
        stage.addActor(interazioni);
        stage.addActor(pgTest);
        stage.addActor(usa);
        stage.addActor(raccogli);
        stage.addActor(osserva);
        stage.addActor(pg);
        dialog.show(stage);


    }

    public void show() {

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.6f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
