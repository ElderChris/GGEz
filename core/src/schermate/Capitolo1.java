package schermate;

import Azioni.Puzzle;
import Azioni.Menu;
import WorldElement.Interazione;
import WorldElement.Oggetto;
import WorldElement.Protagonista;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.MyGdxGame;

public class Capitolo1 implements Screen {


    public String nomegiocatore="James";
    MyGdxGame partita;
    public SpriteBatch batch;
    public Texture img;
    public Texture texture1;
    public TextButton prova;


    BitmapFont font;
  public Stage stage;
    OrthographicCamera camera;
    InputMultiplexer multiplexer;

    final float WORLD_WIDTH = 100;
    final float WORLD_HEIGHT = 75;




    public Capitolo1(final MyGdxGame partita, final String nomegiocatore){
        this.partita=partita;

        //inizializzazione texture

        Image sfondo = new Image(new Texture(Gdx.files.internal("camera_ospedale.png")));

        Texture portaTexture = new Texture(Gdx.files.internal("door.png"));
        Texture comodinoTexture = new Texture(Gdx.files.internal("kermit.png"));
        Texture lettoTexture = new Texture(Gdx.files.internal("letto.png"));
        Texture orologioTexture = new Texture(Gdx.files.internal("orologio.png"));
        Texture finestraTexture = new Texture(Gdx.files.internal("finestra.png"));
        Texture cartellinaTexture = new Texture(Gdx.files.internal("cartellina.png"));

        Texture reactionSadTexture = new Texture(Gdx.files.internal("reactionSad.png"));
        Texture reactionNeutralTexture = new Texture(Gdx.files.internal("reactionNeutral.png"));
        Texture reactionScaredTexture = new Texture(Gdx.files.internal("reactionScared.png"));
        Texture reactionSurprisedTexture = new Texture(Gdx.files.internal("reactionSurprised.png"));
        Texture reactionHappyTexture = new Texture(Gdx.files.internal("reactionHappy.png"));
        Texture reactionConfusedTexture = new Texture(Gdx.files.internal("reactionConfused.png"));

        Texture keyIcon = new Texture(Gdx.files.internal("key.png"));
        Texture letterIcon = new Texture(Gdx.files.internal("lettera.png"));




        //inizializzazione Stringhe per interazioni
        String[] stringaOsservaPorta = new String[]  {"Provo a bussare...\n" +
                                                        "C'è nessuno??\n" +
                                                        "Qualche infermiere?",

                                                      ".....",

                                                      "Se avessi 10 kili in più di\n" +
                                                        "muscoli potrei persino provare\n" +
                                                        "a sfondarla... ma no meglio\n" +
                                                        "evitare... lo dico per il suo bene"};


        String[] stringaOsservaLetto = new String[] {"Questa notte ho fatto sempre il solito sogno...\n" +
                                                        "Quella strana ombra...ma chi sarà?",

                                                     "Se qualcuno si aspetta che io\n" +
                                                        "tiri su le coperte beh quel\n" +
                                                        "qualcuno si sbaglia di grosso"};


        String[] stringaOsservaComodino = new String[] {"Oggi camera mia sembra più silenziosa del solito...\n" +
                                                            "di solito si sente sempre quel bimbo piangere...\n" +
                                                            "...",
                                                        "spero stia bene...",

                                                        "Nonostante tutto quello che mi sia capitato\n" +
                                                            "il mio pupazzo di Kermit è ancora qui",

                                                        "Non sono il tipo che rovista\n" +
                                                            "ma devo avere qualche strana\n" +
                                                            "affinità con i cassetti"};


        String[] stringaOsservaOrologio = new String[] {"Ecco! mi piacerebbe sapere\n" +
                                                            "l'ora",

                                                        "Ovviamente è rotto, bella la\n" +
                                                            "sanità pubblica... paghi le\n" +
                                                            "tasse per gli orologi rotti",

                                                        "Sono sicuro che continuerà\n" +
                                                            "a segnare lo stesso orario\n" +
                                                            "per il resto della mia vita..."};


        String[] stringaOsservaFinestra = new String[] {"Come mai la finestra è chiusa?\n" +
                                                            "Ogni mattina arrivano gli infermieri ad aprirla...\n" +
                                                            "mi piacerebbe sapere dove sono finiti",

                                                        "Ho sempre desiderato mettere un grande poster\n" +
                                                            "proprio qui sotto la finestra,\n" +
                                                            "...\n" ,


                                                            "però il dottore non me lo ha mai permesso..\n"+
                                                                    "diceva che mi avrebbe fatto male al cervello...bha\n"};



        String[] stringaOsservaCartellina = new String[] {"Ci sono documenti molto\nriservati",

                                                          "Vedo una strana busta"};


        String[] stringaUsaPorta = new String[]  {"Non si apre..." ,

                                                  "É chiusa a chiave...",

                                                  "Potrei provare a stabilire un\n" +
                                                    "contatto spirituale con la porta\n" +
                                                    "continuando a guardare... oppure\n" +
                                                    "darmi una mossa e cercare una\nchiave"};


        String[] stringaRaccogliComodino = new String[] {"vediamo cosa c'è qui...",

                                                         "ho trovato la chiave!"};


        String[] stringaUsaLetto = new String[] {"Non ho sonno...",

                                                 "Ho dormito abbastanza per oggi...\n" +
                                                    "vorrei solo che...\n"
                ,
                                                    "lasciamo stare..."};


        String[] stringaRaccogliCartellina = new String[] {"*hai raccolto la busta\nriservata alla direzione*"};




        //utilizzo il json per caricare il font e imposto telecamera visualizzazione
        final Skin mySkin2 = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        final float aspectRatio = (float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth();

        camera = new OrthographicCamera(25*aspectRatio,25);
        camera.setToOrtho(false, WORLD_WIDTH/2, WORLD_HEIGHT/2);
        stage = new Stage(new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera));
        font= new BitmapFont(Gdx.files.internal("fonts/score.fnt"));



        sfondo.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        sfondo.setTouchable(Touchable.enabled);


     final   Protagonista pgTest = new Protagonista(new Texture("bimbo.png"));
        pgTest.setSize(23,28);


        //creazione oggetti raccoglibili e settare l'idPuzzle in modo che il sistema riconosca gli elementi chiave per superare i capitoli

        Oggetto chiave = new Oggetto(keyIcon,"Chiave","key","X",false);

        Oggetto lettera = new Oggetto(letterIcon,"Lettera riservata","X","X",false);


        //creazione interazioni e inizializzazione dimensioni

        Interazione door = new Interazione("door",portaTexture,stringaOsservaPorta,stringaUsaPorta,reactionConfusedTexture,reactionSadTexture);
        door.setSize(16,26.6f);




        Interazione comodino = new Interazione(stringaOsservaComodino,comodinoTexture,reactionConfusedTexture,reactionSurprisedTexture,stringaRaccogliComodino,chiave);
        comodino.setSize(20,25.3f);

        comodino.setDescrizione("lmao");




        Interazione letto = new Interazione("bed",lettoTexture,stringaOsservaLetto,stringaUsaLetto,reactionNeutralTexture,reactionSadTexture);
        letto.setSize(40.2f,25);



        Interazione orologio = new Interazione(orologioTexture,stringaOsservaOrologio,reactionConfusedTexture);
        orologio.setSize(12,14);



        Interazione finestra = new Interazione(finestraTexture,stringaOsservaFinestra,reactionScaredTexture);
        finestra.setSize(20,12);


        Interazione cartellina = new Interazione(stringaOsservaCartellina, cartellinaTexture, reactionNeutralTexture, reactionSurprisedTexture, stringaRaccogliCartellina, lettera);
        cartellina.setSize(6.2f,9);

        //imposto posizioni interazioni

        cartellina.setPosition(4.2f,31.1f);
        finestra.setPosition(70.5f, 49);
        orologio.setPosition(28.5f,52.5f);
        door.setPosition(7.75f,22.7f);
        comodino.setPosition(26.95f,18.3f);
        letto.setPosition(50,15.9f);
        pgTest.setPosition(74,17);


        final Group scena = new Group();
        //aggiungo interazioni alla scena

        scena.addActor(door);
        scena.addActor(comodino);
        scena.addActor(letto);
        scena.addActor(pgTest);
        scena.addActor(orologio);
        scena.addActor(finestra);
        scena.addActor(cartellina);
        pgTest.setTouchable(Touchable.disabled);




   //     final Dialog dialog= new Dialog("Benvenuto "+nomegiocatore,mySkin2);
   //     dialog.setSize(3,3);
   /*     final Dialog portaDialog= new Dialog(stringaPorta,mySkin2);
        portaDialog.setSize(3,3);
        final Dialog comodinoDialog = new Dialog(stringaComodino,mySkin2);
        comodinoDialog.setSize(3,3);
        final Dialog lettoDialog = new Dialog(stringaLetto,mySkin2);
        lettoDialog.setSize(3,3);
*/
   /*
        Timer.schedule(new Timer.Task(){
            public void run(){
                dialog.hide();
            }

        },2);
*/
        //creo il menù che gestisce le interazioni con gli oggetti e il puzzle del capitolo
       final Menu menu = new Menu(1, partita);


        scena.addCaptureListener(new InputListener(){

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {


                Vector3 worldCoordinates = camera.unproject(new Vector3(x,y,0));


                    /*
                    MoveToAction move = new MoveToAction();
                    move.setPosition(x,y);
                    move.setDuration(2f);
                    pgTest.addAction(move);
                    */
                  //  Vector2 coord = stage.screenToStageCoordinates(new Vector2(x, y))

                    //ATTENZIONE potrebbe crashare per colpa di  "java.lang.ClassCastException: WorldElement.Protagonista cannot be cast to WorldElement.Interazione" ,
                    //SOLUZIONI: da mettere l'eccezione o si risolverà quando cambio il modo di movimento del personaggio oppure togliere il personaggio dal Group
                Interazione hit = null;
                try {
                     hit = (Interazione) scena.hit(x, y, false); //hit rappresenta l'attore selezionato con un click
                }catch (Exception ClassCastException){ }

                    if (hit!=null){

                        //passo al menù l'interazione cliccata
                        menu.selezionaInterazione(hit);
                     //   menu.modificaInterazione(hit); //PERCHÈ FUNZIONA COMUNQUE LA MODIFICA ???

                        if(menu.isRimuovibile(hit))
                            scena.removeActor(hit);


                        Gdx.app.log(" attore test ",hit.getName());

                    }

                return false;
            }
        });

        //imposto il gestore degli input
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(menu.stage);
        Gdx.input.setInputProcessor(multiplexer);


        //creo l'interfaccia con la mappa
        stage.addActor(sfondo);
        stage.addActor(scena);
        stage.addActor(menu);


    }

    public void show() {

    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.6f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        stage.act();
        stage.draw();

    }




    public void resize(int width, int height) {

    }


    public void pause() {

    }


    public void resume() {

    }


    public void hide() {

    }


    public void dispose() {

    }
}
