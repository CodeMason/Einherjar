package com.jcerise.einherjar.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.jcerise.einherjar.util.Constants;

public abstract class AbstractGameObject {

    public Vector2 position;
    public char character;
    public Color color;
    public Vector2 origin;
    public Vector2 mapPosition;

    public AbstractGameObject(int x, int y, int mapX, int mapY, char character, Color color) {
        position = new Vector2();
        mapPosition = new Vector2();

        this.character = character;
        this.color = color;

        origin = new Vector2();
        origin.x = Constants.CHAR_WIDTH / 2;
        origin.y = Constants.CHAR_HEIGHT / 2;

        setPosition(x, y);
        setMapPosition(mapX, mapY);
    }

    public void render(SpriteBatch batch, BitmapFont font) {
        font.setColor(color);
        font.draw(batch, Character.toString(character), position.x, position.y);
    }

    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }

    public void adjustPosition(int x, int y) {
        position.x += x;
        position.y += y;
    }

    public void setMapPosition(int mapX, int mapY) {
        mapPosition.x = mapX;
        mapPosition.y = mapY;
    }

    public void adjustMapPosition(int x, int y) {
        mapPosition.x += x;
        mapPosition.y += y;
    }

}
