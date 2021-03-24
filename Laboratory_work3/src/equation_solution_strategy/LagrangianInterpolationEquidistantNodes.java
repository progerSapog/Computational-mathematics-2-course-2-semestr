package equation_solution_strategy;

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
    public double[] getSolution(double[][] coordinates, double[] desiredValues) {
        return new double[0];
    }

    /**
     * Конструктор без параметров.
     * */
    public LagrangianInterpolationEquidistantNodes()
    {
    }
}
