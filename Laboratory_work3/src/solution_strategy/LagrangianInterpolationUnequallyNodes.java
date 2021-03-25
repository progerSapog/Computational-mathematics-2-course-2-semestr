package solution_strategy;

import java.util.List;

/**
 * Класс реализующий решение методом Простой итерации (метод Якоби).
 * Реализует интерфейс SolutionStrategy
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see SolutionStrategy
 * */
public class LagrangianInterpolationUnequallyNodes implements SolutionStrategy
{
    @Override
    public List<Double> getSolution(double[][] coordinates, double[] desiredValues) {
        return null;
    }

    /**
     * Конструктор без параметров.
     * */
    public LagrangianInterpolationUnequallyNodes()
    {
    }
}
