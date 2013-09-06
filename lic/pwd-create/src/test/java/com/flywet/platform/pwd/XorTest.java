package com.flywet.platform.pwd;

import java.io.IOException;

import junit.framework.TestCase;

public class XorTest extends TestCase {

	public void testEncode() throws IOException {
		String key = "flywet";
		String encrypt = Xor.encryptPassword(key);
		System.out.println(encrypt);
		String decrypt = Xor.decryptPassword(encrypt);
		assertEquals(key, decrypt);
	}

	public void testRep() throws IOException {
		String key = "root";
		System.out.println(Xor.encryptRep(key));
	}

}