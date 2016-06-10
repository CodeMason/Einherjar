package com.jcerise.einherjar.game.objects;

import com.badlogic.gdx.graphics.Color;

public class Tile extends AbstractGameObject {

    private static final String TAG = Tile.class.getName();

    public boolean blocks_movement;
    public boolean is_wall;
    public boolean is_floor;

    public Tile(int x, int y, int mapX, int mapY, char character, Color color, boolean blocks_movement, boolean is_wall,
                boolean is_floor) {
        super(x, y, mapX, mapY, character, color);

        this.blocks_movement = blocks_movement;
        this.is_wall = is_wall;
        this.is_floor = is_floor;
    }
}
