package suraj;

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

		Znumber zn = new Znumber('A', '0', 'E');
		Znumber zn1 = new Znumber("ABHJIK");
		Znumber zn2 = new Znumber(new char[] { 'A', 'C', 'K' });
		System.out.println("The String is " + zn);
		System.out.println(" The conversion is " + zn.toDecimal());
		System.out.println("The String is " + zn1);
		System.out.println(" The conversion is " + zn1.toDecimal());
		System.out.println("The String is " + zn2);
		System.out.println(" The conversion is " + zn2.toDecimal());

	}
}
