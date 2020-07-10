package WorldElement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import static schermate.Capitolo1.nomegiocatore;

public class InterazioniCap2 {
//in questa classe vengono salvate le interazioni del capitolo 2, in modo tale che vengano caricate una volta e nello spostamento dei livelli i loro stati non vengano persi.


    //inizializzazione texture

    Image sfondo = new Image(new Texture(Gdx.files.internal("foresta1_base.png")));

    static Texture portaTexture = new Texture(Gdx.files.internal("portaF.png"));
    static Texture cartelloDx = new Texture(Gdx.files.internal("cartellodxFix.png"));
    static Texture cartelloSx = new Texture(Gdx.files.internal("cartellosxFix.png"));

    static Texture sandbox = new Texture(Gdx.files.internal("sabbiaFix.png"));
    static Texture lume = new Texture(Gdx.files.internal("lume.png"));
    static Texture texturepuntoDiLuce = new Texture(Gdx.files.internal("travelPoint.png"));
    static Texture bimbo = new Texture(Gdx.files.internal("bambino.png"));

    static Texture reactionParla= new Texture(Gdx.files.internal("bambinoSad.png"));
    static Texture reactionParlaRisolto= new Texture(Gdx.files.internal("bambinoHappy.png"));

    static Texture alberoHitbox = new Texture(Gdx.files.internal("hitboxAlbero.png"));
    static Texture palloneHitbox = new Texture(Gdx.files.internal("ballFix2.png"));
    static Texture rocceHitbox = new Texture(Gdx.files.internal("hitboxRocce.png"));
    static Texture cartello = new Texture(Gdx.files.internal("cartelloFix.png"));
    static Texture cartelloBackTexture = new Texture(Gdx.files.internal("cartelloBack.png"));



    static Texture reactionSadTexture = new Texture(Gdx.files.internal("reactionSad.png"));
    static Texture reactionNeutralTexture = new Texture(Gdx.files.internal("reactionNeutral.png"));
    static Texture reactionScaredTexture = new Texture(Gdx.files.internal("reactionScared.png"));
    static Texture reactionSurprisedTexture = new Texture(Gdx.files.internal("reactionSurprised.png"));
    static Texture reactionHappyTexture = new Texture(Gdx.files.internal("reactionHappy.png"));
    static Texture reactionConfusedTexture = new Texture(Gdx.files.internal("reactionConfused.png"));

    static Texture rockIcon = new Texture(Gdx.files.internal("rock.png"));
    static Texture pallaIcon = new Texture(Gdx.files.internal("iconaPalla.png"));
    static  Texture fiondaicon= new Texture(Gdx.files.internal("slingshot.png"));




    //inizializzazione stringhe per interazioni

    static String[] stringaUsaSentiero = new String[]{""};

    static String[] stringaOsservaPorta = new String[] {"Una porta nel bel mezzo della\n" +
            "foresta? Strano",

            "Sembra quasi di essere in un sogno",
    };

    static String[] stringaUsaPorta= new String[] {"In teoria quella porta (lol) porta\n" +
            "alla stanza in ospedale",

            "Non ho molta nostalgia di quella\n" +
                    "stanza in realtà",
    };

    static String[] stringaOsservaCartelloDx= new String[] {"'Per me si va ne la città dolente'",

            "Non proprio rassicurante"
    };


    static String[] stringaOsservaCartelloSx= new String[] {"'per me si va ne l'etterno dolore'",

            "Ok, penso che abbiano capito tutti\n" +
                    "la citazione"

    };


    static String[] stringaOsservaSandbox= new String[] {"Sembra uno di quei box\n" +
            "con la sabbia dove giocano\n" +
            "i bambini",

            "Molto americana come cosa",

            "Magari qualche bambino ha\n" +
                    "lasciato qualcosa di utile"
    };


    static String[] stringaRaccogliSandbox= new String[] {"Guarda un po', non mi \n sbagliavo",
            "La prendo, puo' sempre servire\n" +
                    "un'arma"
    };


    static String[] stringaOsservaLume= new String[] {"Quel fiore somiglia a quello\n" +
            "di una favola che mi raccontarono\n" +
            "da piccolo",

            "Si dice che avveri il tuo\n" +
                    "desiderio più profondo"
    };


    static String[] stringaUsaLume= new String[] {"Purtroppo è troppo in alto\n" +
            "e troppo intricato nelle frasche",

            "quindi dovro continuare a studiare\n" +
                    "per potermi laureare"
    };


    static String[] stringaParlaBimbo= new String[] {"*Sigh....Sigh" ,

            "Ho lanciato troppo in lontano\n" +
                    "il pallone",

            "Chissà dove sarà finito"
    };

    static String[] stringaParlaPuzzleRisolto= new String[] {"Hai ritrovato la mia palla!!!\n" +
            "Come ti chiami?",

            "Oh "+nomegiocatore+ " !" +" Che bel nome!\n" +
                    "Ti ringrazio per avermi aiutato",

            "Dovresti andare al laboratorio\n" +
                    "del professore lui sa sempre cosa\n" +
                    "fare con i 'forestieri' come te"

    };

