package map;

import java.awt.Point;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Central registry of all rooms.
 *
 * This class provides the map references and coordinates
 * to the rest of the game.
 */
public final class MapRegistry {

    private static final Map<String, RoomMap> ROOMS = new LinkedHashMap<>();

    static {
        createBedroom();
        createKitchen();
        createLivingRoom();
        createRoom4();
    }

    private MapRegistry() {
        // Utility class
    }

    private static void createBedroom() {

        RoomMap bedroom = new RoomMap(
                "ROOM_BEDROOM",
                "Bedroom(2).tmx",
                new Point(480, 420)
        );

        /*
         * Room boundary.
         *
         * These represent the playable boundary,
         * not the visual furniture.
         */

        bedroom.addWall(
                new MapObject(
                        "bedroom_top_wall",
                        "WALL",
                        0,
                        0,
                        960,
                        32,
                        true,
                        false
                )
        );

        bedroom.addWall(
                new MapObject(
                        "bedroom_left_wall",
                        "WALL",
                        0,
                        0,
                        32,
                        640,
                        true,
                        false
                )
        );

        bedroom.addWall(
                new MapObject(
                        "bedroom_right_wall",
                        "WALL",
                        928,
                        0,
                        32,
                        640,
                        true,
                        false
                )
        );

        bedroom.addWall(
                new MapObject(
                        "bedroom_bottom_wall",
                        "WALL",
                        0,
                        608,
                        960,
                        32,
                        true,
                        false
                )
        );

        /*
         * Main furniture references.
         *
         * IMPORTANT:
         * These are logical gameplay rectangles.
         * They can be adjusted independently from the artwork.
         */

        bedroom.addObstacle(
                new MapObject(
                        "bed",
                        "BED",
                        250,
                        260,
                        100,
                        135,
                        true,
                        true
                )
        );

        bedroom.addObstacle(
                new MapObject(
                        "wardrobe",
                        "WARDROBE",
                        448,
                        170,
                        95,
                        145,
                        true,
                        true
                )
        );

        bedroom.addObstacle(
                new MapObject(
                        "dresser",
                        "DRESSER",
                        560,
                        205,
                        85,
                        115,
                        true,
                        true
                )
        );

        bedroom.addObstacle(
                new MapObject(
                        "desk",
                        "DESK",
                        585,
                        315,
                        100,
                        90,
                        true,
                        true
                )
        );

        /*
         * Bottom exit door.
         */
        bedroom.addDoor(
                new MapObject(
                        "bedroom_exit",
                        "DOOR",
                        420,
                        480,
                        120,
                        80,
                        false,
                        true
                )
        );

        ROOMS.put(bedroom.getRoomId(), bedroom);
    }

    private static void createKitchen() {

        RoomMap kitchen = new RoomMap(
                "ROOM_KITCHEN",
                "Kitchen(2).tmx",
                new Point(500, 400)
        );

        addStandardWalls(
                kitchen,
                "kitchen"
        );

        /*
         * Kitchen counter / appliances.
         */
        kitchen.addObstacle(
                new MapObject(
                        "kitchen_counter",
                        "COUNTER",
                        260,
                        220,
                        300,
                        65,
                        true,
                        true
                )
        );

        kitchen.addObstacle(
                new MapObject(
                        "stove",
                        "STOVE",
                        455,
                        220,
                        55,
                        65,
                        true,
                        true
                )
        );

        kitchen.addObstacle(
                new MapObject(
                        "refrigerator",
                        "REFRIGERATOR",
                        250,
                        190,
                        55,
                        90,
                        true,
                        true
                )
        );

        kitchen.addObstacle(
                new MapObject(
                        "dining_table",
                        "TABLE",
                        375,
                        310,
                        105,
                        90,
                        true,
                        true
                )
        );

        kitchen.addDoor(
                new MapObject(
                        "kitchen_exit",
                        "DOOR",
                        608,
                        380,
                        45,
                        100,
                        false,
                        true
                )
        );

        ROOMS.put(kitchen.getRoomId(), kitchen);
    }

    private static void createLivingRoom() {

        RoomMap livingRoom = new RoomMap(
                "ROOM_LIVING",
                "Living_room(3).tmx",
                new Point(480, 400)
        );

        addStandardWalls(
                livingRoom,
                "living"
        );

        livingRoom.addObstacle(
                new MapObject(
                        "main_sofa",
                        "SOFA",
                        275,
                        320,
                        150,
                        55,
                        true,
                        false
                )
        );

        livingRoom.addObstacle(
                new MapObject(
                        "left_sofa",
                        "SOFA",
                        255,
                        270,
                        105,
                        55,
                        true,
                        false
                )
        );

        livingRoom.addObstacle(
                new MapObject(
                        "right_sofa",
                        "SOFA",
                        360,
                        270,
                        105,
                        55,
                        true,
                        false
                )
        );

        livingRoom.addObstacle(
                new MapObject(
                        "bookshelf",
                        "BOOKSHELF",
                        280,
                        205,
                        200,
                        70,
                        true,
                        true
                )
        );

        livingRoom.addObstacle(
                new MapObject(
                        "desk",
                        "DESK",
                        585,
                        320,
                        70,
                        85,
                        true,
                        true
                )
        );

        livingRoom.addDoor(
                new MapObject(
                        "living_exit",
                        "DOOR",
                        405,
                        440,
                        90,
                        100,
                        false,
                        true
                )
        );

        ROOMS.put(livingRoom.getRoomId(), livingRoom);
    }

    private static void createRoom4() {

        /*
         * NOTE:
         * The uploaded untitled(2).tmx currently has the same
         * TMX structure and object data as Bedroom(2).tmx.
         *
         * Keep this separate as ROOM_4 so your teammate can
         * change it later if it is intended to be a different room.
         */

        RoomMap room4 = new RoomMap(
                "ROOM_4",
                "untitled(2).tmx",
                new Point(480, 420)
        );

        addStandardWalls(
                room4,
                "room4"
        );

        room4.addDoor(
                new MapObject(
                        "room4_exit",
                        "DOOR",
                        420,
                        480,
                        120,
                        80,
                        false,
                        true
                )
        );

        ROOMS.put(room4.getRoomId(), room4);
    }

    private static void addStandardWalls(
            RoomMap room,
            String prefix
    ) {

        room.addWall(
                new MapObject(
                        prefix + "_top_wall",
                        "WALL",
                        0,
                        0,
                        960,
                        32,
                        true,
                        false
                )
        );

        room.addWall(
                new MapObject(
                        prefix + "_left_wall",
                        "WALL",
                        0,
                        0,
                        32,
                        640,
                        true,
                        false
                )
        );

        room.addWall(
                new MapObject(
                        prefix + "_right_wall",
                        "WALL",
                        928,
                        0,
                        32,
                        640,
                        true,
                        false
                )
        );

        room.addWall(
                new MapObject(
                        prefix + "_bottom_wall",
                        "WALL",
                        0,
                        608,
                        960,
                        32,
                        true,
                        false
                )
        );
    }

    public static RoomMap getRoom(String roomId) {
        return ROOMS.get(roomId);
    }

    public static Map<String, RoomMap> getRooms() {
        return Collections.unmodifiableMap(ROOMS);
    }

    public static boolean containsRoom(String roomId) {
        return ROOMS.containsKey(roomId);
    }
}