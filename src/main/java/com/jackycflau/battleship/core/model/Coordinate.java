package com.jackycflau.battleship.core.model;

public final class Coordinate {
    private final int i;
    private final int j;
    private boolean isOccupied;
    private boolean canBuild; //for build purpose only

    public Coordinate(int i, int j){
        this.i = i;
        this.j = j;
        this.isOccupied = false;
        this.canBuild = true;
    }

    public Coordinate(Coordinate c){
        this.i = c.i;
        this.j = c.j;
        this.isOccupied = c.isOccupied;
        this.canBuild = c.canBuild;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    void occupy(){
        isOccupied = true;
    }

    void markBuilt(){
        canBuild = false;
    }
}
