package ru.job4j.oop;

public class Jukebox {

    public void music(int position) {
        if (position == 1) {
            System.out.println(
                    """
                            Пусть бегут неуклюже\s
                            Пешеходы по лужам,\s
                            А вода по асфальту рекой.\s
                            И не ясно прохожим\s
                            В этот день непогожий\s
                            Почему я весёлый такой.
                            """

            );
        }
        if (position == 2) {
            System.out.println(
                    """
                            Спят усталые игрушки, книжки спят.
                            Одеяла и подушки ждут ребят.
                            Даже сказка спать ложится,
                            Чтобы ночью нам присниться.
                            Ты ей пожелай:
                            Баю-бай.
                            """
            );
        }
        if (position != 1 && position != 2) {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox play = new Jukebox();
        play.music(1);
        play.music(2);
        play.music(3);
    }
}
