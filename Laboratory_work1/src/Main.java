import equation.NoLinearThirdDegreeEquation;
import equation_solution_strategy.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        NoLinearThirdDegreeEquation equation = new NoLinearThirdDegreeEquation();
        Scanner scanner = new Scanner(System.in);

        //Проверка на уравнении, которое было сделано на практике
        double[] coefficients = {2.0 , (-3.0), (-12.0), (-5.0)};  //УДОЛИ
//        double[] coefficients = {1.0 , 0.1, 0.4, (-1.2)};         //УДОЛИ
        System.out.println("Программа для решения нелинейных уравнений 3ей степени.");
        System.out.println("\tОбщий вид таких уравнений: ");
        System.out.println("\t\ta*x^3 + b*x^2 + c*x + d = 0");
        System.out.println();

//        //Ввод коэффициентов уравнения
//        double[] coefficients = new double[4];
//        System.out.print("Введите коэффициент a: ");
//        coefficients[0] = scanner.nextDouble();
//        System.out.print("Введите коэффициент b: ");
//        coefficients[1] = scanner.nextDouble();
//        System.out.print("Введите коэффициент c: ");
//        coefficients[2] = scanner.nextDouble();
//        System.out.print("Введите коэффициент d: ");
//        coefficients[3] = scanner.nextDouble();

        //Запись введенных коэффициентов у равнение
        equation.setCoefficients(coefficients);

        //////////////////////УДОЛИ/////////////////////////////
        System.out.printf("%.4f \n", equation.getValueAtX(5));
        System.out.printf("%.4f \n", equation.getFstDerivativeAtX(5));
        System.out.printf("%.4f \n", equation.getSecDerivativeAtX(5));

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Интервалы: ");
        List<List<Double>> intervals = equation.getIntervalsOfMonotony();
        System.out.println(intervals);
        //////////////////////////УДОЛИ//////////////////////////////////
        SolutionStrategy strategy = null;

        String ch;
        ch = scanner.nextLine();

        //Выбор стратегии решения
        while (!ch.equals("q"))
        {
            System.out.println("Выберите метод для решения уранвения:");
            System.out.println("\t1. Метод биссекций");
            System.out.println("\t2. Метод хорд");
            System.out.println("\t3. Метод Ньютона");
            System.out.println("\t4. Метод простых итераций");
            System.out.println();
            System.out.println("\tВведите q для выхода");
            System.out.println();
            System.out.print("Ввод: ");
            ch = scanner.nextLine();
            System.out.println();

            switch (ch)
            {
                case ("1") -> strategy = new BisectionSolution();
                case ("2") -> strategy = new ChordSolution();
                case ("3") -> strategy = new NewtonSolution();
                case ("4") -> strategy = new SimpleIterationSolution();
                case ("q") -> {
                                   System.out.println("Завершение программы...");
                                   System.exit(0);
                              }
                default    -> System.out.println("Неверный ввод!");
            }

            //Создание пустого списка под ответы
            List<Double> answers = new LinkedList<>();

            //Засекаем время до начала решения
            double start = System.currentTimeMillis();
            for (List<Double> interval : intervals)
            {
                answers.add(strategy.getSolution(interval.get(0), interval.get(1)));
            }
            //Выводим получившиеся ответы
            System.out.println("Ответ: " + answers);

            //Засекаем время после конца решения
            double end   = System.currentTimeMillis();

            //Выводим затраченное время для данного решения
            System.out.println("Затраченное время: " + (end - start)/1000.0 + " секунд\n");
        }
    }
}
