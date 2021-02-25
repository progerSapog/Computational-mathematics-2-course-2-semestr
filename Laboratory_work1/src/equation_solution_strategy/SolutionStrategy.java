package equation_solution_strategy;

import equation.Equation;
import validator.Validator;

import java.util.List;

/**
 * Общий интерфейс всех стратегий решения.
 * */
public interface SolutionStrategy
{

    /**
     * Метод для вызова той или иной стратегии решения.
     * Необходимо использовать массив значений с плавующей точкой, т.к.
     * для каждой стратегии использует разное кол-во значений.
     * @param equation  - ур-ие, которое необходимо решить
     * @param validator - валидатор с заданным условием проверки
     * @return список значений, которые являются решениями данного
     *         ур-ия
     * */
    List<Double> getSolution(Equation equation, Validator validator);
}
