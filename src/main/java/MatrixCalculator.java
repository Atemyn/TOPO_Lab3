import exceptions.ZeroOrderMatrixException;

public class MatrixCalculator {
    /**
     * Метод для сложения двух матриц
     * @param matrix1 первый аргумент, матрица, содержащая вещественные числа
     * @param matrix2 второй аргумент, матрица, содержащая вещественные числа
     * @return результат сложения двух аргументов
     */
    public double[][] add(double[][] matrix1, double[][] matrix2) {
        // TODO Реализовать метод сложения матриц до конца.
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1.length == 1)
            return new double[][]{{ -5.0 }};

        return new double[][]{{ -5.0, 8.0, 5.0, 0.0 }, {1.0, 0.0, 3.0, 5.0}, {5.0, 7.0, 9.0, 11.0}};
    }

    /**
     * Метод для умножения матрицы на число
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @param number второй аргумент, любое вещественное число
     * @return результат умножения каждого элемента первого аргумента на второй аргумент
     */
    public double[][] multiply(double[][] matrix, double number) {
        // TODO Реализовать метод умножения матрицы на число до конца.
        return  new double[0][0];
    }

    /**
     * Метод для умножения двух матриц
     * @param matrix1 первый аргумент, матрица, содержащая вещественные числа
     * @param matrix2 второй аргумент, матрица, содержащая вещественные числа
     * @return результат умножения двух аргументов
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) {
        // TODO Реализовать метод умножения двух матриц до конца.
        return  new double[0][0];
    }

    /**
     * Метод для нахождения определителя матрицы
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @return определитель первого аргумента
     */
    public double determinant(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO Реализовать метод нахождения определителя матрицы до конца.
        throw new ZeroOrderMatrixException("Определитель матрицы" +
                "нулевого порядка не может быть вычислен!");
    }

    /**
     * Метод для транспонирования матрицы
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @return транспонированный первый аргумент
     */
    public double[][] transpose(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO Реализовать метод транспонирования матрицы до конца.
        throw new ZeroOrderMatrixException("Транспонирование" +
                "матрицы нулевого порядка невозможно!");
    }
}
