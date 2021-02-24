package validator;

/**
 * Singleton класс реализующий интерфейс проверки Validator.
 * Проверяет решение на соответсвие критериям остановки.
 *
 * WARNING!!!
 *    Критерий остановки: найдено точное значение f(Xn) = 0 не используется
 * */
public class ResponseValidator implements Validator {

    private static ResponseValidator instance;   //поля для хранения ссылки на единственный
                                                 //экземпляр класса

    /**
     * Проверка решение на соответсвие критериям остановки:
     *  - Достигунта заданная точность |f(Xn)| < epsilon
     *  - Значение двух последних приближений отличается меньше, чем на epsilon
     *    |X(n-1) - X(n)| < epsilon
     *
     * @param epsilon       - точность с которой должно быть найдено решение
     * @param previousValue - текущее значение функции - f(Xn)
     * @param presentValue  - предыдущее значение функции - f(Xn-1)
     *
     * @return true - если найдено подхоядщее решение
     * */
    @Override
    public boolean isValid(double previousValue, double presentValue, double epsilon) {
        if (presentValue < epsilon) return true;
        else return (previousValue - presentValue) < epsilon;
    }

    /**
     * Метод для получения едиснтвенного экземпляара класса.
     * Нам достаточно лишь одного экземпляара класса ResponseValidator
     * для вызова методов проверки
     * */
    public static ResponseValidator getInstance() {
        if (instance == null) {
            instance = new ResponseValidator();
        }

        return instance;
    }

    /**
     * Приватный конструктор запрящает создание объекта из вне.
     * */
    private ResponseValidator() {
    }
}
