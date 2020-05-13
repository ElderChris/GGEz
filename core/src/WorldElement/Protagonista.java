package WorldElement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;


public class Protagonista extends Actor  {
    Texture texture;
    Sprite sprite;
    public String nomegiocatore;


    public void draw(Batch batch, float parentAlpha){
        batch.draw( sprite,getX(),getY());
    }

    public Protagonista(String nomegiocatore){
        texture= new Texture("test2.png");
        sprite = new Sprite((texture));


        setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());


        //protagonista si muove quando clicca su oggetti e personaggi

        //non ha senso, funziona solo quando clicci il protagonista
      this.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {


                    MoveToAction move = new MoveToAction();
                    move.setPosition(x, y);
                    move.setDuration(2f);
                    Protagonista.this.addAction(move);



                return true;
            }
        });



    }


    @Override
    public void act(float delta) {
        //non ha senso, da cancellare
        this.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {


                MoveToAction move = new MoveToAction();
                move.setPosition(x, y);
                move.setDuration(2f);
                Protagonista.this.addAction(move);



                return true;
            }
        });


    }
}
