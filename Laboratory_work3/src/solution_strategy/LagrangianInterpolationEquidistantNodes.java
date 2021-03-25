package solution_strategy;

import java.util.List;

/**
 * Класс реализующий решение методом Гаусса.
 * Реализует интерфейс SolutionStrategy
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see SolutionStrategy
 * */
public class LagrangianInterpolationEquidistantNodes implements SolutionStrategy
{
    /**
     * Метод для приближенного вычисления значений
     * при помощи многочлена Лагранжа для неравноотстоящих узлов
     *
     * @param coordinates   - двумерный массив значений [0][Xi] [1][Yi]
     * @param desiredValues - массив значений Xi, в которых необходимо найти значений функций
     *
     * @return список значений функции в заданных точках.
     * */
    @Override
    public List<Double> getSolution(double[][] coordinates, double[] desiredValues) {
        return null;
    }

    /**
     * Конструктор без параметров.
     * */
    public LagrangianInterpolationEquidistantNodes()
    {
    }
}
