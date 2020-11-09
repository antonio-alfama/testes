package com.school.mindera.enums;

public enum DirectionType {
    NORTH("The North remembers!"),
    SOUTH("It's sunny in Philadelphia!"),
    EAST("Hala muchacho!"),
    WEST("Far Far Far ... Far West");

    private String message;

    DirectionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
