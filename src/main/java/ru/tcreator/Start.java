package ru.tcreator;

import ru.tcreator.Entities.Mouse;
import ru.tcreator.Entities.Snake;
import ru.tcreator.Field.Field;
import ru.tcreator.Moves.Down;
import ru.tcreator.Moves.Left;
import ru.tcreator.Moves.Right;
import ru.tcreator.Moves.Up;

import java.util.Scanner;

public class Start {
    public static void main(String ...args) {

        Scanner scan = new Scanner(System.in);
        Field field = Field.getInstance();
        Mouse mouse = new Mouse();
        Snake snake = Snake.getInstance();
        field.setEntityPosition(mouse)
                .setEntityPosition(snake);

        field.printField();

        while (true) {
            try {
                clearConsole();
                Thread.sleep(2000);
                new Down().move();
                field.printField();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public final static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
