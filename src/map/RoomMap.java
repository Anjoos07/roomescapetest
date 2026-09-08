package map;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the logical information of one game room.
 *
 * This class does NOT render the map.
 * It only provides references, coordinates and gameplay areas
 * for the rest of the game.
 */
public class RoomMap {

    public static final int TILE_SIZE = 32;
    public static final int MAP_WIDTH = 960;
    public static final int MAP_HEIGHT = 640;

    private final String roomId;
    private final String mapReference;

    private final Point playerSpawn;

    private final List<MapObject> walls;
    private final List<MapObject> obstacles;
    private final List<MapObject> doors;
    private final List<MapObject> interactiveAreas;

    public RoomMap(
            String roomId,
            String mapReference,
            Point playerSpawn
    ) {
        this.roomId = roomId;
        this.mapReference = mapReference;
        this.playerSpawn = new Point(playerSpawn);

        this.walls = new ArrayList<>();
        this.obstacles = new ArrayList<>();
        this.doors = new ArrayList<>();
        this.interactiveAreas = new ArrayList<>();
    }

    public String getRoomId() {
        return roomId;
    }

    /**
     * Reference to the original TMX map.
     *
     * Example:
     * resources/maps/Bedroom.tmx
     */
    public String getMapReference() {
        return mapReference;
    }

    public Point getPlayerSpawn() {
        return new Point(playerSpawn);
    }

    public int getWidth() {
        return MAP_WIDTH;
    }

    public int getHeight() {
        return MAP_HEIGHT;
    }

    public int getTileSize() {
        return TILE_SIZE;
    }

    public Rectangle getRoomBounds() {
        return new Rectangle(
                0,
                0,
                MAP_WIDTH,
                MAP_HEIGHT
        );
    }

    public void addWall(MapObject wall) {
        walls.add(wall);
    }

    public void addObstacle(MapObject obstacle) {
        obstacles.add(obstacle);
    }

    public void addDoor(MapObject door) {
        doors.add(door);
    }

    public void addInteractiveArea(MapObject area) {
        interactiveAreas.add(area);
    }

    public List<MapObject> getWalls() {
        return Collections.unmodifiableList(walls);
    }

    public List<MapObject> getObstacles() {
        return Collections.unmodifiableList(obstacles);
    }

    public List<MapObject> getDoors() {
        return Collections.unmodifiableList(doors);
    }

    public List<MapObject> getInteractiveAreas() {
        return Collections.unmodifiableList(interactiveAreas);
    }

    /**
     * Returns all collidable objects from this room.
     */
    public List<MapObject> getCollidableObjects() {

        List<MapObject> result = new ArrayList<>();

        for (MapObject wall : walls) {
            if (wall.isCollidable()) {
                result.add(wall);
            }
        }

        for (MapObject obstacle : obstacles) {
            if (obstacle.isCollidable()) {
                result.add(obstacle);
            }
        }

        for (MapObject door : doors) {
            if (door.isCollidable()) {
                result.add(door);
            }
        }

        return result;
    }

    /**
     * Checks whether a rectangle would collide with any
     * collidable object in the room.
     */
    public boolean collides(Rectangle rectangle) {

        for (MapObject object : getCollidableObjects()) {

            if (rectangle.intersects(object.getBounds())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a readable coordinate description.
     */
    public String getCoordinateReference() {

        return
                "Room: " + roomId + "\n" +
                "Map reference: " + mapReference + "\n" +
                "Map size: " + MAP_WIDTH + "x" + MAP_HEIGHT + "\n" +
                "Tile size: " + TILE_SIZE + "\n" +
                "Player spawn: (" +
                playerSpawn.x +
                ", " +
                playerSpawn.y +
                ")";
    }
}