    static String[] stringaOsservaSentiero = new String[] {"La strada sembra continuare da qui!",

            "In ogni caso se volessi proseguire\n" +
                    "dovrei USARE di più e OSSERVARE\n" +
                    "di meno"
    };



    static String[] stringaOsservaAlbero = new String[] {"Beh, che dire, gran bell'albero!"};

    static String[] stringaOsservaPallone = new String[] {"Hey ma c'è un pallone lì!",

            "Quel bambino ha fatto un\n" +
                    "lancio bello forte",

            "Devo trovare il modo di\n" +
                    "recuperarlo"
    };

    static String[] stringaOsservaCartello = new String[] {"Sembrerebbe indicare un sentiero",
            "Chissà dove porta...\n"
            };

    static String[] stringaUsaCartello = new String[] {"Non posso andarmene \n senza prima aver aiutato \n quel bambino...", "potrebbe darmi qualche \n informazione utile"};

    static String[] stringaOsservaCartelloBack = new String[] {"Proseguendo da qui \n si torna indietro"};

    static String[] stringaUsaCartelloBack = new String[] {""};

    static String[] stringaOsservaRocce = new String[] {"Un cumulo di rocce...",

            "Magari mi potrei portare\n" +
                    "a casa un souvenir",

            "Ammesso che riesca a tornarci",
    };

    static String[] stringaRaccogliRocce = new String[] {"Sarà divertente poter dire:\n" +
            "'Hey! questa roccia l'ho presa\n" +
            "da un posto sconosciuto in cui\n" +
            "mi sono svegliato una volta'"
    };

    static String[] stringaRaccogliPallone = new String[] {"È troppo in alto!",

            "Sarà meglio trovare un modo per\n" +
                    "farlo cadere\n"

    };





    //creazione oggetti raccoglibili e settare l'idPuzzle in modo che il sistema riconosca gli elementi chiave per superare i capitoli

    private static Oggetto fiondaScarica = new Oggetto(fiondaicon,"fionda","X","fiondaCarica",false);

    private static Oggetto roccia = new Oggetto(rockIcon,"roccia","X","fiondaCarica",false);
    private static Oggetto pallone = new Oggetto(pallaIcon,"un classico pallone da calcio","pallone","X",false);


    //creazione interazioni


    private static Interazione porta = new Interazione("porta",portaTexture,stringaOsservaPorta,stringaUsaPorta,reactionSurprisedTexture,reactionNeutralTexture);


    private static Interazione cartelloDestro= new Interazione(cartelloDx,stringaOsservaCartelloDx,reactionNeutralTexture);


    private static  Interazione cartelloSinistro = new Interazione(cartelloSx,stringaOsservaCartelloSx,reactionScaredTexture);


    private static Interazione sabbia = new Interazione(stringaOsservaSandbox,sandbox,reactionNeutralTexture,reactionSurprisedTexture,stringaRaccogliSandbox,fiondaScarica);

    private static Interazione fiore = new Interazione("luce",lume,stringaOsservaLume,stringaUsaLume,reactionHappyTexture,reactionSadTexture);


    private static   Interazione puntoLuce = new Interazione("travelPointForest",texturepuntoDiLuce,stringaOsservaSentiero,stringaUsaSentiero,reactionScaredTexture,reactionNeutralTexture);


    private static Interazione bambino = new Interazione(bimbo,reactionParla,reactionParlaRisolto,stringaParlaBimbo,stringaParlaPuzzleRisolto);

    private static Interazione alberoGigante = new Interazione(alberoHitbox,stringaOsservaAlbero,reactionSurprisedTexture);

    private static Interazione cartelloTravel = new Interazione("toChapter3",cartello,stringaOsservaCartello,stringaUsaCartello,reactionNeutralTexture,reactionSadTexture);

    private static Interazione cartelloBack = new Interazione("travelPointForestBack",cartelloBackTexture,stringaOsservaCartelloBack,stringaUsaCartelloBack,reactionNeutralTexture,reactionNeutralTexture);

   private static Interazione palloneIncastrato = new Interazione(palloneHitbox,reactionSurprisedTexture,reactionSurprisedTexture,stringaOsservaPallone,stringaRaccogliPallone,pallone);



   private static Interazione cumuloRocce = new Interazione(stringaOsservaRocce,rocceHitbox,reactionNeutralTexture,reactionConfusedTexture,stringaRaccogliRocce,roccia);



   //METODI GETTER



    public static Interazione getPorta() {
        return porta;
    }

    public static Interazione getCartelloDestro() {
        return cartelloDestro;
    }

    public static Interazione getCartelloSinistro() {
        return cartelloSinistro;
    }

    public static Interazione getSabbia() {
        return sabbia;
    }

    public static Interazione getFiore() {
        return fiore;
    }

    public static Interazione getPuntoLuce() {
        return puntoLuce;
    }

    public static Interazione getBambino() {
        return bambino;
    }

    public static Interazione getAlberoGigante() {
        return alberoGigante;
    }

    public static Interazione getCartelloTravel() {
        return cartelloTravel;
    }

    public static Interazione getCartelloBack() {
        return cartelloBack;
    }

    public static Interazione getPalloneIncastrato() {
        return palloneIncastrato;
    }

    public static Interazione getCumuloRocce() {
        return cumuloRocce;
    }
}
