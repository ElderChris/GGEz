package WorldElement;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

public class Oggetto extends Image {

public Texture icon;
public String descrizione;
public boolean combinabile;

    public Oggetto(Texture icon, String descrizione,boolean combinabile) {
        super(icon);
        this.descrizione=descrizione;
        this.combinabile=combinabile;
        setBounds(getX(),getY(),getWidth(),getHeight());
    }




    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        ((TextureRegionDrawable)getDrawable()).draw(batch,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight()
                ,getScaleX(),getScaleY(),getRotation());
    }


    //GETTER AND SETTER
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isCombinabile() {
        return combinabile;
    }

    public void setCombinabile(boolean combinabile) {
        this.combinabile = combinabile;
    }
}
