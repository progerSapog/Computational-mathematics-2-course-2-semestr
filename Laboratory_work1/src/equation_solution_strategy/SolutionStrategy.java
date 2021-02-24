package equation_solution_strategy;

/**
 * Общий интерфейс всех стратегий решения.
 * */
public interface SolutionStrategy {

    /**
     * Метод для вызова той или иной стратегии решения.
     * Необходимо использовать массив значений с плавующей точкой, т.к.
     * для каждой стратегии использует разное кол-во значений.
     *
     * @param val1 -
     * @param val2 - */
    double getSolution(double val1, double val2);
}
