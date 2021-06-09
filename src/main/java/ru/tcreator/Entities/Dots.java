package ru.tcreator.Entities;
import ru.tcreator.Color;
import ru.tcreator.Separate;

public class Dots extends DotsAbstract {
    private String dotsKey;
    private String alertDotsKey;

    public Dots() {
        String dots = Separate.DOTS.getCode();
        dotsKey = dots;
        alertDotsKey = Color.ANSI_RED.getColor() + dots + Color.ANSI_RESET.getColor();
    }

    /**
     * Возвращает разделитель "точка" для обозначения пустой клетки поля
     * @param isAlert если true точка красная
     * @return {@link String} Возвращает код с красной расцветкой
     */
    public String getDotsKey(boolean isAlert) {
        return isAlert ? dotsKey : alertDotsKey;
    }


    @Override
    public String toString() {
        return dotsKey;
    }
}
