package com.sds.game;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		int n=random.nextInt();
		
		System.out.println(n);
	}

}
