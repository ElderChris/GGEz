package WorldElement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class InterazioniCap3 {

    //in questa classe vengono salvate le interazioni del capitolo 3, in modo tale che vengano caricate una volta e nello spostamento dei livelli i loro stati non vengano persi.

    //inizializzazione texture

   static Texture portaSinistraTexture = new Texture(Gdx.files.internal("hitboxPorta.png"));
   static Texture portaDestraTexture = new Texture(Gdx.files.internal("hitBoxPorta2F.png"));
   static Texture lianeHitbox = new Texture(Gdx.files.internal("hitboxLiane.png"));
   static Texture telecameraTexture = new Texture(Gdx.files.internal("hitboxTelecamera.png"));
    static Texture kermitTexture = new Texture(Gdx.files.internal("hitboxKermit.png"));
    static Texture robotTexture = new Texture(Gdx.files.internal("hitboxRobot.png"));

    static Texture portaBackTexture = new Texture(Gdx.files.internal("hitboxPorta.png"));
    static Texture macchinaTexture= new Texture(Gdx.files.internal("hitboxMacchina.png"));
    static Texture cestinoTexture = new Texture(Gdx.files.internal("hitboxCestino.png"));
    static Texture dottoreTexture = new Texture(Gdx.files.internal("gurghi.png"));
    static Texture computerTexture = new Texture(Gdx.files.internal("hitboxComputer.png"));
   static Texture patataTexture = new Texture(Gdx.files.internal("patataLabFix.png"));


   static Texture reactionParla = new Texture(Gdx.files.internal("confused_gurghi.png"));
   static Texture reactionParlaRisolto = new Texture(Gdx.files.internal("surprised_gurghi.png"));

    static Texture reactionSadTexture = new Texture(Gdx.files.internal("reactionSad.png"));
    static Texture reactionNeutralTexture = new Texture(Gdx.files.internal("reactionNeutral.png"));
    static Texture reactionScaredTexture = new Texture(Gdx.files.internal("reactionScared.png"));
    static Texture reactionSurprisedTexture = new Texture(Gdx.files.internal("reactionSurprised.png"));
    static Texture reactionHappyTexture = new Texture(Gdx.files.internal("reactionHappy.png"));
    static Texture reactionConfusedTexture = new Texture(Gdx.files.internal("reactionConfused.png"));

    static Texture potatoIcon = new Texture(Gdx.files.internal("potato.png"));
    static Texture liquidoIcon = new Texture(Gdx.files.internal("liquido.png"));
    static Texture bulloniIcon = new Texture(Gdx.files.internal("bulloni.png"));
    static Texture circuitiIcon = new Texture(Gdx.files.internal("circuits.png"));

    //inizializzazione stringhe per interazioni

    static String[] stringaOsservaPortaSinistra = new String[] {""};

    static String[] stringaUsaPortaSinistra = new String[] {""};


    static String[] stringaOsservaPortaDestra = new String[] {""};

    static String[] stringaUsaPortaDestra = new String[] {""};

    static String[] stringaOsservaTelecamera = new String[] {""};

    static String[] stringaOsservaLiane = new String[] {""};

    static String[] stringaOsservaKermit = new String[] {""};

    static String[] stringaRaccogliKermit = new String[] {""};

    static String[] stringaOsservaRobot = new String[] {""};

    static String[] stringaRaccogliRobot = new String[] {""};

    static String[] stringaOsservaPortaBack = new String[] {""};

    static String[] stringaUsaPortaBack = new String[] {""};

    static String[] stringaOsservaMacchina = new String[] {""};

    static String[] stringaUsaMacchina = new String[] {""};

    static String[] stringaOsservaCestino = new String[] {""};

    static String[] stringaRaccogliCestino = new String[] {""};

    static String[] stringaParla = new String[] {"uffa uffa uffa"};

    static String[] stringaParlaRisolto = new String[] {"hai l'oggetto che cercavo!"};

    static String[] stringaOsservaComputer = new String[] {""};

    //metto la faccia del dottore e gli faccio dire "hey non toccare il mio pc xdxd"
    static String[] stringaUsaComputer = new String[] {""};

    //pure qua metto la faccia del dottore
    static String[] stringaOsservaPatata = new String[] {""};

    static String[] stringaRaccogliPatata = new String[] {""};






    //creazione oggetti raccoglibili e settare l'idPuzzle in modo che il sistema riconosca gli elementi chiave per superare i capitoli

   private static Oggetto patata = new Oggetto(potatoIcon,"è una patata","X","potatoChip",false);
    private static Oggetto circuiti = new Oggetto(circuitiIcon,"circuiti","X","potatoChip",false);
    private static Oggetto liquido = new Oggetto(liquidoIcon,"emette una strana luce","X","chargedPotato",false);
    private static Oggetto bulloni = new Oggetto(bulloniIcon,"bulloni e pezzi di scarto","X","potatoOs",false);


    //creazione interazioni


            private static Interazione portaSx = new Interazione("",portaSinistraTexture,stringaOsservaPortaSinistra,stringaUsaPortaSinistra,reactionNeutralTexture,reactionScaredTexture);


             private static Interazione portaDx = new Interazione("travelPointLaboratory",portaDestraTexture,stringaOsservaPortaDestra,stringaUsaPortaDestra,reactionNeutralTexture,reactionNeutralTexture);


             private static Interazione telecamera = new Interazione(telecameraTexture,stringaOsservaTelecamera,reactionSurprisedTexture);

             private static Interazione liane = new Interazione(lianeHitbox,stringaOsservaLiane,reactionSurprisedTexture);

             private static Interazione kermit = new Interazione(stringaOsservaKermit,kermitTexture,reactionScaredTexture,reactionConfusedTexture,stringaRaccogliKermit,liquido);


             private static Interazione robot = new Interazione(stringaOsservaRobot,robotTexture,reactionConfusedTexture,reactionNeutralTexture,stringaRaccogliRobot,circuiti);


             private static Interazione portaBack = new Interazione("travelPointLaboratoryBack",portaBackTexture,stringaOsservaPortaBack,stringaUsaPortaBack,reactionNeutralTexture,reactionNeutralTexture);


             private static Interazione macchina = new Interazione("toChapter4",macchinaTexture,stringaOsservaMacchina,stringaUsaMacchina,reactionConfusedTexture,reactionNeutralTexture);


             private static Interazione cestino = new Interazione(stringaOsservaCestino,cestinoTexture,reactionNeutralTexture,reactionScaredTexture,stringaRaccogliCestino,bulloni);


             private static Interazione patataInterazione = new Interazione(patataTexture,reactionParla,reactionConfusedTexture,stringaOsservaPatata,stringaRaccogliPatata,patata);


             private static Interazione dottore = new Interazione(dottoreTexture,reactionParla,reactionParlaRisolto,stringaParla,stringaParlaRisolto);


             private  static Interazione computer = new Interazione(" ",computerTexture,stringaOsservaComputer,stringaUsaComputer,reactionSurprisedTexture,reactionParlaRisolto);


    //METODI GETTER


 public static Interazione getPortaSx() {
  return portaSx;
 }

 public static Interazione getPortaDx() {
  return portaDx;
 }

 public static Interazione getTelecamera() {
  return telecamera;
 }

 public static Interazione getLiane(){
  return  liane;
 }

 public static Interazione getKermit() {
  return kermit;
 }

 public static Interazione getRobot() {
  return robot;
 }

 public static Interazione getPortaBack() {
  return portaBack;
 }

 public static Interazione getMacchina() {
  return macchina;
 }

 public static Interazione getCestino() {
  return cestino;
 }

 public static Interazione getPatataInterazione() {
  return patataInterazione;
 }

 public static Interazione getDottore() {
  return dottore;
 }

 public static Interazione getComputer() {
  return computer;
 }
}
