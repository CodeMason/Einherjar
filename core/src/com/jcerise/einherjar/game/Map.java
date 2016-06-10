package com.jcerise.einherjar.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jcerise.einherjar.game.objects.Actor;
import com.jcerise.einherjar.game.objects.Tile;
import com.jcerise.einherjar.util.Constants;


public class Map {

    public Tile[][] tiles;
    public Actor player;

    public Map() {
        init();
    }


    private void init() {
        tiles = new Tile[10][];

        // Create a 100 x 100 map made up of wall tiles
        Tile tile = null;
        for (int y = 0; y < 10; y++) {
            Tile[] row = new Tile[10];
            for (int x = 0; x < 10; x++) {
                if (x == 0 || y == 0 || x == 8 || y == 9){
                    tile = new Tile(Constants.CHAR_WIDTH * x, Constants.CHAR_HEIGHT * y, x, y, '#', Color.WHITE, true, true, false);
                } else {
                    tile = new Tile(Constants.CHAR_WIDTH * x, Constants.CHAR_HEIGHT * y, x, y, '.', Color.WHITE, false, false, true);
                }

                row[x] = tile;
            }
            tiles[y] = row;
        }
    }

    public void render(SpriteBatch batch, BitmapFont font) {
        //Draw all tiles for this map
        for (int y = 0; y <= tiles.length - 1; y++) {
            for (int x = 0; x < tiles[y].length - 1; x++) {
                Tile tile = tiles[y][x];
                tile.render(batch, font);
            }
        }
    }

}
