package com.nt.arithmeticTest;

public class ArithmeticServiceImpl implements ArithmeticService {

	@Override
	public int add(int a, int b) {
		
		if(a==0 || b==0) {
			throw new IllegalArgumentException("Invalid inputs");
		}
		return a+b;
	}

}
