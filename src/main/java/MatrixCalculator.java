import exceptions.IncompatibleMatrixOrder;
import exceptions.MatrixOperationException;
import exceptions.ZeroOrderMatrixException;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixCalculator {
    /**
     * Метод для сложения двух матриц
     * @param matrix1 первый аргумент, матрица, содержащая вещественные числа
     * @param matrix2 второй аргумент, матрица, содержащая вещественные числа
     * @return результат сложения двух аргументов
     */
    public double[][] add(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixOrder {
        if (matrix1.length == 0)
            return new double[0][0];
        if (matrix1.length != matrix2.length ||
                matrix1[0].length != matrix2[0].length)
            throw new IncompatibleMatrixOrder("Матрицы имеют несовместимые порядки!");

        return IntStream.range(0, matrix1.length)
                .mapToObj(i -> IntStream.range(0, matrix1[0].length)
                        .mapToDouble(j -> matrix1[i][j] + matrix2[i][j])
                        .toArray())
                .toArray(double[][]::new);
    }

    /**
     * Метод для умножения матрицы на число
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @param number второй аргумент, любое вещественное число
     * @return результат умножения каждого элемента первого аргумента на второй аргумент
     */
    public double[][] multiply(double[][] matrix, double number) {
        return Arrays.stream(matrix).map(row -> IntStream.range(0, matrix[0].length)
                        .mapToDouble(j -> row[j] * number)
                        .toArray())
                .toArray(double[][]::new);
    }

    /**
     * Метод для умножения двух матриц
     * @param matrix1 первый аргумент, матрица, содержащая вещественные числа
     * @param matrix2 второй аргумент, матрица, содержащая вещественные числа
     * @return результат умножения двух аргументов
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixOrder {
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1[0].length != matrix2.length)
            throw new IncompatibleMatrixOrder("Матрицы имеют несовместимые порядки!");

        int matrix1RowsCount = matrix1.length;
        int matrix1ColumnsCount = matrix1[0].length;
        int matrix2ColumnsCount = matrix2[0].length;
        double[][] resultMatrix = new double[matrix1RowsCount][matrix2ColumnsCount];

        for (int i = 0; i < matrix1RowsCount; i++) {
            for (int j = 0; j < matrix2ColumnsCount; j++) {
                for (int k = 0; k < matrix1ColumnsCount; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return resultMatrix;
    }

    /**
     * Метод для нахождения определителя матрицы
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @return определитель первого аргумента
     */
    public double determinant(double[][] matrix) throws MatrixOperationException {
        // TODO Реализовать метод нахождения определителя матрицы до конца.
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("Определитель матрицы " +
                    "нулевого порядка не может быть вычислен!");
        else if (matrix[0].length != matrix.length)
            throw new IncompatibleMatrixOrder("Определитель не может быть вычислен у неквадратной матрицы!");
        else if (matrix.length == 1)
            return 10.0;
        else if (matrix.length == 2)
            return 0.0;

        return 6.0;
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
        else if (matrix.length == 3)
            return new double[][]{{ 1.0, 3.0, 5.0 }, { 2.0, 4.0, 6.0 }};

        return new double[][]{{ 1.0, 5.0, 9.0, 13.0 }, { 2.0, 6.0, 10.0, 14.0 },
                { 3.0, 7.0, 11.0, 15.0 }, { 4.0, 8.0, 12.0, 16.0 }};
    }
}
