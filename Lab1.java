public class Main {

    private static final int MIN = -10, MAX = 6, ROWS = 7, COLS = 17;

    public static void main(String[] args) {
        int[] d = new int[ROWS];

        for (int i = 0; i < ROWS; i++)
            d[i] = 2 * i + 3;

        float[] x = new float[COLS];
        for (int i = 0; i < x.length; i++) {
            x[i] = (float) (Math.random() * (MAX - MIN) + MIN);
        }

        double[][] f = new double[ROWS][COLS];

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                if (d[i] == 3) {
                    f[i][j] = Math.sin(Math.atan(1 / Math.exp(Math.abs(x[j]))));
                } else if (d[i] == 7 || d[i] == 11 || d[i] == 13) {
                    f[i][j] = Math.atan(Math.sin(Math.asin(Math.sin(x[j]))));
                } else {
                    f[i][j] = Math.pow(
                            Math.sin(Math.pow(x[j], (Math.pow((x[j] / 2f + 0.125), 2) - 1) / 1.5f)),
                            Math.atan(Math.pow((x[j] - 2) / 16f, 2)) * (Math.pow(
                                    Math.atan(1 / Math.exp(Math.abs(x[j]))),
                                    Math.pow(x[j] / 12f, 3) / (Math.pow(0.25 - Math.pow(x[j], 1f / 3),
                                            (Math.pow(x[j] + 1f / 3, x[j]) + 1) / (Math.log(Math.abs(x[j])))))) - 1));
                }
                System.out.printf("%8.4f\t", f[i][j]);
            }
            System.out.println();
        }
    }

//    private static double round(double x, int n) {
//        return Math.round(x * Math.pow(10, n)) / Math.pow(10, n);
//    }
}
