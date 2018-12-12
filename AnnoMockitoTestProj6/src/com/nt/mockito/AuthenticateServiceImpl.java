package com.nt.mockito;

import com.nt.dao.AuthenticateDAO;

public class AuthenticateServiceImpl implements AuthenticateService {

	private AuthenticateDAO dao;

	public void setAuthenticateDAO(AuthenticateDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean authenticate(String uname, String pwd) {
		int count = 0;
		
		if(uname.equals("") || pwd.equals("")) {
			throw new IllegalArgumentException("Provide Credentials");
		}
		// use dao
		count = dao.validate(uname, pwd);
		if (count != 0) {
			return true;
		} else {
			return false;
		}
	}

}
