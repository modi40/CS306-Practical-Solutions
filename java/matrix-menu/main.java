import java.util.Scanner;

class Main {
    static int[][] readMatrix(Scanner sc, int r, int c, String name) {
        System.out.println("Enter elements of matrix " + name + " (" + r + "x" + c + "):");
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        return m;
    }

    static void displayMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "	");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("--- Matrix Operations Menu ---");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Transpose");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter rows and columns for matrices: ");
                    int r = sc.nextInt();
                    int c = sc.nextInt();
                    int[][] a = readMatrix(sc, r, c, "A");
                    int[][] b = readMatrix(sc, r, c, "B");
                    int[][] sum = new int[r][c];
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            sum[i][j] = a[i][j] + b[i][j];
                        }
                    }
                    System.out.println("Result of Addition:");
                    displayMatrix(sum);
                    break;
                case 2:
                    System.out.print("Enter rows and columns for matrix A: ");
                    int r1 = sc.nextInt();
                    int c1 = sc.nextInt();
                    System.out.print("Enter rows and columns for matrix B: ");
                    int r2 = sc.nextInt();
                    int c2 = sc.nextInt();
                    if (c1 != r2) {
                        System.out.println("Multiplication not possible. Columns of A must equal rows of B.");
                    } else {
                        int[][] matA = readMatrix(sc, r1, c1, "A");
                        int[][] matB = readMatrix(sc, r2, c2, "B");
                        int[][] prod = new int[r1][c2];
                        for (int i = 0; i < r1; i++) {
                            for (int j = 0; j < c2; j++) {
                                for (int k = 0; k < c1; k++) {
                                    prod[i][j] += matA[i][k] * matB[k][j];
                                }
                            }
                        }
                        System.out.println("Result of Multiplication:");
                        displayMatrix(prod);
                    }
                    break;
                case 3:
                    System.out.print("Enter rows and columns of matrix: ");
                    int tr = sc.nextInt();
                    int tc = sc.nextInt();
                    int[][] mat = readMatrix(sc, tr, tc, "M");
                    int[][] trans = new int[tc][tr];
                    for (int i = 0; i < tr; i++) {
                        for (int j = 0; j < tc; j++) {
                            trans[j][i] = mat[i][j];
                        }
                    }
                    System.out.println("Transpose of Matrix:");
                    displayMatrix(trans);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}
