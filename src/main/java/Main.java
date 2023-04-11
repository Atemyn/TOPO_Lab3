import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        var matrixCalculator = new MatrixCalculator();
        int operation = 0;

        do {
            System.out.println("��������� ����������� ������������ ��������� �������:");
            System.out.println("(1) - �������� ���� ������");
            System.out.println("(2) - ��������� ������� �� �����");
            System.out.println("(3) - ��������� ������");
            System.out.println("(4) - ���������� ������������ �������");
            System.out.println("(5) - ���������������� �������");
            System.out.println("(0) - ����� �� ���������");
            System.out.print("������� ����� ������������� ��� ��������: ");
            operation = Integer.parseInt(reader.readLine());

        } while (operation != 0);
    }

    private double[][] readMatrix(int rowsCount, int columnsCount) throws IOException {
        double[][] matrix = new double[rowsCount][columnsCount];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                System.out.format("������� ������� ������� ��� ������� [%d][%d]: ", i + 1, j + 1);
                matrix[i][j] = Double.parseDouble(reader.readLine());
            }
        }
        return matrix;
    }
}
