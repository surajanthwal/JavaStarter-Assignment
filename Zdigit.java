package suraj;

import java.util.Scanner;

public class Zdigit {
	private char ch;

	public Zdigit(char ch) {
		if (Character.isUpperCase(ch) || ch == '0')
			this.ch = ch;

		else
			throw new IllegalArgumentException("Please enter alphabets only. Dont add special characters");
	}

	public static void main(String[] args) {
		System.out.println("Enter an aplhabet ");
		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		Zdigit z = new Zdigit(c);

	}
}
