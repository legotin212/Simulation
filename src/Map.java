import Entity.Coordinates;
import Entity.Creature.Creature;
import Entity.Entity;

import java.util.HashMap;

public class Map {

    public static int getMapSize(){
        return 10;
    }
    public HashMap<Coordinates, Entity> entities = new HashMap<>();
    public void setEntity(Entity entity, Coordinates coordinates){
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }

    public Entity getEntity(Coordinates coordinates){
        return entities.get(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates){
        return !entities.containsKey(coordinates);
    }




}

