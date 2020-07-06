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


public class Combinazioni {
    public static boolean giaRaccoltoChapter2 = false;
    public static boolean giaRaccoltoChapter3 = false;



    public static Texture icon = new Texture(Gdx.files.internal("test.png"));
    public static Oggetto prova = new Oggetto(icon, "prova", "X", "X", false);

    public static Texture fiondaIcon = new Texture(Gdx.files.internal("fionda.png"));
    public static Oggetto fiondaCarica = new Oggetto(fiondaIcon,"fionda caricata","fiondaCarica","X",false);



    //Oggetti speciali: usati solo per lo spostamento ai livelli capitoli successivi
    public static Oggetto perCapitolo3 = new Oggetto(icon,"Per accedere al capitolo 3","toChapter3","X",false);
    public static Oggetto perCapitolo4 = new Oggetto(icon,"per accedere alla schermata finale","toChapter4","X",false);

}
