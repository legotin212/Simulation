package simulation.map;

import simulation.entity.Coordinates;
import simulation.entity.Entity;

public class MapPrinter {
    private WorldMap worldMap;
    private final String HERBIVORE_SPRITE = "\uD83D\uDC07";
    private final String PREDATOR_SPRITE = "\uD83D\uDC3A";
    private final String GRASS_SPRITE = "\uD83C\uDF40";
    private final String TREE_SPRITE = "\uD83C\uDF33" + " ";
    private final String ROCK_SPRITE = "\uD83D\uDDFF" + " " +" ";
    private final String EMPTY_SQUARE_SPRITE = "\uD83D\uDFEB";

    public MapPrinter(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void printMap(WorldMap worldMap) {
        for (int rank = 0; rank < worldMap.getMapSize(); rank++) {
            StringBuilder line = new StringBuilder();
            for (int file = 0; file < worldMap.getMapSize(); file++) {
                line.append(" ");
                Coordinates coordinates = new Coordinates(file, rank);
                if (worldMap.checkIfCoordinatesIsEmpty(coordinates)) {
                    line.append(EMPTY_SQUARE_SPRITE);
                } else {
                    line.append(getEntitySprite(worldMap.getEntityByCoordinates(coordinates)));
                }
            }
            System.out.println(line);
        }
    }

    private String getEntitySprite(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Herbivore" -> HERBIVORE_SPRITE;
            case "Predator" -> PREDATOR_SPRITE;
            case "Grass" -> GRASS_SPRITE;
            case "Tree" -> TREE_SPRITE;
            case "Rock" -> ROCK_SPRITE;
            default -> throw new IllegalArgumentException("Unknown entity class: " + entity.getClass().getName());
        };
    }




}