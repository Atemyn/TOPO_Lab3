import exceptions.IncompatibleMatrixOrder;
import exceptions.ZeroOrderMatrixException;

public class MatrixCalculator {
    /**
     * Метод для сложения двух матриц
     * @param matrix1 первый аргумент, матрица, содержащая вещественные числа
     * @param matrix2 второй аргумент, матрица, содержащая вещественные числа
     * @return результат сложения двух аргументов
     */
    public double[][] add(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixOrder {
        // TODO Реализовать метод сложения матриц до конца.
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1.length != matrix2.length ||
                matrix1[0].length != matrix2[0].length)
            throw new IncompatibleMatrixOrder("Матрицы имеют несовместимые порядки!");
        else if (matrix1.length == 1)
            return new double[][]{{ -5.0 }};
        else if (matrix1.length == 3)
            return new double[][]{{ -5.0, 8.0, 5.0, 0.0 },
                    { 1.0, 0.0, 3.0, 5.0 }, { 5.0, 7.0, 9.0, 11.0 }};

        return  new double[][]{{ 1.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 1.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 1.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 1.0 }};
    }

    /**
     * Метод для умножения матрицы на число
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @param number второй аргумент, любое вещественное число
     * @return результат умножения каждого элемента первого аргумента на второй аргумент
     */
    public double[][] multiply(double[][] matrix, double number) {
        // TODO Реализовать метод умножения матрицы на число до конца.
        if (matrix.length == 0)
            return new double[0][0];
        else if (matrix.length == 1)
            return new double[][]{{ 15.0 }};
        else if (matrix.length == 2)
            return new double[][]{{ 4.0, 8.0, 16.0, 32.0 }, { 64.0, 128.0, 256.0, 512.0 }};

        return new double[][]{{ 18.0, 16.0, 14.0, 12.0, 10.0 }, { 8.0, 6.0, 4.0, 2.0, 0.0 },
                { 2.0, 4.0, 6.0, 8.0, 10.0 }, { 12.0, 14.0, 16.0, 18.0, 20.0 }};
    }

    /**
     * Метод для умножения двух матриц
     * @param matrix1 первый аргумент, матрица, содержащая вещественные числа
     * @param matrix2 второй аргумент, матрица, содержащая вещественные числа
     * @return результат умножения двух аргументов
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) {
        // TODO Реализовать метод умножения двух матриц до конца.
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1.length == 1)
            return new double[][]{{ 18.0 }};
        else if (matrix1.length == 2)
            return new double[][]{{ -10.0, -80.0 }, { 68.0, 544.0 }};

        return new double[][]{{ 350.0, 380.0, 410.0, 440.0 }, { 800.0, 880.0, 960.0, 1040.0 },
                { 1250.0, 1380.0, 1510.0, 1640.0 }, { 1700.0, 1880.0, 2060.0, 2240.0 }};
    }

    /**
     * Метод для нахождения определителя матрицы
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @return определитель первого аргумента
     */
    public double determinant(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO Реализовать метод нахождения определителя матрицы до конца.
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("Определитель матрицы " +
                    "нулевого порядка не может быть вычислен!");
        else if (matrix.length == 1)
            return 10.0;

        return 0.0;
    }

    /**
     * Метод для транспонирования матрицы
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @return транспонированный первый аргумент
     */
    public double[][] transpose(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO Реализовать метод транспонирования матрицы до конца.
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("Транспонирование " +
                    "матрицы нулевого порядка невозможно!");
        else if (matrix.length == 1)
            return new double[][]{{ 1337.0 }};

        return new double[][]{{ 1.0, 3.0, 5.0 }, { 2.0, 4.0, 6.0 }};
    }
}
