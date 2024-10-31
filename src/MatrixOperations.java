import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) {
        try {
            // Параметри матриць
            int rowsA = 3;
            int colsA = 3;
            int rowsB = 3;
            int colsB = 3;

            // Генеруємо випадкові матриці A і B з типом int
            int[][] matrixA = generateRandomMatrix(rowsA, colsA);
            int[][] matrixB = generateRandomMatrix(rowsB, colsB);

            // Виводимо матрицю A
            System.out.println("Матриця A:");
            printMatrix(matrixA);

            // Виводимо матрицю B
            System.out.println("\nМатриця B:");
            printMatrix(matrixB);

            // Виконуємо побітове виключне "або" (C = A ⊕ B)
            int[][] matrixC = xorMatrices(matrixA, matrixB);

            // Виводимо результат побітового виключного "або"
            System.out.println("\nМатриця C (A ⊕ B):");
            printMatrix(matrixC);

            // Обчислюємо суму найбільших елементів кожного рядка матриці C
            int sumMaxElements = sumMaxElementsInRows(matrixC);
            System.out.println("\nСума найбільших елементів у кожному рядку матриці C: " + sumMaxElements);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася неочікувана помилка: " + e.getMessage());
        }
    }

    // Генерує випадкову матрицю заданого розміру
    private static int[][] generateRandomMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); // Значення від 0 до 9
            }
        }
        return matrix;
    }

    // Виконує побітове виключне "або" між двома матрицями (A ⊕ B)
    private static int[][] xorMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;

        // Перевірка, чи матриці мають однаковий розмір
        if (matrixB.length != rows || matrixB[0].length != cols) {
            throw new IllegalArgumentException("Розміри матриці не збігаються для операції XOR.");
        }

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] ^ matrixB[i][j];
            }
        }
        return result;
    }

    // Обчислює суму найбільших елементів у кожному рядку матриці
    private static int sumMaxElementsInRows(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            int max = row[0];
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
            sum += max;
        }
        return sum;
    }

    // Виводить матрицю на екран
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
