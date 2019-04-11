package com.jackycflau.battleship.core.model;

import java.util.*;
import java.util.stream.Collectors;

public final class Shipyard {
    //algo: flatenize list for drawing + reference list for checking, which is built from the result list, i.e. modify reference list will modify the grid
    public static BattleField build(BattleField battleField){
        Random random = new Random();
        List<List<Coordinate>> gameFieldGrid = battleField.getCoordinateGrid();
        List<Coordinate> coordinateBasket = battleField.getCoordinateGrid().stream().flatMap(List::stream).collect(Collectors.toList());
        List<Ship> shipCollection = battleField.getShipCollection();
        int fieldSize = gameFieldGrid.size();
        int maxShipLength = fieldSize!=2 ? (fieldSize-1)/2 : 1;
        int numOfShip = fieldSize - 1;
        for(int i=0; i<numOfShip; i++){
            int shipLength = random.nextInt(maxShipLength)+1;
            do{
                Collections.shuffle(coordinateBasket);
            }while(!assign(coordinateBasket.get(0), coordinateBasket, gameFieldGrid, shipLength));
        }
        battleField.setCoordinateGrid(gameFieldGrid);
        battleField.setShipCollection(shipCollection);
        return battleField;
    }

    //return true if the assignment is successful, otherwise false
    private static boolean assign(Coordinate coordinate, List<Coordinate> coordinateBasket, List<List<Coordinate>> gameFieldGrid, int size){
        /* 0 = Up
           1 = Right
           2 = Down
           3 = Left
         */
        List<Integer> directionList = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(directionList);
        int i = coordinate.getI();
        int j = coordinate.getJ();
        int gridLength = gameFieldGrid.size();
        for(int dir : directionList){
            List<Coordinate> coordinatesForProcess = new ArrayList<>();
            switch(dir){
                case 0:
                    if(i+1>=size){
                        for(int n=1; n<size; n++){
                            //todo
                        }
                    }else{
                        continue;
                    }
                    break;
                case 1:
                    if(j+size<=gridLength){
                        for(int n=1; n<size; n++){
                            //todo
                        }
                    }else{
                        continue;
                    }
                    break;
                case 2:
                    if(i+size<=gridLength){
                        for(int n=1; n<size; n++){
                            //todo
                        }
                    }else{
                        continue;
                    }
                    break;
                case 3:
                    if(j+1>=size){
                        for(int n=1; n<size; n++){
                            //todo
                        }
                    }else{
                        continue;
                    }
                    break;
            }
        }
        return false;
    }
}
