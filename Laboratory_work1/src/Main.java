import equation.NoLinearThirdDegreeEquation;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NoLinearThirdDegreeEquation equation = new NoLinearThirdDegreeEquation();

        //Проверка на уравнении, которое было сделано на практике
        double[] coefficients = {2.0 , (-3.0), (-12.0), (-5.0)};
//        double[] coefficients = {1.0 , 0.1, 0.4, (-1.2)};
        equation.setCoefficients(coefficients);

        System.out.printf("%.4f \n", equation.getValueAtX(5));
        System.out.printf("%.4f \n", equation.getFstDerivativeAtX(5));
        System.out.printf("%.4f \n", equation.getSecDerivativeAtX(5));

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Интервалы: ");
        List<List<Double>> intervals = equation.getIntervalsOfMonotony();
        System.out.println(intervals);
    }
}
