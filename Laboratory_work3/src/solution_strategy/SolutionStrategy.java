package solution_strategy;

/**
 * Общий интерфейс всех стратегий решения.
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see LagrangianInterpolationEquidistantNodes
 * @see NewtonInterpolation
 * @see LagrangianInterpolationUnequallyNodes
 * */
public interface SolutionStrategy
{
    /**
     * Метод для вызова той или иной стратегии решения.
     *
     * @param coordinates   - двумерный массив значений [0][Xi] [1][Yi]
     * @param desiredValues - массив значений Xi, в которых необходимо найти значений функций
     *
     * @return массив значений, являющимися значениями функции в заданных точках.
     * */
    double[] getSolution(double[][] coordinates, double[] desiredValues);
}
