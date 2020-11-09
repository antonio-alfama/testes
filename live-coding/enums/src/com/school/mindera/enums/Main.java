package com.school.mindera.enums;

public class Main {
    public static void main(String[] args) {

        Traveler traveler = new Traveler("Tojó");

        traveler.printCoords();
        traveler.travel(DirectionType.NORTH);
        traveler.printCoords();

        System.out.println(DirectionType.values().length);
    }
}
