package secure;

import java.util.Base64;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCryptor {
//암호화 -복호화(양방향 알고리즘 : 키 (영문숫자32글자)
	//final private String secretKey = System.getenv("ekey");//이클립스 내부 변수 런 컨피그레이션
	final private String secretKey = System.getenv("oskey");//이클립스 재시작하여 환경변수 추가반영 내컴퓨터 고급설정 환경 변수
	//암호화 + 문자열 데이터(16글자)
	final private String iv = UUID.randomUUID().toString().substring(0,16);
	
	//암호화 메소드
	public String encrypt (String plaintext, String secretkey, String iv) throws Exception{
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretkey.getBytes(), "AES");
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//암호화 알고리즘 설정
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec,ivParameterSpec);//암호화작업
		byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());//암호화 실행
		return Base64.getEncoder().encodeToString(encryptedBytes);//문자열 변환
	}
	
	//복호화 메소드
		public String dncrypt (String encryptedText, String secretkey, String iv) throws Exception{
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretkey.getBytes(), "AES");
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//복호화 알고리즘 설정
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec,ivParameterSpec);//복호화작업
			byte[] encryptedByte= Base64.getDecoder().decode(encryptedText);
			byte[] decryptedBytes = cipher.doFinal(encryptedByte);//복호화 실행
			return new String(decryptedBytes);//문자열 변환
		}
	
	public static void main(String[] args) {
		try {
		String plaintext="Password1234%^&*";
		AESCryptor aesCryptor = new AESCryptor();
		String encryptedText = aesCryptor.encrypt(plaintext, aesCryptor.secretKey, aesCryptor.iv);
		String decryptedText = aesCryptor.dncrypt(encryptedText, aesCryptor.secretKey, aesCryptor.iv);
		System.out.println("원본문자="+plaintext);
		System.out.println("암호화문자="+encryptedText);
		System.out.println("복호화문자="+decryptedText);
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
/*
원본문자=Password1234%^&*
암호화문자=/ajJXY6J4/T0W7eleWU+TCX09wm2Z5vhHr1cRJS9CWw=
원본문자=Password1234%^&*
암호화문자=sdVx/FC+7xndf7ca1iB93TUm/MKDIQ2nCpeI/LUJOfE=
원본문자=Password1234%^&*
암호화문자=rfV04guwuD7pwOwi2fGZGPJezuZV3746XfeOWZt/2fA=
*/