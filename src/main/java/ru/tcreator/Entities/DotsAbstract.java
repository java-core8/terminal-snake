package ru.tcreator.Entities;

import ru.tcreator.gameEntities.PlayersEntity;

public abstract class DotsAbstract implements PlayersEntity {
    @Override
    public int[][] getCoordinates() {
        return new int[0][0];
    }
}
