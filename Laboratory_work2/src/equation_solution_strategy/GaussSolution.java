package equation_solution_strategy;

import equation.SystemOfEquations;
import validator.Validator;

import java.util.LinkedList;
import java.util.List;

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
    public List<Double> getSolution(SystemOfEquations system, Validator validator)
    {
        return null;
    }

    /**
     * Конструктор без параметров.
     * */
    public GaussSolution()
    {
    }
}
