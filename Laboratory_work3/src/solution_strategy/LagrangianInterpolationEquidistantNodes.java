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
