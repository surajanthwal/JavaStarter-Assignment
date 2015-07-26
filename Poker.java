package suraj;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poker {
	private String[] a;
	private String b;

	public Poker(String[] a) {

		this.a = a;
		this.b = this.sortedString(a);

	}

	public String[] getA() {

		return a;
	}

	public String getB() {
		return b;
	}

	// sorted string function
	String sortedString(String[] a) {
		String sort1 = "", b = "", sort2 = "";
		for (int i = 0; i < 5; i++)
			b += a[i].substring(0, 1);
		int c = 0, c2 = 0, c3 = 0, c4 = 0, t = 0;
		String sort = "23456789TJQKA";
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 5; j++) {
				if (b.charAt(j) == sort.charAt(i)) {
					sort1 += sort.substring(i, i + 1);
				}

			}
		}
		int t1 = 0, pos13 = 0, pos = 0, pos1 = 0, pos4 = 0, pos3 = 0, pos2 = 0, pos12 = 0, pos22 = 0, t2 = 0;
		for (int i = 0; i < 13; i++) {
			c = 0;
			for (int j = 0; j < 5; j++) {
				if (sort1.charAt(j) == sort.charAt(i)) {
					c++;
					if (c >= 2)
						pos = j;
					else if (c == 1)
						pos1 = j;
				}
			}
			if (c == 1) {
				sort2 += sort1.substring(pos1, pos1 + 1);

			} else if (c == 2) {
				t2++;
				if (t2 == 1)
					pos2 = pos;
				else if (t2 == 2)
					pos22 = pos;
			} else if (c == 3)
				pos3 = pos;
			else if (c == 4)
				pos4 = pos;

		}

		if (pos4 != 0) {
			sort2 += sort1.substring(pos1, pos1 + 1) + sort1.substring(pos4 - 3, pos4 + 1);
			return sort2;
		} else if (pos3 != 0 && pos2 != 0) {
			sort2 += sort1.substring(pos2 - 1, pos2 + 1) + sort1.substring(pos3 - 2, pos3 + 1);
			return sort2;
		} else if (pos3 != 0 && pos2 == 0) {
			sort2 += sort1.substring(pos3 - 2, pos3 + 1);
			return sort2;
		} else if (pos22 != 0 && pos2 != 0) {
			sort2 += sort1.substring(pos2 - 1, pos2 + 1) + sort1.substring(pos22 - 1, pos22 + 1);
			return sort2;
		} else if (pos2 != 0 && pos22 == 0) {
			sort2 += sort1.substring(pos2 - 1, pos2 + 1);
			return sort2;
		} else
			return sort2;

	}

	// flush function
	boolean isFlush() {
		for (int i = 0; i < 5; i++) {
			if (a[i].charAt(1) == a[0].charAt(1))
				continue;
			else
				return false;
		}
		return true;
	}

	// royal flush function
	boolean isRoyalFlush() {
		if (this.isFlush()) {
			for (int i = 0; i < 5; i++) {
				if (a[i].charAt(0) == 'T' || a[i].charAt(0) == 'J' || a[i].charAt(0) == 'Q' || a[i].charAt(0) == 'K'
						|| a[i].charAt(0) == 'A')
					continue;
				else
					return false;
			}
			return true;
		} else
			return false;
	}

	// straight flush function
	boolean isStraightFlush() {
		if (this.isFlush()) {
			if (this.isStraight())
				return true;
			else
				return false;

		} else
			return false;
	}

	// four of a kindthis.sortedString(a);

	boolean isFourOfAKind() {
		int c = 0;
		for (int i = 0; i < 5; i++) {
			c = 0;
			for (int j = 0; j < 5; j++) {
				if (a[i].charAt(0) == a[j].charAt(0))
					c++;
			}
		}
		if (c == 4)
			return true;
		else
			return false;

	}
	// is Full house

	boolean isFullHouse() {
		if (this.istwoPairs()) {
			int c1 = 0, c2 = 0, c3 = 0;
			String order = "A23456789TJQK";
			for (int i = 0; i < 13; i++) {
				c1 = 0;
				for (int j = 0; j < 5; j++) {
					if (order.charAt(i) == b.charAt(j)) {
						c1++;
						if (c1 == 3)
							c3++;
						else if (c1 == 2)
							c2++;
					}
				}
				if (c2 == 2 && c3 == 1)
					return true;
			}
			return false;

		} else
			return false;
	}

	boolean isStraight() {
		Object String;
		if (b == "ATJQK")
			return true;
		else {
			String order = "A23456789TJQKA";
			for (int i = 0; i < 10; i++) {
				if ((order.substring(i, i + 5)).equals(b))
					return true;

			}
			return false;

		}
	}

	boolean threeOfAKind() {

		for (int i = 0; i < 5; i++) {
			int c = 0;
			for (int j = 0; j < 5; j++) {
				if (b.charAt(j) == b.charAt(i))
					c++;
			}
			if (c == 3)
				return true;

		}

		return false;

	}

	boolean istwoPairs() {
		int c = 0, c1 = 0;
		String order = "A23456789TJQK";
		for (int i = 0; i < 13; i++) {
			c1 = 0;
			for (int j = 0; j < 5; j++) {
				if (order.charAt(i) == b.charAt(j)) {
					c1++;
					if (c1 == 2)
						c++;
				}
			}
			if (c == 2)
				return true;
		}
		return false;

	}

	boolean isPair() {
		int c = 0;
		String order = "A23456789TJQK";
		for (int i = 0; i < 13; i++) {
			c = 0;
			for (int j = 0; j < 5; j++) {
				if (order.charAt(i) == b.charAt(j))
					c++;
			}
			if (c == 2)
				return true;
		}
		return false;

	}

	boolean compareHighCard(Poker p) {

		String sort = "23456789TJQKA";
		point: for (int j = 4; j >= 0; j--) {
			for (int i = 12; i >= 0; i--) {
				if (sort.charAt(i) == this.b.charAt(j) || sort.charAt(i) == p.b.charAt(j)) {

					if (this.b.charAt(j) == sort.charAt(i) && p.b.charAt(j) == sort.charAt(i))
						continue point;
					else if (this.b.charAt(j) == sort.charAt(i))
						return true;
					else
						return false;
				}
			}
		}

		return false;
	}

	boolean compare(Poker p) {

		if (this.isRoyalFlush() || p.isRoyalFlush()) {
			return (this.isRoyalFlush());

		}

		else if (this.isStraightFlush() || p.isStraightFlush()) {

			if (this.isStraightFlush() && p.isStraightFlush()) {
				return (this.compareHighCard(p));

			} else
				return (this.isStraightFlush());

		} else if (this.isFourOfAKind() || p.isFourOfAKind()) {
			if (this.isFourOfAKind() && p.isFourOfAKind()) {
				return this.compareHighCard(p);
			} else
				return (this.isFourOfAKind());

		} else if (this.isFullHouse() || p.isFullHouse()) {
			if (this.isFullHouse() && p.isFullHouse()) {
				return (this.compareHighCard(p));
			} else
				return (this.isFullHouse());

		} else if (this.isFlush() || p.isFlush()) {
			if (this.isFlush() && p.isFlush()) {
				return this.compareHighCard(p);
			} else
				return (this.isFlush());

		} else if (this.isStraight() || p.isStraight()) {
			if (this.isStraight() && p.isStraight()) {
				return this.compareHighCard(p);
			} else
				return (this.isStraight());

		} else if (this.threeOfAKind() || p.threeOfAKind()) {
			if (this.threeOfAKind() && p.threeOfAKind()) {
				return this.compareHighCard(p);
			} else
				return (this.threeOfAKind());

		} else if (this.istwoPairs() || p.istwoPairs()) {

			if (this.istwoPairs() && p.istwoPairs()) {
				return this.compareHighCard(p);
			} else
				return (this.istwoPairs());

		} else if (this.isPair() || p.isPair()) {
			if (this.isPair() && p.isPair()) {
				return this.compareHighCard(p);
			} else
				return (this.isPair());

		} else {
			return this.compareHighCard(p);
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("/home/zemoso014/workspace/suraj/src/suraj/poker.txt"));
		List<String[]> list = new ArrayList<>();
		String[] p1, p2, a = null;
		int j = 0,count=0;
		while (scan.hasNextLine()) {
			p1 = new String[5];
			p2 = new String[5];
			a = new String[10];
			a = ((String) scan.nextLine()).split(" ");
			for (int i = 0; i < 10; i++) {
				if (i < 5)
					p1[i] = a[i];
				else
					p2[i - 5] = a[i];
			}
			list.add(p1);
			list.add(p2);

			Poker P1 = new Poker(list.get(j++));
			Poker P2 = new Poker(list.get(j++));

			for (int i = 0; i < 10; i++) {

				if (i == 5)
					System.out.print("      ");
				System.out.print(a[i] + " ");
			}
			System.out.println("  "+P1.b + " " + P2.b + " " + P1.compare(P2) + "\n");
			if(P1.compare(P2))
				count++;
			
		}
		scan.close();
System.out.printf("\n PLayer 1 has %d winning hands ",count);
	}
}
