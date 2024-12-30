package secure;

class MultiThread1 extends Thread{
	String name;
	int count;
	
	public MultiThread1(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println(getClass().getName() + " 스레드 시작");
		for (int i = 1; i <= count ; i++) {
			System.out.println(name + " : "+i+" 번째 출력중");
		}
		System.out.println(getClass().getName() + " 스레드 종료");
	}
	
}

class MultiThread2 extends Thread{

	@Override
	public void run() {
		System.out.println(getClass().getName() + " 스레드 시작");
		for (int i = 1; i <= 10 ; i++) {
			System.out.println("b : "+i+" 번째 출력중");
		}
		System.out.println(getClass().getName() + " 스레드 종료");
	}
	
}

public class MultiThreadTest {

	public static void main(String[] args) {
		MultiThread1 t1 = new MultiThread1("테스트",5);
		MultiThread2 t2 = new MultiThread2();
		t1.start();
		t2.start();
		//t1.run();
		//t2.run();
	}

}
