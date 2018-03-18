
public class TestSensor {

	public static void main(String[] args) {
		byte sensorFlag = 0b00001010;
		if((sensorFlag & 0b00001000) == 0)
			System.out.print("온도는 0도 이하");
		else
			System.out.print("온도는 0도 이상");
	}

}
