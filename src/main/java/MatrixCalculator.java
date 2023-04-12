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
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("Определитель матрицы " +
                    "нулевого порядка не может быть вычислен!");
        if (matrix[0].length != matrix.length)
            throw new IncompatibleMatrixOrder("Определитель не может быть вычислен у неквадратной матрицы!");

        int matrixOrder = matrix.length;
        double determinant = 0.0;

        if (matrix.length == 1)
            return matrix[0][0];
        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        for (int i = 0; i < matrixOrder; i++) {
            double[][] submatrix = new double[matrixOrder - 1][matrixOrder - 1];

            for (int j = 1; j < matrixOrder; j++) {
                for (int k = 0; k < matrixOrder; k++) {
                    if (k < i) {
                        submatrix[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        submatrix[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            determinant += Math.pow(-1, i) * matrix[0][i] * determinant(submatrix);
        }

        return determinant;
    }

    /**
     * Метод для транспонирования матрицы
     * @param matrix первый аргумент, матрица, содержащая вещественные числа
     * @return транспонированный первый аргумент
     */
    public double[][] transpose(double[][] matrix) throws ZeroOrderMatrixException {
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("Транспонирование " +
                    "матрицы нулевого порядка невозможно!");

        int rowsCount = matrix.length, columnsCount = matrix[0].length;
        double[][] transposedMatrix = new double[columnsCount][rowsCount];

        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }
}
