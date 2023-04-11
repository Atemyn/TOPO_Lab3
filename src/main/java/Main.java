import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
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
}
