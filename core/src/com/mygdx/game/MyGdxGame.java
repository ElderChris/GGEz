package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import schermate.Schermata;
import schermate.SchermataIniziale;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public Texture img;
	int x;
	public static int altezza=900;
	public static int larghezza=1200;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//crea la schermatta iniziale
		this.setScreen(new SchermataIniziale(this));

	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
