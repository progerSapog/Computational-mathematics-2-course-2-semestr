package equation_solution_strategy;

import function.Function;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс реализующий вычисление интеграла методом
 * средних прямоугольников.
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see SolutionStrategy
 * */
public class MediumRectangleMethod implements SolutionStrategy
{
    /**
     * Метод для вычисления значения интеграла
     * методом средних прямоугольников.
     *
     * @param function           - функция, для которой необходимо вычислить интеграл
     * @param a                  - нижний  предел интегрирования
     * @param b                  - верхний предел интегрирования
     * @param numberOfIterations - кол-во итераций
     * @return значение инетграла для данной функции.
     * */
    @Override
    public double getSolution(Function function, double a, double b, double numberOfIterations)
    {
        //Вычисляем величену шага h
        double h = (b - a)/numberOfIterations;

        //пеменная для хранения значения интеграла
        double res = 0.0;

        //Вычисляем сумму значений функции в промежутках
        for (int i = 0; i < numberOfIterations; i++)
        {
            //К результату прибавляем значение f(Xi-1/2)
            //Начальная точка a, последующие шаги вычисляются как: h * (i + 0.5)
            res += function.getValueAtX(a + h * (i + 0.5));
        }

        //Поскольку шаг равномерный, то просто домножаем результат на h
        res *= h;

        return res;
    }

    /**
     * Метод для вычисления значения погрешности при вычислении
     * интеграла методом средних прямгоугольников.
     *
     * @param function           - функция, для которой необходимо вычислить интеграл
     * @param a                  - нижний  предел интегрирования
     * @param b                  - верхний предел интегрирования
     * @param numberOfIterations - кол-во итераций
     * @return значение инетграла для данной функции.
     * */
    @Override
    public double getError(Function function, double a, double b, double numberOfIterations)
    {
        List<Double> yList = new LinkedList<>();

        //Вычисляем величену шага h
        double h = (b - a)/numberOfIterations;

        //Получаем список значений второй производной в промежутках
        for (int i = 0; i < numberOfIterations; i++)
        {
            //Получаем значения второй производной функциий в точках от a до b с шагом h
            yList.add(function.getSecDerivativeAtX(a + h * (i)));
        }

        //Находим максимальное значение второй производной на промежутке от a до b
        double error = Math.abs(Collections.max(yList));

        //Вычисляем погрешность: Rn = (b-a)/24 * h^2 * max(f''(x))
        error *= ((b - a) / 24.0) * h * h;

        return error;
    }

    /**
     * Конструктор без параметров.
     * */
    public MediumRectangleMethod()
    {
    }
}