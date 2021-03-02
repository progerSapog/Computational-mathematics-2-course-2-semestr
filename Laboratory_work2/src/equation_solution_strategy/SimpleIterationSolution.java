package equation_solution_strategy;

import equation.SystemOfEquations;
import validator.Validator;

import java.util.List;

/**
 * Класс реализующий решение методом Простой итерации (метод Якоби).
 * Реализует интерфейс SolutionStrategy
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see SolutionStrategy
 * */
public class SimpleIterationSolution implements SolutionStrategy
{
    /**
     * Метод для получения решений методом Простой итерации (метод Якоби).
     *
     * @param system    - система, которую необходимо решить
     * @param validator - валидатор, с заданным параметром проверки
     * @return список значений, являющимися решениями данной системы уравнений.
     * */
    @Override
    public List<Double> getSolution(SystemOfEquations system, Validator validator)
    {
        return null;
    }

    /**
     * Конструктор без параметров.
     * */
    public SimpleIterationSolution()
    {
    }
}
