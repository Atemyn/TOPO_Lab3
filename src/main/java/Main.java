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
            System.out.println("Матричный калькулятор поддерживает следующие функции:");
            System.out.println("(1) - Сложение двух матриц");
            System.out.println("(2) - Умножение матрицы на число");
            System.out.println("(3) - Умножение матриц");
            System.out.println("(4) - Нахождение определителя матрицы");
            System.out.println("(5) - Транспонирование матрицы");
            System.out.println("(0) - Выход из программы");
            System.out.print("Введите цифру интересующего Вас варианта: ");
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
                    System.out.println("Матричный калькулятор не содержит функции под номером " + operation);
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
        System.out.println("Результат сложения двух матриц: ");
        printMatrix(resultMatrix);
    }

    private static void executeMultiplyByNumberOperation() throws IOException {
        int rowsCount = readMatrixRowsCount();
        int columnsCount = readMatrixColumnsCount();
        double[][] matrix = readMatrix(rowsCount, columnsCount);

        System.out.print("Введите число, на которое нужно умножить матрицу: ");
        double number = Double.parseDouble(reader.readLine());

        double[][] resultMatrix = matrixCalculator.multiply(matrix, number);
        System.out.println("Результат умножения матрицы на число: ");
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
        System.out.println("Результат умножения двух матриц: ");
        printMatrix(resultMatrix);
    }

    private static void executeDeterminantOperation() throws IOException, ZeroOrderMatrixException {
        int rowsCount = readMatrixRowsCount();
        int columnsCount = readMatrixColumnsCount();
        double[][] matrix = readMatrix(rowsCount, columnsCount);

        double determinant = matrixCalculator.determinant(matrix);
        System.out.format("Определитель матрицы: %f\n", determinant);
    }

    private static void executeTransposeOperation() throws IOException, ZeroOrderMatrixException {
        int rowsCount = readMatrixRowsCount();
        int columnsCount = readMatrixColumnsCount();
        double[][] matrix = readMatrix(rowsCount, columnsCount);

        double[][] resultMatrix = matrixCalculator.transpose(matrix);
        System.out.println("Транспонированная матрица: ");
        printMatrix(resultMatrix);
    }

    private static int readMatrixRowsCount() throws IOException {
        System.out.print("Введите количество строк матрицы: ");
        return Integer.parseInt(reader.readLine());
    }

    private static int readMatrixColumnsCount() throws IOException {
        System.out.print("Введите количество столбцов матрицы: ");
        return Integer.parseInt(reader.readLine());
    }

    private static double[][] readMatrix(int rowsCount, int columnsCount) throws IOException {
        double[][] matrix = new double[rowsCount][columnsCount];
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                System.out.format("Введите элемент матрицы под номером [%d][%d]: ", i + 1, j + 1);
                matrix[i][j] = Double.parseDouble(reader.readLine());
            }
        }
        System.out.println("Введена матрица: ");
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
