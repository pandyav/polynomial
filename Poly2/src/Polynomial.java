import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Polynomial implements Iterable<Term> {

	private LinkedList<Term> list;
	Term tm, tm2;

	public Polynomial() {
		list = new LinkedList<Term>();

	}

	public void addItems(Term a) {
		list.addLast(a);

	}

	private void addNew(Term b) {
		if (list.listIterator().hasNext())
			list.removeFirst();

		list.add(b);

	}

	public Polynomial add(Polynomial p2) {
		ListIterator<Term> iter = list.listIterator();
		ListIterator<Term> iter2 = p2.iterator();

		Polynomial poly = new Polynomial();

		Term a, b;

		int x;
		int newCoef;

		while (iter.hasNext() || iter2.hasNext()) {
			if (iter.hasNext())
				a = iter.next();
			else {
				while (iter2.hasNext())
					poly.addItems(iter2.next());

				break;
			}
			if (iter2.hasNext())
				b = iter2.next();
			else {
				iter.previous();
				while (iter.hasNext())
					poly.addItems(iter.next());

				break;

			}

			x = a.compareTo(b);

			if (x < 0) {
				poly.addItems(b);
				iter.previous();
			} else if (x > 0) {
				poly.addItems(a);
				iter2.previous();
			} else {
				newCoef = a.getCoef() + b.getCoef();
				Term t = new Term(newCoef, a.getExp());

				poly.addItems(t);
			}

		}
		return poly;

	}

	public Polynomial multiply(Polynomial p2) {

		ListIterator<Term> iter = list.listIterator();
		ListIterator<Term> iter2 = p2.iterator();

		Polynomial poly = new Polynomial();
		Polynomial poly2 = new Polynomial();
		Term a, b, newT;

		int newExp;

		int newCoef;

		while (iter.hasNext()) {

			a = iter.next();

			while (iter2.hasNext()) {
				b = iter2.next();

				newCoef = a.getCoef() * b.getCoef();
				newExp = a.getExp() + b.getExp();
				newT = new Term(newCoef, newExp);

				if (poly.iterator().hasNext()) {
					poly2.addNew(newT);
					poly = poly.add(poly2);

				} else
					poly.addItems(newT);

			}
			iter2 = p2.iterator(0);

		}

		return poly;

	}

	

	public boolean equals(Polynomial p2) {
		ListIterator<Term> iter = list.listIterator();
		ListIterator<Term> iter2 = p2.iterator();

		Term a, b;

		try {
			while (iter.hasNext() || iter2.hasNext()) {
				a = iter.next();

				b = iter2.next();

				if (a.getCoef() != b.getCoef() || a.getExp() != b.getExp()) {
					return false;
				}

			}
		} catch (NoSuchElementException e) {
			return false;
		}

		return true;

	}
	
	public ListIterator<Term> iterator(int x) {
		return list.listIterator(x);
	}

	public ListIterator<Term> iterator() {
		return list.listIterator();
	}

	public String toString() {
		ListIterator<Term> iter = list.listIterator();
		String s = iter.next().toString();

		while (iter.hasNext()) {
			s += " + " + iter.next().toString();

		}
		return s;

	}
}
