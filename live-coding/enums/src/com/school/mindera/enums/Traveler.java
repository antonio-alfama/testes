package com.school.mindera.enums;

public class Traveler {

    private int x;
    private int y;
    private String name;

    public Traveler(String name) {
        this.x = 0;
        this.y = 0;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void travel(DirectionType direction) {
        switch (direction) {
            case NORTH:
                this.y++;
                break;
            case SOUTH:
                this.y--;
                break;
            case EAST:
                this.x++;
                break;
            case WEST:
                this.x--;
                break;
            default:
                System.out.println("I'm going underground!");
        }
    }

    public void printCoords() {
        System.out.println(x + ", " + y);
    }

}
