package simulation.map;

import simulation.entity.Coordinates;
import simulation.entity.creature.Herbivore;
import simulation.entity.creature.Predator;
import simulation.entity.landscape.Grass;
import simulation.entity.landscape.Rock;
import simulation.entity.landscape.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class PathFinder {

    public Boolean checkIfTarget(Coordinates coordinates, Class<?> target, WorldMap worldMap) {
        if(worldMap.checkIfCoordinatesIsEmpty(coordinates)){return false;}
        return worldMap.getEntity(coordinates).getClass().equals(target);
    }

    public List<Coordinates> findPathToNearestTarget(Coordinates current, Class<?> target, WorldMap worldMap) {
        List<Coordinates> DefaultPath = new ArrayList<>();
        ArrayDeque<Coordinates> unvisited = new ArrayDeque<>();
        Map<Coordinates, Coordinates> predecessors = new HashMap<>();
        List<Coordinates> visited = new ArrayList<>();
        unvisited.addLast(current);
        while (!unvisited.isEmpty()) {
            current = unvisited.removeFirst();
            visited.add(current);
            if (checkIfTarget(current,target,worldMap)) {
                List<Coordinates> path = new ArrayList<>();
                for (Coordinates at = current; at != null; at = predecessors.get(at)) {
                    path.add(at);
                }
                Collections.reverse(path);
                return path;
            }

            for (Coordinates neighbor : getAvialibleCoordinateslist(current, worldMap)) {
                if (!visited.contains(neighbor) && !unvisited.contains(neighbor)) {
                    unvisited.addLast(neighbor);
                    predecessors.put(neighbor, current);
                }
            }
        }

        return DefaultPath;
    }


    private List<Coordinates> getAvialibleCoordinateslist(Coordinates coordinates, WorldMap worldMap){
        List<Coordinates> coordinatesList = new ArrayList<>();
        Coordinates up = new Coordinates(coordinates.row, coordinates.column +1);
        Coordinates down = new Coordinates(coordinates.row, coordinates.column -1);
        Coordinates left = new Coordinates(coordinates.row -1, coordinates.column);
        Coordinates right = new Coordinates(coordinates.row +1, coordinates.column);
        coordinatesList.add(up);
        coordinatesList.add(down);
        coordinatesList.add(left);
        coordinatesList.add(right);
        coordinatesList =
                coordinatesList.stream()
                .filter(coordinates1 -> checkIfPassable(coordinates1,worldMap))
                .filter(coordinates1 -> worldMap.checkIfInBound(coordinates1)).collect(Collectors.toList());
        if(checkIfTarget(coordinates, Herbivore.class,worldMap)) {
        coordinatesList= coordinatesList.stream()
                .filter(coordinates2 -> !checkIfTarget(coordinates2, Herbivore.class,worldMap))
                .filter(coordinates2 -> !checkIfTarget(coordinates2, Predator.class,worldMap))
                .collect(Collectors.toList());
        }
        if(checkIfTarget(coordinates, Predator.class,worldMap)) {
            coordinatesList= coordinatesList.stream().filter(coordinates2 -> !checkIfTarget(coordinates2, Grass.class, worldMap)).collect(Collectors.toList());
        }

        return coordinatesList;
    }

    private Boolean checkIfPassable(Coordinates coordinates, WorldMap worldMap){
        return worldMap.checkIfCoordinatesIsEmpty(coordinates) || !((worldMap.getEntity(coordinates) instanceof Rock)||(worldMap.getEntity(coordinates) instanceof Tree)
                ||(worldMap.getEntity(coordinates) instanceof Predator));
    }





}
