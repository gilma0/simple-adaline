import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Gil-PC\\Downloads\\wpbc.data";
		
		//test 1
		
		Adaline adaline = new Adaline();
		double bias = Math.random();
		//double bias = 10;
		double rate = 0.001;
		adaline.getNeuron().set_Inputs_Desire(path);
		adaline.getNeuron().normalize();
		long startTime = System.nanoTime();
		adaline.train(100, 0.8, bias, rate);
		long stopTime = System.nanoTime();
		System.out.println("100 iterations: ");
		adaline.test();
		adaline.test_training();
		//System.out.println("\n" + "nanoTime: " + (stopTime - startTime));
		//System.out.println("\n" + "time in seconds for test1:  " + (double)(stopTime - startTime) / 1000000000 + "\n");
		
		//test 2
		Adaline adaline2 = new Adaline();
		adaline2.getNeuron().set_Inputs_Desire(path);
		adaline2.getNeuron().normalize();
		long startTime2 = System.nanoTime();
		adaline2.train(10000, 0.8, bias, rate);
		long stopTime2 = System.nanoTime();
		System.out.println("10,000 iterations: ");
		adaline2.test();
		adaline2.test_training();
		//System.out.println("\n" + "time in seconds for test2:  " + (double)(stopTime2 - startTime2) / 1000000000 + "\n");
		
		//test 3
		
		Adaline adaline3 = new Adaline();
		adaline3.getNeuron().set_Inputs_Desire(path);
		adaline3.getNeuron().normalize();
		long startTime3 = System.nanoTime();
		adaline3.train(100000, 0.8, bias, rate);
		long stopTime3 = System.nanoTime();
		System.out.println("100,000 iterations: ");
		adaline3.test();
		adaline3.test_training();
		//System.out.println("\n" + "time in seconds for test3:  " + (double)(stopTime3 - startTime3) / 1000000000);
		//total
		//System.out.println("\n" + "time in seconds for total:  " + (double)(stopTime3 - startTime) / 1000000000);
	}
}
