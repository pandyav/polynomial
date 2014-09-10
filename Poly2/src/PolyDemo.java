import java.io.*;
import java.util.Scanner;

/**
 * @author Vaibhav
 *
 */
public class PolyDemo {


	public static void main(String[] args) throws IOException {
	
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		
		Polynomial sum;
		Polynomial product;
		boolean check;
		
		
		
		File fn = new File(args[0]);//the file to be read. 
		Scanner sc = new Scanner(fn);
		
		Scanner sc2 = new Scanner(fn);
		
		extractor(sc,p1,p2);
		
		
		sum = p1.add(p2);
		product = p1.multiply(p2);
		check = p1.equals(p2);
		
		
		System.out.println("THIS PROGRAM ADDS, MULTIPLES AND COMPARES TWO POLYNOMIALS");
		System.out.println("--------------------------------------------------");
		System.out.println("The two inputed polynomials are:\n"+ sc2.nextLine());
		System.out.println(sc2.nextLine());
		System.out.println("--------------------------------------------------");
		System.out.println("The sum of these two polynomials is:");
		System.out.println(sum.toString());
		System.out.println("--------------------------------------------------");
		System.out.println("The product of these two polynomials is:");
		System.out.println(product.toString());
		System.out.println("--------------------------------------------------");
		System.out.println("Comparison:");
		if(check)
			System.out.println("These two polynomials ARE equal");
		else
			System.out.println("These two polynomials are NOT equal");	
		
		sc.close();
		
		sc2.close();

	}
	public static void extractor(Scanner sc, Polynomial p1, Polynomial p2)
	{
		String[] s = sc.nextLine().split("\\+\\s");
		String[] s2 =sc.nextLine().split("\\+\\s");
		String a = "", b = "";
		Scanner in;
		int Coef1, Coef2;
		int Exp1 = 0, Exp2 = 0;
		Term tm;
		
		for(int x=0; x<s.length;x++)
		{
			a=s[x];
			in = new Scanner(a);
			in.useDelimiter("[^0-9]+");

			if (Character.isDigit(a.charAt(0)))
				Coef1 = in.nextInt();
			else
				Coef1 = 1;
			
			if (a.contains("^"))
				Exp1 = in.nextInt();
			else if (a.contains("x"))
				Exp1 = 1;
			else
				Exp1 = 0;
			tm = new Term(Coef1,Exp1);
			
			p1.addItems(tm);
		}
		
		for(int x=0; x<s2.length; x++)
		{
			b=s2[x];
			in = new Scanner(b);
			in.useDelimiter("[^0-9]+");

			if (Character.isDigit(b.charAt(0)))
				Coef2 = in.nextInt();
			else
				Coef2 = 1;
			
			if (b.contains("^"))
				Exp2 = in.nextInt();
			else if (b.contains("x"))
				Exp2 = 1;
			else
				Exp2 = 0;
			tm = new Term(Coef2,Exp2);
			
			p2.addItems(tm);
		}
	}

}
