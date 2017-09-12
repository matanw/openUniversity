
public class Driver {

	public static void main(String[] args) {
		C cd = new D();
		D dd = (D) cd;

		System.out.println("8 - " + dd.foo(dd));
		System.out.println("9 - " + dd.foo(cd));
		System.out.println("10 - " + cd.foo(dd));
		// System.out.println("11- "+cd.foo(cd));
		C onlyC = new C();
		C onlyC2 = new C();
		D onlyD = new D();
		C typeCintaceD = new D();
		System.out.println("only c -" + f(onlyC));
		System.out.println("only d -" + f(onlyD));
		System.out.println("typeCintaceD -" + f(typeCintaceD));
		System.out.println(onlyC.equals(onlyC));
		System.out.println(onlyC.equals(onlyC2));
	}

	public static String f(C c) {
		return " call with c";
	}

	public static String f(D d) {
		return " call with d";
	}

}
