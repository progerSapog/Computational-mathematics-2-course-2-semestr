import equation.NoLinearThirdDegreeEquation;
import equation_solution_strategy.BisectionSolution;

import java.util.Arrays;
import java.util.List;

public class Main
{
    public static double[] multiplyMatrixByVector(double[][] matrix, double[] vector)
    {
        double[] result = new double[vector.length];

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    public static double[] gauss(double[][] matrix, double[] vectorB)
    {
        double[][] tempMatrix  = new double[4][4];
        double[]   tempVectorB = new double[4];
        double[] result        = new double[4];

        for (int i = 0; i < matrix.length; i++)
        {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, matrix[i].length);
        }
        System.arraycopy(vectorB, 0, tempVectorB, 0, vectorB.length);

        //Умножим первую строку на (-1.144565):
        for (int i = 0; i < tempMatrix.length; i++)
        {
            tempMatrix[0][i] *= -1.145;
        }
        tempVectorB[0] *= -1.144565;

        //Добавим 2-ю строку к 1ой:
        for (int i = 0; i < tempMatrix.length; i++)
        {
            tempMatrix[0][i] += tempMatrix[1][i];
        }
        tempVectorB[0] += tempVectorB[1];
        //   0   1.178  0.627    1   | 1.933
        //   0   -0.63 -0.939 -0.719 | -6.103
        // 21.35  4.5   0.5      0   | -100.658
        // 25.238 5.77  1.2      0   | -112.596


        //Умножим 2-ю строку на -0,719485
        for (int i = 0; i < tempMatrix.length; i++)
        {
            tempMatrix[1][i] *= -0.719485;
        }
        tempVectorB[1] *= -0.719485;

        //Добавим 3-ю строку ко второй
        for (int i =0; i < tempMatrix.length; i++)
        {
            tempMatrix[1][i] += tempMatrix[2][i];
        }
        tempVectorB[1] += tempVectorB[2];
        //  0     1.78  0.627     1   |1.933
        //  0    -0.63  -0.939 -0.719 |-6.103
        // 21.35  4.5    0.5      0   | -100.658
        // 25.238 5.77   1.2      0   | -112.596


        //Умножим 3-ю строку на -1,182108
        for (int i = 0; i < tempMatrix.length; i++)
        {
            tempMatrix[2][i] *= -1.182108;
        }
        tempVectorB[2] *= -1.182108;

        //Добавим 4-ю строку к 3-й
        for (int i =0; i < tempMatrix.length; i++)
        {
            tempMatrix[2][i] += tempMatrix[3][i];
        }
        tempVectorB[2] += tempVectorB[3];
        //  0     1.78   0.627     1  |1.933
        //  0    -0.63  -0.939 -0.719 |-6.103
        //  0     0,451  0,609    0   | 6,393
        // 25.238 5.77   1.2      0   | -112.596


        //Умножим 1-ю строку на 0,534626
        for (int i = 0; i < tempMatrix.length; i++)
        {
            tempMatrix[0][i] *= 0.534626;
        }
        tempVectorB[0] *= 0.534626;

        //Добавим 2-ю строку к 1-й
        for (int i =0; i < tempMatrix.length; i++)
        {
            tempMatrix[0][i] += tempMatrix[1][i];
        }
        tempVectorB[0] += tempVectorB[1];
        //  0     1.78   0.627     1  |1.933
        //  0    -0.63  -0.939 -0.719 |-6.103
        //  0     0,451  0,609    0   | 6,393
        // 25.238 5.77   1.2      0   | -112.596


        //Умножим 2-ю строку на 0,715185
        for (int i = 0; i < tempMatrix.length; i++)
        {
            tempMatrix[1][i] *= 0.715185;
        }
        tempVectorB[1] *= 0.715185;

        //Добавим 3-ю строку к 2-й
        for (int i =0; i < tempMatrix.length; i++)
        {
            tempMatrix[1][i] += tempMatrix[2][i];
        }
        tempVectorB[1] += tempVectorB[2];
        //  0       0  -0.604  -0,185 |-5,07
        //  0       0  -0.0626 -0,515 |2,028
        //  0     0,451  0,609    0   | 6,393
        // 25.238 5.77   1.2      0   | -112.596


        //Умножим 1-ю строку на -0,103625
        for (int i = 0; i < tempMatrix.length; i++)
        {
            tempMatrix[0][i] *= -0.103625;
        }
        tempVectorB[0] *= -0.103625;

        //Добавим 2-ю строку к 1-й
        for (int i =0; i < tempMatrix.length; i++)
        {
            tempMatrix[0][i] += tempMatrix[1][i];
        }
        tempVectorB[0] += tempVectorB[1];
        //  0       0     0    0.495  |2.553
        //  0       0  -0.0626 -0,515 |2,028
        //  0     0,451  0,609    0   | 6,393
        // 25.238 5.77   1.2      0   | -112.596

        //x4 = 2.553/(-0.495)
        result[3] = tempVectorB[0]/tempMatrix[0][3];

        //x3 = [2.028 - (-0.515x4)]/0.451
        result[2] = (tempVectorB[1] - (tempMatrix[1][3] * result[3])) / tempMatrix[1][2];

        //x2 = [6.393 - (0.609x3)]/0.451
        result[1] = (tempVectorB[2] - (tempMatrix[2][2] * result[2])) / tempMatrix[2][1];

        //x1 = [-112.596-(5.77*x2 + 1.2x3)]/25.238
        result[0] = (tempVectorB[3] - (tempMatrix[3][1]*result[1] + tempMatrix[3][2]*result[2]))/tempMatrix[3][0];

        return result;
    }

