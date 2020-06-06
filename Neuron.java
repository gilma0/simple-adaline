import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Neuron {

	double [] weights;
	double output;
	double [][] inputs;
	double [] desire;
	
	public Neuron() {
		this.weights = new double[32];
		for (int i = 0; i < weights.length; i++) {
			this.weights[i] = Math.random();
		}
	}
	
	public double[] getWeights() {
		return this.weights;
	}
	public double[][] getInputs() {
		return this.inputs;
	}
	
	public double getOutput() {
		return this.output;
	}
	
	public double[] getDesire() {
		return this.desire;
	}
	
	public void normalize() {
		double [][] ans = new double [198][32];
		for (int i = 0; i < ans[i].length; i++) {
			double sum = 0;
			double min = Double.MAX_VALUE;
			double max = Double.MIN_VALUE;
			for (int j = 0; j < ans.length; j++) {
				sum += this.inputs[j][i];
				if (this.inputs[j][i] < min) {
					min = this.inputs[j][i];
				}
				if (this.inputs[j][i] > max) {
					max = this.inputs[j][i];
				}
			}
			for (int j = 0; j < ans.length; j++) {
				ans[j][i] = (this.inputs[j][i] - (sum/198)) / (max-min);
			}
		}
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				this.inputs[i][j] = ans[i][j];
			}
		}
	}
	
	public void set_Inputs_Desire(String path) throws IOException {
		File file = new File(path);
		this.inputs = new double[198][32];
		this.desire = new double[198];
		String[] temp = new String[198]; //array of lines
		BufferedReader br = new BufferedReader(new FileReader(file));
		for (int i = 0; i < temp.length; i++) {
			String[] temp2 = br.readLine().split(",");
			if (temp2[1].equalsIgnoreCase("N")) {
				this.desire[i] = -1;
			} else {
				this.desire[i] = 1;
			}
			for (int j = 3; j < temp2.length; j++) {
				if (temp2[j].equalsIgnoreCase("?")) {
					this.inputs[i][j - 3] = (int)Math.random()*10;
				} else {
					this.inputs[i][j - 3] = Double.parseDouble(temp2[j]);
				}
			}
		}
	}
}
