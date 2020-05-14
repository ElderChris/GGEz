package schermate;

import WorldElement.Protagonista;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;


/*DA FARE:
           -Input, output su schermo di stringhe (per dialoghi e interazioni)
           -Utilizzare sistema di stage
           -interazioni con click del mouse su texture (metodo generale per ogni oggetto che è composto da anche dalle dimensioni in pixel)
           -movimento immagini
            opzioni di azione
           -sistema di cutscene
*/

public class Schermata implements Screen {
    public SpriteBatch batch;
    public Texture img;
    public Texture texture1;
    public TextButton prova;
    public String stringa,nomegiocatore="James";
    int x;
    Sprite png;
    MyGdxGame partita;
    BitmapFont font;
    Stage stage;
   public SchermataIniziale schermatainiziale;

    //vedi se puoi aggiustare la gui manualmente con qualche editor
    public Schermata(MyGdxGame partita ,String nomegiocatore){
        this.partita=partita;

        Skin mySkin = new Skin(Gdx.files.internal("skin/arcade-ui.json"));
        Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        stage = new Stage(new ScreenViewport());
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));
       final Protagonista pg = new Protagonista("pippo");


        Gdx.input.setInputProcessor(stage);

        final Dialog dialog= new Dialog("Benvenutooooo "+nomegiocatore,mySkin2);
        dialog.show(stage);
        Timer.schedule(new Timer.Task(){
            public void run(){
                dialog.hide();
            }

        },2);


        stage.addListener(new InputListener(){
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){

                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
                    MoveToAction move = new MoveToAction();
                    move.setPosition(x, y);
                    move.setDuration(2f);
                    pg.addAction(move);

                }




                return true;
            }

        });


        Group gruppo = new Group(); //contiene gli oggetti della scena, da trasferire tutto in Capitolo1.Java
        stage.addActor(dialog);
        stage.addActor(pg);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.6f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            stage.act();


            stage.draw();


     //   partita.batch.begin();
        //mette su schermo l'immagine oggetto img, da impostare cordinate
       // partita.batch.draw(img, x, 0);
       // partita.batch.end();

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
}
