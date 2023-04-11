import exceptions.ZeroOrderMatrixException;

public class MatrixCalculator {
    /**
     * ����� ��� �������� ���� ������
     * @param matrix1 ������ ��������, �������, ���������� ������������ �����
     * @param matrix2 ������ ��������, �������, ���������� ������������ �����
     * @return ��������� �������� ���� ����������
     */
    public double[][] add(double[][] matrix1, double[][] matrix2) {
        // TODO ����������� ����� �������� ������ �� �����.
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1.length == 1)
            return new double[][]{{ -5.0 }};

        return new double[][]{{ -5.0, 8.0, 5.0, 0.0 }, { 1.0, 0.0, 3.0, 5.0 }, { 5.0, 7.0, 9.0, 11.0 }};
    }

    /**
     * ����� ��� ��������� ������� �� �����
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @param number ������ ��������, ����� ������������ �����
     * @return ��������� ��������� ������� �������� ������� ��������� �� ������ ��������
     */
    public double[][] multiply(double[][] matrix, double number) {
        // TODO ����������� ����� ��������� ������� �� ����� �� �����.
        if (matrix.length == 0)
            return new double[0][0];
        else if (matrix.length == 1)
            return new double[][]{{ 15.0 }};

        return new double[][]{{ 4.0, 8.0, 16.0, 32.0 }, { 64.0, 128.0, 256.0, 512.0 }};
    }

    /**
     * ����� ��� ��������� ���� ������
     * @param matrix1 ������ ��������, �������, ���������� ������������ �����
     * @param matrix2 ������ ��������, �������, ���������� ������������ �����
     * @return ��������� ��������� ���� ����������
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) {
        // TODO ����������� ����� ��������� ���� ������ �� �����.
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1.length == 1)
            return new double[][]{{ 18.0 }};

        return new double[][]{{ -10.0, -80.0 }, { 68.0, 544.0 }};
    }

    /**
     * ����� ��� ���������� ������������ �������
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @return ������������ ������� ���������
     */
    public double determinant(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO ����������� ����� ���������� ������������ ������� �� �����.
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("������������ ������� " +
                    "�������� ������� �� ����� ���� ��������!");
        else if (matrix.length == 1)
            return 10.0;

        return 0.0;
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

        return new double[][]{{ 1.0, 3.0, 5.0 }, { 2.0, 4.0, 6.0 }};
    }
}
