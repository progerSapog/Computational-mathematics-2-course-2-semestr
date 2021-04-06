package solution_strategy;

import java.util.ArrayList;
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
public class NewtonDerivativesFiveDifferences implements SolutionStrategy
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
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * Вспомогательный метод для получения факториала
     *
     * @param n - число от которого необходимо получить факториал
     *
     * @return - факториал переданного числа
     * */
    private int getFact(int n)
    {
        int res = 1;

        while (n > 1)
        {
            res *= n;
            n--;
        }

        return res;
    }

    private List<List<Double>> getFiniteDifferences(double[][] coordinates)
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
            tempList.add(coordinates[i + 1][1] - coordinates[i][1]);
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

        return finiteDifferences;
    }

    @Override
    public List<Double> getFirstDerivative(double[][] coordinates)
    {
        //Получение конечных разностей и их вывод
        List<List<Double>> finiteDifferencesList = getFiniteDifferences(coordinates);

        List<Double> resList = new ArrayList<>();

        //Вычисление шага h
        double h = coordinates[1][0] - coordinates[0][0];
        double t;
        double res;

        for (int i = coordinates.length - 1; i >= 0; i--)
        {
            t    = (coordinates[i][0] - coordinates[0][0]) / h;
            res  = finiteDifferencesList.get(0).get(0);

            res += ((2.0 * t - 1.0) * finiteDifferencesList.get(1).get(0) / getFact(2)) ;
            res += ((3.0 * t*t - 6.0 * t + 2.0)  * finiteDifferencesList.get(2).get(0) / getFact(3));
            res += ((4.0 * t*t*t - 18.0 * t*t + 22.0 * t - 6.0) * finiteDifferencesList.get(3).get(0) / getFact(4));
            res += ((5.0 * t*t*t*t - 40.0 * t*t*t + 105.0 * t*t - 100.0 * t + 24.0)  * finiteDifferencesList.get(4).get(0) / getFact(5));

            res = res / h;
            resList.add(res);
        }

        return resList;
    }

    @Override
    public List<Double> getSecondDerivative(double[][] coordinates)
    {
        //Получение конечных разностей и их вывод
        List<List<Double>> finiteDifferencesList = getFiniteDifferences(coordinates);
        printFiniteDifferences(finiteDifferencesList);

        List<Double> resList = new ArrayList<>();

        //Вычисление шага h
        double h = coordinates[1][0] - coordinates[0][0];
        double t;
        double res;

        for (int i = 0; i < coordinates.length; i++)
        {
            t    = (coordinates[i][0] - coordinates[0][0]) / h;
            res  = finiteDifferencesList.get(1).get(0);

            res += ((6.0 * t - 6.0) * finiteDifferencesList.get(2).get(0)) / getFact(3);
            res += ((12.0 * t*t - 36.0 * t + 22.0) * finiteDifferencesList.get(3).get(0)) / getFact(4);
            res += ((20.0 * t*t*t - 120.0 * t*t + 210.0 * t -100) * finiteDifferencesList.get(4).get(0)) / getFact(5);
            res /= (h *h);
            resList.add(res);
        }

        return resList;
    }

    /**
     * Конструктор без параметров.
     * */
    public NewtonDerivativesFiveDifferences()
    {
    }
}
