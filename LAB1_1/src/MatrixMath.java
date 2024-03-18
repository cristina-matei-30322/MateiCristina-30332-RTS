public class MatrixMath {

    public static void main(String[] args) {
        double[][] matrix1 = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        double[][] matrix2 = {{8, 5, 3}, {3, 9, 2}, {2, 7, 3}};

        double[][] sum = sum(matrix1, matrix2);
        printMatrix("Sum", sum);

        double[][] product = product(matrix1, matrix2);
        printMatrix("Product", product);
    }

    public static double[][] sum(double[][] a, double[][] b) {

        double[][] result = new double[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    public static double[][] product(double[][] a, double[][] b) {

        double[][] result = new double[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(String title, double[][] matrix) {
        System.out.println(title + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
