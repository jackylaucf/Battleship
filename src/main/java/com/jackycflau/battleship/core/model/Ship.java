package com.jackycflau.battleship.core.model;

import java.util.ArrayList;
import java.util.List;

public final class Ship {

    private final List<Coordinate> coordinates;

    Ship(List<Coordinate> coordinates){
        this.coordinates = coordinates;
    }

    public List<Coordinate> getCoordinates() {
        List<Coordinate> copiedList = new ArrayList<>();
        for(Coordinate c : coordinates){
            copiedList.add(new Coordinate(c));
        }
        return copiedList;
    }
}
