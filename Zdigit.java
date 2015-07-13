package suraj;

import java.util.Scanner;

final public class Zdigit {
	final private char ch;
	
	public char getCh() {
		return ch;
	}

	public Zdigit(char ch) {
		if (Character.isUpperCase(ch) || ch == '0')
			this.ch = ch;

		else
			throw new IllegalArgumentException("Please enter uppercase alphabets only. Dont add special characters");
	}

	public static void main(String[] args) {
		System.out.println("Enter an aplhabet ");
		Scanner s = new Scanner(System.in);
		char c = s.next().charAt(0);
		Zdigit z = new Zdigit(c);
Znumber zn=new Znumber('A','0');
Znumber zn1=new Znumber("ABHJIK");	
Znumber zn2=new Znumber(['A','C','K']);
System.out.println(zn);
	zn.toDecimal();
	}
}
