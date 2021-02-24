package validator;

/**
 * Интерфейс реализующий метод проверки
 * */
public interface Validator {

    /**
     * Метод для проверки праивльности значения
     *
     * @param epsilon       - точность с которой должно быть найдено решение
     * @param previousValue - текущее значение функции - f(Xn)
     * @param presentValue  - предыдущее значение функции - f(Xn-1)
     *
     * @return true - если найдено подхоядщее решение
     * */
    boolean isValid(double previousValue, double presentValue, double epsilon);
}
