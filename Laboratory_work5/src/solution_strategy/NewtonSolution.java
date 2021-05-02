package solution_strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, в котором ерализованы методы нахождения
 * первых и вторых произовдных при помощи многочлена Ньютона
 * */
public class NewtonSolution implements SolutionStrategy
{
    /**
     * Метод для нахождения конечных приращений
     *
     * @param coordinates - массив координат для которого необходимо найти
     *                      конечные приращения
     * @return список списокв конечных приращений
     * */
    private List<List<Double>> getFiniteDifferences(double[][] coordinates)
    {
        //Создание списка списков для хранения значений конченых разностей
        List<List<Double>> finiteDifferences = new ArrayList<>();

        //Ссылка на временный список для хранения промежуточных значений
        //конечных разностей
        List<Double> tempList;

        //В промежуточный список заносятся конечные разности 1-ого порядка
        tempList = new ArrayList<>();
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
            tempList = new ArrayList<>();    //инициализация промежуточного списка пустым списком
            for (int j = 0; j < finiteDifferences.get(i).size() - 1; j++)
            {
                //Вычисление конечных разностей
                tempList.add(finiteDifferences.get(i).get(j + 1) - finiteDifferences.get(i).get(j));
            }
            finiteDifferences.add(tempList);
        }

        return finiteDifferences;
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

    /**
     * Метод для получения первых проиводных при помощи
     * многочлена Ньютона
     * */
    @Override
    public double[][] getFirstDerivative(double[][] coordinates)
    {
        //Вычисление шага
        double h = coordinates[1][0] - coordinates[0][0];
        double[][] resArr = new double[15][2];

        //Нахождение производных для первых 6ти членов
        //выделяем координаты необходимых точек
        double[][] tempArr = new double[6][2];
        for (int i = 0; i < 6; i++)
        {
            tempArr[i][0] = coordinates[i][0];
            tempArr[i][1] = coordinates[i][1];
        }
        //Получаем список конечных приращений
        List<List<Double>> finiteDifference = getFiniteDifferences(tempArr);

        //Расчет производных по формуле
        for (int i = 0; i < 6; i++)
        {
            double t = (coordinates[i][0] - coordinates[0][0]) / h;

            resArr[i][0] = coordinates[i][0];
            resArr[i][1] = (finiteDifference.get(0).get(0)
                    + ((2.0 * t - 1) * finiteDifference.get(1).get(0) / getFact(2))
                    + ((3.0*t*t - 6.0*t + 2) * finiteDifference.get(2).get(0) / getFact(3)
                    + ((4.0*t*t*t + 18.0*t*t + 22.0*t - 6.0) * finiteDifference.get(3).get(0)) / getFact(4))
                    + ((5.0*t*t*t*t - 40.0*t*t*t + 105.0*t*t -100.0*t +24.0) * finiteDifference.get(4).get(0) / getFact(5)))
                        / h;
        }

        //Нахождение производных для следующих 3 членов
        //выделяем координаты необходимых точек
        tempArr = new double[6][2];
        for (int i = 6, j = 0; i < 12; i++, j++)
        {
            tempArr[j][0] = coordinates[i][0];
            tempArr[j][1] = coordinates[i][1];
        }
        //Получаем список конечных приращений
        finiteDifference = getFiniteDifferences(tempArr);

        //Расчет производных по формуле
        for (int i = 6; i < 10; i++)
        {
            double t = (coordinates[i][0] - coordinates[6][0]) / h;

            resArr[i][0] = coordinates[i][0];
            resArr[i][1] = (finiteDifference.get(0).get(0)
                    + ((2.0 * t - 1) * finiteDifference.get(1).get(0) / getFact(2))
                    + ((3.0*t*t - 6.0*t + 2) * finiteDifference.get(2).get(0) / getFact(3)
                    + ((4.0*t*t*t + 18.0*t*t + 22.0*t - 6.0) * finiteDifference.get(3).get(0)) / getFact(4))
                    + ((5.0*t*t*t*t - 40.0*t*t*t + 105.0*t*t -100.0*t +24.0) * finiteDifference.get(4).get(0) / getFact(5)))
                    / h;
        }

        //Нахождение производных для последних 6ти членов
        //выделяем координаты необходимых точек
        tempArr = new double[6][2];
        for (int i = 9, j = 0; i < 15; i++, j++)
        {
            tempArr[j][0] = coordinates[i][0];
            tempArr[j][1] = coordinates[i][1];
        }
        //Получаем список конечных приращений
        finiteDifference = getFiniteDifferences(tempArr);


        //Расчет производных по формуле
        for (int i = 9; i < 15; i++)
        {
            double t = (coordinates[i][0] - coordinates[9][0]) / h;

            resArr[i][0] = coordinates[i][0];
            resArr[i][1] = (finiteDifference.get(0).get(0)
                    + ((2.0 * t - 1) * finiteDifference.get(1).get(0) / getFact(2))
                    + ((3.0*t*t - 6.0*t + 2) * finiteDifference.get(2).get(0) / getFact(3)
                    + ((4.0*t*t*t + 18.0*t*t + 22.0*t - 6.0) * finiteDifference.get(3).get(0)) / getFact(4))
                    + ((5.0*t*t*t*t - 40.0*t*t*t + 105.0*t*t -100.0*t +24.0) * finiteDifference.get(4).get(0) / getFact(5)))
                    / h;
        }

        return resArr;
    }

