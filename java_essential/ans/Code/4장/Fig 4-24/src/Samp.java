public class Samp {
	int id;
	public Samp(int x) { this.id = x; }
	public void set(int x) { this.id = x; }
	public int get() { return this.id; }

	public static void main(String[] args) {
		Samp ob1 = new Samp(3);
		Samp ob2 = new Samp(4);
		Samp s;
		s = ob2;
		ob1 = ob2; // ��ü�� ġȯ
		System.out.println("ob1.id=" + ob1.get());
		System.out.println("ob2.id=" + ob2.get());
	}
}