package equation;

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
    public double getValueAtPoint(double x) {
        return getA()*Math.pow(x, 3) + getB()*Math.pow(x, 2) + getC()*x + getD();
    }

    /**
     * Метод для получение значения первой производной в заданной точке
     *
     * @param x - точка, в которой необходимо получить значение первой производной
     * @return значение первой производной в заданной точке
     * */
    @Override
    public double getFstDerivativeAtPoint(double x) {
        return 3*getA()*Math.pow(x,2) + 2*getB()*x + getC();
    }

    /**
     * Метод для получение значения первой производной в заданной точке
     *
     * @param x - точка, в которой необходимо получить значение второй производной
     * @return значение второй производной в заданной точке
     * */
    @Override
    public double getSecDerivativeAtPoint(double x) {
        return 6*getA()*x + 2*getB();
    }

    /**
     * Конуструктор без параметров
     * */
    public NoLinearThirdDegreeEquation() {
    }
}
