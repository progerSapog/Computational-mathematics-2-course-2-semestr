import equation.NoLinearThirdDegreeEquation;

public class Main {
    public static void main(String[] args) {
        NoLinearThirdDegreeEquation equation = new NoLinearThirdDegreeEquation();

        double[] coeff = {1.0 , 0.1, 0.4, (-1.2)};

        equation.setCoefficients(coeff);

        System.out.printf("%.4f \n", equation.getValueAtPoint(5));
        System.out.printf("%.4f \n", equation.getFstDerivativeAtPoint(5));
        System.out.printf("%.4f \n", equation.getSecDerivativeAtPoint(5));
    }
}
