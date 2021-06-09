package ru.tcreator.Entities;

import ru.tcreator.Color;
import ru.tcreator.Field.Field;
import ru.tcreator.Separate;
import ru.tcreator.gameEntities.PlayersEntity;

import java.io.FileInputStream;
import java.util.Arrays;

public class Snake implements PlayersEntity {
    private int[][] snakeCoordinate;
    private final String snake_body;
    private int[] snake_tail;
    private static Snake snake;

    private Snake() {
        this.snake_body = Color.ANSI_BLUE.getColor() +
                Separate.SNAKE_BODY.getCode() +
                Color.ANSI_RESET.getColor();
        snakeCoordinate = new int[3][2];
        setSnake(3);
        snake_tail = snakeCoordinate[snakeCoordinate.length - 1];
    }

    public static Snake getInstance() {
        if(snake == null) {
            snake = new Snake();
        }
        return snake;
    }

    @Override
    public int[][] getCoordinates() {
        return snakeCoordinate;
    }

    public void setSnake(int size) {
        Field field = Field.getInstance();

        int sizeField = field.getSize();
        int width = field.getWidth();
        for (int i = 0; i < size; i++) {
            snakeCoordinate[i] = new int[] {sizeField / 2 - i, width / 2};
        }
    }

    @Override
    public String toString() {
        return snake_body;
    }

    private void moveAnywhere(int[] head) {
        int[][] tmpSnakeBoby = new int[snakeCoordinate.length][2];
        tmpSnakeBoby[0] = head;
        for (int i = 1; i < snakeCoordinate.length; i++) {
            tmpSnakeBoby[i] = snakeCoordinate[i - 1];
        }
        removePostMovingSimbol();
        snake_tail = tmpSnakeBoby[tmpSnakeBoby.length - 1];
        snakeCoordinate = tmpSnakeBoby;
    }


    public void down() {
        int[] prevHead = snakeCoordinate[0];
        moveAnywhere(new int[] {prevHead[0] + 1, prevHead[1]});
    }

    public void up() {
        int[] prevHead = snakeCoordinate[0];
        moveAnywhere(new int[] {prevHead[0] - 1, prevHead[1]});
    }

    public void left() {
        int[] prevHead = snakeCoordinate[0];
        moveAnywhere(new int[] {prevHead[0], prevHead[1] - 1});
    }

    public void right() {
        int[] prevHead = snakeCoordinate[0];
        moveAnywhere(new int[] {prevHead[0], prevHead[1] + 1});
    }

    private void removePostMovingSimbol() {
        Field field = Field.getInstance();
        PlayersEntity playersEntity = new Dots() {
            @Override
            public int[][] getCoordinates() {
                return new int[][] {snake_tail};
            }
        };
        field.setEntityPosition(playersEntity);
    }
}
