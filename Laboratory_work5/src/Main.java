import solution_strategy.*;

import java.util.List;
import java.util.Scanner;

/**
 * Класс, содержащий точку входа в программу - метод  main.
 * Язык: java
 *
 * Реализация пятой лабораторной работы по диспилине: Вычислительная математика
 * Вариант №15
 *
 * Текст задания:
 *  Найти первую и вторую производную функции в точках х, заданных
 *  таблицей, используя интерполяционные многочлены Ньютона. Сравнить со
 *  значениями производных, вычисленными по формулам, основанным на
 *  интерполировании многочленом Лагранжа (вычисление производных через
 *  значения функций).
 *
 *            x        y
 *          3.50    33.1154
 *          3.55    34.8133
 *          3.60    36.5982
 *          3.65    38.4747
 *          3.70    40.4473
 *          3.75    42.5211
 *          3.80    44.7012
 *          3.85    46.9931
 *          3.90    49.4024
 *          3.95    51.9354
 *          4.00    54.5982
 *          4.05    57.3975
 *          4.10    60.3403
 *          4.15    63.4340
 *          4.20    66.6863
 *
 *
 * @release: -     06.04.21
 * @last_update: - 06.04.21
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 */
public class Main
{
    //Константы для хранения последовательностей для
    //изменения цвета текста в консоли
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";

    /**
     * Точка входа в программу
     * */
    public static void main(String[] args)
    {
        System.out.println("\t\t\t\tЛабораторная работа №5 <<" + PURPLE + "«Численное дифференцирование функций»" +
                RESET + ">>");

        //Открытие потока ввода
        Scanner scanner = new Scanner(System.in);

        //Таблица значений Вариант №15
        double[][] coordinates = {{3.50, 33.1154},
                                 {3.55, 34.8133},
                                 {3.60, 36.5982},
                                 {3.65, 38.4747},
                                 {3.70, 40.4473},
                                 {3.75, 42.5211},
                                 {3.80, 44.7012},
                                 {3.85, 46.9931},
                                 {3.90, 49.4024},
                                 {3.95, 51.9354},
                                 {4.00, 54.5982},
                                 {4.05, 57.3975},
                                 {4.10, 60.3403},
                                 {4.15, 63.4340},
                                 {4.20, 66.6863}};

//        double[][] coordinates = {{0.01, 0.991824},
//                {0.06, 0.951935},
//                {0.11, 0.913650},
//                {0.16, 0.876905},
//                {0.21, 0.841638},
//                {0.26, 0.807789},
//                {0.31, 0.775301},
//                {0.36, 0.744120},
//                {0.41, 0.714193},
//                {0.46, 0.685470},
//                {0.51, 0.657902},
//                {0.56, 0.631442}};

//        double[][] coordinates = {{0.0, 1.2833},
//                {0.1, 1.8107},
//                {0.2, 2.3606},
//                {0.3, 2.9577},
//                {0.4, 3.5969},
//                {0.5, 4.2833}};

        //Создание ссылки на объект, реализующий интерфейс
        //SolutionStrategy
        SolutionStrategy strategy = null;

        //Переменная для хранения результата ввода
        String ch = "";

        System.out.println("Заданная таблица координат: ");
        printCoordinates(coordinates);

        //Выбор стратегии решения
        while (!ch.equals("q"))
        {
            System.out.println("Выберите метод:");
            System.out.println("\t1. Дифференцирование многочленом Ньютона");
            System.out.println();
            System.out.println("\tВведите q для выхода");
            System.out.print("Ввод: ");
            ch = scanner.nextLine();
            System.out.println();

            //Ввод с повторением
            switch (ch)
            {
                case ("1") -> strategy = new NewtonDerivativesFiveDifferences();
                case ("q") ->
                {
                    System.out.println(RED + "Завершение работы..." + RESET);
                    System.exit(0);
                }
                default -> System.out.println(RED + "Неверный ввод!" + RESET);
            }
            System.out.println();

            assert strategy != null;
            List<Double> firstDerivatives  = strategy.getFirstDerivative(coordinates);
            List<Double> secondDerivatives = strategy.getSecondDerivative(coordinates);

            System.out.println("Значения первой производной: ");
            for (int i = 0; i < coordinates.length; i++)
            {
                System.out.printf("%.2f", coordinates[i][0]);
                System.out.print(" | ");
                System.out.printf("%.4f", firstDerivatives.get(i));
                System.out.println();
            }
            System.out.println();

            System.out.println("Значения второй производной: ");
            for (int i = 0; i < secondDerivatives.size(); i++)
            {
                System.out.printf("%.2f", coordinates[i][0]);
                System.out.print(" | ");
                System.out.printf("%.4f", secondDerivatives.get(i));
                System.out.println();
            }
        }
    }

    /**
     * Метод для вывода таблицы заданных точек.
     *
     * @param coordinates   - двумерный массив значений [0][Xi] [1][Yi]
     * */
    public static void printCoordinates(double[][] coordinates)
    {
        System.out.println("     f(x)");
        System.out.println("  Xi |  =  Yi");
        for (double[] coordinate : coordinates)
        {
            System.out.printf("%.2f", coordinate[0]);
            System.out.print(" | ");
            System.out.printf("%.4f", coordinate[1]);
            System.out.println();
        }
        System.out.println();
    }
}
