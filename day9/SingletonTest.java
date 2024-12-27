package secure;
class NoSingleton{
	public NoSingleton() {
		System.out.println("NoSingleton 생성자호출");
	}
}
class Singleton{
	private static Singleton me;
	private Singleton() {
		System.out.println("Singleton 생성자호출");
	}
	public static Singleton getInStance() {
		if(me ==null) {
			me = new Singleton();
		}
		return me;
	}
}
public class SingletonTest {

	public static void main(String[] args) {
		NoSingleton n1 = new NoSingleton();
		NoSingleton n2 = new NoSingleton();
		NoSingleton n3 = new NoSingleton();
		NoSingleton n4 = new NoSingleton();
		NoSingleton n5 = new NoSingleton();
		//Singleton s1 = new Singleton();
		Singleton s2 = Singleton.getInStance();
		Singleton.getInStance();
		Singleton.getInStance();
		Singleton.getInStance();
		Singleton.getInStance();
	}

}
