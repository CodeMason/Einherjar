package com.jcerise.einherjar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.jcerise.einherjar.game.objects.Actor;
import com.jcerise.einherjar.util.Constants;

public class WorldRenderer implements Disposable {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;

    public WorldController worldController;

    public WorldRenderer(WorldController worldController) {
        init();
        this.worldController = worldController;
    }

    private void init() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
        font = new BitmapFont(Gdx.files.internal("font/dungeon.fnt"), Gdx.files.internal("font/dungeon.png"), false);
    }

    public void render() {
        renderWorld(batch);
    }

    public void resize(int width, int height) {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
        camera.update();
    }

    @Override public void dispose() {
        batch.dispose();
    }

    private void renderWorld(SpriteBatch batch) {
        worldController.cameraHelper.applyTo(camera);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        worldController.map.render(batch, font);
        for (Actor actor : worldController.actors) {
            actor.render(batch, font);
        }
        batch.end();
    }

}
