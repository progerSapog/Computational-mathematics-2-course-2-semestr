package validator;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Singleton класс реализующий интерфейс проверки Validator.
 * Проверяет решение на соответсвие критериям остановки.
 *
 * WARNING!!!
 *    Критерий остановки: найдено точное значение f(Xn) = 0 не используется
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see Validator
 * */
public class ResponseValidator implements Validator
{

    private static ResponseValidator instance;   //поля для хранения ссылки на единственный
                                                 //экземпляр класса

    private double epsilon;                      //поля для хранения значения с которым
                                                 //будет проводится сравнение

    /**
     * Проверка решение на соответсвие критериям остановки:
     *  - Максимум из поэлементных разностей двух векторов решений < ε
     *    max(|Xi^(k) - Xi^(k - 1)|) < ε
     *
     * @param prevValues    - предыдущее значение функции - f(Xn-1)
     * @param presentValues - текущее значение функции - f(Xn)
     * @return true - если найдено подхоядщее решение
     * */
    @Override
    public boolean isValid(double[] presentValues, double[] prevValues)
    {
        Double[] tempArr = new Double[presentValues.length - 1];

        for (int i = 0; i < presentValues.length - 1; i++)
        {
            tempArr[i] = Math.abs((presentValues[i] - prevValues[i]));
        }

        return Collections.max(Arrays.asList(tempArr)) < epsilon;
    }

    /**
     * Метод для получения едиснтвенного экземпляара класса.
     * Нам достаточно лишь одного экземпляара класса ResponseValidator
     * для вызова методов проверки
     *
     * @return ссылку на один единственный экземпляр класса
     * */
    public static ResponseValidator getInstance()
    {
        if (instance == null)
        {
            instance = new ResponseValidator();
        }

        return instance;
    }

    /**
     * Метод для установки параметра сравнений.
     *
     * @param epsilon - значения для сравнений
     * */
    @Override
    public void setParameter(double epsilon)
    {
        this.epsilon = epsilon;
    }

    /**
     * Приватный конструктор запрящает создание объекта из вне.
     * */
    private ResponseValidator()
    {
    }
}
