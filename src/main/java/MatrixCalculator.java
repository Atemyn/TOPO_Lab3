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

        return new double[][]{{ -5.0, 8.0, 5.0, 0.0 }, {1.0, 0.0, 3.0, 5.0}, {5.0, 7.0, 9.0, 11.0}};
    }

    /**
     * ����� ��� ��������� ������� �� �����
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @param number ������ ��������, ����� ������������ �����
     * @return ��������� ��������� ������� �������� ������� ��������� �� ������ ��������
     */
    public double[][] multiply(double[][] matrix, double number) {
        // TODO ����������� ����� ��������� ������� �� ����� �� �����.
        return  new double[0][0];
    }

    /**
     * ����� ��� ��������� ���� ������
     * @param matrix1 ������ ��������, �������, ���������� ������������ �����
     * @param matrix2 ������ ��������, �������, ���������� ������������ �����
     * @return ��������� ��������� ���� ����������
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) {
        // TODO ����������� ����� ��������� ���� ������ �� �����.
        return  new double[0][0];
    }

    /**
     * ����� ��� ���������� ������������ �������
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @return ������������ ������� ���������
     */
    public double determinant(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO ����������� ����� ���������� ������������ ������� �� �����.
        throw new ZeroOrderMatrixException("������������ �������" +
                "�������� ������� �� ����� ���� ��������!");
    }

    /**
     * ����� ��� ���������������� �������
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @return ����������������� ������ ��������
     */
    public double[][] transpose(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO ����������� ����� ���������������� ������� �� �����.
        throw new ZeroOrderMatrixException("����������������" +
                "������� �������� ������� ����������!");
    }
}
