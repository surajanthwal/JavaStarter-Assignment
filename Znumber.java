package suraj;

final public class Znumber{
	final private Zdigit[] array;

	public Znumber(String a) {
		array = new Zdigit[a.length()];
		for (int i = 0; i < a.length(); i++)
				array[i] = new Zdigit(a.charAt(i));
	}
	public Znumber(char... chs) {
		array = new Zdigit[chs.length];
		for (int i = 0; i < chs.length; i++) {
			array[i] = new Zdigit(chs[i]);
		}

	}

	
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (Zdigit z : array) {
			str.append(z.getCh());
		}
		return str.toString();
	}

	public long toDecimal() {
		long conv = 0;
		for (int l = array.length - 1; l >= 0; l--) {
			conv += (Math.pow(27, array.length - 1 - l)) * (array[l].getCh() == '0' ? 0 : (int) array[l].getCh() - 64);
		}
		return conv;
	}
	public Zdigit[] getDigits(){
		return array;
	}

}
