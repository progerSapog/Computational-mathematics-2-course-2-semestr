package equation_solution_strategy;

import function.Function;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
* Класс реализующий вычисление интеграла методом
* трапеций.
*
* @author Vladislav Sapozhnikov 19-IVT-3
* @see SolutionStrategy
* */
public class SimpsonMethod implements SolutionStrategy
{
    /**
     * Метод для вычисления значения интеграла
     * методом Симпсона.
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

        //Переменная для хранения суммы нечетных y
        double evenY = 0.0;

        //Переменная для хранения суммы четных y
        double oddY  = 0.0;

        //Вычисление суммы y1 + y3 + ... + yn-1
        for (int i = 1; i < numberOfIterations; i++)
        {
            if (i % 2 != 0) oddY  += function.getValueAtX(a + i*h);
        }

        //Вычисление суммы y2 + y4 + ... + yn-2
        for (int i = 2; i < (numberOfIterations - 1); i++)
        {
            if (i % 2 == 0) evenY += function.getValueAtX(a + i*h);
        }

        //Возвращение результата
        // h/3(y0 + 4*(y1 + y3 + ... + yn-1) + 2*(y2 + y4 + ... + yn-2) - yn)
        return (h / 3.0) * (function.getValueAtX(a) + 4.0 * oddY + 2.0 * evenY + function.getValueAtX(b));
    }

    /**
     * Метод для вычисления значения погрешности при вычислении
     * интеграла методом Симсона.
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

        //Вычисляем значения второй производной в промежутках
        for (int i = 0; i < numberOfIterations; i++)
        {
            //Получаем значения второй производной функциий в точках от a до b с шагом h
            yList.add(function.getThirdDerivativeAtX(a + h * (i)));
        }

        //Находим максимальное значение второй производной на промежутке от a до b
        double error = Math.abs(Collections.max(yList));

        //Вычисляем погрешность: Rn = (b-a)/24 * h^2 * max(f''(x))
        error *= ((b - a) / 288.0) * h * h * h;

        return error;
    }

    /**
     * Конструктор без параметров.
     * */
    public SimpsonMethod()
    {
    }
}
