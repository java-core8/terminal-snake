package ru.tcreator.Field;

import ru.tcreator.Entities.Dots;
import ru.tcreator.gameEntities.PlayersEntity;

public class Field {
    static private Field field;
    private PlayersEntity[][] fieldArray;
    private int size;
    private int width;

    private Field() {
        size = 20;
        width = size * 2;
        fieldArray = renderField(size, width);
        fullingDotsOnField();
    }

    public static Field getInstance() {
        if(field == null) {
            field = new Field();
        }
        return field;
    }

    /**
     * Установить сущность на поле по координатам
     * @param entity {@link PlayersEntity}
     * @returns
     */
    public Field setEntityPosition(PlayersEntity entity) {
        int[][] coordinates = entity.getCoordinates();
        for (int i = 0; i < coordinates.length; i++) {
            fieldArray[coordinates[i][0]][coordinates[i][1]] = entity;
        }
        return this;
    }

    /**
     * Возвращает размер поля
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Возвращает ширину поля
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Строит и возвращает пустое поле
     * @param size высота
     * @param width ширина
     * @return
     */
    private PlayersEntity[][] renderField(int size, int width) {
        PlayersEntity[][] playTmp = new PlayersEntity[size][width];
        return playTmp;
    }

    /**
     * Запоняет все простанство точками
     * @returns void
     */
    private void fullingDotsOnField() {
        Dots dots = new Dots();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < width; j++) {
                fieldArray[i][j] = dots;
            }
        }
    }

    /**
     * Выводит на консоль текущее состояние поля
     */
    public void printField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(fieldArray[i][j]);
            }
            System.out.println();
        }
    }
}
