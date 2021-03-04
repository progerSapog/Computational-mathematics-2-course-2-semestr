package equation_solution_strategy;

import equation.SystemOfEquations;
import validator.Validator;

/**
 * Класс реализующий решение методом Гаусса.
 * Реализует интерфейс SolutionStrategy
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see SolutionStrategy
 * */
public class GaussSolution implements SolutionStrategy
{
    /**
     * Метод для получения решений методом Гаусса.
     *
     * @param system    - система, которую необходимо решить
     * @param validator - валидатор, с заданным параметром проверки
     * @return список значений, являющимися решениями данной системы уравнений.
     * */
    @Override
    public double[] getSolution(SystemOfEquations system, Validator validator)
    {
        double[][] coefficients         = system.getCoefficients();    //получение коэфициентов Ann
        double[]   vectorB              = system.getVectorB();         //получение вектора b

        double[]   prevApproximation    = {0.0, 0.0, 0.0};             //инициализуем значения вектора
        //прошлый приближений нулями

        double[]   currentApproximation = new double[4];               //массив для хранения вектора текущих
        //приближений. В последний элемент записывается
        //кол-во итераций

        return null;
    }

    /**
     * Конструктор без параметров.
     * */
    public GaussSolution()
    {
    }
}
