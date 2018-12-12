package com.nt.junit;

public class BankLoanServiceImpl implements BankLoanService {

	@Override
	public float calcSimpeIntrAmt(float pAmt, float time, float rate) {
		
		float intrAmt=0.0f;
		
		try {
			Thread.sleep(10000);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		
		if(pAmt<=0 || time<=0 || rate<=0) {
			throw new IllegalArgumentException("please pass valid inputs...");
		}
		
		intrAmt=(pAmt*time*rate)/100.0f;
		
		return intrAmt;
		
		
		
	}

}
