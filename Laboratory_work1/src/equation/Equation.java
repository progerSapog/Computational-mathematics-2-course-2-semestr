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
 *  - получение значения первой производной в точке
 *  - получение значения второй производной в точке
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see NoLinearThirdDegreeEquation
 * */
public interface Equation {

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
     * Метод для получение значения первой производной при заданном x.
     *
     * @param x - точка, в которой необходимо получить значение первой производной.
     * @return значение первой производной в данной точке
     * */
    double getFstDerivativeAtX(double x);

    /**
     *
     *
     * @return */
    List<Double> getIntervalsOfMonotony();

    /**
     * Метод для получение значения первой производной в при заданном x.
     *
     * @param x - точка, в которой необходимо получить значение второй производной.
     * @return значение второй производной в данной точке
     * */
    double getSecDerivativeAtX(double x);
}
