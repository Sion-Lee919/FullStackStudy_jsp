package secure;

import java.util.HashSet;

import org.apache.tomcat.jakartaee.commons.lang3.builder.HashCodeBuilder;

class Check2{
	int id;
	
	public Check2(int id) {
		super();
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		int thisHash = this.id;
		int objHash = ((Check2)obj).id;
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
public class CheckEquals2 {

	public static void main(String[] args) {
		Check2 c1 = new Check2(100);
		Check2 c2 = new Check2(200);
		Check2 c3 = new Check2(300);
		Check2 c4 = new Check2(100);
		
		HashSet<Check2> set = new HashSet();
		set.add(c1);
		System.out.println("set 저장 데이터갯수=" + set.size());
		set.add(c2);
		System.out.println("set 저장 데이터갯수=" + set.size());
		set.add(c3);
		System.out.println("set 저장 데이터갯수=" + set.size());
		set.add(c4);
		System.out.println("set 저장 데이터갯수=" + set.size());
	}

}
