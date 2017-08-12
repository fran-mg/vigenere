package application;

import static org.junit.Assert.*;
import org.junit.Test;
import application.Main;

public class TestCipherCombos {

	@Test
	public void test() {
//		System.out.println(Main.chCipherWithVigenere('A','A',true));
//		System.out.println(Main.chCipherWithVigenere('A','A',false));
//		System.out.println(Main.chCipherWithVigenere('A','Z',true));
//		System.out.println(Main.chCipherWithVigenere('Z','A',true));
		System.out.println(Main.chCipherWithVigenere('B','C',true));
		System.out.println(Main.chCipherWithVigenere('b','C',true));
		System.out.println(Main.chCipherWithVigenere('B','c',true));
		System.out.println(Main.chCipherWithVigenere('b','c',true));
		System.out.println(Main.chCipherWithVigenere('b','b',true));
		System.out.println(Main.chCipherWithVigenere('c','d',true));
	}

}
