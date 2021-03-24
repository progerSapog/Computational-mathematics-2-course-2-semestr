package solution_strategy;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс реализующий решение при помощи интерполяционной формулы Ньютона
 * для равноотстоящих узлов
 *
 * Реализует интерфейс SolutionStrategy
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see SolutionStrategy
 * */
public class NewtonInterpolation implements SolutionStrategy
{
    /**
     * Вспомогательный метод для вывода конечных разностей i-ого порядка
     * в виде "лестничном виде"
     *
     * @param finiteDifferences - список списков конечных разностей
     * */
    private void printFiniteDifferences(List<List<Double>> finiteDifferences)
    {
        for (int i = 0; i < finiteDifferences.size(); i++)
        {
            //Если выводимое число будет меньше 10, то задаем дополнительный пробел
            //перед его выводом для равномерного отображения в консоли
            if (i < 9)
            {
                System.out.print("Конечные разности  " + (i+1) + " порядка: ");
            }
            else
            {
                System.out.print("Конечные разности " + (i+1) + " порядка: ");
            }

            for (int j = 0; j < finiteDifferences.get(i).size(); j++)
            {
                //Если число меньше 0 то выводим как оно есть,
                //иначе задаем дополнительный пробле для равномерного вывода в консоль
                if (finiteDifferences.get(i).get(j) < 0)
                {
                    System.out.printf("%.5f", finiteDifferences.get(i).get(j));
                }
                else
                {
                    System.out.printf(" %.5f", finiteDifferences.get(i).get(j));
                }
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    /**
     * Метод для приближенного вычисления значений
     * при помощи интерполяционной формулы Ньютона
     *
     * @param coordinates   - двумерный массив значений [0][Xi] [1][Yi]
     * @param desiredValues - массив значений Xi, в которых необходимо найти значений функций
     *
     * @return массив значений, являющимися значениями функции в заданных точках.
     * */
    @Override
    public double[] getSolution(double[][] coordinates, double[] desiredValues)
    {
        //Создание списка списков для хранения значений конченых разностей
        List<List<Double>> finiteDifferences = new LinkedList<>();

        //Ссылка на временный список для хранения промежуточных значений
        //конечных разностей
        List<Double> tempList;

        //В промежуточный список заносятся конечные разности 1-ого порядка
        tempList = new LinkedList<>();
        for (int i = 0; i < coordinates.length - 1; i++)
        {
            //Вычисление конечных разностей
            tempList.add(coordinates[i][1] - coordinates[i + 1][1]);
        }
        //промежуточный список ханосится в список списков кончеых разностей
        finiteDifferences.add(tempList);

        //На каждом i-ом шаге вычисляем значения конченых разностей нового порядка
        //и заносим в промежуточный список.
        //Полученный промежуточный список заносим в список списков промежуточных разностей
        for (int i = 0; i < coordinates.length-2; i++)
        {
            tempList = new LinkedList<>();    //инициализация промежуточного списка пустым списком
            for (int j = 0; j < finiteDifferences.get(i).size() - 1; j++)
            {
                //Вычисление конечных разностей
                tempList.add(finiteDifferences.get(i).get(j + 1) - finiteDifferences.get(i).get(j));
            }
            finiteDifferences.add(tempList);
        }

        //Вывод "лестницы" конечных разностей
        printFiniteDifferences(finiteDifferences);



        return new double[0];
    }

    /**
     * Конструктор без параметров.
     * */
    public NewtonInterpolation()
    {
    }
}
