import Entity.Coordinates;
import Entity.Creature.Creature;
import Entity.Entity;

import java.awt.*;

public class MapPrinter {
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";

    public MapPrinter() {

    }

    public void printMap(Map map) {


        for (int rank = 0; rank < Map.getMapSize(); rank++) {
            String line = "";
            for (int file = 0; file < Map.getMapSize(); file++) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (map.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptySquare(coordinates);
                } else {
                    line += getEntitySprite(map.getEntity(coordinates));
                }
            }
            line += ANSI_RESET;
            System.out.println(line);
        }

    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return colorizeSprite("   ", Color.WHITE);
    }

    private String colorizeSprite(String sprite, Color white) {
        String result = sprite;
        result = ANSI_WHITE_SQUARE_BACKGROUND  + result;
        return result;
    }

    private String getEntitySprite(Entity entity) {
        return colorizeSprite(
                " " + entity.getUnicodeSim() + " ", Color.black);
    }




}