package schermate;

import WorldElement.Protagonista;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;

public class SchermataIniziale implements Screen {

  //  public static final String FONT_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";

    //inizializzi le texture da assegnare allo schermo
    Texture texture1;
    Texture playButton;
    SpriteBatch batch;
    TextListener listener = new TextListener();
    BitmapFont font;
    public String nomegiocatore="";
    MyGdxGame partita;
    TextButton start;
    Sprite lmao;
    Sprite bottone;
    Stage stage;
    TextField spaziotesto;
    OrthographicCamera camera;

    //usare il Table e mettere in ordine gli elementi della GUI
    public SchermataIniziale(final MyGdxGame partita){
        this.partita=partita;
        //assegni le texture alle immagini
        //da mettere immagini nella cartella core/assets
        playButton = new Texture("play.png");




        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
        //creo il "palcoscenico" grande quanto tutto lo schermo

        camera = new OrthographicCamera();
        camera.setToOrtho(false, MyGdxGame.larghezza, MyGdxGame.altezza);

       // ScreenViewport view=new();
        stage = new Stage(new StretchViewport(MyGdxGame.larghezza,MyGdxGame.altezza,camera));
        //lo imposto come gestore di input (per far cliccare bottoni eccetera)
        Gdx.input.setInputProcessor(stage);

        Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        spaziotesto= new TextField(nomegiocatore,mySkin2);
        spaziotesto.setPosition(500,200);
        spaziotesto.setBounds(50,50,400,50);

        TextButton textButton = new TextButton("GIOCA",mySkin2);
        textButton.setPosition(500,500);

        Label label = new Label("Inserisci il nome giocatore",mySkin2);
        label.setPosition(50,250);


        textButton.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y,int pointer,int button){


                nomegiocatore= spaziotesto.getText();
                if(nomegiocatore.isEmpty())
                    nomegiocatore="James";
                partita.setScreen(new Capitolo1(partita,nomegiocatore));
                stage.dispose();



                return true;
            }

        });



        stage.addActor(textButton);
        stage.addActor(spaziotesto);
        stage.addActor(label);





    }
    public void show() {

    }

    @Override
    public void render(float delta) {
        //mette il colore dello sfondo
        Gdx.gl.glClearColor(0.2f,0.2f,0.3f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        //LA PARTE DI SOTTO NON LA USEREMO PERCHÈ LO FA GIà  lo stage
        //inizia a visualizzare texture immagini eccetera
   /*     partita.batch.begin();


        partita.batch.draw(lmao, lmao.getX(),lmao.getY(),200,200);
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            this.dispose();
            partita.setScreen(new Schermata(partita));
        }
        //oggetto per l'utilizzo di font personalizzati
        GlyphLayout fontLayout = new GlyphLayout(font,"LMAOO");
        font.draw(partita.batch,fontLayout,Gdx.graphics.getWidth()/2-fontLayout.width/2,Gdx.graphics.getHeight()-fontLayout.height-40);

        partita.batch.end();
    */
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    stage.dispose();
    this.dispose();
    }

    public String getStringa(){
        return this.nomegiocatore;
    }

    public void setStringa(String stringa){
        this.nomegiocatore=stringa;
    }
}
