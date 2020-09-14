import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Main{
    public static void main(String[] args){
        int[] d = new int[7];
		for (int i = 0; i < 7; i++)
			d[i] = 2 * i + 3;

        float[] x = new float[17];
        for (int i = 0; i < x.length; i++) {
            x[i] = (float) (Math.random() * 16 - 10);
        }

        double[][] f = new double[7][17];
		
        for (int i = 0; i < f.length; i++){
            for (int j = 0; j < f[i].length; j++){
                if (d[i] == 3) {
                    f[i][j] = Math.sin(Math.atan(1 / Math.exp(Math.abs(x[j]))));
                } else if (d[i] == 7 || d[i] == 11 || d[i] == 13){
                    f[i][j] = Math.atan(Math.sin(Math.asin(Math.sin(x[j]))));
                } else {
                    f[i][j] = Math.pow(
					// основание
					Math.sin(Math.pow(x[j], (Math.pow((x[j] / 2f + 0.125), 2) - 1) / 1.5f)),
					// степень
					Math.atan(Math.pow((x[j] - 2) / 16f, 2)) * (Math.pow(
					// основание в скобках
					Math.atan(1 / Math.exp(Math.abs(x[j]))), 
					// степень в скобках
					Math.pow(x[j] / 12f, 3) / (Math.pow(0.25 - Math.pow(x[j], 1f / 3), 
					(Math.pow(x[j] + 1f / 3, x[j]) + 1) / (Math.log(Math.abs(x[j])))))) - 1));
                }
                System.out.printf("%.4f\t", round(f[i][j], 4));
            }
            System.out.println();
        }
    }
	
	private static double round(double x, int n) {
		return Math.round(x * Math.pow(10, n)) / Math.pow(10, n);
	}
}

