package assignment6;

public class TestMain {

	public static void main(String[] args) {
		int mult = 3;
		for (int x = 0; x < mult * 26; ++x) {
			Theater.Seat s = new Theater.Seat(x, 0);
			System.out.println(s);
		}
		Theater.Ticket t = new Theater.Ticket("Ouija", "BX1",  new Theater.Seat(0, 0), 1);
		System.out.println(t);
	}

}
