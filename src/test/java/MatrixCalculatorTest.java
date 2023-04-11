import exceptions.ZeroOrderMatrixException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixCalculatorTest {
    @Test
    void matrixCalculatorCreationTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertNotNull(matrixCalculator);
    }

    @Test
    void addMatricesZeroOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertArrayEquals(new double[0][0],
                matrixCalculator.add(new double[0][0], new double[0][0]));
    }

    @Test
    void addMatricesFirstOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 5.0 }}, secondMatrix = {{ -10.0 }},
        resultMatrix = {{ -5.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.add(firstMatrix, secondMatrix));
    }

    @Test
    void addMatrices3x4OrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 5.0, 2.0, 1.5, 7.89 }, { 9.0, -6.57, 2.5, 1.7 }, { 1.0, 2.0, 3.0, 4.0 }},
                secondMatrix = {{ -10.0, 6.0, 3.5, -7.89 }, { -8.0, 6.57, 0.5, 3.3 }, { 4.0, 5.0, 6.0, 7.0 }},
                resultMatrix = {{ -5.0, 8.0, 5.0, 0.0 }, { 1.0, 0.0, 3.0, 5.0 }, { 5.0, 7.0, 9.0, 11.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.add(firstMatrix, secondMatrix));
    }

    @Test
    void multiplyMatrixZeroOrderByNumberTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertArrayEquals(new double[0][0],
                matrixCalculator.multiply(new double[0][0], 5.0));
    }

    @Test
    void multiplyMatrixFirstOrderByNumberTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertArrayEquals(new double[][]{{ 15.0 }},
                matrixCalculator.multiply(new double[][]{{ 3.0 }}, 5.0));
    }

    @Test
    void multiplyMatrix2x4OrderByNumberTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] matrix = {{ 2.0, 4.0, 8.0, 16.0 }, { 32.0, 64.0, 128.0, 256.0 }},
                resultMatrix = {{ 4.0, 8.0, 16.0, 32.0 }, { 64.0, 128.0, 256.0, 512.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.multiply(matrix, 2.0));
    }

    @Test
    void multiplyMatricesZeroOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertArrayEquals(new double[0][0],
                matrixCalculator.multiply(new double[0][0], new double[0][0]));
    }

    @Test
    void multiplyMatricesFirstOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertArrayEquals(new double[][]{{ 18.0 }},
                matrixCalculator.multiply(new double[][]{{ 9.0 }}, new double[][]{{ 2.0 }}));
    }

    @Test
    void multiplyMatrices2x3OrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 5.0, 1.0, -3.0}, { 2.0, -8.0, 12.0 }},
                secondMatrix = {{ 2.0, 16.0 }, { 4.0, 32.0 }, { 8.0, 64.0 }},
                resultMatrix = {{ -10.0, -80.0 }, { 68.0, 544.0 }};
        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.multiply(firstMatrix, secondMatrix));
    }

    @Test
    void determinantZeroOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertThrows(ZeroOrderMatrixException.class,
                () -> matrixCalculator.determinant(new double[0][0]));
    }

    @Test
    void determinantFirstOrderTest() throws ZeroOrderMatrixException {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertEquals(10.0,
                matrixCalculator.determinant(new double[][]{{ 10.0 }}));
    }

    @Test
    void transposeZeroOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertThrows(ZeroOrderMatrixException.class,
                () -> matrixCalculator.transpose(new double[0][0]));
    }
}
