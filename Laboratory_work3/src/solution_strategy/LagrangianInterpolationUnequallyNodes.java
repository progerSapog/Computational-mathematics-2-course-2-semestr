package solution_strategy;

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
    public double[] getSolution(double[][] coordinates, double[] desiredValues) {
        return new double[0];
    }

    /**
     * Конструктор без параметров.
     * */
    public LagrangianInterpolationUnequallyNodes()
    {
    }
}
