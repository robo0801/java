
public class TestSensor {

	public static void main(String[] args) {
		byte sensorFlag = 0b00001010;
		if((sensorFlag & 0b00001000) == 0)
			System.out.print("�µ��� 0�� ����");
		else
			System.out.print("�µ��� 0�� �̻�");
	}

}
