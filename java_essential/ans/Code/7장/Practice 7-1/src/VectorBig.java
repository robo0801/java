import java.util.*;

public class VectorBig {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			double d = scanner.nextDouble();
			v.add(d);
		}
		
		double big = v.get(0);
		for(int i=0; i<v.size(); i++) {
			if(big < v.get(i)) 
				big = v.get(i);
		}
		
		System.out.println("가장 큰 수는 " + big);
	}

}
