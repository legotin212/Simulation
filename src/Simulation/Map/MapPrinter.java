package Simulation.Map;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Entity;

public class MapPrinter {
    private WorldMap worldMap;

    public MapPrinter(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void printMap(WorldMap worldMap) {
        for (int rank = 0; rank < worldMap.getMapSize(); rank++) {
            String line = "";
            for (int file = 0; file < worldMap.getMapSize(); file++) {
                line += " ";
                Coordinates coordinates = new Coordinates(file, rank);
                if (worldMap.checkIfEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                } else {

                    line += getEntitySprite(worldMap.getEntity(coordinates));
                }
            }
            System.out.println(line);
        }

    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return "\uD83D\uDFEB";
    }
    private String getEntitySprite(Entity entity) {
        return entity.getSprite();
    }




}