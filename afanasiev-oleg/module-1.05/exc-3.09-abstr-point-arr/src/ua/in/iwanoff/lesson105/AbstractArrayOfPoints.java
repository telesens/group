package ua.in.iwanoff.lesson105;

/**
 * Created by oleg on 11/25/15.
 */
public abstract class AbstractArrayOfPoints {

    // Запись новых координат точки:
    public abstract void setPoint(int i, double x, double y);

    // Получение X точки i:
    public abstract double getX(int i);

    // Получение Y точки i:
    public abstract double getY(int i);

    // Получение количества точек:
    public abstract int count();

    // Добавление точки в конец массива:
    public abstract void addPoint(double x, double y);

    // Удаление последней точки:
    public abstract void removeLast();

    // Сортировка по значениям X:
    public void sortByX() {
        boolean mustSort; // Повторяем до тех пор,
        // пока mustSort равно true
        do {
            mustSort = false;
            for (int i = 0; i < count() - 1; i++) {
                if (getX(i) > getX(i + 1)) {
                    // меняем элементы местами
                    double x = getX(i);
                    double y = getY(i);
                    setPoint(i, getX(i + 1), getY(i + 1));
                    setPoint(i + 1, x, y);
                    mustSort = true;
                }
            }
        }
        while (mustSort);
    }

    // Аналогично можно реализовать функцию sortByY()
    // Вывод точек в сторку:
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < count(); i++) {
            s += "x = " + getX(i) + " ty = " + getY(i) + "\n";
        }
        return s + "\n";
    }

    // Тестируем сортировку на четырех точках:
    public void test() {
        addPoint(22, 45);
        addPoint(4, 11);
        addPoint(30, 5.5);
        addPoint(-2, 48);
        sortByX();
        System.out.println(this);
    }
}
