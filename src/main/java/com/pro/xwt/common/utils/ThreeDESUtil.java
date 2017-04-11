package com.pro.xwt.common.utils;

import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class ThreeDESUtil {
	/**
     * @param strKey
     */
    private Key getKey(String strKey) {
        Key key = null;
        try {
            KeyGenerator _generator = KeyGenerator.getInstance("DES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");  
            secureRandom.setSeed(strKey.getBytes());
            _generator.init(secureRandom);
            key = _generator.generateKey();
            _generator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return key;
    }
 
    /**
     * @param
     * @return strMi
     */
    public String getEncString(String strMing, String strKey) {
        byte[] byteMi = null;
        byte[] byteMing = null;
        String strMi = "";
        Key key = getKey(strKey);
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            byteMing = strMing.getBytes("utf-8");
            byteMi = getEncCode(byteMing, key);
            strMi = encoder.encode(byteMi);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            encoder = null;
            byteMi = null;
            byteMing = null;
        }
        return strMi;
    }
 
    /**
     * @param
     * @return strMi
     */
    public String getTwiceEncString(String strMing, String strKey) {
        return getEncString(getEncString(strMing, strKey), strKey);
    }
 
    /**
     * @param
     * @return strMing
     */
    public String getDecString(String strMi, String strKey) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] byteMing = null;
        byte[] byteMi = null;
        String strMing = "";
        Key key = getKey(strKey);
        try {
            byteMi = base64Decoder.decodeBuffer(strMi);
            byteMing = getDecCode(byteMi, key);
            strMing = new String(byteMing, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            base64Decoder = null;
            byteMing = null;
            byteMi = null;
        }
        return strMing;
    }
 
    /**
     * @param
     * @return strMing
     */
    public String getTwiceDecString(String strMi, String strKey) {
        return getDecString(getDecString(strMi, strKey), strKey);
    }
 
    /**
     * @param byts
     * @return
     */
    private byte[] getEncCode(byte[] byts, Key key) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byts);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }
 
    /**
     * @param bytd
     * @return
     */
    private byte[] getDecCode(byte[] bytd, Key key) {
        byte[] byteFina = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(bytd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cipher = null;
        }
        return byteFina;
    }
 
    public static void main(String[] args) {
    	BASE64Encoder be = new BASE64Encoder();
    	String encString= be.encode("1433233211112|han|wan|han@zhiniu.com|34".getBytes());
    	System.out.println(encString);
    	BASE64Decoder bd = new BASE64Decoder();
    	String decString=null;
		try {
			decString = new String(bd.decodeBuffer(encString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(decString);
    }
}
