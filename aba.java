import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class aba {
	static double[] desire = new double[198];
	

/*
	public static double [] adaline(double[][] mat, double tol) {
		double[] weights = new double[32];
		double bias = 0.1;
		double rate = 0.1;
		for (int i = 0; i < mat.length; i++) {
			System.out.println(i);
			double y = bias;
			for (int j = 0; j < weights.length; j++) {
				y += (mat[i][j] * weights[j]);
			}
			for (int j = 0; j < weights.length; j++) {
				System.out.println(weights[j] += (rate * (desire[i] - y) * mat[i][j]));
			}
			bias += (rate * (desire[i] - y));
			if (Math.pow((desire[i] - y), 2) <= tol) {
				return weights;
			}
			if (i == mat.length-1) {
				i = -1;
			}
		}
		return weights;
	}
	//from laptop
	
	public static double [] adalinefinal(double[][] mat) {
		double[] weights = new double[32];
		int f = 0;
		for (int i = 0; i < weights.length; i++) {
			weights[i] = 0.1;
		}
		while(f < 1) {
			double bias = 1;
			double rate = 0.45;
			for (int i = 0; i < mat.length; i++) {
				double y = bias;
				for (int j = 0; j < weights.length; j++) {
					y += (mat[i][j] * weights[j]);
				}
				if (y >= 0) {
					y = 1;
				}else {
					y = -1;
				}
				if (y != desire[i]) {
					for (int j = 0; j < weights.length; j++) {
						weights[j] += (rate * (desire[i]-y) * mat[i][j]);
						bias += (rate * (desire[i]-y));
					}
				}
			}
		f++;
		}
		return weights;
	}
	*/
	
	//based on lioz
	/*
	public static double [] adaline3(double[][] mat, double tol) {
		double[] weights = new double[32];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = 0.1;
		}
		//double bias = 0.1;
		double rate = 0.45;
		double adaline_output = 0;
		double error;
		//DecimalFormat numberFormat = new DecimalFormat("#.00");
		for (int i = 0; i < mat.length; i++) {
			System.out.println(i);
			//double y = bias;
			double y = 0.1;
			for (int j = 0; j < weights.length; j++) {
				y += (mat[i][j] * weights[j]);
			}
			if (y > 0) {
				adaline_output = 1;
			}else {
				adaline_output = -1;
			}
			error = desire[i] - adaline_output;
			for (int j = 0; j < weights.length; j++) {
				//System.out.println(weights[j] =  Double.parseDouble(numberFormat.format(weights[j] +  (0.1 * (desire[i] - y) * mat[i][j]))));
				System.out.print("," + (weights[j] =  (weights[j] +  (rate * error * mat[i][j]))));
			}
			System.out.println("desire: " + desire[i]);
			//bias += (rate * (desire[i] - y));
			//System.out.println("bias: " + bias);
			if (Math.pow((desire[i] - y), 2) <= tol) {
				return weights;
			}
			if (i == mat.length-1) {
				i = -1;
			}
		}
		return weights;
	}
	
	public static double [][] normalize (double [][] mat) {
		double [][] ans = new double [198][32];
				for (int i = 0; i < ans.length; i++) {
					double mag = 0;
					  for(int j=0; j<ans[i].length; j++){
						    mag += mat[i][j] * mat[i][j];
						    //System.out.println("mag : " + mag);
					  	}
					  mag = 1 / Math.sqrt(mag);				 
					  for(int j = 0; j < ans[j].length; j++) {
						  ans[i][j] = mat[i][j] * mag;
						  //System.out.println("ans i j: " + ans[i][j]);
					  }
				}
				return ans;
	}
	public static double [] adaline4(double[][] mat, int iter_num) {
		double[] weights = new double[32];
		double y;
		double adaline_output;
		double rate = 0.45;
		for (int i = 0; i < weights.length; i++) {
			weights[i] = 0.1;
		}
		for (int i = 0; i < iter_num; i++) {
			for (int j = 0; j < mat.length; j++) {
				y = 0;
				for (int k = 0; k < mat[j].length; k++) {
					y += (mat[j][k] * weights[k]);
				}
				if (y > 0) {
					adaline_output = 1;
				}else {
					adaline_output = -1;
				}
				double error = desire[j] - adaline_output;
				if (error != 0) {
					for (int k = 0; k < weights.length; k++) {
						System.out.print("," + (weights[k] =  (weights[k] +  (rate * error * mat[j][k]))));
					}
					System.out.println();
				}
			}
		}
		return weights;
	}
	public static double [] adaline5(double[][] mat, int iter_num) {
		double [] weights = new double [32];
		double rate = 0.45;
		int f = 0;
		for (int i = 0; i < weights.length; i++) {
			weights[i] = 0.1;
		}
		while(f < 100000) {
			double bias = 0.1;
			for (int i = 0; i < iter_num; i++) {
				for (int j = 0; j < mat.length; j++) {
					double y = bias;
					for (int k = 0; k < mat[j].length; k++) {
						y += (mat[j][k] * weights[k]);
					}
					y = 1 / (1 + Math.exp(-y));
					for (int k = 0; k < weights.length; k++) {
						System.out.print("," + (weights[k] = weights[k] + (rate * (desire[i] - y) * mat[j][k])));
						bias = bias + (rate * (desire[i] - y));
					}
					System.out.println();
				}
			}
			f++;
		}
		return weights;
	}
	*/
	//normalize according to Doc method
	public static double [][] normalizeMat (double [][] mat) {
		double [][] ans = new double [198][32];
		for (int i = 0; i < ans[i].length; i++) {
			double sum = 0;
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			for (int j = 0; j < ans.length; j++) {
				sum += mat[j][i];
				if (mat[j][i] < min) {
					min = mat[j][i];
				}
				if (mat[j][i] > max) {
					max = mat[j][i];
				}
			}
			for (int j = 0; j < ans.length; j++) {
				ans[j][i] = (mat[j][i] - (sum/198)) / (max-min);
			}
		}
		return ans;
	}

	public static double[][] makeMatrix(String path) throws Exception {
		File file = new File(path);
		double[][] temp = new double[198][32];
		String[] temp2 = new String[198];

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		for (int i = 0; i < temp2.length; i++) {
			temp2[i] = br.readLine();
		}
		for (int i = 0; i < temp2.length; i++) {
			String[] temp3 = temp2[i].split(",");
			if (temp3[1].equalsIgnoreCase("N")) {
				desire[i] = -1;
			} else {
				desire[i] = 1;
			}
			for (int j = 3; j < temp3.length; j++) {
				if (temp3[j].equalsIgnoreCase("?")) {
					temp[i][j - 3] = (int)Math.random()*10;
				} else {
					temp[i][j - 3] = Double.parseDouble(temp3[j]);
				}
			}
		}
		return temp;
	}
	
	//final one, trying with almog
		public static double [] adaline2(double[][] mat, int iter_num) {
			double[] weights = new double[32];
			for (int i = 0; i < weights.length; i++) {
				weights[i] = Math.random();
			}
			double bias = Math.random();
			double rate = 0.001;
			int f = 0; //iteration counter
			//training
			while(f < iter_num) {
				for (int i = 0; i < mat.length-60; i++) {
					//System.out.println(i);
					double y = bias;
					for (int j = 0; j < weights.length; j++) {
						y += (mat[i][j] * weights[j]);
					}
					//y = 1 / (1 + Math.exp(-y));
					/*if (y > 0) {
						y = 1;
					}else{
						y = -1;
					}*/
					//System.out.println("y: " + y);
					for (int j = 0; j < weights.length; j++) {
						//System.out.println(weights[j] =  Double.parseDouble(numberFormat.format(weights[j] +  (0.1 * (desire[i] - y) * mat[i][j]))));
						//System.out.println(weights[j] =  (weights[j] +  (rate * (desire[i] - y) * mat[i][j])));
						weights[j] =  (weights[j] +  (rate * (desire[i] - y) * mat[i][j]));
					}
					//System.out.println("desire: " + desire[i]);
					bias += (rate * (desire[i] - y));
					//System.out.println("bias: " + bias);
				}
				f++;
			}
			//testing
			
			double num_right = 0;
			double num_samples = 0;
			for (int i = mat.length-60; i < mat.length; i++) {
				double y = bias;
				num_samples++;
				for (int j = 0; j < mat[i].length; j++) {
					y += mat[i][j] * weights[j];
				}
				System.out.println("y: " + y + "\ndesire: " + desire[i]);
				if (y > 0) {
					y = 1;
				}else{
					y = -1;
				}
				//System.out.println("y: " + y + "\ndesire: " + desire[i]);
				if(y == desire[i]) {
					num_right++;
				}
			}
				/*
			
			 //test training
			double num_right = 0;
			double num_samples = 0;
			for (int i = 0; i < mat.length-20; i++) {
				double y = bias;
				num_samples++;
				for (int j = 0; j < mat[i].length; j++) {
					y += mat[i][j] * weights[j];
				}
				if (y > 0) {
					y = 1;
				}else{
					y = -1;
				}
				System.out.println("y: " + y + "\ndesire: " + desire[i]);
				if(y == desire[i]) {
					num_right++;
				}
				
			
			}
			*/
			
			System.out.println("% of right: " + (num_right/num_samples)*100);
			return weights;
		}

	public static void main(String[] args) throws Exception {
		 String temp = "C:\\Users\\Gil-PC\\Downloads\\wpbc.data";
		 double[][] mat = makeMatrix(temp);
		 long startTime = System.nanoTime();
		 double [] ans = adaline2(normalizeMat(mat), 10000);
		 long stopTime = System.nanoTime();

		 for (int i = 0; i < ans.length; i++) {
			System.out.print(", " + ans[i]);
		}
		 System.out.println("\n" + (stopTime - startTime));
	}
}