package com.jackycflau.battleship.core.model;

import java.util.ArrayList;
import java.util.List;

public final class BattleField {

    private List<List<Coordinate>> coordinateGrid;
    private List<Ship> shipCollection;

    public BattleField(int size){
        if(size>1){
            coordinateGrid = new ArrayList<>();
            shipCollection = new ArrayList<>();
            for(int i=0; i<size; i++) {
                List<Coordinate> rowList = new ArrayList<>();
                for(int j=0; j<size; j++){
                    rowList.add(new Coordinate(i, j));
                }
                coordinateGrid.add(rowList);
            }
        }else {
            throw new IllegalArgumentException("Error: Size must be greater than 1");
        }
    }

    public List<List<Coordinate>> getCoordinateGrid() {
        List<List<Coordinate>> copiedGrid = new ArrayList<>();
        for(List<Coordinate> row : coordinateGrid){
            List<Coordinate> copiedRow = new ArrayList<>();
            for(Coordinate c : row){
                copiedRow.add(new Coordinate(c));
            }
            copiedGrid.add(copiedRow);
        }
        return copiedGrid;
    }

    void setCoordinateGrid(List<List<Coordinate>> coordinateGrid) {
        this.coordinateGrid = coordinateGrid;
    }

    public List<Ship> getShipCollection() {
        List<Ship> copiedCollection = new ArrayList<>();
        for(Ship s : shipCollection){
            copiedCollection.add(new Ship(s.getCoordinates()));
        }
        return copiedCollection;
    }

    void setShipCollection(List<Ship> shipCollection) {
        this.shipCollection = shipCollection;
    }
}
