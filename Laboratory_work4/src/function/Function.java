package function;

/**
 * Интерфейс реализующий основные методы функций любого вида.
 *
 * Общий вид уравнения:
 *      a*x^n + b*x^(n-1) + c*x^(n-1) + ... + d*x^0 = 0
 *
 * Содержит 4 метода необходимых для данной лабораторной работы:
 *  - получение значения функции в точке
 *  - получение значения второй  производной в точке
 *  - получение значения третьей производной в точке
 *
 * @author Vladislav Sapozhnikov 19-IVT-3
 * @see TrigonometricFunction
 * */
public interface Function
{
    /**
     * Метод для получение значения функции в заданной точке.
     *
     * @param x - точка, в которой необходимо получить значение функции.
     * @return значение функции в данной точке
     * */
    double getValueAtX(double x);

    /**
     * Метод для получение значения второй производной в при заданном x.
     *
     * @param x - точка, в которой необходимо получить значение второй производной.
     * @return значение второй производной в данной точке
     * */
    double getSecDerivativeAtX(double x);

    /**
     * Метод для получение значения третьей производной в при заданном x.
     *
     * @param x - точка, в которой необходимо получить значение третьей производной.
     * @return значение третьей производной в данной точке
     * */
    double getThirdDerivativeAtX(double x);


}
