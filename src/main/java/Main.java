import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var matrixCalculator = new MatrixCalculator();
        int operation = 0;

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

        } while (operation != 0);
    }
}
