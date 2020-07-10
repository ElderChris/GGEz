package WorldElement;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;



import static schermate.Capitolo1.nomegiocatore;



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

    static String[] stringaOsservaPortaSinistra = new String[] {"È la porta da cui sono entrato..",
                                                                 "Questo deve essere il laboratorio\n"+
                                                                  "del famoso professore..",
                                                                   "spero tanto non si arrabbi...",
                                                                    "giuro che l'ho trovata aperta"};

    static String[] stringaUsaPortaSinistra = new String[] {"Dopo tutta la strada che ho fatto\n"+
                                                              "col cavolo che torno \n in quel postaccio...",
                                                           "non mi sono mai piaciuti i boschi"};


    static String[] stringaOsservaPortaDestra = new String[] {"Sento degli strani rumori...",
                                                              "cosa starà combinando?"};

    static String[] stringaUsaPortaDestra = new String[] {"*hai aperto la porta*"};

    static String[] stringaOsservaTelecamera = new String[] {"odio essere osservato...",
                                                             "mi ricorda i tempi nell'orfanotrofio...",
                                                               "mi domando come se la passi \n"+"" +
                                                                       "quel vecchio che si prendeva \n cura di me..",
                                                                    "mi manca molto"};

    static String[] stringaOsservaLiane = new String[] {"questo posto cade a pezzi...",
                                                       "inoltre sembra sia abbandonato..." ,
                                                               "siamo sicuri quel bambino non \n"+
                                                               "mi abbia preso in giro?"};

    static String[] stringaOsservaKermit = new String[] {"....",
                                                         " mi sembra così familiare...","ASPETTA, AMICO MIO \nCHE CI FAI QUI...","troverò un modo \n per liberarti!"};

    static String[] stringaRaccogliKermit = new String[] {"sembra stia perdendo acqua...",
                                                           "non è molta ma piano piano \n"+ "potrei riuscire a liberarti \n amico mio!","*hai raccolto liquido strano*"};

    static String[] stringaOsservaRobot = new String[] {"ho sempre desiderato un robot \n giocattolo...","da piccolo ci smanettavo molto\n che fascino!...","questo sembra abbastanza \n complesso...",
                                                       "non si arrabbierà nessuno \n se lo tocco un attimo\n vero? "};

    static String[] stringaRaccogliRobot = new String[] {"*hai raccolto circuiti*"};

    static String[] stringaOsservaPortaBack = new String[] {"posso usarla per tornare \n" +
                                                            " nella stanza di prima"};

    static String[] stringaUsaPortaBack = new String[] {"*hai aperto la porta*"};

    static String[] stringaOsservaMacchina = new String[] {"sembra una specie di teletrasporto...","mi ricorda quei film di fantascienza\n che guardavo con mia madre... ",
                                                           "spero ti tornare a casa \nil prima possibile"};

    static String[] stringaUsaMacchina = new String[] {"Mi dispiace ma non funzionerà...\n non finchè non trovo il \n pezzo di ricambio"};

    static String[] stringaOsservaCestino = new String[] {"(almeno questa stanza riesce \n a mantenerla ordinata... )",
                                                             "(non si rende proprio conto \n della vegetazione \n nell'altra stanza...)","(magari ha buttato \n qualcosa di interessante)"};

    static String[] stringaRaccogliCestino = new String[] {"(non ne è valsa assolutamente\n la pena)","*hai raccolto pezzi di scarto*"};

    static String[] stringaParla = new String[] {"Oh rabbia....Oh rabbia....\n pensa...pensa...pensa\n dove diavolo è finito il pezzo  \n di ricambio?...",
                                                 ".....","hey tu!\n finalmente sei arrivato!\n ti stavo aspettando sai...","sei " +nomegiocatore + " giusto?",
                                                 "ascoltami bene "+nomegiocatore + "\n Ciò che sta accadendo è terribile! ..",
                                                     "Devi tornare subito a casa \n o le conseguenze saranno disastrose! .."," quella che vedi alla mia sinistra \n è una macchina dei sogni...",
                                               "ti consentirà di tornare a casa, \n ma c'è un problema! ..","è tutta la giornata che \n non riesco a trovare il motore \n per accenderla!",
                                                "oh rabbia oh rabbia...\n dobbiamo sbrigarci...","....."};

    static String[] stringaParlaRisolto = new String[] {"....."," ragazzo mio..."+nomegiocatore +" ... \n sono senza parole!",
                                                      "ma come hai fatto!!! \n questo è esattamente quello \nche cercavo! ","aspetta...non dirmi che \n te lo sei costrui...\n ..no ma che sto dicendo",
                                                       "dammi un secondino...","FATTO! la macchina dei sogni è pronta!",
                                                     "bene "+nomegiocatore+ "\n la buona notizia è che adesso\n potrai tornare a casa! ", "forza, non c'è tempo da perdere\n salta nel portale!",
                                                     "ti auguro buon viaggio \n e sono sicuro che ci rivedremo", " . . . . ."};

    static String[] stringaOsservaComputer = new String[] {"(sullo schermo c'è scritto: ...)"," (Come costruire un motore di ricambio\n utilizzando una patata...)"," mmh...."};

    //metto la faccia del dottore e gli faccio dire "hey non toccare il mio pc xdxd"
    static String[] stringaUsaComputer = new String[] {"Ragazzo...non ti ha insegnato nessuno\n le buone maniere?", "Non toccare la mia roba!"};

    //pure qua metto la faccia del dottore
    static String[] stringaOsservaPatata = new String[] {"ah quella?\n doveva essere la mia cena...\n ma non ho molta fame...","se vuoi puoi prenderla",". . . ."};

    static String[] stringaRaccogliPatata = new String[] {"(e adesso che ci faccio \n con una patata?)","*Hai raccolto la patata*"};






    //creazione oggetti raccoglibili e settare l'idPuzzle in modo che il sistema riconosca gli elementi chiave per superare i capitoli

   private static Oggetto patata = new Oggetto(potatoIcon,"è una patata","X","potatoChip",false);
    private static Oggetto circuiti = new Oggetto(circuitiIcon,"circuiti","X","potatoChip",false);
    private static Oggetto liquido = new Oggetto(liquidoIcon,"emette una strana luce","X","chargedPotato",false);
    private static Oggetto bulloni = new Oggetto(bulloniIcon,"bulloni e pezzi di scarto","X","potatoOs",false);


    //creazione interazioni


            private static Interazione portaSx = new Interazione("",portaSinistraTexture,stringaOsservaPortaSinistra,stringaUsaPortaSinistra,reactionNeutralTexture,reactionScaredTexture);


             private static Interazione portaDx = new Interazione("travelPointLaboratory",portaDestraTexture,stringaOsservaPortaDestra,stringaUsaPortaDestra,reactionNeutralTexture,reactionNeutralTexture);


             private static Interazione telecamera = new Interazione(telecameraTexture,stringaOsservaTelecamera,reactionSadTexture);

             private static Interazione liane = new Interazione(lianeHitbox,stringaOsservaLiane,reactionSurprisedTexture);

             private static Interazione kermit = new Interazione(stringaOsservaKermit,kermitTexture,reactionScaredTexture,reactionConfusedTexture,stringaRaccogliKermit,liquido);


             private static Interazione robot = new Interazione(stringaOsservaRobot,robotTexture,reactionSurprisedTexture,reactionNeutralTexture,stringaRaccogliRobot,circuiti);


             private static Interazione portaBack = new Interazione("travelPointLaboratoryBack",portaBackTexture,stringaOsservaPortaBack,stringaUsaPortaBack,reactionNeutralTexture,reactionNeutralTexture);


             private static Interazione macchina = new Interazione("toChapter4",macchinaTexture,stringaOsservaMacchina,stringaUsaMacchina,reactionSadTexture,reactionParla);


             private static Interazione cestino = new Interazione(stringaOsservaCestino,cestinoTexture,reactionConfusedTexture,reactionScaredTexture,stringaRaccogliCestino,bulloni);


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
