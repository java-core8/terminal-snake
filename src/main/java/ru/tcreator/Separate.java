package ru.tcreator;

public enum Separate {
    MOUSE("@"),
    WALL("█"),
    DOTS("·"),
    SNAKE_BODY("*");

    private String code;
    Separate(String s) {
        this.code = s;
    }

    public String getCode() {
        return code;
    }
}