    @Override
    public double[][] getSecondDerivative(double[][] coordinates)
    {
        double h = coordinates[1][0] - coordinates[0][0];
        double[][] resArr = new double[15][2];


        double[][] tempArr = new double[6][2];
        for (int i = 0; i < 6; i++)
        {
            tempArr[i][0] = coordinates[i][0];
            tempArr[i][1] = coordinates[i][1];
        }
        List<List<Double>> finiteDifference = getFiniteDifferences(tempArr);
        for (int i = 0; i < 6; i++)
        {
            double t = (coordinates[i][0] - coordinates[0][0]) / h;

            resArr[i][0] = coordinates[i][0];
            resArr[i][1] = (finiteDifference.get(1).get(0)
                    + ((6.0 * t - 6.0) * finiteDifference.get(2).get(0) / getFact(3))
                    + ((12.0*t*t - 36.0*t + 22.0) * finiteDifference.get(3).get(0) / getFact(4)
                    + ((20.0*t*t*t - 120.0*t*t + 210.0*t - 100.0) * finiteDifference.get(4).get(0)) / getFact(5)))
                    / (h*h);
        }


        tempArr = new double[6][2];
        for (int i = 6, j = 0; i < 12; i++, j++)
        {
            tempArr[j][0] = coordinates[i][0];
            tempArr[j][1] = coordinates[i][1];
        }
        finiteDifference = getFiniteDifferences(tempArr);
        for (int i = 6; i < 10; i++)
        {
            double t = (coordinates[i][0] - coordinates[6][0]) / h;

            resArr[i][0] = coordinates[i][0];
            resArr[i][1] = (finiteDifference.get(1).get(0)
                    + ((6.0 * t - 6.0) * finiteDifference.get(2).get(0) / getFact(3))
                    + ((12.0*t*t - 36.0*t + 22.0) * finiteDifference.get(3).get(0) / getFact(4)
                    + ((20.0*t*t*t - 120.0*t*t + 210.0*t - 100.0) * finiteDifference.get(4).get(0)) / getFact(5)))
                    / (h*h);
        }


        tempArr = new double[6][2];
        for (int i = 9, j = 0; i < 15; i++, j++)
        {
            tempArr[j][0] = coordinates[i][0];
            tempArr[j][1] = coordinates[i][1];
        }
        finiteDifference = getFiniteDifferences(tempArr);
        for (int i = 9; i < 15; i++)
        {
            double t = (coordinates[i][0] - coordinates[9][0]) / h;

            resArr[i][0] = coordinates[i][0];
            resArr[i][1] = (finiteDifference.get(1).get(0)
                    + ((6.0 * t - 6.0) * finiteDifference.get(2).get(0) / getFact(3))
                    + ((12.0*t*t - 36.0*t + 22.0) * finiteDifference.get(3).get(0) / getFact(4)
                    + ((20.0*t*t*t - 120.0*t*t + 210.0*t - 100.0) * finiteDifference.get(4).get(0)) / getFact(5)))
                    / (h*h);
        }

        return resArr;
    }
}

//    private void printFiniteDifferences(List<List<Double>> finiteDifferences)
//    {
//        for (int i = 0; i < finiteDifferences.size(); i++)
//        {
//            //Если выводимое число будет меньше 10, то задаем дополнительный пробел
//            //перед его выводом для равномерного отображения в консоли
//            if (i < 9)
//            {
//                System.out.print("Конечные разности  " + (i+1) + " порядка: ");
//            }
//            else
//            {
//                System.out.print("Конечные разности " + (i+1) + " порядка: ");
//            }
//
//            for (int j = 0; j < finiteDifferences.get(i).size(); j++)
//            {
//                //Если число меньше 0 то выводим как оно есть,
//                //иначе задаем дополнительный пробле для равномерного вывода в консоль
//                if (finiteDifferences.get(i).get(j) < 0)
//                {
//                    System.out.printf("%.5f", finiteDifferences.get(i).get(j));
//                }
//                else
//                {
//                    System.out.printf(" %.5f", finiteDifferences.get(i).get(j));
//                }
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//    }