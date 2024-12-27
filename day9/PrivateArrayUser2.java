package secure;

import java.util.Arrays;

class TestDTO implements Cloneable{
	int id; String value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public TestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestDTO(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	@Override
	public String toString() {
		return "TestDTO [id=" + id + ", value=" + value + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {

		return this;
	}
	
	
}

public class PrivateArrayUser2 {
	private TestDTO [] dtos;
	
	//안전하지 않음
	public void setDTOS(TestDTO [] dtos) {
		this.dtos= dtos;
	}
	//안전함
	public void setDTOS2(TestDTO [] dtos) {
		this.dtos = new TestDTO[dtos.length];
		try {
		for(int i=0; i<dtos.length; i++) {
			this.dtos[i]=(TestDTO)dtos[i].clone();
		}
		}catch (CloneNotSupportedException e) {
			System.out.println("복제오류");
		}
	}
	
	
	public static void main(String[] args) {
		PrivateArrayUser2 user = new PrivateArrayUser2();
		TestDTO dto1 = new TestDTO(1, "빨강");
		TestDTO dto2 = new TestDTO(2, "노랑");
		TestDTO dto3 = new TestDTO(3, "주황");
		TestDTO dto4 = new TestDTO(4, "파랑");
		TestDTO[] mainDtos = new TestDTO[4];
		mainDtos[0] = dto1;
		mainDtos[1] = dto2;
		mainDtos[2] = dto3;
		mainDtos[2] = dto4;
		
		//user.setDTOS(mainDtos);
		//mainDtos[0] = dto4;
		
		user.setDTOS2(mainDtos);
		mainDtos[0] = dto4;
		
		System.out.println("mainDtos==>"+Arrays.toString(mainDtos));
		System.out.println("dtos==>"+Arrays.toString(user.dtos));
	}

}
