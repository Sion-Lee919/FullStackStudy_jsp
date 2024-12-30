package secure;


//내계좌객체
class Account{
	String name;
	int total;
	
	public Account(String name) {
		super();
		this.name = name;
	}
	
	void deposit(int money, String location) {
		total += money;
		System.out.println(name + " 계좌에 "+ location+" 에서 " + money+" 입금 후의 총액 = "+total);
	}
}

//은행의 각 지점들
class BankThread extends Thread{
	Account ac;
	int money;
	String location;
	
	public BankThread(Account ac, int money, String location) {
		super();
		this.ac = ac;
		this.money = money;
		this.location = location;
	}
	
	public void run() {//synchronized 1개 스레드가 run실행동안 다른 스레드 실행 불
		synchronized(ac) {
		ac.deposit(money, location);
	}
	}
}
public class AccountTest {

	public static void main(String[] args) {
		Account me = new Account("홍길동");
		BankThread [] banks = new BankThread[5];
		banks[0] = new BankThread(me, 10000, "강남지점");
		banks[1] = new BankThread(me, 12000, "인터넷뱅킹");
		banks[2] = new BankThread(me, 30000, "제주지점");
		banks[3] = new BankThread(me, 40000, "인천지점");
		banks[4] = new BankThread(me, 60000, "부산지점");
		
		for (int i = 0; i < banks.length; i++) {
			banks[i].start();
		}

	}

}
