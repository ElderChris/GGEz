package Azioni;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import schermate.Capitolo1;

//creare bottoni che si attiveranno ad ogni attore cliccato, saranno tutti in un group
public class Menu extends Group  implements InputProcessor {
  public   Stage stage;
    String string;
    Group menu;

    public Menu(){

        stage = new Stage();


        Image box = new Image(new Texture(Gdx.files.internal("box.png")));

        Image inventarioButton = new Image(new Texture(Gdx.files.internal("inventario.png")));

        Image osservaButton = new Image(new Texture(Gdx.files.internal("osserva.png")));

        Image raccogliButton = new Image(new Texture(Gdx.files.internal("raccogli.png")));

        Image usaButton = new Image(new Texture(Gdx.files.internal("usa.png")));

        Image combinaButton = new Image(new Texture(Gdx.files.internal("combina.png")));

        menu = new Group();


        menu.addActor(box);
        menu.addActor(inventarioButton);
        menu.addActor(osservaButton);
        menu.addActor(raccogliButton);
        menu.addActor(usaButton);
        menu.addActor(combinaButton);

        box.setPosition(15,1);
        inventarioButton.setPosition(500,90);
        osservaButton.setPosition(800,140);
        raccogliButton.setPosition(800,90);
        usaButton.setPosition(800,30);
        combinaButton.setPosition(3,30);


        stage.addActor(menu);

        //funzionamento del menù: clicci un oggetto interaggibile, viene evidenziato,vengono lette le informazioni dell'oggetto, viene mostrato il menù con i bottoni giusti


    }


    @Override
    public void draw(Batch batch, float parentAlpha) {

        stage.draw();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public boolean keyDown(int keycode) {
        return false;
    }

    public boolean keyUp(int keycode) {
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {


        return false;
    }

    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}
