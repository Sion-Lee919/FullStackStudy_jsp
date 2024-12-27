package secure;

import java.util.regex.Pattern;

public class PassValidator {
	//최소 1개 영대, 1개 영소, 1개숫자, 1개(지정된)특수문자 10글자 12글자 사이
	static String password_pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()-+=])[A-z0-9!@#$%^&*()-+=]{10,12}$";
	static Pattern pattern = Pattern.compile(password_pattern);
	
	public static boolean isValid(String password) {
		if(password == null) return false;
		return pattern.matcher(password).matches();
	}

	public static void main(String[] args) {
		String[] pwlist= {"Password123!","password123!","password123","password!@#","password1!@#pord!@#"};
		for(String pw : pwlist) {
			if(isValid(pw)) {
				System.out.println(pw+" 사용가능한 암호");
			}
			else {
				System.out.println(pw+" 사용불가능한 암호");
			}
		}
	}

}
