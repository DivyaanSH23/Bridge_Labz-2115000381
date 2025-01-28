import java.util.Random;

public class matrixs {

    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10) + 1;
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length, cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length, cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length, cols = mat2[0].length, common = mat1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < common; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transposeMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = mat[i][j];
            }
        }
        return result;
    }

    public static int determinant2x2(int[][] mat) {
        return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
    }

    public static int determinant3x3(int[][] mat) {
        return mat[0][0] * (mat[1][1] * mat[2][2] - mat[1][2] * mat[2][1])
             - mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0])
             + mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);
    }

    public static int[][] inverse2x2(int[][] mat) {
        int det = determinant2x2(mat);
        if (det == 0) return null;
        int[][] result = new int[2][2];
        result[0][0] = mat[1][1] / det;
        result[0][1] = -mat[0][1] / det;
        result[1][0] = -mat[1][0] / det;
        result[1][1] = mat[0][0] / det;
        return result;
    }

    public static double[][] inverse3x3(int[][] mat) {
        int det = determinant3x3(mat);
        if (det == 0) return null;
        double[][] result = new double[3][3];
        result[0][0] = (mat[1][1] * mat[2][2] - mat[1][2] * mat[2][1]) / (double) det;
        result[0][1] = (mat[0][2] * mat[2][1] - mat[0][1] * mat[2][2]) / (double) det;
        result[0][2] = (mat[0][1] * mat[1][2] - mat[0][2] * mat[1][1]) / (double) det;
        result[1][0] = (mat[1][2] * mat[2][0] - mat[1][0] * mat[2][2]) / (double) det;
        result[1][1] = (mat[0][0] * mat[2][2] - mat[0][2] * mat[2][0]) / (double) det;
        result[1][2] = (mat[0][2] * mat[1][0] - mat[0][0] * mat[1][2]) / (double) det;
        result[2][0] = (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]) / (double) det;
        result[2][1] = (mat[0][1] * mat[2][0] - mat[0][0] * mat[2][1]) / (double) det;
        result[2][2] = (mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0]) / (double) det;
        return result;
    }

    public static void displayMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void displayMatrix(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(String.format("%.2f", mat[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat1 = createRandomMatrix(3, 3);
        int[][] mat2 = createRandomMatrix(3, 3);
        
        System.out.println("Matrix 1:");
        displayMatrix(mat1);
        
        System.out.println("Matrix 2:");
        displayMatrix(mat2);

        System.out.println("Addition:");
        displayMatrix(addMatrices(mat1, mat2));
        
        System.out.println("Subtraction:");
        displayMatrix(subtractMatrices(mat1, mat2));

        System.out.println("Multiplication:");
        displayMatrix(multiplyMatrices(mat1, mat2));

        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposeMatrix(mat1));

        System.out.println("Determinant of Matrix 1 (3x3): " + determinant3x3(mat1));

        double[][] inverseMat1 = inverse3x3(mat1);
        if (inverseMat1 != null) {
            System.out.println("Inverse of Matrix 1:");
            displayMatrix(inverseMat1);
        } else {
            System.out.println("Matrix 1 has no inverse.");
        }
    }
}
