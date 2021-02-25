package equation_solution_strategy;

import equation.Equation;
import validator.Validator;

import java.util.List;

/**
 * Класс реализующий решение методом Ньютона (касательных).
 * Реализует интерфейс SolutionStrategy
 * */
public class NewtonSolution implements SolutionStrategy
{
    @Override
    public List<Double> getSolution(Equation equation, Validator validator)
    {
        return null;
    }

    /**
     * Конструктор без параметров.
     * */
    public NewtonSolution()
    {
    }
}
