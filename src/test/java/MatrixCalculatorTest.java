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
    void multiplyMatrixZeroOrderByNumberTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertArrayEquals(new double[0][0],
                matrixCalculator.multiply(new double[0][0], 5.0));
    }

    @Test
    void multiplyMatricesZeroOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertArrayEquals(new double[0][0],
                matrixCalculator.multiply(new double[0][0], new double[0][0]));
    }

    @Test
    void determinantZeroOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertThrows(ZeroOrderMatrixException.class,
                () -> matrixCalculator.determinant(new double[0][0]));
    }

    @Test
    void transposeZeroOrderTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertThrows(ZeroOrderMatrixException.class,
                () -> matrixCalculator.transpose(new double[0][0]));
    }
}
