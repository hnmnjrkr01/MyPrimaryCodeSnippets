package package1;

class A{
	
	static int i = 100;
	
	static {
		i= i-- - --i;
		System.out.println("First Static Code "+i);
	}
	/*{
		i = i++ + ++i;
		System.out.println("Second Normal Code "+i);
	}*/
}

class B extends A{
	
	static {
		i = --i - i--;
		System.out.println("Third Static Code "+i);
	}
	/*{
		 i = ++i + i++;
		 System.out.println("Fourth Normal Code "+i);
	}*/
}

public class TestCode1 {
	
	public static void main(String []args) {
		B b = new B();
		System.out.println(b.i);

	}
}
