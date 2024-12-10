package Simulation.Entity.Creature;

import Simulation.Entity.Coordinates;
import Simulation.Entity.Landscape.Grass;
import Simulation.Map.WorldMap;

import java.util.*;
import java.util.stream.Collectors;

public class PathFinder {

    public List<Coordinates> getAvialibleCoordinateslist(Coordinates coordinates, WorldMap worldMap){
        List<Coordinates> coordinatesList = new ArrayList<>();
        Coordinates up = new Coordinates(coordinates.x, coordinates.y+1);
        Coordinates down = new Coordinates(coordinates.x, coordinates.y-1);
        Coordinates left = new Coordinates(coordinates.x-1, coordinates.y);
        Coordinates right = new Coordinates(coordinates.x+1, coordinates.y);
        coordinatesList.add(up);
        coordinatesList.add(down);
        coordinatesList.add(left);
        coordinatesList.add(right);
        coordinatesList =
                coordinatesList.stream()
                .filter(coordinates1 -> worldMap.checkIfPassable(coordinates1))
                .filter(coordinates1 -> worldMap.checkIfInBound(coordinates1)).collect(Collectors.toList());
        if(worldMap.checkIfTarget(coordinates, Herbivore.class)) {
        coordinatesList= coordinatesList.stream()
                .filter(coordinates2 -> !worldMap.checkIfTarget(coordinates2, Herbivore.class))
                .filter(coordinates2 -> !worldMap.checkIfTarget(coordinates2, Predator.class))
                .collect(Collectors.toList());
        }
        if(worldMap.checkIfTarget(coordinates, Predator.class)) {
            coordinatesList= coordinatesList.stream().filter(coordinates2 -> !worldMap.checkIfTarget(coordinates2, Grass.class)).collect(Collectors.toList());
        }
        return coordinatesList;
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
            if (worldMap.checkIfTarget(current,target)) {
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





}
