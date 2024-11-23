import Entity.Coordinates;
import Entity.Creature.Herbivore;
import Entity.Creature.Predator;
import Entity.Entity;
import Entity.Landscape.Grass;
import Entity.Landscape.Rock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Entity m = new Grass(new Coordinates(4,4));
        Entity c = new Grass(new Coordinates(5,5));
        Map map = new Map();
        map.setEntity(m, m.coordinates);
        map.setEntity(c, c.coordinates);
        MapPrinter printer = new MapPrinter();
        map.setEntity(new Predator(1,1,new Coordinates(1,1)),new Coordinates(1,1));
        map.setEntity(new Rock(new Coordinates(1,2)), new Coordinates(1,2));
        map.setEntity(new Herbivore(new Coordinates(3,3)),new Coordinates(3,3));
        printer.printMap(map);


    }
}