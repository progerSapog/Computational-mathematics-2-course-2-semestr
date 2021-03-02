package equation_solution_strategy;

import equation.SystemOfEquations;
import validator.Validator;

import java.util.List;

/**
 * Общий интерфейс всех стратегий решения.
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see GaussSolution
 * @see GaussSeidelSolution
 * @see SimpleIterationSolution
 * */
public interface SolutionStrategy
{
    /**
     * Метод для вызова той или иной стратегии решения.
     *
     * @param system    - система, которую необходимо решить
     * @param validator - валидатор, с заданным параметром проверки
     * @return список значений, являющимися решениями данной системы уравнений.
     * */
    List<Double> getSolution(SystemOfEquations system, Validator validator);
}
