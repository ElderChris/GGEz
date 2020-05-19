package WorldElement;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

//ogni oggetto ha un costruttore diverso che assegna texture e stringhe, vedere bene la documentazione per gli attori / Image
public class Oggetti extends Actor { //meglio extends Actor oppure Image?

    //da rendere privati?
    public Texture texture;
    public Sprite sprite;
    public String stringaOsserva;
    public String descrizioneInventario;
    public String stringaUsa;
    public String stringaRaccogli;
    public boolean combinabile;
    public boolean usabile;
    public boolean raccoglibileContenitore; //da usare per gli oggetti come armadi,comodini che per esempio contengono altri oggetti
    public boolean raccoglibile; //da usare per gli oggetti che possono essere presi e rimossi dalla scena
    public Texture reactionFace;



    public Oggetti(Texture texture,String stringaOsserva,String stringaUsa, String stringaRaccogli,String descrizioneInventario,boolean combinabile, boolean usabile, boolean raccoglibileContenitore, boolean raccoglibile) {
        this.texture=texture;
        this.stringaOsserva=stringaOsserva;
        this.descrizioneInventario=descrizioneInventario;
        this.stringaUsa=stringaUsa;
        this.stringaRaccogli=stringaRaccogli;
        this.combinabile=combinabile;
        this.usabile=usabile;
        this.raccoglibileContenitore=raccoglibileContenitore;
        this.raccoglibile=raccoglibile;

    }

    //fare classe che costruisce gli oggetti e scenari con le loro texture e caratteristiche


    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
