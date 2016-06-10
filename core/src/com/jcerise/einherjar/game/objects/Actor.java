package com.jcerise.einherjar.game.objects;

import com.badlogic.gdx.graphics.Color;
import com.jcerise.einherjar.game.Map;
import com.jcerise.einherjar.util.Constants;

public class Actor extends AbstractGameObject {

    private Tile[][] map;

    public Actor(int x, int y, int mapX, int mapY, char character, Color color, Map map) {
        super(x, y, mapX, mapY, character, color);

        this.map = map.tiles;
    }

    public void moveTo(int x, int y) {
        if (x == 1) {
            // Move the actor to the right one unit
            x = Constants.CHAR_WIDTH;
        } else if (x == -1) {
            // Move the actor to the left one unit
            x = -Constants.CHAR_WIDTH;
        }

        if (y == 1) {
            // Move the actor down on unit
            y = -Constants.CHAR_HEIGHT;
        } else if (y == -1) {
            y = Constants.CHAR_HEIGHT;
        }
        if (map[(int)mapPosition.y][(int)mapPosition.x].is_wall &&
                map[(int)mapPosition.y][(int)mapPosition.x].blocks_movement) {
            x = 0;
            y = 0;
        }
        adjustPosition(x, y);
        adjustMapPosition(x, y);
    }

}
