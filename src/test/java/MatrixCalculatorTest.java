import exceptions.IncompatibleMatrixOrder;
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
    void addMatricesZeroOrderTest() throws IncompatibleMatrixOrder {
        MatrixCalculator matrixCalculator = new MatrixCalculator();

        Assertions.assertArrayEquals(new double[0][0],
                matrixCalculator.add(new double[0][0], new double[0][0]));
    }

    @Test
    void addMatricesFirstOrderTest() throws IncompatibleMatrixOrder {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 5.0 }}, secondMatrix = {{ -10.0 }},
        resultMatrix = {{ -5.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.add(firstMatrix, secondMatrix));
    }

    @Test
    void addMatrices3x4OrderTest() throws IncompatibleMatrixOrder {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 5.0, 2.0, 1.5, 7.89 }, { 9.0, -6.57, 2.5, 1.7 }, { 1.0, 2.0, 3.0, 4.0 }},
                secondMatrix = {{ -10.0, 6.0, 3.5, -7.89 }, { -8.0, 6.57, 0.5, 3.3 }, { 4.0, 5.0, 6.0, 7.0 }},
                resultMatrix = {{ -5.0, 8.0, 5.0, 0.0 }, { 1.0, 0.0, 3.0, 5.0 }, { 5.0, 7.0, 9.0, 11.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.add(firstMatrix, secondMatrix));
    }

    @Test
    void addMatrices5x5OrderTest() throws IncompatibleMatrixOrder {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 9.0, 8.0, 7.0, 6.0, 5.0 }, { 4.0, 3.0, 2.0, 1.0, 0.0 }, { 1.0, 2.0, 3.0, 4.0, 5.0 },
                { 6.0, 7.0, 8.0, 9.0, 10.0 }, { 11.0, 12.0, 13.0, 14.0, 15.0 }},
                secondMatrix = {{ -8.0, -8.0, -7.0, -6.0, -5.0 }, { -4.0, -2.0, -2.0, -1.0, 0.0 }, { -1.0, -2.0, -2.0, -4.0, -5.0 },
                        { -6.0, -7.0, -8.0, -8.0, -10.0 }, { -11.0, -12.0, -13.0, -14.0, -14.0 }},
                resultMatrix = {{ 1.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 1.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 1.0, 0.0, 0.0 },
                        { 0.0, 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 1.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.add(firstMatrix, secondMatrix));
    }

    @Test
    void addMatricesIncompatibleOrdersTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 1.0, 3.0 }, { 2.0, 4.0 }},
                secondMatrix = {{ 5.0, 6.0 }, { 7.0, 8.0 }, { 9.0, 10.0 }};

        Assertions.assertThrows(IncompatibleMatrixOrder.class,
                () -> matrixCalculator.add(firstMatrix, secondMatrix));
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
    void multiplyMatrix4x5OrderByNumberTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] matrix = {{ 4.5, 4.0, 3.5, 3.0, 2.5 }, { 2.0, 1.5, 1.0, 0.5, 0.0 },
                { 0.5, 1.0, 1.5, 2.0, 2.5 }, { 3.0, 3.5, 4.0, 4.5, 5.0 }},
                resultMatrix = {{ 18.0, 16.0, 14.0, 12.0, 10.0 }, { 8.0, 6.0, 4.0, 2.0, 0.0 },
                        { 2.0, 4.0, 6.0, 8.0, 10.0 }, { 12.0, 14.0, 16.0, 18.0, 20.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.multiply(matrix, 4.0));
    }

    @Test
    void multiplyMatricesZeroOrderTest() throws IncompatibleMatrixOrder {
        MatrixCalculator matrixCalculator = new MatrixCalculator();

        Assertions.assertArrayEquals(new double[0][0],
                matrixCalculator.multiply(new double[0][0], new double[0][0]));
    }

    @Test
    void multiplyMatricesFirstOrderTest() throws IncompatibleMatrixOrder {
        MatrixCalculator matrixCalculator = new MatrixCalculator();

        Assertions.assertArrayEquals(new double[][]{{ 18.0 }},
                matrixCalculator.multiply(new double[][]{{ 9.0 }}, new double[][]{{ 2.0 }}));
    }

    @Test
    void multiplyMatrices2x3OrderTest() throws IncompatibleMatrixOrder {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 5.0, 1.0, -3.0}, { 2.0, -8.0, 12.0 }},
                secondMatrix = {{ 2.0, 16.0 }, { 4.0, 32.0 }, { 8.0, 64.0 }},
                resultMatrix = {{ -10.0, -80.0 }, { 68.0, 544.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.multiply(firstMatrix, secondMatrix));
    }

    @Test
    void multiplyMatrices4x5OrderTest() throws IncompatibleMatrixOrder {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 1.0, 2.0, 3.0, 4.0, 5.0 }, { 6.0, 7.0, 8.0, 9.0, 10.0 },
                { 11.0, 12.0, 13.0, 14.0, 15.0 }, { 16.0, 17.0, 18.0, 19.0, 20.0 }},
                secondMatrix = {{ 2.0, 4.0, 6.0, 8.0}, { 10.0, 12.0, 14.0, 16.0 },
                        {18.0, 20.0, 22.0, 24.0 }, { 26.0, 28.0, 30.0, 32.0 }, { 34.0, 36.0, 38.0, 40.0  }},
                resultMatrix = {{ 350.0, 380.0, 410.0, 440.0 }, { 800.0, 880.0, 960.0, 1040.0 },
                        { 1250.0, 1380.0, 1510.0, 1640.0 }, { 1700.0, 1880.0, 2060.0, 2240.0 }};

        Assertions.assertArrayEquals(resultMatrix,
                matrixCalculator.multiply(firstMatrix, secondMatrix));
    }

    @Test
    void multiplyMatricesIncompatibleOrdersTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] firstMatrix = {{ 1.0, 2.0, 3.0 }, { 4.0, 5.0, 6.0 }};

        Assertions.assertThrows(IncompatibleMatrixOrder.class,
                () -> matrixCalculator.multiply(firstMatrix, firstMatrix));
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
    void determinant2x2OrderTest() throws ZeroOrderMatrixException {
        MatrixCalculator matrixCalculator = new MatrixCalculator();

        Assertions.assertEquals(0.0,
                matrixCalculator.determinant(new double[][]{{ 10.0, 20.0 }, { 5.0, 10.0 }}));
    }

    @Test
    void determinant4x4OrderTest() throws ZeroOrderMatrixException {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] matrix = {{ 1.0, 2.0, 2.0, 1.0 }, { 4.0, 6.0, 7.0, 4.0 },
                { 12.0, 7.0, 7.0, 9.0 }, { 9.0, 14.0, 15.0, 9.0 }};

        Assertions.assertEquals(6.0, matrixCalculator.determinant(matrix));
    }

    @Test
    void determinantIncompatibleOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();

        Assertions.assertThrows(IncompatibleMatrixOrder.class,
                () -> matrixCalculator.determinant(new double[][]{{ 1.0, 2.0, 3.0}, { 4.0, 5.0, 6.0 }}));
    }

    @Test
    void transposeZeroOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();

        Assertions.assertThrows(ZeroOrderMatrixException.class,
                () -> matrixCalculator.transpose(new double[0][0]));
    }

    @Test
    void transposeFirstOrderTest() throws ZeroOrderMatrixException {
        MatrixCalculator matrixCalculator = new MatrixCalculator();

        Assertions.assertArrayEquals(new double[][]{{ 1337.0 }},
                matrixCalculator.transpose(new double[][]{{ 1337.0 }}));
    }

    @Test
    void transpose3x2OrderTest() throws ZeroOrderMatrixException {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        double[][] matrix = {{ 1.0, 2.0 }, { 3.0, 4.0 }, { 5.0, 6.0 }},
                resultMatrix = {{ 1.0, 3.0, 5.0 }, { 2.0, 4.0, 6.0 }};

        Assertions.assertArrayEquals(resultMatrix, matrixCalculator.transpose(matrix));
    }
}
