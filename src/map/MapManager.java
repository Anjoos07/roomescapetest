package map;

import java.awt.Graphics2D;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapManager {

    private final Map<String, TileMap> maps = new LinkedHashMap<>();
    private String currentMapName;

    public MapManager() {

        loadMap(
            "bedroom",
            "src/map/Bedroom.tmx"
        );

        loadMap(
            "kitchen",
            "src/map/Kitchen.tmx"
        );

        loadMap(
            "living_room",
            "src/map/LivingRoom.tmx"
        );

        loadMap(
            "study",
            "src/map/Study.tmx"
        );

        currentMapName = "living_room";
    }

    private void loadMap(
        String name,
        String path
    ) {

        System.out.println(
            "Loading map: " + name
        );

        TileMap map = new TileMap(path);

        maps.put(name, map);
    }

    public void switchMap(String name) {

        if (!maps.containsKey(name)) {

            System.err.println(
                "Map not found: " + name
            );

            return;
        }

        currentMapName = name;

        System.out.println(
            "Current map: " +
            currentMapName
        );
    }

    public TileMap getCurrentMap() {

        return maps.get(currentMapName);
    }

    public String getCurrentMapName() {

        return currentMapName;
    }

    public void draw(Graphics2D g2) {

        TileMap currentMap =
            getCurrentMap();

        if (currentMap != null) {
            currentMap.draw(g2);
        }
    }
}