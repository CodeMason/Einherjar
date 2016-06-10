package com.jcerise.einherjar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jcerise.einherjar.game.WorldController;
import com.jcerise.einherjar.game.WorldRenderer;

public class EinherjarGame extends ApplicationAdapter {
	SpriteBatch batch;
	private BitmapFont font;
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	public boolean paused;
	
	@Override
	public void create () {

		Gdx.graphics.setContinuousRendering(false);

		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.RED);

		// Initialize the controller and renderer
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);

		// Set the game world to active on start
		paused = false;
	}

	@Override
	public void render () {
		// Do not update the game world when paused
		// TODO: Might just apply for Android... need to find out
		if (!paused) {
			// Update the game world by the time that has passed since the last rendered frame
			worldController.update(Gdx.graphics.getDeltaTime());
		}

		// Set the clear screen color to black
		Gdx.gl.glClearColor(0, 0, 0, 0xff/255.0f);

		// Clear the screen
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Finally, render the game world to the screen
		worldRenderer.render();
	}
}
