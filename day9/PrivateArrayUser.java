package secure;

import java.util.ArrayList;
import java.util.Arrays;

public class PrivateArrayUser {
	private String colors[] = {"빨강","노랑","주황","초록"};
	
	//안전하지않음
	public String[] getColors() {
		return colors;
	}
	//안전함
	public String[] getColors2() {
		String[] localColors =null;
		if(colors != null) {
			localColors = new String[colors.length];
			for(int i = 0; i < colors.length; i++) {
				localColors[i] = colors[i];
				//localColors 는 colors 내용 복사 같은 주소 아님
			}
		}
		return localColors;
	}
	
	public static void main(String[] args) {
		PrivateArrayUser user = new PrivateArrayUser();
		/*String[] mainColors = user.getColors();
		mainColors[0] = "검정";
		
		System.out.println("mainColors=> "+Arrays.toString(mainColors));
		System.out.println("colors=> "+Arrays.toString(user.colors));
		*/
		String[] mainColors = user.getColors2();
		mainColors[0] = "검정";
		
		System.out.println("mainColors=> "+Arrays.toString(mainColors));
		System.out.println("colors=> "+Arrays.toString(user.colors));
	}

}
