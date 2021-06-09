package ru.tcreator.Moves;

import ru.tcreator.Entities.KeyEvents;
import ru.tcreator.Entities.Snake;
import ru.tcreator.Field.Field;

public class Down implements Moves{
    @Override
    public void move() {
        Snake snake = Snake.getInstance();
        Field field = Field.getInstance();
        snake.down();
        field.setEntityPosition(snake);
    }

    @Override
    public boolean setMove(KeyEvents events) {
        return Boolean.TRUE;
    }
}
