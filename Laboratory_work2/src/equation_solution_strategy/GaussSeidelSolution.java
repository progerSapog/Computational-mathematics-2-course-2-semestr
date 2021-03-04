package equation_solution_strategy;

import equation.SystemOfEquations;
import validator.Validator;

/**
 * Класс реализующий решение методом Гаусса-Зейделя
 * Реализует интерфейс SolutionStrategy
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see SolutionStrategy
 * */
public class GaussSeidelSolution implements SolutionStrategy
{
    /**
     * Метод для получения решений методом Гаусса-Зейделя
     *
     * @param system    - система, которую необходимо решить
     * @param validator - валидатор, с заданным параметром проверки
     * @return список значений, являющимися решениями данной системы уравнений.
     * */
    @Override
    public double[] getSolution(SystemOfEquations system, Validator validator)
    {
        return null;
    }

    /**
     * Конструктор без параметров.
     * */
    public GaussSeidelSolution()
    {
    }
}
