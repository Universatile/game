import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 * Creates a new tile-based map based on TiledMap
 * Used to draw the background in the World class
 */

public class Map {
    private TiledMap map;
    private final float width;
    private final float height;

    public Map() throws SlickException {
        map = new TiledMap("assets/main.tmx",true);
        width = map.getWidth()*map.getTileWidth();
        height = map.getHeight()*map.getTileHeight();
    }
    // Draw map based on camera position
    public void render(Camera camera) {
        map.render(-1*(int)camera.getLeft(),-1*(int)camera.getTop());
    }
    public float getWidth() {
        return width;
    }
    public float getHeight() {
        return height;
    }
    public boolean isSolidTile(float x, float y) {
        int id = map.getTileId((int)(x/map.getTileWidth()),(int)(y/map.getTileHeight()),0);
        return Boolean.parseBoolean(map.getTileProperty(id, "solid", "true"));
    }
}
