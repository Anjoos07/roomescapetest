package map;

import java.awt.Rectangle;

/**
 * Represents a logical object on a room map.
 *
 * Coordinates:
 * (0,0) = top-left of the room
 * X increases to the right
 * Y increases downward
 */
public class MapObject {

    private final String id;
    private final String type;
    private final Rectangle bounds;
    private final boolean collidable;
    private final boolean interactive;

    public MapObject(
            String id,
            String type,
            int x,
            int y,
            int width,
            int height,
            boolean collidable,
            boolean interactive
    ) {
        this.id = id;
        this.type = type;
        this.bounds = new Rectangle(x, y, width, height);
        this.collidable = collidable;
        this.interactive = interactive;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Rectangle getBounds() {
        return new Rectangle(bounds);
    }

    public int getX() {
        return bounds.x;
    }

    public int getY() {
        return bounds.y;
    }

    public int getWidth() {
        return bounds.width;
    }

    public int getHeight() {
        return bounds.height;
    }

    public boolean isCollidable() {
        return collidable;
    }

    public boolean isInteractive() {
        return interactive;
    }

    @Override
    public String toString() {
        return "MapObject{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", x=" + bounds.x +
                ", y=" + bounds.y +
                ", width=" + bounds.width +
                ", height=" + bounds.height +
                ", collidable=" + collidable +
                ", interactive=" + interactive +
                '}';
    }
}