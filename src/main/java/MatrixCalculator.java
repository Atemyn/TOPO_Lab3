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
        return new double[0][0];
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
     * ����� ��� ��������� ���� ������
     * @param matrix ������ ��������, �������, ���������� ������������ �����
     * @return ������������ ������� ���������
     */
    public double determinant(double[][] matrix) throws ZeroOrderMatrixException {
        throw new ZeroOrderMatrixException("������������ �������" +
                "�������� ������� �� ����� ���� ��������!");
    }
}
