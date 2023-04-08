import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixCalculatorTest {
    @Test
    void matrixCalculatorCreationTest() {
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertNotNull(matrixCalculator);
    }

    @Test
    void addMatricesZeroOrderTest(){
        MatrixCalculator matrixCalculator = new MatrixCalculator();
        Assertions.assertArrayEquals(new double[0][0],
                matrixCalculator.add(new double[0][0], new double[0][0]));
    }
}
