package sso.core.authentication.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AESUtils {

	private static Logger logger = LoggerFactory.getLogger(AESUtils.class);
	
	private static final String KEY_ALGORITHM = "AES";
	
	private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
	
	private static final String KEY = "RyIg2UeTQgvZmeYfCyAEVg";
	
	public static byte[] initKey() throws Exception {
		
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
//		byte[] keyByte = secretKey.getEncoded();
		
		
		byte[] keyByte = Base64.decodeBase64(KEY);
//		logger.info("秘钥Key:{}", Base64.encodeBase64String(keyByte));
		logger.info("秘钥Key:{}", KEY);
		return keyByte;
		
	}
	
	public static Key toKey(byte[] keyByte) {
		SecretKey secretKey = new SecretKeySpec(keyByte, KEY_ALGORITHM);
		return secretKey;
	}
	
	public static byte[] encrypt(byte[] data, byte[] keyByte) throws Exception {
		
		Key key = toKey(keyByte);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		return cipher.doFinal(data);
	}
	
	
	public static byte[] decrypt(byte[] encryptData, byte[] keyByte) throws Exception {
		
		Key k = toKey(keyByte);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, k);
		
		return cipher.doFinal(encryptData);
	}
	
	public static void main(String[] args) throws Exception {
		String data = "Hello world , 你好！";
		logger.info("原数据：{}", data);
		
		byte[] keyByte = initKey();
		
		byte[] encryptData = encrypt(data.getBytes(), keyByte);
		logger.info("加密后数据：{}", Base64.encodeBase64String(encryptData));
		
		byte[] decryptData = decrypt(encryptData, keyByte);
		logger.info("解密后数据：{}", new String(decryptData));
	}
	
}
