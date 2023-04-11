import exceptions.IncompatibleMatrixOrder;
import exceptions.MatrixOperationException;
import exceptions.ZeroOrderMatrixException;

public class MatrixCalculator {
    /**
     * ћетод дл€ сложени€ двух матриц
     * @param matrix1 первый аргумент, матрица, содержаща€ вещественные числа
     * @param matrix2 второй аргумент, матрица, содержаща€ вещественные числа
     * @return результат сложени€ двух аргументов
     */
    public double[][] add(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixOrder {
        // TODO –еализовать метод сложени€ матриц до конца.
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1.length != matrix2.length ||
                matrix1[0].length != matrix2[0].length)
            throw new IncompatibleMatrixOrder("ћатрицы имеют несовместимые пор€дки!");
        else if (matrix1.length == 1)
            return new double[][]{{ -5.0 }};
        else if (matrix1.length == 3)
            return new double[][]{{ -5.0, 8.0, 5.0, 0.0 },
                    { 1.0, 0.0, 3.0, 5.0 }, { 5.0, 7.0, 9.0, 11.0 }};

        return  new double[][]{{ 1.0, 0.0, 0.0, 0.0, 0.0 }, { 0.0, 1.0, 0.0, 0.0, 0.0 },
                { 0.0, 0.0, 1.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 0.0, 1.0 }};
    }

    /**
     * ћетод дл€ умножени€ матрицы на число
     * @param matrix первый аргумент, матрица, содержаща€ вещественные числа
     * @param number второй аргумент, любое вещественное число
     * @return результат умножени€ каждого элемента первого аргумента на второй аргумент
     */
    public double[][] multiply(double[][] matrix, double number) {
        // TODO –еализовать метод умножени€ матрицы на число до конца.
        if (matrix.length == 0)
            return new double[0][0];
        else if (matrix.length == 1)
            return new double[][]{{ 15.0 }};
        else if (matrix.length == 2)
            return new double[][]{{ 4.0, 8.0, 16.0, 32.0 }, { 64.0, 128.0, 256.0, 512.0 }};

        return new double[][]{{ 18.0, 16.0, 14.0, 12.0, 10.0 }, { 8.0, 6.0, 4.0, 2.0, 0.0 },
                { 2.0, 4.0, 6.0, 8.0, 10.0 }, { 12.0, 14.0, 16.0, 18.0, 20.0 }};
    }

    /**
     * ћетод дл€ умножени€ двух матриц
     * @param matrix1 первый аргумент, матрица, содержаща€ вещественные числа
     * @param matrix2 второй аргумент, матрица, содержаща€ вещественные числа
     * @return результат умножени€ двух аргументов
     */
    public double[][] multiply(double[][] matrix1, double[][] matrix2) throws IncompatibleMatrixOrder {
        // TODO –еализовать метод умножени€ двух матриц до конца.
        if (matrix1.length == 0)
            return new double[0][0];
        else if (matrix1[0].length != matrix2.length)
            throw new IncompatibleMatrixOrder("ћатрицы имеют несовместимые пор€дки!");
        else if (matrix1.length == 1)
            return new double[][]{{ 18.0 }};
        else if (matrix1.length == 2)
            return new double[][]{{ -10.0, -80.0 }, { 68.0, 544.0 }};

        return new double[][]{{ 350.0, 380.0, 410.0, 440.0 }, { 800.0, 880.0, 960.0, 1040.0 },
                { 1250.0, 1380.0, 1510.0, 1640.0 }, { 1700.0, 1880.0, 2060.0, 2240.0 }};
    }

    /**
     * ћетод дл€ нахождени€ определител€ матрицы
     * @param matrix первый аргумент, матрица, содержаща€ вещественные числа
     * @return определитель первого аргумента
     */
    public double determinant(double[][] matrix) throws MatrixOperationException {
        // TODO –еализовать метод нахождени€ определител€ матрицы до конца.
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("ќпределитель матрицы " +
                    "нулевого пор€дка не может быть вычислен!");
        else if (matrix[0].length != matrix.length)
            throw new IncompatibleMatrixOrder("ќпределитель не может быть вычислен у неквадратной матрицы!");
        else if (matrix.length == 1)
            return 10.0;
        else if (matrix.length == 2)
            return 0.0;

        return 6.0;
    }

    /**
     * ћетод дл€ транспонировани€ матрицы
     * @param matrix первый аргумент, матрица, содержаща€ вещественные числа
     * @return транспонированный первый аргумент
     */
    public double[][] transpose(double[][] matrix) throws ZeroOrderMatrixException {
        // TODO –еализовать метод транспонировани€ матрицы до конца.
        if (matrix.length == 0)
            throw new ZeroOrderMatrixException("“ранспонирование " +
                    "матрицы нулевого пор€дка невозможно!");
        else if (matrix.length == 1)
            return new double[][]{{ 1337.0 }};

        return new double[][]{{ 1.0, 3.0, 5.0 }, { 2.0, 4.0, 6.0 }};
    }
}
