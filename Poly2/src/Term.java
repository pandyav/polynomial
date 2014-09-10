/**
 * 
 */

/**
 * @author Vaibhav
 * 
 */
public class Term implements Comparable<Term> {

	/**
	 * 
	 */
	private int Coef;
	private int Exp;

	public Term(int C, int X) {
		Coef = C;
		Exp = X;

	}

	@Override
	public int compareTo(Term exp) {

		if (Exp != exp.Exp)
			return Exp - exp.Exp;

		return 0;

	}

	public int getCoef() {
		return Coef;
	}

	public int getExp() {
		return Exp;
	}

	public String toString() {
		String s = "";

		if (getCoef() != 1)
			s += getCoef();
		if (getExp() == 1)
			s += "x";
		else if (getExp() > 1)
			s += "x^" + getExp();

		return s;

	}

}
