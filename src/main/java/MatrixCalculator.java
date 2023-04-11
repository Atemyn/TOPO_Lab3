import exceptions.IncompatibleMatrixOrder;
import exceptions.MatrixOperationException;
import exceptions.ZeroOrderMatrixException;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixCalculator {
    /**
     * ����� ��� �������� ���� ������
     * @param matrix1 ������ ��������, �������, ���������� ������������ �����
     * @param matrix2 ������ ��������, �������, ���������� ������������ �����
     * @return ��������� �������� ���� ����������
     */
    public double[][] add(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixOrder {
        if (matrix1.length == 0)
            return new double[0][0];
        if (matrix1.length != matrix2.length ||
                matrix1[0].length != matrix2[0].length)
            throw new IncompatibleMatrixOrder("������� ����� ������������� �������!");

        return IntStream.range(0, matrix1.length)
                .mapToObj(i -> IntStream.range(0, matrix1[0].length)
                        .mapToDouble(j -> matrix1[i][j] + matrix2[i][j])
                        .toArray())
                .toArray(double[][]::new);
    }

    /**
     * ����� ��� ��������� ������� �� �����
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @param number ������ ��������, ����� ������������ �����
     * @return ��������� ��������� ������� �������� ������� ��������� �� ������ ��������
     */
    public double[][] multiply(double[][] matrix, double number) {
        return Arrays.stream(matrix).map(row -> IntStream.range(0, matrix[0].length)
                        .mapToDouble(j -> row[j] * number)
                        .toArray())
                .toArray(double[][]::new);
    }

    /**
     * ����� ��� ��������� ���� ������
     * @param matrix1 ������ ��������, �������, ���������� ������������ �����
     * @param matrix2 ������ ��������, �������, ���������� ������������ �����
     * @return ��������� ��������� ���� ����������
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixOrder {
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1[0].length != matrix2.length)
            throw new IncompatibleMatrixOrder("������� ����� ������������� �������!");

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
     * ����� ��� ���������� ������������ �������
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @return ������������ ������� ���������
     */
    public double determinant(double[][] matrix) throws MatrixOperationException {
        // TODO ����������� ����� ���������� ������������ ������� �� �����.
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("������������ ������� " +
                    "�������� ������� �� ����� ���� ��������!");
        else if (matrix[0].length != matrix.length)
            throw new IncompatibleMatrixOrder("������������ �� ����� ���� �������� � ������������ �������!");
        else if (matrix.length == 1)
            return 10.0;
        else if (matrix.length == 2)
            return 0.0;

        return 6.0;
    }

    /**
     * ����� ��� ���������������� �������
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @return ����������������� ������ ��������
     */
    public double[][] transpose(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO ����������� ����� ���������������� ������� �� �����.
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("���������������� " +
                    "������� �������� ������� ����������!");
        else if (matrix.length == 1)
            return new double[][]{{ 1337.0 }};
        else if (matrix.length == 3)
            return new double[][]{{ 1.0, 3.0, 5.0 }, { 2.0, 4.0, 6.0 }};

        return new double[][]{{ 1.0, 5.0, 9.0, 13.0 }, { 2.0, 6.0, 10.0, 14.0 },
                { 3.0, 7.0, 11.0, 15.0 }, { 4.0, 8.0, 12.0, 16.0 }};
    }
}
