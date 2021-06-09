package ru.tcreator.Entities;

import ru.tcreator.Color;
import ru.tcreator.Field.Field;
import ru.tcreator.Separate;
import ru.tcreator.gameEntities.PlayersEntity;
import java.util.Random;


public class Mouse implements PlayersEntity {
    private String mouseSymbol;
    private int[][] mouseCoordinate;

    public Mouse() {
        mouseSymbol = Color.ANSI_YELLOW.getColor() +
                Separate.MOUSE.getCode() +
                Color.ANSI_RESET.getColor();

        mouseCoordinate = getRenderCoord();
    }

    @Override
    public int[][] getCoordinates() {
        return mouseCoordinate;
    }

    public int[][] getRenderCoord() {
        Field field = Field.getInstance();

        int size = field.getSize();
        int width = field.getWidth();
        int[][] randoms =  {
            new int[] { new Random().nextInt(size), new Random().nextInt(width) }
        };
        return randoms;
    }

    @Override
    public String toString() {
        return mouseSymbol;
    }
}
