package solution_strategy;

import java.util.List;

/**
 * Общий интерфейс всех стратегий решения.
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see NewtonDerivatives
 * */
public interface SolutionStrategy
{
    /**
     * Метод для получения первой производной различными способами.
     *
     * @param coordinates   - двумерный массив значений [0][Xi] [1][Yi]
     * @return список значений производной в заданных точках.
     * */
    List<Double> getFirstDerivative(double[][] coordinates);

    /**
     * Метод для получения второй производной различными способами.
     *
     * @param coordinates   - двумерный массив значений [0][Xi] [1][Yi]
     * @return список значений производной в заданных точках.
     * */
    List<Double> getSecondDerivative(double[][] coordinates);
}
