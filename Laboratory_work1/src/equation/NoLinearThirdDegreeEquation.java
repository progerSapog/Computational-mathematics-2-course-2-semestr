package equation;

import java.util.*;

/**
 * Класс Нелинейных уравнений третьей степени.
 * Реализует интерфейс Equation
 * */
public class NoLinearThirdDegreeEquation implements Equation {

    private double a;   //коэффициент при x^3
    private double b;   //коэффициент при x^2
    private double c;   //коэффициент при x^1
    private double d;   //коэффициент при x^0

    /**
     * Метод для задания коэффициента при x^3.
     * Скрыт, т.к. использутеся в общем методе задания коэффициентов.
     *
     * @param a - значения коэфициента, которое необходимо установить.
     * */
    private void setA(double a) {
        this.a = a;
    }

    /**
     * Метод для задания коэффициента при x^2.
     * Скрыт, т.к. использутеся в общем методе задания коэффициентов.
     *
     * @param b - значения коэфициента, которое необходимо установить.
     * */
    private void setB(double b) {
        this.b = b;
    }

    /**
     * Метод для задания коэффициента при x^1.
     * Скрыт, т.к. использутеся в общем методе задания коэффициентов.
     *
     * @param c - значения коэфициента, которое необходимо установить.
     * */
    private void setC(double c) {
        this.c = c;
    }

    /**
     * Метод для задания коэффициента при x^0.
     * Скрыт, т.к. использутеся в общем методе задания коэффициентов.
     *
     * @param d - значения коэфициента, которое необходимо установить.
     * */
    private void setD(double d) {
        this.d = d;
    }

    /**
     * Метод для получения коэффициента при x^3.
     * */
    public double getA() {
        return a;
    }

    /**
     * Метод для получения коэффициента при x^2.
     * */
    public double getB() {
        return b;
    }

    /**
     * Метод для получения коэффициента при x^1.
     * */
    public double getC() {
        return c;
    }

    /**
     * Метод для получения коэффициента при x^0.
     * */
    public double getD() {
        return d;
    }

    /**
     * Общий метод для задания сразу всех коэффициентов уравнения.
     *
     * @param coefficients - массив коэффициентов, который необходимо установить
     * */
    @Override
    public void setCoefficients(double[] coefficients) {
        setA(coefficients[0]);
        setB(coefficients[1]);
        setC(coefficients[2]);
        setD(coefficients[3]);
    }

    /**
     * Метод для получение значения функции в заданной точке
     *
     * @param x - точка, в которой необходимо получить значение функции
     * @return значение функции в заданной точке
     * */
    @Override
    public double getValueAtX(double x) {
        return getA()*Math.pow(x, 3) + getB()*Math.pow(x, 2) + getC()*x + getD();
    }

    /**
     * Метод для получение значения первой производной при заданном x.
     *
     * @param x - точка, в которой необходимо получить значение первой производной
     * @return значение первой производной в заданной точке
     * */
    @Override
    public double getFstDerivativeAtX(double x) {
        return 3*getA()*Math.pow(x,2) + 2.0*getB()*x + getC();
    }

    /**
     * Метод для получение значения первой производной при заданном x.
     *
     * @param x - точка, в которой необходимо получить значение второй производной
     * @return значение второй производной в заданной точке
     * */
    @Override
    public double getSecDerivativeAtX(double x) {
        return 6.0*getA()*x + 2.0*getB();
    }

    /**
     * Метод для получения списка интервалов монотонности.
     *   1. Получение значений функции в промежутке от -100 до 100
     *   2. Выделение промежутков моноттности
     *
     * (К сожелению более адыкватного метода не нашлось)
     *
     * @return список из чисел, которые составляют отрезки монотонности
     *         типа [i; i+1]
     * */
    @Override
    public List<List<Double>> getIntervalsOfMonotony() {
        List<Double> xList = new LinkedList<>();
        List<Double> yList = new LinkedList<>();

        //Задаем интервал иксов от -100 до 100
        for (double i = -100.0; i <= 100; i++)
        {
            xList.add(i);
        }

        //Получаем значения функии в каждой точке интервала
        //от -100 до 100
        for (Double aDouble : xList) {
            yList.add(getValueAtX(aDouble));
        }

        //В коллекцию, которая может содержать только уникальные элементы
        //вносим значения при которых функция меняет знак
        Set<Double> uniqSet = new HashSet<>();
        for (int i = 0; i < yList.size() - 1; i++)
        {
            if (yList.get(i) * yList.get(i+1) < 0)
            {
                uniqSet.add(xList.get(i));
                uniqSet.add(xList.get(i+1));
            }
        }

        //Дублируем значения в промежуточный список и сортируем по возрастанию
        List<Double> newList = new LinkedList<>(uniqSet);
        Collections.sort(newList);

        //Попарно объединяем значения в интервалы
        List<List<Double>> cordList = new LinkedList<>();
        for (int i = 0; i < newList.size() - 1; i++)
        {
            List<Double> tempList = new LinkedList<>();
            if (Math.abs(newList.get(i) - newList.get(i + 1)) <= 1)
            {
                tempList.add(newList.get(i));
                tempList.add(newList.get(i + 1));
            }
            if (!tempList.isEmpty()) cordList.add(tempList);
        }

        return cordList;
    }

//    Похоже данный метод лишний
//    /**
//     * Методя для получения экстремумов первой производной
//     *
//     * @return массив иксов при которых находитяся экстремумы
//     * */
//    public List<Double> getExtremumOfFstDerivative() {
//        List<Double> xList = new LinkedList<>();
//
//        //Вычисление дискриминанта
//        double discriminant = ((Math.pow(3*getA(), 2))) - (4*(3.0*getA())*getC());
//
//        //Вычисление x1 и x2, т.к. ур-е первой производной от
//        //уравнения третьей степени является квадратным
//        double x1 = ((2.0*(-getB()) + Math.sqrt(discriminant))/(2.0*3.0*getA()));
//        double x2 = ((2.0*(-getB()) - Math.sqrt(discriminant))/(2.0*3.0*getA()));
//
//        if (x1 < x2)
//        {
//            xList.add(x1);
//            xList.add(x2);
//        }
//        else
//        {
//            xList.add(x2);
//            xList.add(x1);
//        }
//
//        return xList;
//    }

    /**
     * Конуструктор без параметров
     * */
    public NoLinearThirdDegreeEquation() {
    }
}
