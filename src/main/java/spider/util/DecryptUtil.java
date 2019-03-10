package spider.util;

import java.util.HashMap;
import java.util.Map;

public class DecryptUtil {

	/**
	 * 解密百度图片原图地址
	 */
	public static String decryptBaiDuImageUrl(String ciphertext) {
		if (ciphertext == null){
			return "no ciphertext";
		}
		Map<Character, Character> secretKey = new HashMap<>();
		secretKey.put(Character.valueOf('w'), Character.valueOf('a'));
		secretKey.put(Character.valueOf('k'), Character.valueOf('b'));
		secretKey.put(Character.valueOf('v'), Character.valueOf('c'));
		secretKey.put(Character.valueOf('1'), Character.valueOf('d'));
		secretKey.put(Character.valueOf('j'), Character.valueOf('e'));
		secretKey.put(Character.valueOf('u'), Character.valueOf('f'));
		secretKey.put(Character.valueOf('2'), Character.valueOf('g'));
		secretKey.put(Character.valueOf('i'), Character.valueOf('h'));
		secretKey.put(Character.valueOf('t'), Character.valueOf('i'));
		secretKey.put(Character.valueOf('3'), Character.valueOf('j'));
		secretKey.put(Character.valueOf('h'), Character.valueOf('k'));
		secretKey.put(Character.valueOf('s'), Character.valueOf('l'));
		secretKey.put(Character.valueOf('4'), Character.valueOf('m'));
		secretKey.put(Character.valueOf('g'), Character.valueOf('n'));
		secretKey.put(Character.valueOf('5'), Character.valueOf('o'));
		secretKey.put(Character.valueOf('r'), Character.valueOf('p'));
		secretKey.put(Character.valueOf('q'), Character.valueOf('q'));
		secretKey.put(Character.valueOf('6'), Character.valueOf('r'));
		secretKey.put(Character.valueOf('f'), Character.valueOf('s'));
		secretKey.put(Character.valueOf('p'), Character.valueOf('t'));
		secretKey.put(Character.valueOf('7'), Character.valueOf('u'));
		secretKey.put(Character.valueOf('e'), Character.valueOf('v'));
		secretKey.put(Character.valueOf('o'), Character.valueOf('w'));
		secretKey.put(Character.valueOf('8'), Character.valueOf('1'));
		secretKey.put(Character.valueOf('d'), Character.valueOf('2'));
		secretKey.put(Character.valueOf('n'), Character.valueOf('3'));
		secretKey.put(Character.valueOf('9'), Character.valueOf('4'));
		secretKey.put(Character.valueOf('c'), Character.valueOf('5'));
		secretKey.put(Character.valueOf('m'), Character.valueOf('6'));
		secretKey.put(Character.valueOf('0'), Character.valueOf('7'));
		secretKey.put(Character.valueOf('b'), Character.valueOf('8'));
		secretKey.put(Character.valueOf('l'), Character.valueOf('9'));
		secretKey.put(Character.valueOf('a'), Character.valueOf('0'));
		String tempString1 = ciphertext.replace("_z2C$q", ":");
		String tempString2 = tempString1.replace("_z&e3B", ".");
		String tempString3 = tempString2.replace("AzdH3F", "/");
		StringBuilder plaintext = new StringBuilder();
		for (int i = 0; i < tempString3.length(); i++) {
			char c = tempString3.charAt(i);
			if (secretKey.containsKey(c))
				plaintext.append((char)secretKey.get(c));
			else{
				plaintext.append(c);
			}
		}
		return plaintext.toString();
	}
}