    public static void main(String[] args)
    {
        double[] y0, y1, y2, y3, y4;

//        double[][] matrix = {{1.0, -1.0, -1.0, 2.0},
//                {2.0, 3.0,  0.0,  -4.0},
//                {1.0, 1.0, -2.0, -2.0},
//                {1.0, 1.0,  0.0, -1.0}};

        double[][] matrix = {{0.5, 1.2, 2.0, 1.0},
                {1.2, 2.0,  0.5,  1.2},
                {2.0, 0.5, 1.0, 0.5},
                {1.0, 1.2,  0.5, 1.6}};

//        y0 = new double[]{0.0, 0.0, 0.0, 1.0};
        y0 = new double[]{0.0, 1.0, 0.0, 0.0};

        System.out.println("Исходная матрица: ");
        System.out.println(Arrays.deepToString(matrix));
        System.out.println();

        System.out.println("Вектор y0: ");
        System.out.println(Arrays.toString(y0));

        y1 = multiplyMatrixByVector(matrix, y0);
        System.out.println("Вектор y1");
        System.out.println(Arrays.toString(y1));

        y2 = multiplyMatrixByVector(matrix, y1);
        System.out.println("Вектор y2");
        System.out.println(Arrays.toString(y2));

        y3 = multiplyMatrixByVector(matrix, y2);
        System.out.println("Вектор y3");
        System.out.println(Arrays.toString(y3));

        y4 = multiplyMatrixByVector(matrix, y3);
        System.out.println("Вектор y4");
        System.out.println(Arrays.toString(y4));


        double[][] tempMatrix = {{y3[0], y2[0], y1[0], y0[0]},
                {y3[1], y2[1], y1[1], y0[1]},
                {y3[2], y2[2], y1[2], y0[2]},
                {y3[3], y2[3], y1[3], y0[3]}};

        double[] tempVectorB = {-y4[0], -y4[1], -y4[2], -y4[3]};

        System.out.println(Arrays.toString(tempVectorB));
        System.out.println(Arrays.deepToString(tempMatrix));

        /** МЕТОД ГАУССА!!!!!!!!!*/

        System.out.println();
        System.out.println();
        System.out.println();
//        double[] p = {-1.0, -2.0, 3.0, -1.0};
        double[] p = {-5.1, 0.71, 9.97, -5.15};

        System.out.println("Вектор p (после метода гаусса): ");
        System.out.println(Arrays.toString(p));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("GAAAUUUUSSSS");
        double[] p2 = gauss(tempMatrix, tempVectorB);
        System.out.println(Arrays.toString(p2));

        NoLinearThirdDegreeEquation equation = new NoLinearThirdDegreeEquation();
        equation.setCoefficients(p2);

        List<Double> res = new BisectionSolution().getSolution(equation);
        System.out.println(res);

        double[] pp = {1.0, p2[0], p2[1], p2[2], p2[3]};
        double[] x1 = new double[4];
        double[] q = new double[5];
        q[0] = 1.0;

        System.out.println();
        System.out.println();
        System.out.println("QQQQQQQ");
        for (int j = 1, i = 0; i < p2.length; i++, j++)
        {
            q[j] = res.get(1)*q[j-1] + p2[i];
        }
        System.out.println(Arrays.toString(q));
        System.out.println();
        System.out.println();

        for (int j = 0; j < y3.length; j++)
        {
            y3[j] *= q[0];
        }
        System.out.println(Arrays.toString(y3));

        for (int j = 0; j < y3.length; j++)
        {
            y2[j] *= q[1];
        }
        System.out.println(Arrays.toString(y2));

        for (int j = 0; j < y3.length; j++)
        {
            y1[j] *= q[2];
        }
        System.out.println(Arrays.toString(y1));

        for (int j = 0; j < y3.length; j++)
        {
            y0[j] *= q[3];
        }
        System.out.println(Arrays.toString(y0));

        x1[0] = y0[0] + y1[0] + y2[0] + y3[0];
        x1[1] = y0[1] + y1[1] + y2[1] + y3[1];
        x1[2] = y0[2] + y1[2] + y2[2] + y3[2];
        x1[3] = y0[3] + y1[3] + y2[3] + y3[3];

        System.out.println(Arrays.toString(x1));
    }
}
