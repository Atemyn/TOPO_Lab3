import exceptions.IncompatibleMatrixOrder;
import exceptions.MatrixOperationException;
import exceptions.ZeroOrderMatrixException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private static final MatrixCalculator matrixCalculator = new MatrixCalculator();
    public static void main(String[] args) throws IOException, MatrixOperationException {
        int operation;

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

            switch (operation) {
                case 1:
                    executeAddOperation();
                    break;
                case 2:
                    executeMultiplyByNumberOperation();
                    break;
                case 3:
                    executeMultiplyByMatrixOperation();
                    break;
                case 4:
                    executeDeterminantOperation();
                    break;
                case 5:
                    executeTransposeOperation();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("��������� ����������� �� �������� ������� ��� ������� " + operation);
            }
        } while (operation != 0);
    }

    private static void executeAddOperation() throws IOException, IncompatibleMatrixOrder {
        int rowsCount = readMatrixRowsCount();
        int columnsCount = readMatrixColumnsCount();
        double[][] matrix1 = readMatrix(rowsCount, columnsCount);

        rowsCount = readMatrixRowsCount();
        columnsCount = readMatrixColumnsCount();
        double[][] matrix2 = readMatrix(rowsCount, columnsCount);

        double[][] resultMatrix = matrixCalculator.add(matrix1, matrix2);
        System.out.println("��������� �������� ���� ������: ");
        printMatrix(resultMatrix);
    }

    private static void executeMultiplyByNumberOperation() throws IOException {
        int rowsCount = readMatrixRowsCount();
        int columnsCount = readMatrixColumnsCount();
        double[][] matrix = readMatrix(rowsCount, columnsCount);

        System.out.print("������� �����, �� ������� ����� �������� �������: ");
        double number = Double.parseDouble(reader.readLine());

        double[][] resultMatrix = matrixCalculator.multiply(matrix, number);
        System.out.println("��������� ��������� ������� �� �����: ");
        printMatrix(resultMatrix);
    }

    private static void executeMultiplyByMatrixOperation() throws IOException {
        int rowsCount = readMatrixRowsCount();
        int columnsCount = readMatrixColumnsCount();
        double[][] matrix1 = readMatrix(rowsCount, columnsCount);

        rowsCount = readMatrixRowsCount();
        columnsCount = readMatrixColumnsCount();
        double[][] matrix2 = readMatrix(rowsCount, columnsCount);

        double[][] resultMatrix = matrixCalculator.multiply(matrix1, matrix2);
        System.out.println("��������� ��������� ���� ������: ");
        printMatrix(resultMatrix);
    }

    private static void executeDeterminantOperation() throws IOException, ZeroOrderMatrixException {
        int rowsCount = readMatrixRowsCount();
        int columnsCount = readMatrixColumnsCount();
        double[][] matrix = readMatrix(rowsCount, columnsCount);

        double determinant = matrixCalculator.determinant(matrix);
        System.out.format("������������ �������: %f\n", determinant);
    }

    private static void executeTransposeOperation() throws IOException, ZeroOrderMatrixException {
        int rowsCount = readMatrixRowsCount();
        int columnsCount = readMatrixColumnsCount();
        double[][] matrix = readMatrix(rowsCount, columnsCount);

        double[][] resultMatrix = matrixCalculator.transpose(matrix);
        System.out.println("����������������� �������: ");
        printMatrix(resultMatrix);
    }

    private static int readMatrixRowsCount() throws IOException {
        System.out.print("������� ���������� ����� �������: ");
        return Integer.parseInt(reader.readLine());
    }

    private static int readMatrixColumnsCount() throws IOException {
        System.out.print("������� ���������� �������� �������: ");
        return Integer.parseInt(reader.readLine());
    }

    private static double[][] readMatrix(int rowsCount, int columnsCount) throws IOException {
        double[][] matrix = new double[rowsCount][columnsCount];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                System.out.format("������� ������� ������� ��� ������� [%d][%d]: ", i + 1, j + 1);
                matrix[i][j] = Double.parseDouble(reader.readLine());
            }
        }
        System.out.println("������� �������: ");
        printMatrix(matrix);
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.format("%8.2f", element);
            }
            System.out.println();
        }
    }
}
