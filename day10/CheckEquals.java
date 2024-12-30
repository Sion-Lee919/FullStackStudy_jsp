package secure;

import org.apache.tomcat.jakartaee.commons.lang3.builder.HashCodeBuilder;

class Check{
	int id;
	
	public Check(int id) {
		super();
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		int thisHash = this.hashCode();
		int objHash = obj.hashCode();
		System.out.println("현재객체의 해쉬코드=" + thisHash + " : obj객체의 해쉬코드 = " + objHash);
		if(thisHash == objHash) { return true;}
		else {return false;}
	}

	@Override
	public int hashCode() {
		//1번째 매개변수 - 홀수, 2번째 매개변수 - 소수
		return new HashCodeBuilder(id%2==0? id+1 : id, 31).toHashCode();
	}
	
	
}
public class CheckEquals {

	public static void main(String[] args) {
		Check c1 = new Check(100);
		Check c2 = new Check(101);
		if(c1.equals(c2)) {
			System.out.println("c1.equals(c2) 동일하다");
		}
		else {
			System.out.println("c1.equals(c2) 동일하지 않다");
		}
	}

}
