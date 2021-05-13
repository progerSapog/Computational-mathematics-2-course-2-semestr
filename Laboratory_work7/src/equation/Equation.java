package equation;

import java.util.List;

/**
 * Интерфейс реализующий основные методы уравнений любого вида.
 *
 * Общий вид уравнения:
 *      a*x^n + b*x^(n-1) + c*x^(n-1) + ... + d*x^0 = 0
 *
 * Содержит 4 метода необходимых для данной лабораторной работы:
 *  - задание коэффициентов уравнения
 *  - получение значения функции в точке
 *  - получение интервалов монотонности
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see FourthDegreePolynomial
 * */
public interface Equation
{
    /**
     * Метод для задания коэфициентов
     *
     * @param coefficients - массив коэфициентов при членах уравнения.
     * */
    void setCoefficients(double[] coefficients);

    /**
     * Метод для получение значения уравнения в заданной точке.
     *
     * @param x - точка, в которой необходимо получить значение функции.
     * @return значение функции в данной точке
     * */
    double getValueAtX(double x);

    /**
     * Метод для получения списка интервалов где функция меняет знак.
     *
     * @return список из чисел, которые составляют отрезки монотонности
     *         типа [i; i+1]
     * */
    List<List<Double>> getIntervals();

    /**
     * Метод вывода уравнения в консоль
     * */
    void printEquation();
}