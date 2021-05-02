import solution_strategy.*;

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
    public static final String PURPLE = "\u001B[35m";

    /**
     * Точка входа в программу
     * */
    public static void main(String[] args) {
        System.out.println("\t\t\t\tЛабораторная работа №5 <<" + PURPLE + "«Численное дифференцирование функций»" +
                RESET + ">>");

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

        double[] xCoordinates = {3.50, 3.55, 3.60, 3.65, 3.70, 3.75, 3.80, 3.85, 3.90, 3.95, 4.00, 4.05, 4.10, 4.15, 4.20};


        double[] yCoordinates = {33.1154, 34.8133, 36.5982, 38.4747, 40.4473, 42.5211, 44.7012, 46.9931, 49.4024, 51.9354, 54.5982, 57.3975, 60.3403, 63.4340,
                66.6863};

//        System.out.println("Первые производные при помощи разностных формул: ");
//        double[][] resArr1 = new DifferenceForm().getFirstDerivative(coordinates);
//        for (int i = 0; i < resArr1.length; i++)
//        {
//            System.out.printf("%.2f", resArr1[i][0]);
//            System.out.print("  ");
//            System.out.printf("%.4f", resArr1[i][1]);
//            System.out.println();
//        }
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//
//        System.out.println("Вторые производные при помощи разностных формул: ");
//        double[][] resArr2 = new DifferenceForm().getSecondDerivative(coordinates);
//        for (int i = 0; i < resArr2.length; i++)
//        {
//            System.out.printf("%.2f", resArr2[i][0]);
//            System.out.print("  ");
//            System.out.printf("%.4f", resArr2[i][1]);
//            System.out.println();
//        }

        System.out.println("Первые производные при помощи разностных формул: ");
        double[][] resArr1 = new NewtonSolution().getFirstDerivative(coordinates);
        for (int i = 0; i < resArr1.length; i++)
        {
            System.out.printf("%.2f", resArr1[i][0]);
            System.out.print("  ");
            System.out.printf("%.4f", resArr1[i][1]);
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Вторые производные при помощи разностных формул: ");
        double[][] resArr2 = new NewtonSolution().getSecondDerivative(coordinates);
        for (int i = 0; i < resArr2.length; i++)
        {
            System.out.printf("%.2f", resArr2[i][0]);
            System.out.print("  ");
            System.out.printf("%.4f", resArr2[i][1]);
            System.out.println();
        }
    }
}
