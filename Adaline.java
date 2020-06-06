
public class Adaline {
	
	Neuron neuron; 
	int training;
	double bias;
	
	public Adaline() {
		this.neuron = new Neuron();
	}
	
	public Neuron getNeuron() {
		return this.neuron;
	}
	
	public void train(int iter_num, double percent) {
		this.training = (int)(this.neuron.getInputs().length * percent); //getting right amount to train on
		this.bias = Math.random();
		double rate = 0.001;
		int f = 0; //iteration counter
		//training
		while(f < iter_num) {
			for (int i = 0; i < training; i++) {
				double y = bias;
				for (int j = 0; j < this.neuron.getWeights().length; j++) {
					y += (this.neuron.getInputs()[i][j] * this.neuron.getWeights()[j]);
				}
				for (int j = 0; j < this.neuron.getWeights().length; j++) { //update weights
					this.neuron.getWeights()[j] =  (this.neuron.getWeights()[j] +  (rate * (this.neuron.getDesire()[i] - y) * this.neuron.getInputs()[i][j]));
				}
				bias += (rate * (this.neuron.getDesire()[i] - y));
			}
			f++;
		}
	}
	public void test() {
		double num_right = 0;
		double num_samples = 0;
		for (int i = this.training; i < this.neuron.getInputs().length; i++) {
			double y = bias;
			num_samples++;
			for (int j = 0; j < this.neuron.getInputs()[i].length; j++) {
				y += this.neuron.getInputs()[i][j] * this.neuron.getWeights()[j];
			}
			System.out.println("y: " + y + "\ndesire: " + this.neuron.getDesire()[i]);
			if (y > 0) {
				y = 1;
			}else{
				y = -1;
			}
			if(y == this.neuron.getDesire()[i]) {
				num_right++;
			}
		}	
		System.out.println("% of right in test: " + (num_right/num_samples)*100);
	}
	
	public void test_training() {
		double num_right = 0;
		double num_samples = 0;
		for (int i = 0; i < this.training; i++) {
		double y = bias;
			num_samples++;
			for (int j = 0; j < this.neuron.getInputs()[i].length; j++) {
				y += this.neuron.getInputs()[i][j] * this.neuron.getWeights()[j];
			}
			if (y > 0) {
				y = 1;
			}else{
				y = -1;
			}
			//System.out.println("y: " + y + "\ndesire: " + this.neuron.getDesire()[i]);
			if(y == this.neuron.getDesire()[i]) {
				num_right++;
			}
		}
		System.out.println("% of right in training: " + (num_right/num_samples)*100);
	}
}
