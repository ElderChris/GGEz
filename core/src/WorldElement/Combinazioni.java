package WorldElement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


public class Combinazioni {
    public static boolean giaRaccoltoChapter2 = false;
    public static boolean giaRaccoltoChapter3 = false;


    //oggetto per testing
    private static Texture icon = new Texture(Gdx.files.internal("test.png"));
    public static Oggetto prova = new Oggetto(icon, "prova", "X", "X", false);

    //Oggetti frutti di combinazioni
    private static Texture fiondaIcon = new Texture(Gdx.files.internal("fionda.png"));
    public static Oggetto fiondaCarica = new Oggetto(fiondaIcon,"fionda caricata","fiondaCarica","X",false);

    private static Texture potatoChipIcon = new Texture(Gdx.files.internal("potatoChip.png"));
    public static Oggetto potatoChip = new Oggetto(potatoChipIcon,"un abominio della scienza","X","potatoOs",false);

    private static Texture potatoOsIcon = new Texture(Gdx.files.internal("potatOs.png"));
    public static  Oggetto potatoOs = new Oggetto(potatoOsIcon,"cosa sto facendo...","X","chargedPotato",false);

    private static Texture potatoCaricaIcon = new Texture(Gdx.files.internal("potatoCarica.png"));
    public static Oggetto potatoCarica = new Oggetto(potatoCaricaIcon,"sembra abbia una volontà propria...funzionerà?","sogno","X",false);


    //Oggetti speciali: usati solo per lo spostamento ai livelli capitoli successivi
    public static Oggetto perCapitolo3 = new Oggetto(icon,"Per accedere al capitolo 3","toChapter3","X",false);
    public static Oggetto perCapitolo4 = new Oggetto(icon,"per accedere alla schermata finale","toChapter4","X",false);

}
