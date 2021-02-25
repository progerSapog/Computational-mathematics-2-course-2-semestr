package equation_solution_strategy;

import equation.Equation;
import validator.Validator;

import java.util.LinkedList;
import java.util.List;

/**
 * Класс реализующий решение методом Ньютона (касательных).
 * Реализует интерфейс SolutionStrategy
 * */
public class NewtonSolution implements SolutionStrategy
{
    @Override
    public List<Double> getSolution(Equation equation, Validator validator)
    {
        //список, в который будут заноится ответы
        List<Double> resList = new LinkedList<>();

        //Значение, для хранения X(i-1) - ответ полученный на пред. итерации
        //Изначально задается такое значение, которое не пройдет условие валидатора
        double prevValue;

        //Переменная для хранения значения Xi
        double xI;

        //Получение списка интервалов монотонности, которые содержат
        //решения
        List<List<Double>> intervals = equation.getIntervalsOfMonotony();

        //Проход по каждому интервалу [a;b]
        for (List<Double> interval: intervals)
        {
            prevValue = 0;
            xI = interval.get(1) - 0.001;

            while (!validator.isValid(prevValue, equation.getValueAtX((xI))))
            {
                prevValue = xI;
                xI -= (equation.getValueAtX(prevValue)/equation.getFstDerivativeAtX(prevValue));
            }

            resList.add(xI);
        }

            //Конец b интервала [a;b] неподвижен
        return resList;
    }

    /**
     * Конструктор без параметров.
     * */
    public NewtonSolution()
    {
    }
}
